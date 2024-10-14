package pe.edu.cibertec.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import java.util.List;

import pe.edu.cibertec.modelos.Departamento;
import pe.edu.cibertec.modelos.Empleado;
import pe.edu.cibertec.repositorio.DepartamentoRepository;
import pe.edu.cibertec.repositorio.EmpleadoRepository;

@Controller
public class EmpleadoController {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping("/agregarEmpleado")
    public String mostrarFormulario(Model modelo) {
        modelo.addAttribute("departamentos", departamentoRepository.findAll());
        modelo.addAttribute("empleado", new Empleado()); 
        return "vistas/Empleado/agregar"; 
    }

    @PostMapping("/agregarEmpleado")
    public String agregarEmpleado(Model modelo,
                                  @Valid @ModelAttribute("empleado") Empleado empleado,
                                  BindingResult bindingResult) {
        // Validaciones personalizadas
        if (bindingResult.hasErrors()) {
            modelo.addAttribute("departamentos", departamentoRepository.findAll());
            return "vistas/Empleado/agregar"; 
        }

        // Guardar el empleado en la base de datos
        empleadoRepository.save(empleado);

       
        return "redirect:/listarEmpleados";
    }
}
