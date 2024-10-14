package pe.edu.cibertec.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "El nombre no puede estar vacío.")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ ]+$", message = "El nombre solo puede contener letras.")
    private String nombre;

    @NotEmpty(message = "El apellido no puede estar vacío.")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ ]+$", message = "El apellido solo puede contener letras.")
    private String apellido;

    @Positive(message = "El salario debe ser un valor positivo.")
    @Min(value = 1200, message = "El salario debe ser al menos 1200.")
    @Max(value = 52000, message = "El salario no debe exceder los 52000.")
    private Double salario;

    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

    // Constructor vacío
    public Empleado() {
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
