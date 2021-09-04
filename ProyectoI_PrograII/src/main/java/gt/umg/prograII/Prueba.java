package gt.umg.prograII;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.utils.PageRange;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PRAcroForm;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.javafx.font.FontConstants;
import sun.security.krb5.internal.APRep;

import javax.swing.text.StyleConstants;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PushbackReader;
import java.util.*;
import java.util.List;

/**
 * @author Edilmer Rojas
 */
public class Prueba {
    static Fecha fecha = new Fecha();

    /**
     * Metodo Admnistrativo validaciòn
     */
    Scanner entrada = new Scanner(System.in);
    short opc1, opc2, aux;
    Vehiculo autos[] = null;
    Vehiculo aux2;
    Fecha tiempo = new Fecha();

    private void printArr() {
        if (autos != null) {
            for (int i = 0; i < autos.length; i++) {
                System.out.print("Lugar [" + i + "] = ");
                System.out.println(autos[i]);
            }
        } else System.out.println("-El estacionamiento esta cerrado-");
    }

    /**
     * Metodo para aperrturar el estacionamiento
     */

    private void abrirEst() {
        if (autos == null) {
            autos = new Vehiculo[5];
            System.out.println("-Estacionamiento abierto-");
            System.out.println("Tiempo actual: " + tiempo.fechaActual() + " " + tiempo.horaActual());
        } else System.out.println("-El estacionamiento ya fue abierto-");
        printArr();
    }

    /**
     * Metodo que gestionara la parte administrativa
     */
    public static void administracion() {
        Prueba pb = new Prueba();
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenidos al Administrador de vehiculos");
        System.out.println("Defina los estacinamientos habilitados para los 3 tipos de vehiculo: ");
        System.out.print("Estacionamiento Habilitados Motos: ");
        int spacimotos = sc.nextInt();
        System.out.print("Estacionamiento Habilitados Carros: ");
        int spaciocarros = sc.nextInt();
        System.out.print("Estacionamiento Habilitados Camiones: ");
        int spaciocamiones = sc.nextInt();
        System.out.println("Definir precio & estadia de Estacionamiento Motos: ");
        double preciomoto = sc.nextDouble();
        int estadia = sc.nextInt();
        System.out.println("Definir precio & estadia de Estacionamiento de Carros: ");
        double preciocarro = sc.nextDouble();
        int estadiac = sc.nextInt();
        System.out.println("Definir precio & estadia de Estacionamiento de Camiones: ");
        double preciocamion = sc.nextDouble();
        int estadiacam = sc.nextInt();
        System.out.println("1.........................Auto");
        System.out.println("2.........................Motos");
        System.out.println("3.........................Camiones");
        System.out.print("Escoga una opcion:");
        int ops = sc.nextInt();
        switch (ops) {
            case 1:
                pb.asignarLugar();
                break;
            case 2:
                pb.asignarLugar();
                break;
            case 3:
                pb.asignarLugar();
                break;
        }
    }

    private void asignarLugar() {
        if (autos != null) {
            System.out.println("\nIngrese el lugar para estacionar el vehiculo: (0~4)");
            opc1 = entrada.nextShort();
            if (opc1 >= 0 && opc1 < autos.length) {
                System.out.println("Ingrese la matricula del auto: ");
                String matricula = entrada.next();
                System.out.println("Ingrese el modelo del auto: ");
                String modelo = entrada.next();
                System.out.println("Ingrese el numero puertas del auto: ");
                int puertas = entrada.nextInt();
                System.out.println("Ingrese el color del auto: ");
                String color = entrada.next();
                autos[opc1] = new Vehiculo(matricula, modelo, puertas, color);
                System.out.print("\nAutomovil asignado en lugar [" + opc1 + "] : " + autos[opc1]);
            } else System.out.println("Lugar invalido - fuera de rango");
        } else System.out.println("-El estacionamiento esta cerrado-");
    }

    /**
     * Metodo de ingresar y generar ticket al momento de validar espacio en el estacionamiento
     */
    public static void ingreso() {
        /*
         * Creamos Documento Ticket
         * */
        Document doc = new Document(PageSize.A6.rotate());
        Random r1 = new Random();
        Random r2 = new Random();
        int n1 = r1.nextInt(75 - 25 + 1) + 25;
        int n2 = r2.nextInt(75 - 25 + 1) + 25;
        try {
            PdfWriter.getInstance(doc, new FileOutputStream("Ticket.pdf"));
            Rectangle pagasize = new Rectangle(216f, 720f);
            doc.open();
            Font bold = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
            /**
             * Declaramos los titulos del documento
             * */
            Paragraph paragraph = new Paragraph("Ticket de Parqueo Chonitas Grill");
            Paragraph titulo = new Paragraph("Boulevard Austriaco 37-01");
            Paragraph dire = new Paragraph("Zona 16 Guatemala, Guatemala");
            Paragraph entrada = new Paragraph("Fecha: " + fecha.fechaActual());
            Paragraph hentrada = new Paragraph("Horario de Entrada: " + fecha.horaActual());
            Paragraph noticket = new Paragraph(" Ticket NO: " + "AE" + n1 + "ED" + n2);
            /**
             * Añadimos los titlos del Documento
             * */
            doc.add(pagasize);
            doc.add(paragraph);
            doc.add(titulo);
            doc.add(dire);
            doc.add(entrada);
            doc.add(hentrada);
            doc.add(noticket);
            doc.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo al finalizar y retirar el vehiculo generar facturar
     */
    private void retirarVehic() {
        if (autos != null) {
            System.out.println("Ingrese el lugar a retirar : ");
            opc1 = entrada.nextShort();
            if (autos[opc1] != null) {
                System.out.println("\t" + autos[opc1] + " Eliminado del lugar [" + opc1 + "]");
                autos[opc1] = null;
            } else System.out.println("-No existe algun vehiculo en ese lugar-");
        } else System.out.println("-El estacionamiento esta cerrado-");

    }

    public static void egreseo() {
        Prueba ps= new Prueba();
        Persona persona = new Persona();
        Scanner isr = new Scanner(System.in);
        System.out.println("Salida del estacionamiento : ");
        System.out.println("1.......................retirarda");
        System.out.print("Escoga su opcion: ");
        int ope=isr.nextInt();
        switch (ope){
            case 1:
                ps.retirarVehic();
                System.out.println("Emision de Factura: ");
                System.out.println("1.................Nit");
                System.out.println("2.................C/F");
                System.out.print("Eliga su Opcion: ");
                int iop = isr.nextInt();
                switch (iop) {
                    case 1:
                        System.out.println("Ingrese nombre del Cliente: ");
                        String name = isr.nextLine();
                        System.out.println("Ingrese su numero de Nit del Cliente: ");
                        String nit = isr.nextLine();
                        System.out.println("Ingrese el Telefono del Cliente: ");
                        String Tel = isr.nextLine();
                        System.out.println("Cantidad: ");
                        String can = isr.nextLine();
                        System.out.println("Ingrese la Descripcion de la Factura: ");
                        String Des = isr.nextLine();
                        System.out.println("Ingrese el Total: ");
                        String tt = isr.nextLine();
                        /*
                         * Creacion del Documento Factura
                         * */
                        Document fac = new Document(PageSize.DEMY_QUARTO);
                        try {
                            PdfWriter.getInstance(fac, new FileOutputStream("Factura.pdf"));
                            fac.open();
                            Font diseño = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
                            /*
                             * Parrafo - Titulo
                             * */
                            Paragraph titulo_f = new Paragraph("Los Equipos, Sociedad Anonima");
                            Paragraph addres = new Paragraph("Boulevard Austriaco 37-01");
                            Paragraph addes01 = new Paragraph("Zona 16, Guatemala, Guatemala");
                            Paragraph addes02 = new Paragraph("NIT: 9737625-6");
                            Paragraph addes03 = new Paragraph("Vigente 15-02-2022");
                            Paragraph addes04 = new Paragraph("Resolucion 2021-1-61-2098688");
                            Paragraph addes05 = new Paragraph("De Fecha : " + fecha.fechaActual() + " " + fecha.horaActual());
                            Paragraph serie = new Paragraph("SCEQ04 del 1045001 al 1065000");
                            Paragraph datafac = new Paragraph("Factura: SCEQ04  No: ");
                            Paragraph spacio1 = new Paragraph("                        ");
                            Paragraph spacio2 = new Paragraph("                        ");
                            Paragraph spacio3 = new Paragraph("                        ");

                            /*
                             * Añadimos los titulos al documento
                             * */
                            fac.add(titulo_f);
                            fac.add(addres);
                            fac.add(addes01);
                            fac.add(addes02);
                            fac.add(addes03);
                            fac.add(addes04);
                            fac.add(addes05);
                            fac.add(serie);
                            fac.add(datafac);
                            fac.add(spacio1);
                            fac.add(spacio2);
                            fac.add(spacio3);
                            /*
                             * Creamos una Tabla Datos de Factura
                             * */
                            PdfPTable tabla = new PdfPTable(6);
                            tabla.addCell("Nombre:                      ");
                            tabla.addCell("NIT:                         ");
                            tabla.addCell("Telefono:                    ");
                            tabla.addCell("Cantidad:                    ");
                            tabla.addCell("Descripcion:                 ");
                            tabla.addCell("Total:                       ");
                            tabla.addCell(name);
                            tabla.addCell(nit);
                            tabla.addCell(Tel);
                            tabla.addCell(can);
                            tabla.addCell(Des + "  ");
                            tabla.addCell("Q" + tt);
                            /*
                             * Añadimos la tabla
                             * */
                            fac.add(tabla);
                            /*
                             * Añadimos el titulo final de la factura
                             * */
                            Paragraph spacio4 = new Paragraph("                        ");
                            Paragraph spacio5 = new Paragraph("                        ");
                            Paragraph spacio6 = new Paragraph("                        ");
                            Paragraph defi = new Paragraph("Sujeto a Retencion Definitiva");
                            fac.add(spacio4);
                            fac.add(spacio5);
                            fac.add(spacio6);
                            fac.add(defi);
                            /*
                             * Se cierra el Documento
                             * */
                            fac.close();
                        } catch (DocumentException e) {
                            e.printStackTrace();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:

                        break;
                }
                break;
        }

    }

    public static void main(String[] args) {
        Prueba p = new Prueba();
        Scanner scp = new Scanner(System.in);
        System.out.println("Bienvenidos al parque Pamplona Zona 13 " + " " + fecha.fechaActual() + " " + fecha.horaActual());
        System.out.println("Seleccionte la opcion a ejecutar: ");
        System.out.println("0..................Abrir Estacionamiento");
        System.out.println("1..................Administracion");
        System.out.println("2..................Ingreso Vehiculo");
        System.out.println("3..................Egreso Vehiculo");
        int op = scp.nextInt();
        switch (op) {
            case 0:

                break;
            case 1:
                p.administracion();
                break;
            case 2:
                p.ingreso();
                break;
            case 3:
                p.egreseo();
                break;
        }


    }
}
