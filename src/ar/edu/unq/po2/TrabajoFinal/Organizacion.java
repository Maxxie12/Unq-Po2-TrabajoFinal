package ar.edu.unq.po2.TrabajoFinal;

public class Organizacion {
	
	private String nombre;
    private Ubicacion ubicacion;
    private String tipo;
    private int cantidadPersonal;

    //Constructor
    public Organizacion(String nombre, Ubicacion ubicacion, String tipo, int cantidadPersonal) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.cantidadPersonal = cantidadPersonal;
    }

    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidadPersonal() {
        return cantidadPersonal;
    }

    public void setCantidadPersonal(int cantidadPersonal) {
        this.cantidadPersonal = cantidadPersonal;
    }
}
