package home.richk.servesyou;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class Application {
	static Properties p;
	
    public static void main(String[] args) {
    	Application.loadProps();
        SpringApplication.run(Application.class, args);
    }

    private static void loadProps() {
    	ClassPathResource resource = new ClassPathResource( "app.properties" );
    	p = new Properties();
    	InputStream inputStream = null;
    	try {
    	    inputStream = resource.getInputStream();
    	    p.load( inputStream );
    	} catch ( IOException e ) {
    	    System.err.println(e.getMessage());
    	} finally {
    	    try { inputStream.close(); } catch ( Exception x) {}
    	}
	}
    public static String searchURL() {
        return p.getProperty( "searchURL" );
    }
    public static String searchKEY() {
        return p.getProperty( "searchKEY" );
    }  
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}
