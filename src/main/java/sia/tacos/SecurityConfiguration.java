package sia.tacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import sia.tacos.service.UserRepositoryUserDetailsService;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfiguration {
    @Autowired
    private UserRepositoryUserDetailsService userDetailService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/design", "/orders")
                    .hasRole("USER")
                .antMatchers("/", "/**").permitAll()
            ;
        
        http.formLogin().loginPage("/login");
        http.logout().logoutSuccessUrl("/");

        // for h2database...
        http.csrf().ignoringAntMatchers("/h2-console/**");
        http.headers().frameOptions().sameOrigin();
        http.userDetailsService(userDetailService);
        return http.build();
    }

    // @Bean
    // public DaoAuthenticationProvider authenticationProvider() {
    //     DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    //     provider.setPasswordEncoder(passwordEncoder());
    //     provider.setUserDetailsService(userDetailService);
    //     return provider;
    // }


    @Bean
    public PasswordEncoder passwordEncoder() {
      return new StandardPasswordEncoder("53cr3t");
    }

}