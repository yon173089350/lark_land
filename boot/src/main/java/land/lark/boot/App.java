package land.lark.boot;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * App
 *
 * @author yonxu
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        var app = new SpringApplication(App.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
