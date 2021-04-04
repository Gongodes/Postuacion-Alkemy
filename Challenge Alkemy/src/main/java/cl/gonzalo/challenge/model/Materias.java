
package cl.gonzalo.challenge.model;


import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name="subjects")
public class Materias implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name="name")
    private String nombre;
    
    @Column(name="schedule")
    private String horario;
    
    @Column(name="subject_quota")
    private int cupo;
    
    @Column(name="description")
    private String descripcion;
    
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToOne
    @JoinColumn(name = "professor_id", referencedColumnName = "id")
    private Profesores profesor;

    public Materias() {
    }

    public Materias(int id, String nombre, String horario, int cupo, String descripcion, Profesores profesor) {
        this.id = id;
        this.nombre = nombre;
        this.horario = horario;
        this.cupo = cupo;
        this.descripcion = descripcion;
        this.profesor = profesor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }

    
    
  
    
private static final int serialVersionUID = (int) 1L;
   
    
    
    
}