package cl.gonzalo.challenge.controller;

import cl.gonzalo.challenge.model.Materias;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import cl.gonzalo.challenge.repository.IMaterias;
import java.util.List;

@Controller
public class InicioA {

    @Autowired
    private IMaterias mtr;

    String Forbiden;

    @GetMapping("/login")
    public String login(Model m, String error) {
        if (error != null) {
            m.addAttribute("error", "Tu usuario o contraseña es invalida.");
        }

        return "login";
    }

    @GetMapping("/accessdenied")
    public String denied() {

        return "denied";
    }

    @GetMapping("/")
    public String inicio(HttpServletRequest request, HttpServletResponse response) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "inicio";
    }

    @GetMapping("/alumno")
    public String alumno(Model m) {

        List<Materias> materia = mtr.findAllByOrderByNombreAsc();

        m.addAttribute("materia", materia);
        return "alumno";
    }

}
