package cn.wpin.mall.backend;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author wangpin
 */
@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(BackendApplication.class)
                .bannerMode(Banner.Mode.CONSOLE)
                .run(args);
    }
}
