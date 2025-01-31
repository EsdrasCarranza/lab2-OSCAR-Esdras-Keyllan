/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2.oscar.esdras.kellyan;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class EmpresaInterfaz {
    private Empresa empresa;
    private JTextArea areaTexto;
    
    public EmpresaInterfaz() {
        empresa = new Empresa("Mi Empresa");
        JFrame frame = new JFrame("Gestión de Empleados");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        JPanel botonesPanel = new JPanel();
        
        JButton btnListar = new JButton("Listar Empleados");
        btnListar.addActionListener(e -> listarEmpleados());
        botonesPanel.add(btnListar);
        
        JButton btnRegistrar = new JButton("Registrar Empleado");
        btnRegistrar.addActionListener(e -> registrarEmpleado());
        botonesPanel.add(btnRegistrar);
        
        JButton btnRegistrarVenta = new JButton("Registrar Venta");
        btnRegistrarVenta.addActionListener(e -> registrarVenta());
        botonesPanel.add(btnRegistrarVenta);
        
        JButton btnCalcularPago = new JButton("Calcular Pago");
        btnCalcularPago.addActionListener(e -> calcularPago());
        botonesPanel.add(btnCalcularPago);
        
        JButton btnGenerarReporte = new JButton("Generar Reporte");
        btnGenerarReporte.addActionListener(e -> generarReporte());
        botonesPanel.add(btnGenerarReporte);
        
        panel.add(botonesPanel, BorderLayout.SOUTH);
        
        frame.add(panel);
        frame.setVisible(true);
    }
    
    private void listarEmpleados() {
        areaTexto.setText(empresa.listarEmpleados());
    }
    
    private void registrarEmpleado() {
        String codigo = JOptionPane.showInputDialog("Ingrese código único del empleado:");
        String nombre = JOptionPane.showInputDialog("Ingrese nombre del empleado:");
        double salario = 0;
        Clase_Base empleado = new Clase_Base(codigo, nombre,salario);
        empresa.registrarEmpleado(empleado);
    }
    
    private void registrarVenta() {
        String codigo = JOptionPane.showInputDialog("Ingrese código único del empleado:");
        double monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese monto de la venta:"));
        empresa.registrarVenta(codigo, monto);
    }
    
    private void calcularPago() {
        String codigo = JOptionPane.showInputDialog("Ingrese código único del empleado:");
        double pago = empresa.calcularPagoMensual(codigo);
        JOptionPane.showMessageDialog(null, "Pago mensual: $" + pago);
    }
    
    private void generarReporte() {
        empresa.generarReporteEmpleados();
    }
    
   
}
