package land.lark;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * App
 * 
 * @author yonxu
 */
@SpringBootApplication
@MapperScan("land.lark.mapper")
public class App {

	public static void main(String[] args) {
		var app = new SpringApplication(App.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

}