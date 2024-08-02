package br.com.itilh.sistema.syspedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SyspedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyspedidosApplication.class, args);
	}

	@Bean
    public WebMvcConfigurer forwardToIndex() {
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(@SuppressWarnings("null") ViewControllerRegistry registry) {
                registry.addViewController( "/" )
                        .setViewName("forward:/app/index.html");
            }
        };
	}

}

