package ecproject.narvarosystem.config;

import ecproject.narvarosystem.Repository.UserRepository;
import ecproject.narvarosystem.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService)
                .passwordEncoder(myUserDetailsService.getEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
/*
        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").authenticated()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/course").permitAll()
*/
        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("**/admin/**").authenticated()
                .antMatchers(HttpMethod.POST,"/login").permitAll()
                .antMatchers(HttpMethod.POST,"/user").permitAll()
                .antMatchers(HttpMethod.GET,"/user").permitAll()
                .antMatchers(HttpMethod.GET,"/course").permitAll()
                .antMatchers(HttpMethod.POST,"/message").permitAll()
                .antMatchers(HttpMethod.GET,"/login/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/rest/login")
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
}