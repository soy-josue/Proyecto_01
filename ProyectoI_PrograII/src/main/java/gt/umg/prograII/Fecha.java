package gt.umg.prograII;

import java.util.Calendar;

/***
 * @author Edilmer rojas
 * */
public class Fecha {
    private int anio;
    private int mes;
    private int dia;
    private String hora_registro;
    private int tiempoEnAnios;
    Calendar calendario = Calendar.getInstance();

    public Fecha() {
        this.anio = 0;
        this.mes = 0;
        this.dia = 0;
        this.hora_registro = "00:00:00";
    }

    public Fecha(int anio, int mes, int dia) {
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        hora_registro = horaActual();
    }

    public void setHora_registro(String hora_registro) {
        this.hora_registro = hora_registro;
    }

    public void setTiempoEnAnios(int tiempoEnAnios) {
        this.tiempoEnAnios = tiempoEnAnios;
    }

    public String getHora_registro() {
        return hora_registro;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getTiempoEnAnios() {
        return tiempoEnAnios;
    }

    public int getAnio() {
        return anio;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    @Override
    public String toString() {
        return "{" + "a\u00f1o=" + anio + ", mes=" + mes + ", dia=" + dia;
    }

    public int calcularTiempoEnAnios(Fecha nacimiento) {
        this.tiempoEnAnios = Calendar.YEAR - nacimiento.anio;
        this.mes = Calendar.MONTH;
        if ((this.mes - nacimiento.mes) < 0 || (nacimiento.mes - this.mes) == 0 && (nacimiento.dia - this.dia < 0)) {
            tiempoEnAnios--;
        }
        return tiempoEnAnios;
    }

    public String fechaActual() {
        int year = calendario.get(Calendar.YEAR);
        int month = calendario.get(Calendar.MONTH);
        int day = calendario.get(Calendar.DAY_OF_WEEK);
        return day + "/" + month + "/" + year;
    }

    public String horaActual() {
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        return hora + ":" + minutos;
    }

}