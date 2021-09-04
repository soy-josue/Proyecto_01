package gt.umg.prograII;
/**
 * @author Edilmer Rojas
 * */
public class Vehiculo {
    //atributos privados
    private String matricula;
    private String modelo;
    private int puertas;
    private String color;

    public Vehiculo() {
        matricula = "";
        modelo = "";
        puertas = 0;
        color = "";
    }

    public Vehiculo(String matricula, String modelo, int puertas, String color) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.puertas = puertas;
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public int getPuertas() {
        return puertas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", modelo=" + modelo + ", puertas=" + puertas + ", color=" + color + '}';
    }
}
