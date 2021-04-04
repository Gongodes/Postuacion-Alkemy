package cl.gonzalo.challenge.configuration;

import cl.gonzalo.challenge.service.AdminService;
import cl.gonzalo.challenge.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AlumnoService userDetailsService;
    
     @Autowired AdminService admin;

    @Autowired
    private NoOpPasswordEncoder nopass;

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(admin).passwordEncoder(nopass);
                
        auth.userDetailsService(userDetailsService).passwordEncoder(nopass);
    }
    
    
     
  

     @Override
    protected void configure(HttpSecurity http) throws Exception {
        

        http.authorizeRequests()
                .antMatchers("/alumno*").hasAuthority("alumnos")
                .antMatchers("/admin/*").hasAuthority("admin")
                .antMatchers("/").permitAll() .and()
.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").and().csrf().disable().formLogin()
            .loginPage("/login")
            .failureUrl("/login?error")
            .permitAll()
            .and()
            
      .exceptionHandling().accessDeniedPage("/accessdenied");;

   
    }
   
    }


