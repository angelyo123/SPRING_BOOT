package pe.edu.cibertec.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.cibertec.repositorio.EmpleadoRepository;

@Controller
public class EmpleadoEliminarController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @PostMapping("/eliminarEmpleado")
    public String eliminarEmpleado(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        if (empleadoRepository.existsById(id)) {
            empleadoRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("mensaje", "Empleado eliminado exitosamente.");
        } else {
            redirectAttributes.addFlashAttribute("error", "El empleado con el ID especificado no existe.");
        }
        return "redirect:/listarEmpleados";  
    }
}
