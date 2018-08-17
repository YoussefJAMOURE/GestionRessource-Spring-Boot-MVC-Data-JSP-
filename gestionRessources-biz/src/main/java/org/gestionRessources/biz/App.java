package org.gestionRessources.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages= {"org.gestionRessources.biz"} )
@EntityScan(basePackages= {"org.gestionRessources.biz"})
@ComponentScan("org.gestionRessources.biz")
public class App 

{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
