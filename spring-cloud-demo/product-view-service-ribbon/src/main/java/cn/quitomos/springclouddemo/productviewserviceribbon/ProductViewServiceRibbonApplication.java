package cn.quitomos.springclouddemo.productviewserviceribbon;

import cn.hutool.core.net.NetUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableEurekaClient
public class ProductViewServiceRibbonApplication {

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
        Integer port = 8010;
        try {
            port = future.get(5, TimeUnit.SECONDS);
        } catch (Exception e) {

        }
        executorService.shutdown();
        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(ProductViewServiceRibbonApplication.class).properties("server.port=" + port).run(args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
