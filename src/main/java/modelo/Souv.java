package modelo;

import java.sql.Date;

public class Souv {
    private int idSouvenirs;
    private String tipo;
    private String nombre;
    private String descripcion;
    
    // Constructor
    public Souv() {
    }

    // Getters y setters
    // ...

    // Resto de métodos y atributos
    // ...

    public int getIdSouvenirs() {
        return idSouvenirs;
    }

    public void setIdSouvenirs(int idSouvenirs) {
        this.idSouvenirs = idSouvenirs;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
        public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void add(Souv souvenirs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

    
      
    
    
    
    
    
    
