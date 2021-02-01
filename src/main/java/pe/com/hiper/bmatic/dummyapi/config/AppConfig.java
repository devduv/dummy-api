package pe.com.hiper.bmatic.dummyapi.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class AppConfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        return new InternalResourceViewResolver();
    }
}
