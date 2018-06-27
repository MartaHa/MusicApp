package pl.coderslab.spotify.spotify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import pl.coderslab.spotify.services.SpringDataUserDetailsService;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    DataSource dataSource;

    //password code/decdode
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("user/register", "admin/registerAdmin", "/login").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER")
                .anyRequest().permitAll()
                .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/checkrole")
                .and().logout().logoutSuccessUrl("/goodbye")
                .permitAll()
                .and().exceptionHandling().accessDeniedPage("/403");
    }

    //    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //  registry.addViewController("/login").setViewName("admin/login");
        registry.addViewController("/403").setViewName("403");
    }


}