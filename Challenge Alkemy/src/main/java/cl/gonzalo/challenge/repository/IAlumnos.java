
package cl.gonzalo.challenge.repository;

import cl.gonzalo.challenge.model.Alumnos;
import org.springframework.data.repository.CrudRepository;


public interface IAlumnos extends CrudRepository<Alumnos,Integer> {
    
    Alumnos findByNombre(String nombre);
}
