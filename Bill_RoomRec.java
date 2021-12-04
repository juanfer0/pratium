import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jfhui
 */
public class Bill_RoomRec extends javax.swing.JFrame {
    Connection con=null;    
    ResultSet rs=null;
    PreparedStatement pst=null;
    /**
     * Creates new form Bill_RoomRecord
     */
    public Bill_RoomRec() {
        initComponents();
        con= Connect.ConnectDB();
        Get_Data();
        setLocationRelativeTo(null);
    }
    private void Get_Data(){
         try{
                String sql="Seleccione el numero de Factura como 'numero de factura',Registro de Paciente.PacienteID como 'Paciente ID',Registro de Paciente.nombre de Paciente como 'Nombre de Paciente',Registro de Paciente.Gen como 'Genero',Registro de Paciente.BG como 'grupo Sanguineo',Enfermedad,AdmitDate como 'Fecha de Admicion',Cuarto.RoomNo acomo 'numerode cuarto',Doctor.DoctorID como 'Doctor ID',nombvre del doctor como 'Nobre del Doctor',DischargeDate como 'Fecha de Descarga',Factura_Cuarto.RoomCharges como 'Cambios de Cuartos',Factura_Cuarto.ServiceCharges como 'Cambios de Servicios',Factura_Cuarto.Fecha de Facturacion como 'fecha de facturacion',Metodo de Pago como 'Metodo de Pago',Detalles del Metodo de Pago como 'Detalles del Metodo de Pago',Cambios Totales como 'Cambios Totales',numero de dias como 'Numero de dias',Cambios de Cuarto Totales como 'Cambios de cuarto Totales' de cuarto,Doctor,Regsistro de Paciente,AdmitPatient_Room,Descarga de Paciente_Cuarto,Factura_Cuarto where Cuarto.nbumero de cuarto=AdmitPaciente_Room.Numero de cuarto y Doctor.DoctorID=AdmitPaciente_Cuarto.DoctorID y Registro de Paciente.PacienteID=AdmitPaciente_Cuarto.PacienteID  y AdmitPaciente_Cuarto.PacienteID= Descarga del Paciente_Cuarto.admitID and Factura_Cuarto.DischargeID=Descarga del Paciente_Cuarto.AdmitID  Ordenar Por fecah de Factura"; 
                pst=con.prepareStatement(sql);
                rs= pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
          }
    }
    /**
     * Creates new form Bill_RoomRec
     */
    

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

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        try{
            con=Connect.ConnectDB();
            int row= jTable1.getSelectedRow();
            this.hide();
            Bill_Room frm = new Bill_Room();
            frm.setVisible(true);
            String add= jTable1.getModel().getValueAt(row, 0).toString();
            frm.txtBillNo.setText(add);
             String add3= jTable1.getModel().getValueAt(row, 1).toString();
            frm.PatientID.setText(add3);
              String add4= jTable1.getModel().getValueAt(row, 2).toString();
            frm.txtPatientName.setText(add4);
              String add5= jTable1.getModel().getValueAt(row, 3).toString();
            frm.txtGender.setText(add5);
              String add6= jTable1.getModel().getValueAt(row, 4).toString();
            frm.txtBloodGroup.setText(add6);
              String add7= jTable1.getModel().getValueAt(row, 5).toString();
            frm.txtDisease.setText(add7);
              String add8= jTable1.getModel().getValueAt(row, 6).toString();
            frm.txtAdmitDate.setText(add8);
              String add9= jTable1.getModel().getValueAt(row, 7).toString();
            frm.txtRoomNo.setText(add9);
              String add10= jTable1.getModel().getValueAt(row, 8).toString();
            frm.txtDoctorID.setText(add10);
              String add11= jTable1.getModel().getValueAt(row, 9).toString();
            frm.txtDoctorName.setText(add11);
              String add12= jTable1.getModel().getValueAt(row, 10).toString();
            frm.txtDischargeDate.setText(add12);
              String add13= jTable1.getModel().getValueAt(row, 11).toString();
            frm.txtRoomCharges.setText(add13);
              String add14= jTable1.getModel().getValueAt(row, 12).toString();
            frm.txtServiceCharges.setText(add14);
              String add15= jTable1.getModel().getValueAt(row, 13).toString();
            frm.txtBillingDate.setText(add15);
              String add16= jTable1.getModel().getValueAt(row, 14).toString();
            frm.cmbPaymentMode.setSelectedItem(add16);
              String add17= jTable1.getModel().getValueAt(row, 15).toString();
            frm.txtPaymentModeDetails.setText(add17);
             String add18= jTable1.getModel().getValueAt(row, 16).toString();
            frm.txtTotalCharges.setText(add18);
             String add21= jTable1.getModel().getValueAt(row, 17).toString();
            frm.txtNoOfDays.setText(add21);
             String add22= jTable1.getModel().getValueAt(row, 18).toString();
            frm.txtTotalRoomCharges.setText(add22);
            frm.PatientID.setText(add3);
            frm.btnUpdate.setEnabled(true);
            frm.btnDelete.setEnabled(true);
            frm.btnSave.setEnabled(false);
          }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Bill_RoomRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bill_RoomRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bill_RoomRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bill_RoomRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bill_RoomRec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

