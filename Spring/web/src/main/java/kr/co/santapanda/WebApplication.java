package kr.co.santapanda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**	
 * @author Yeong
 *
 */
@Configuration
@SpringBootApplication
@ComponentScan(basePackages = "kr.co.santapanda")
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

}
