package cn.wpin.mall.backend;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangpin
 */
@SpringBootApplication(scanBasePackages = "cn.wpin.mall.backend")
@EnableDiscoveryClient
@EnableFeignClients("cn.wpin.mall.client")
public class BackendApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(BackendApplication.class)
                .bannerMode(Banner.Mode.CONSOLE)
                .run(args);
    }
}
