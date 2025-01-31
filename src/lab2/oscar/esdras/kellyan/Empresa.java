/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2.oscar.esdras.kellyan;

import java.time.LocalDate;
import java.util.ArrayList;

public class Empresa {
    private String nombreEmpresa;
    private ArrayList<Clase_Base> empleados;

    public Empresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.empleados = new ArrayList<>();
    }

    public void registrarEmpleado(Clase_Base empleado) {
        for (Clase_Base e : empleados) {
            if (e.getCodigo_unico().equals(empleado.getCodigo_unico())) {
                System.out.println("Error: Ya existe un empleado con el mismo código.");
                return;
            }
        }
        empleados.add(empleado);
        System.out.println("Empleado registrado exitosamente.");
    }

    public void agregarEmpleado(Clase_Base empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo.");
        }
        empleados.add(empleado);
        System.out.println("Empleado agregado: " + empleado.getNombre());
    }

    public void registrarVenta(String codigoUnico, double monto) {
        Clase_Base empleado = buscarEmpleadoPorCodigo(codigoUnico);
        if (empleado instanceof EmpleadoVentas) {
            ((EmpleadoVentas) empleado).registrarVenta(monto);
            System.out.println("Venta registrada para el empleado " + empleado.getNombre() + ": $" + monto);
        } else {
            System.out.println("El empleado con código " + codigoUnico + " no pertenece al tipo 'EmpleadoVentas'.");
        }
    }

    public void actualizarFechaFinContrato(String codigoUnico, LocalDate nuevaFechaFinContrato) {
        Clase_Base empleado = buscarEmpleadoPorCodigo(codigoUnico);
        if (empleado instanceof EmpleadoTemporal) {
            ((EmpleadoTemporal) empleado).setFechaFinContrato(nuevaFechaFinContrato);
            System.out.println("Fecha de fin de contrato actualizada para el empleado " + empleado.getNombre() +
                    " a: " + nuevaFechaFinContrato);
        } else {
            System.out.println("El empleado con código " + codigoUnico + " no pertenece al tipo 'EmpleadoTemporal'.");
        }
    }

    public double calcularPagoMensual(String codigoUnico) {
        Clase_Base empleado = buscarEmpleadoPorCodigo(codigoUnico);
        if (empleado != null) {
            double pago = empleado.calcularPago();
            System.out.println("El pago mensual para el empleado " + empleado.getNombre() + " es: $" + pago);
            return pago;
        } else {
            System.out.println("No se encontró un empleado con el código " + codigoUnico);
            return 0.0;
        }
    }

    public void registrarHorasTrabajadas(String codigoUnico, int horas) {
        Clase_Base empleado = buscarEmpleadoPorCodigo(codigoUnico);
        if (empleado != null) {
            empleado.registrar_horas(horas);
        } else {
            System.out.println("Empleado no encontrado");
        }
    }

   public String listarEmpleados() {
    StringBuilder resultado = new StringBuilder();
    resultado.append("Lista de empleados en la empresa ").append(nombreEmpresa).append(":\n");
    
    for (Clase_Base empleado : empleados) {
        resultado.append(empleado.mostrarInformacion()).append("\n");
    }

    return resultado.toString();
}

    public void generarReporteEmpleados() {
        int empleadosEstandar = 0, empleadosTemporales = 0, empleadosVentas = 0;
        System.out.println("Reporte de empleados en " + nombreEmpresa + ":");
        
        for (Clase_Base empleado : empleados) {
            if (empleado instanceof EmpleadoTemporal) {
                empleadosTemporales++;
            } else if (empleado instanceof EmpleadoVentas) {
                empleadosVentas++;
            } else {
                empleadosEstandar++;
            }
            System.out.println(empleado.mostrarInformacion());
        }
        
        System.out.println("Total empleados estándar: " + empleadosEstandar);
        System.out.println("Total empleados temporales: " + empleadosTemporales);
        System.out.println("Total empleados de ventas: " + empleadosVentas);
    }

    public Clase_Base buscarEmpleadoPorCodigo(String codigoUnico) {
        for (Clase_Base empleado : empleados) {
            if (empleado.getCodigo_unico().equals(codigoUnico)) {
                return empleado;
            }
        }
        return null;
    }
}
