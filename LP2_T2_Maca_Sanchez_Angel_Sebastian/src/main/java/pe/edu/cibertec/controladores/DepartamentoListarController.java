package pe.edu.cibertec.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pe.edu.cibertec.modelos.Departamento;
import pe.edu.cibertec.repositorio.DepartamentoRepository;

import java.util.List;

@Controller
public class DepartamentoListarController {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @GetMapping("/listarDepartamentos")
    public String listarDepartamentos(Model modelo) {
        List<Departamento> departamentos = departamentoRepository.findAll();
        modelo.addAttribute("departamentos", departamentos);
        return "vistas/departamento/listar";
    }
}
