package festivos.api.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import festivos.api.dominio.entidades.*;

public interface IFestivosRepository extends JpaRepository<Festivo, Integer> {

    @Query("SELECT s FROM Festivo s WHERE s.nombre LIKE '%' || ?1 || '%'")
    public List<Festivo> buscar(String nombre);
} 
