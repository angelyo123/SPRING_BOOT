package pe.edu.cibertec.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pe.edu.cibertec.modelos.Empleado;
import pe.edu.cibertec.repositorio.EmpleadoRepository;

import java.util.List;

@Controller
public class EmpleadoListarController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping("/listarEmpleados")
    public String listarEmpleados(Model modelo) {
        List<Empleado> listaEmpleados = empleadoRepository.findAll();
        modelo.addAttribute("listaEmpleados", listaEmpleados); 
        return "vistas/Empleado/listar";  
    }
}
