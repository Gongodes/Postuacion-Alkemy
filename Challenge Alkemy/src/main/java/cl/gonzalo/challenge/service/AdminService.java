
package cl.gonzalo.challenge.service;

import cl.gonzalo.challenge.model.Alumnos;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements UserDetailsService{
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        
     
     
     List<GrantedAuthority> roles = new ArrayList<>();
     roles.add(new SimpleGrantedAuthority("admin"));
     
     UserDetails user = new User("admin","1234", roles );
             
             return user;
    }
    
}
