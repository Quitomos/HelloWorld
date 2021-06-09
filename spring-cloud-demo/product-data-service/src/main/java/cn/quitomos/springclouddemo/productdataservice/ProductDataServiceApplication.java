package cn.quitomos.springclouddemo.productdataservice;

import brave.sampler.Sampler;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.NumberUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.support.ExecutorServiceAdapter;

import java.util.Scanner;
import java.util.concurrent.*;

@SpringBootApplication
@EnableEurekaClient
public class ProductDataServiceApplication {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(() -> {
            System.out.println("请在五秒内输入端口号");
            Scanner scanner = new Scanner(System.in);
            Integer port = null;
            while (true) {
                String in = scanner.nextLine();
                try {
                    port = Integer.parseInt(in);
                    break;
                } catch (Exception e) {
                    System.err.println("只能是数字");
                }
            }
            scanner.close();
            return port;
        });
        Integer port = 8001;
        try {
            port = future.get(5, TimeUnit.SECONDS);
        } catch (Exception e) {

        }
        executorService.shutdown();
        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(ProductDataServiceApplication.class).properties("server.port=" + port).run(args);
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
