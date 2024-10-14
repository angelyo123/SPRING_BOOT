package pe.edu.cibertec.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.modelos.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    @Query("SELECT e FROM Empleado e WHERE e.id = :id")
    Empleado buscarPorId(int id);

    @Query("SELECT e FROM Empleado e WHERE e.nombre LIKE %:nombre%")
    List<Empleado> buscarPorNombre(String nombre);

    @Override
    List<Empleado> findAll();
}
