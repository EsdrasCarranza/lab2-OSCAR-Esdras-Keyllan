/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2.oscar.esdras.kellyan;
import java.util.Arrays;
import java.time.LocalDate;

/**
 *
 * @author 50488
 */
public class EmpleadoVentas extends Clase_Base {
      private double[] ventasMensuales;
    private double tasaComision;

    public void EmpleadosVentas(){
        
    }
    
    public EmpleadoVentas(String codigo_Unico, String nombre, double salario_Base, double tasaComision) {
        super(codigo_Unico, nombre, salario_Base);
        this.tasaComision=tasaComision;
        this.ventasMensuales=new double[12];
    }

    public void registrarVenta(double monto){
        if (monto<0){
            System.out.println("No se pueden registrar ventas negativas.");
            return;
        }
        int mesActual=LocalDate.now().getMonthValue() -1; 
        ventasMensuales[mesActual] +=monto;
    }

    public double calcularComision(){
        int mesActual=LocalDate.now().getMonthValue() -1;
        return ventasMensuales[mesActual] * tasaComision;
    }

    public double calcularPago(){
        double pagoBase=super.calcularPago();
        double comision=calcularComision();
        return pagoBase + comision;
    }

    public double calcularVentasAnuales(){
        return Arrays.stream(ventasMensuales).sum();
    }

    public String mostrarInformacion(){
        return super.mostrarInformacion() + "\n" +
               "Ventas Anuales son: " + calcularVentasAnuales();
    }

}
