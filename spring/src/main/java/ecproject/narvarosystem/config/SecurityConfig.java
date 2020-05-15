package ecproject.narvarosystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers(HttpMethod.GET,"/user").permitAll()
//                .antMatchers(HttpMethod.GET,"/rest/user").permitAll()
                .antMatchers(HttpMethod.POST,"/rest/user").permitAll()
                .antMatchers("/user/**").authenticated()
                .antMatchers("user/secured/all").hasRole("ADMIN")
                .antMatchers("/api/").authenticated()
                .antMatchers(HttpMethod.DELETE,"/rest/user").authenticated()
                .antMatchers(HttpMethod.GET,"/login").permitAll()
                .antMatchers(HttpMethod.POST,"/login").permitAll()
                .antMatchers("/").permitAll()
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("http://localhost:8081")
                        .invalidateHttpSession(true)        // set invalidation state when logout
                        .deleteCookies("JSESSIONID")
                        .and()
                        .exceptionHandling()
                        .accessDeniedPage("/403");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(myUserDetailsService)
                .passwordEncoder(myUserDetailsService.getEncoder());
    }
}