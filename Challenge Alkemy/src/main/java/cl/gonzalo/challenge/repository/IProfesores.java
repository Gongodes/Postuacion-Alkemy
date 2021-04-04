
package cl.gonzalo.challenge.repository;

;
import cl.gonzalo.challenge.model.Profesores;
import org.springframework.data.repository.CrudRepository;


public interface IProfesores extends CrudRepository<Profesores,Integer>{
    
    
    Profesores findById(int any);
}
