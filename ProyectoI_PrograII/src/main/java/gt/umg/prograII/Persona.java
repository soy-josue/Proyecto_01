package gt.umg.prograII;
/**
 * @author Edilmer Rojas
 * */
public class Persona {
    private String nit;
    private String nombre;

    /**
     * @Param nit, nombre, telefono;
     * Creamos el Constructor
     */
    public Persona() {
        this.nit = nit;
        this.nombre = nombre;
    }

    /**
     * Metodos Getters & and Setters
     */
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "nit='" + nit + '\'' +
                ", nombre='" + nombre + '\'';
    }
}
