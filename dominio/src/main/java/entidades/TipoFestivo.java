package festivos.api.dominio.entidades;

import jakarta.persistence.*; // para relacionar columnas, entidades y tablas

@Entity
@Table(name = "tipo")
public class TipoFestivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipo;
    
    public TipoFestivo() {
    }

    public TipoFestivo(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
}
