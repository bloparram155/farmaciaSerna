/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Presentacion;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mx.itson.farmacia.Entidades.Usuario;
import mx.itson.farmacia.Implementacion.IUsuario;
import mx.itson.farmacia.Interfaz.UsuarioInterfaz;

/**
 *
 * @author Laprada
 */
public class VerUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form VerUsuario
     */
    public VerUsuario() {
        initComponents();
    }

    
    UsuarioInterfaz usi = new IUsuario();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnBusqueda = new javax.swing.JButton();
        txtBusquedaUsuario = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMostrarUsuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);

        btnBusqueda.setText("Buscar");
        btnBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaActionPerformed(evt);
            }
        });

        tblMostrarUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Domicilio", "Ciudad", "Telefono", "Edad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMostrarUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMostrarUsuariosMouseClicked(evt);
            }
        });
        tblMostrarUsuarios.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblMostrarUsuariosAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(tblMostrarUsuarios);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Datos de Usuarios");

        jLabel2.setText("Nota: Buscar por nombre.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBusqueda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBusquedaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusquedaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusqueda)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void llenarTablaBusqueda(String nombre){
        DefaultTableModel dtm =  new DefaultTableModel();
        tblMostrarUsuarios.setModel(dtm);
        
        dtm.addColumn("Nombre");
        dtm.addColumn("Apellido");
        dtm.addColumn("Domicilio");
        dtm.addColumn("Ciudad");
        dtm.addColumn("Telefono");
        dtm.addColumn("Edad");
        
        for(Usuario user: usi.buscarUsuario(nombre)){
            
            Object[] fila = new Object[7];
            fila[0] = user.getNombre();
            fila[1] = user.getApellido();
            fila[2] = user.getDomicilio();
            fila[3] = user.getCiudad();
            fila[4] = user.getTelefono();
            fila[5] = user.getEdad();
            dtm.addRow(fila);
         
        }
    }
    
    private void llenarTabla(){
         DefaultTableModel dtm =  new DefaultTableModel();
        tblMostrarUsuarios.setModel(dtm);
        
        dtm.addColumn("Nombre");
        dtm.addColumn("Apellido");
        dtm.addColumn("Domicilio");
        dtm.addColumn("Ciudad");
        dtm.addColumn("Telefono");
        dtm.addColumn("Edad");
        
        for(Usuario user: usi.mostrarUsuarios()){
            
            Object[] fila = new Object[7];
            fila[0] = user.getNombre();
            fila[1] = user.getApellido();
            fila[2] = user.getDomicilio();
            fila[3] = user.getCiudad();
            fila[4] = user.getTelefono();
            fila[5] = user.getEdad();
            dtm.addRow(fila);
         
        }
    }
    private void tblMostrarUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMostrarUsuariosMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_tblMostrarUsuariosMouseClicked

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        // TODO add your handling code here:
        
        String busqueda = txtBusquedaUsuario.getText().trim();
        
        llenarTablaBusqueda(busqueda);
        
       
       
        
        
    }//GEN-LAST:event_btnBusquedaActionPerformed

    private void tblMostrarUsuariosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblMostrarUsuariosAncestorAdded
        // TODO add your handling code here:
        llenarTabla();
        
        
    }//GEN-LAST:event_tblMostrarUsuariosAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblMostrarUsuarios;
    private javax.swing.JTextField txtBusquedaUsuario;
    // End of variables declaration//GEN-END:variables
}