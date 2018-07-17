package pl.coderslab.spotify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpotifyApplication extends SpringBootServletInitializer {

    @Override

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpotifyApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(SpotifyApplication.class, args);
    }
}
