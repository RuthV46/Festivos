package festivos.api.aplicacion.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import festivos.api.dominio.entidades.Festivo;
import festivos.api.infraestructura.repositorios.IFestivoRepository;
import festivos.api.core.servicios.IFestivoServicio;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.List;

@Service
public class FestivoServicio implements IFestivoServicio {

    @Autowired
    private IFestivoRepository repositorio;

    public List<Festivo> listar() {
        return repositorio.findAll();
    }

    public List<Festivo> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    public List<Festivo> buscarFecha(String nombre, int dia, int mes) {
        return repositorio.buscarFecha(nombre, dia, mes);
    }

    public boolean esFechaFestiva(LocalDate fecha) {
        List<Festivo> festivos = repositorio.findAll();
        LocalDate pascua = calcularPascua(fecha.getYear());

        for (Festivo festivo : festivos) {
            LocalDate fechaFestivo = calcularFechaFestivo(festivo, fecha.getYear(), pascua);
            if (fechaFestivo != null && fechaFestivo.equals(fecha)) {
                return true;
            }
        }
        return false;
    }

    private LocalDate calcularPascua(int año) {
        int a = año % 19;
        int b = año % 4;
        int c = año % 7;
        int d = (19 * a + 24) % 30;
        int e = (2 * b + 4 * c + 6 * d + 5) % 7;
        int dias = d + e;

        // Pascua = 15 marzo + días calculados
        return LocalDate.of(año, 3, 15).plusDays(dias + 7); // Ajuste para domingo siguiente
    }

    private LocalDate calcularFechaFestivo(Festivo festivo, int año, LocalDate pascua) {
        switch (festivo.getTipo().getId()) {
            case 1: // Fijo
                return LocalDate.of(año, festivo.getMes(), festivo.getDia());

            case 2: // Ley Puente
                return ajustarALunes(LocalDate.of(año, festivo.getMes(), festivo.getDia()));

            case 3: // Basado en Pascua
                return pascua.plusDays(festivo.getDiasPascua());

            case 4: // Pascua + Puente
                return ajustarALunes(pascua.plusDays(festivo.getDiasPascua()));

            default:
                return null;
        }
    }

    private LocalDate ajustarALunes(LocalDate fecha) {
        DayOfWeek diaSemana = fecha.getDayOfWeek();
        if (diaSemana != DayOfWeek.MONDAY) {
            int diasHastaLunes = (DayOfWeek.MONDAY.getValue() - diaSemana.getValue() + 7) % 7;
            return fecha.plusDays(diasHastaLunes);
        }
        return fecha;
    }
}


