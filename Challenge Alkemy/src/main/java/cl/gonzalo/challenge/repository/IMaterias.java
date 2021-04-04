
package cl.gonzalo.challenge.repository;

import cl.gonzalo.challenge.model.Materias;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface IMaterias extends CrudRepository<Materias, Integer> {
    
public List <Materias> findAllByOrderByNombreAsc();

Materias findById(int any);

}
