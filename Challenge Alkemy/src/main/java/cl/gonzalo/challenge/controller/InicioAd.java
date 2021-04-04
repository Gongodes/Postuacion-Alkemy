package cl.gonzalo.challenge.controller;

import cl.gonzalo.challenge.model.Materias;
import cl.gonzalo.challenge.model.Profesores;
import cl.gonzalo.challenge.repository.IMaterias;
import cl.gonzalo.challenge.repository.IProfesores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class InicioAd {

    @Autowired
    private IProfesores prf;
    
    @Autowired
    private IMaterias mtr;
    

    @GetMapping("/")
    public String admin(Model m) {
        
        Iterable<Profesores> lista = prf.findAll();
        
        m.addAttribute("lista",lista);
        
        return "admin";
    }

    @PostMapping("/crear")
    public String crear(Profesores profesor) {
        prf.save(profesor);
        
        return "redirect:/admin/";

    }

    
     @GetMapping("/borrar2/{id}")
    public String borrar2(@PathVariable("id") int id, Model m) {
    prf.delete(prf.findById(id));
    
    return "redirect:/admin/";
}
    
    
    
    
     @GetMapping("/asignaturas")
    public String asig(Model m) {
        
        Iterable<Materias> materia = mtr.findAll();
        Iterable<Profesores> lista2 = prf.findAll();
        m.addAttribute("materia",materia);
        m.addAttribute("lista2",lista2);
        return "materias";
    }

    @PostMapping("/crearasig")
    public String crear(Materias materia) {
        mtr.save(materia);
        
        return "redirect:/admin/asignaturas";

    }
    
    
    @GetMapping("/borrar/{id}")
    public String borrar(@PathVariable("id") int id, Model m) {
    mtr.delete(mtr.findById(id));
    
    return "redirect:/admin/asignaturas";
}

}