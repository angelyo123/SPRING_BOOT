package pe.edu.cibertec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import pe.edu.cibertec.repositorio.EmpleadoRepository;
import pe.edu.cibertec.modelos.Empleado;

import java.util.List;

@SpringBootApplication
public class Lp2T2MacaSanchezAngelSebastianApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Lp2T2MacaSanchezAngelSebastianApplication.class, args);

        EmpleadoRepository empleadoRepository = context.getBean(EmpleadoRepository.class);

        List<Empleado> empleados = empleadoRepository.findAll();
        System.out.println("Empleados listados:");
        for (Empleado empleado : empleados) {
            System.out.println(empleado.getNombre() + " " + empleado.getApellido() + " - Salario: " + empleado.getSalario());
        }
    }
}
