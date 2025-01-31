/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2.oscar.esdras.kellyan;

import java.time.LocalDate;

/**
 *
 * @author 50488
 */
public class EmpleadoTemporal extends Clase_Base {
    private LocalDate fechaFinContrato;
    
    public EmpleadoTemporal(String codigoUnico, String nombre, double salarioBase, LocalDate fechaFinContrato) {
        super(codigoUnico, nombre, salarioBase);
        this.fechaFinContrato=fechaFinContrato;
    }
    
    public LocalDate getFechaFinContrato(){
        return fechaFinContrato;
    }
    
    public void setFechaFinContrato(LocalDate fechaFinContrato) {
        this.fechaFinContrato=fechaFinContrato;
    }
    
    public double calcularPago(){
        LocalDate fechaActual=LocalDate.now();
        if (!fechaActual.isAfter(fechaFinContrato)){
            return super.calcularPago();
        }
        return 0.0; 
    }

    public String mostrarInformacion(){
        return super.mostrarInformacion() + "\n Fecha de Fin del Contrato: " + fechaFinContrato;
    }

}
