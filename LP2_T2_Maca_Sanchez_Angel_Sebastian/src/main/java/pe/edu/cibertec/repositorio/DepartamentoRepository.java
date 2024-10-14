package pe.edu.cibertec.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.modelos.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

    @Query("SELECT d FROM Departamento d WHERE d.id = :id")
    Departamento obtenerPorId(int id);


    @Query("SELECT d FROM Departamento d WHERE d.nombre LIKE %:nombre%")
    List<Departamento> buscarPorNombre(String nombre);

  
    @Override
    List<Departamento> findAll();
}
