package pe.edu.cibertec.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.cibertec.modelos.Empleado;
import pe.edu.cibertec.modelos.Departamento;
import pe.edu.cibertec.repositorio.EmpleadoRepository;
import pe.edu.cibertec.repositorio.DepartamentoRepository;

import java.util.Optional;
import java.util.List;

@Controller
public class EditarEmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @GetMapping("/editarEmpleado/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") int id, Model modelo, RedirectAttributes redirectAttrs) {
        Optional<Empleado> empleadoOpt = empleadoRepository.findById(id);
        if (empleadoOpt.isPresent()) {
            Empleado empleado = empleadoOpt.get();
            List<Departamento> departamentos = departamentoRepository.findAll();
            modelo.addAttribute("empleado", empleado);
            modelo.addAttribute("departamentos", departamentos);
            return "vistas/Empleado/editar";
        } else {
            redirectAttrs.addFlashAttribute("error", "Empleado no encontrado.");
            return "redirect:/listarEmpleados";
        }
    }

    @PostMapping("/actualizarEmpleado")
    public String actualizarEmpleado(Empleado empleado, RedirectAttributes redirectAttrs) {
        try {
            empleadoRepository.save(empleado);
            redirectAttrs.addFlashAttribute("mensaje", "Empleado actualizado correctamente.");
        } catch (Exception e) {
            redirectAttrs.addFlashAttribute("error", "Error al actualizar el empleado.");
        }
        return "redirect:/listarEmpleados";
    }
}
