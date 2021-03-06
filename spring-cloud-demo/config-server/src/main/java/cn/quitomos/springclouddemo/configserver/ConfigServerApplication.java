package cn.quitomos.springclouddemo.configserver;

import cn.hutool.core.net.NetUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigServerApplication {

    public static void main(String[] args) {
        int port = 8030;
        if (!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用，无法启动%n", port);
            System.exit(1);
        }
        new SpringApplicationBuilder(ConfigServerApplication.class)
                .properties("server.port=" + port)
                .run(args);
    }
}
