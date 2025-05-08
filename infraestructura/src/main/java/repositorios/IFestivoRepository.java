package festivos.api.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import festivos.api.dominio.entidades.*;

public interface IFestivoRepository extends JpaRepository<Festivo, Integer> {

    @Query("SELECT s FROM Festivo s WHERE s.nombre LIKE '%' || ?1 || '%'")
    public List<Festivo> buscar(String nombre);

      // Consulta personalizada para buscar por nombre, día y mes
    @Query("SELECT f FROM Festivo f WHERE " +
            "(:nombre IS NULL OR LOWER(f.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) AND " +
            "f.dia = :dia AND " +
            "f.mes = :mes")
    List<Festivo> buscarFecha(
            @Param("nombre") String nombre,
            @Param("dia") int dia,
            @Param("mes") int mes
);

}