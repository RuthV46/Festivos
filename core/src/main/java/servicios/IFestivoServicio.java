package festivos.api.core.servicios;

import java.util.List;
import java.time.LocalDate;
import festivos.api.dominio.entidades.*;

public interface IFestivoServicio {

    List<Festivo> listar();
    List<Festivo> buscar(String nombre);
    List<Festivo> buscarFecha(String nombre, int dia, int mes);
    boolean esFechaFestiva(LocalDate fecha);

}
