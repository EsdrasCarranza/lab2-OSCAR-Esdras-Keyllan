/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2.oscar.esdras.kellyan;

import java.util.Calendar;

/**
 *
 * @author 50488
 */
public class Clase_Base {

    String codigo_unico;
    String nombre;
    Calendar fecha_contratacion;
    double salario_base;
    int horas_trabajadas;

    public Clase_Base(String codigo_unico, String nombre, double salario_base) {
        this.codigo_unico = codigo_unico;
        this.nombre = nombre;
        this.salario_base = salario_base;
        this.horas_trabajadas = 0;
        this.fecha_contratacion = Calendar.getInstance();
    }

    public String getCodigo_unico() {
        return codigo_unico;
    }

    public String getNombre() {
        return nombre;
    }

    public Calendar getFecha_contratacion() {
        return fecha_contratacion;
    }

    public double getSalario_base() {
        return salario_base;
    }

    public int getHoras_trabajadas() {
        return horas_trabajadas;
    }
    
    public void registrar_horas(int horas) {
        if (horas < 0) {
            System.out.println("No se pueden registrar horas negativas.");
            return;
        }
        this.horas_trabajadas += horas;
    }
      public double calcularPago() {
        double pagoProporcional = (salario_base / 160) * horas_trabajadas; 
        double deduccion = pagoProporcional * 0.035; 
        return pagoProporcional - deduccion;
    }
       public String mostrarInformacion() {
        int año = fecha_contratacion.get(Calendar.YEAR);
        int mes = fecha_contratacion.get(Calendar.MONTH) + 1; 
        int día = fecha_contratacion.get(Calendar.DAY_OF_MONTH);

        return "Código: " + codigo_unico + "\n" +
               "Nombre: " + nombre + "\n" +
               "Fecha de contratación: " + día + "/" + mes + "/" + año;
    }


}
