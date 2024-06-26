/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
SELECT COUNT(empleados.idArea),
area.nombre 
from empleados 
inner join area 
on area.id = empleados.idArea
GROUP by (area.nombre);
358 
200
 */
package Vistas;

import Models.Utelerias;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultKeyedValuesDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Jhonatan
 */
public class TablasPequeñas extends javax.swing.JPanel {

    Utelerias utelerias = new Utelerias();
    String[] cabezera = {"Nº Empleadps", "Cantidad"};
    DefaultTableModel modelo = new DefaultTableModel(cabezera, 0);
    String[] cabezera2 = {"Nº Empleadps", "Sexo"};
    DefaultTableModel modelo2 = new DefaultTableModel(cabezera2, 0);
    String[] cabezera3 = {"Monto Total", "Área"};
    DefaultTableModel modelo3 = new DefaultTableModel(cabezera3, 0);

    public TablasPequeñas() {
        initComponents();
        utelerias.cargarTable(modelo, tblDatos, 2);
        utelerias.cargarTable(modelo2, btlDatos2, 3);
        utelerias.cargarTable(modelo3, tblBonos, 4);
        graficarDatos();
        graficarBonos();
        graficoSexo();
    }

    private void graficarDatos() {
        //variables para los graficos
        JFreeChart grafico;
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        ChartPanel panel;
        try {
            //recorremos cada fila
            for (int i = 0; i < tblDatos.getRowCount(); i++) {
                datos.addValue(Integer.parseInt(tblDatos.getValueAt(i, 0).toString()), tblDatos.getValueAt(i, 1).toString(), tblDatos.getValueAt(i, 1).toString());
            }

            //mostramos los graficos
            grafico = ChartFactory.createBarChart("Grafico de cantidad de empleados por Área",
                    "Área", "Cantidad", datos, PlotOrientation.VERTICAL,
                    true, true,
                    false);
            panel = new ChartPanel(grafico);
            //contenido.add(panel);
            //panel.setBounds(300, 40, 400, 200);
            panel.setMouseWheelEnabled(true);
            panel.setPreferredSize(new Dimension(400, 200));

            contenido.setLayout(new BorderLayout());
            contenido.add(panel, BorderLayout.NORTH);
        } catch (NumberFormatException e) {
            System.out.println("""
                               Error al graficar :
                                """ + e.getMessage());
        }
    }

    private void graficarBonos() {
        try {
            //variables para los graficos
            JFreeChart graficoBonos;
            //variables para el grafico
            DefaultPieDataset datosBonos;
            datosBonos = new DefaultKeyedValuesDataset();

            for (int i = 0; i < tblBonos.getRowCount(); i++) {
                datosBonos.setValue(tblBonos.getValueAt(i, 1).toString(), Double.parseDouble(tblBonos.getValueAt(i, 0).toString()));
            }

            graficoBonos = ChartFactory.createPieChart("Monto total en Bonos por Área", datosBonos, true, true, false);

            //creamos un panel
            ChartPanel panelBonos = new ChartPanel(graficoBonos);
            panelBonos.setMouseWheelEnabled(true);
            panelBonos.setPreferredSize(new Dimension(370, 400));

            contenido3.setLayout(new BorderLayout());
            contenido3.add(panelBonos, BorderLayout.NORTH);
        } catch (NumberFormatException e) {
            System.out.println("Error al graficar la tabla Bonos: " + e.toString());
        }
    }

    private void graficoSexo() {
        try {
            //variables para los graficos
            JFreeChart grafico;
            //variables para el grafico
            DefaultPieDataset datos;
            datos = new DefaultKeyedValuesDataset();

            for (int i = 0; i < btlDatos2.getRowCount(); i++) {
                datos.setValue(btlDatos2.getValueAt(i, 1).toString(), Integer.parseInt(btlDatos2.getValueAt(i, 0).toString()));
            }

            grafico = ChartFactory.createPieChart("Cantidad de empleados segun su sexo", datos, true, true, false);

            //creamos un panel
            ChartPanel panel = new ChartPanel(grafico);
            panel.setMouseWheelEnabled(true);
            panel.setPreferredSize(new Dimension(400, 200));

            contenido2.setLayout(new BorderLayout());
            contenido2.add(panel, BorderLayout.NORTH);
        } catch (NumberFormatException e) {
            System.out.println("Error al graficar la tabla sexo: " + e.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenido = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        contenido2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        btlDatos2 = new javax.swing.JTable();
        contenido3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBonos = new javax.swing.JTable();

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº de empleados", "Área"
            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        btlDatos2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº de empleados", "Sexo"
            }
        ));
        jScrollPane2.setViewportView(btlDatos2);

        javax.swing.GroupLayout contenido2Layout = new javax.swing.GroupLayout(contenido2);
        contenido2.setLayout(contenido2Layout);
        contenido2Layout.setHorizontalGroup(
            contenido2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenido2Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contenido2Layout.setVerticalGroup(
            contenido2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenido2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        tblBonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Monto Bono", "Área"
            }
        ));
        jScrollPane3.setViewportView(tblBonos);

        javax.swing.GroupLayout contenido3Layout = new javax.swing.GroupLayout(contenido3);
        contenido3.setLayout(contenido3Layout);
        contenido3Layout.setHorizontalGroup(
            contenido3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenido3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        contenido3Layout.setVerticalGroup(
            contenido3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenido3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contenido2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(contenido3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(contenido3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(contenido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable btlDatos2;
    private javax.swing.JPanel contenido;
    private javax.swing.JPanel contenido2;
    private javax.swing.JPanel contenido3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblBonos;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}
