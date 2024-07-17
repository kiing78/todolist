package fr.home.todolist.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //Le CORS est importantpour les appli qui separent le back et le front. Le back et le front se trouvent
    //sur des origines différentes (différent port, différent domaine, protocol)
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000") // URL de votre application React
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
