package festivos.api.dominio.entidades;

import jakarta.persistence.*;

@Entity //entidad
@Table(name = "festivo") // llama a la tabla desde la base de datos
public class Festivo {

    /*GenerationType.IDENTITY ya que delega la generación del ID a la base de datos
     (equivalente a AUTOINCREMENT en otros motores) */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int dia;
    private int mes;
    private int diasPascua;
    
    /* Para relacionar llave foranea*/
    @ManyToOne
    @JoinColumn(name = "idTipo") 
    private TipoFestivo tipo;

    public Festivo() {
    }

    public Festivo(int id, String nombre, int dia, int mes, int diasPascua, TipoFestivo tipo) {
        this.id = id;
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.diasPascua = diasPascua;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDiasPascua() {
        return diasPascua;
    }

    public void setDiasPascua(int diasPascua) {
        this.diasPascua = diasPascua;
    }

    public TipoFestivo getTipo() {
        return tipo;
    }

    public void setTipo(TipoFestivo tipo) {
        this.tipo = tipo;
    }

    
    
}


