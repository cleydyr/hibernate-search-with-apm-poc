package co.elastic.support.case01173843demo;

import co.elastic.apm.attach.ElasticApmAttacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Case01173843DemoApplication {
	public static void main(String[] args) {
		ElasticApmAttacher.attach();
		SpringApplication.run(Case01173843DemoApplication.class, args);
	}

}
