/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Presentacion;

import javax.swing.table.DefaultTableModel;
import mx.itson.farmacia.Entidades.Laboratorio;
import mx.itson.farmacia.Entidades.Producto;
import mx.itson.farmacia.Implementacion.IProducto;
import mx.itson.farmacia.Interfaz.ProductoInterfaz;

/**
 *
 * @author Laprada
 */
public class VerProducto extends javax.swing.JInternalFrame {

    /**
     * Creates new form VerProducto
     */
    public VerProducto() {
        initComponents();
    }

    ProductoInterfaz pi = new IProducto();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMostrarProductosPro = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBusquedaPro = new javax.swing.JTextField();
        btnBusquedaProducto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnMostrarDatosPro = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);

        tblMostrarProductosPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Cantidad", "Descripcion", "Precio", "Laboratorio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMostrarProductosPro.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblMostrarProductosProAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tblMostrarProductosPro);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Productos Registrados");

        btnBusquedaProducto.setText("Buscar");
        btnBusquedaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaProductoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nota: La busqueda debe ser por nombre.");

        btnMostrarDatosPro.setText("Mostrar datos de productos registrados");
        btnMostrarDatosPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarDatosProActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBusquedaProducto)
                        .addGap(10, 10, 10)
                        .addComponent(txtBusquedaPro, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(174, 174, 174)
                        .addComponent(btnMostrarDatosPro))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBusquedaPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(btnMostrarDatosPro))
                    .addComponent(btnBusquedaProducto))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void llenarTablaProductos(){
         
         DefaultTableModel dtm =  new DefaultTableModel();
         tblMostrarProductosPro.setModel(dtm);
        
        dtm.addColumn("Id");
        dtm.addColumn("Nombre");
        dtm.addColumn("Cantidad");
        dtm.addColumn("Descripcion");
        dtm.addColumn("Precio Unitario");
        dtm.addColumn("Laboratorio");
       
        
        for(Producto lab: pi.obtenerProductos()){
            
            Object[] fila = new Object[6];
            fila[0] = lab.getId();
            fila[1] = lab.getNombre();
            fila[2] = lab.getCantidad();
            fila[3] = lab.getDescripcion();
            fila[4] = lab.getPrecioUnitario();
            fila[5] = lab.getLaboratorio().getNombre();
            
            dtm.addRow(fila);
         
        }
    }
    private void llenarTablaProductos(String x){
         
         DefaultTableModel dtm =  new DefaultTableModel();
         tblMostrarProductosPro.setModel(dtm);
        
        dtm.addColumn("Id");
        dtm.addColumn("Nombre");
        dtm.addColumn("Cantidad");
        dtm.addColumn("Descripcion");
        dtm.addColumn("Precio Unitario");
        dtm.addColumn("Laboratorio");
       
        
        for(Producto lab: pi.buscarProducto(x)){
            
            Object[] fila = new Object[6];
            fila[0] = lab.getId();
            fila[1] = lab.getNombre();
            fila[2] = lab.getCantidad();
            fila[3] = lab.getDescripcion();
            fila[4] = lab.getPrecioUnitario();
            fila[5] = lab.getLaboratorio().getNombre();
            
            dtm.addRow(fila);
         
        }
    }
    private void btnBusquedaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaProductoActionPerformed
        // TODO add your handling code here:
        
        String busqueda = txtBusquedaPro.getText().trim();
        llenarTablaProductos(busqueda);
        
    }//GEN-LAST:event_btnBusquedaProductoActionPerformed

    private void tblMostrarProductosProAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblMostrarProductosProAncestorAdded
        // TODO add your handling code here:
        
        llenarTablaProductos();
    }//GEN-LAST:event_tblMostrarProductosProAncestorAdded

    private void btnMostrarDatosProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarDatosProActionPerformed
        // TODO add your handling code here:
        
        llenarTablaProductos();
    }//GEN-LAST:event_btnMostrarDatosProActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusquedaProducto;
    private javax.swing.JButton btnMostrarDatosPro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMostrarProductosPro;
    private javax.swing.JTextField txtBusquedaPro;
    // End of variables declaration//GEN-END:variables
}