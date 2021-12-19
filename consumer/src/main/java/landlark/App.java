package landlark;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


/**
 * App
 *
 * @author yonxu
 */
@SpringBootApplication
@EnableAsync
@MapperScan("landlark.entity.mapper")
public class App {

    public static void main(String[] args) {
        var app = new SpringApplication(App.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}