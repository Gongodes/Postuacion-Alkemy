
package cl.gonzalo.challenge.service;

import cl.gonzalo.challenge.model.Alumnos;
import cl.gonzalo.challenge.repository.IAlumnos;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoService implements UserDetailsService{

    @Autowired
    private IAlumnos repo;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        
     Alumnos al   =   repo.findByNombre(string);
     
     List<GrantedAuthority> roles = new ArrayList<>();
     roles.add(new SimpleGrantedAuthority("alumnos"));
     
     UserDetails user = new User(al.getNombre(),al.getContraseña(), roles );
             
             return user;
    }
    
    
    
    
    
    
    
}
