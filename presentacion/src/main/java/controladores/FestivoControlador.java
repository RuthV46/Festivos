package festivos.api.presentacion.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import festivos.api.infraestructura.repositorios.*;
import festivos.api.dominio.entidades.*;
import festivos.api.core.servicios.*;

import java.util.List;


@RestController
@RequestMapping("api/festivo")
public class FestivoControlador {

    @Autowired
    private IFestivoServicio servicio;

    @RequestMapping(value="/listar", method = RequestMethod.GET)
    public List<Festivo> listar() {
        return servicio.listar();
    }
    
}
