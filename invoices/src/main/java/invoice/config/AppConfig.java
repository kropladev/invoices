package invoice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "invoice")
@Import(value = {WebAppConfig.class} )
public class AppConfig {

}
