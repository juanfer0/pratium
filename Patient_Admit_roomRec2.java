import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class Patient_Admit_roomRec2 extends javax.swing.JFrame {
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
   
    public Patient_Admit_roomRec2() {
        initComponents();
        con= Connect.ConnectDB();
        Get_Data();
        setLocationRelativeTo(null);
    }
    private void Get_Data(){
       String sql="Seleccione Registro de Paciente.PacienteID como 'Paciente ID',Registro de Paciente.Nombre de Paciente como 'Nombre de Paciente',Registro de Paciente.Genero como 'Genero',Registro de Paciente.BG como 'Grupo Sanguineo',Enfermedad,Fecha de Admicion como 'Fecha de Admicion',Cuarto.Numero de Cuarto 'Numero de Cuarto',Doctor.DoctorID as 'Doctor ID',Nombre de Doctor como 'Nombre de Doctor',AdmitPatient_Cuarto.AP_Observaciones como 'Observaciones' de Cuarto,Doctor,Registro de Paciente,AdmitPatient_Cuarto donde Cuarto.Numero de Caurto=AdmitPatient_Cuarto.Numero de Cuarto y Doctor.DoctorID=AdmitPatient_Cuarto.DoctorID y Registro de Paciente.PatientID=AdmitPatient_Cuarto.PacienteID ordenado por Fecha de Admicion";
       try{
          pst=con.prepareStatement(sql);
          rs= pst.executeQuery();
          jTable1.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
          }
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
                "Titulo 1", "Titulo 2", "Titulo 3", "Titulo 4"
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        
    }                                    

    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
      
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        try{
            con=Connect.ConnectDB();
            int row= jTable1.getSelectedRow();
            String table_click= jTable1.getModel().getValueAt(row, 0).toString();
            String sql="Seleccione * de Cuarto,Doctor,Registro del Paciente,AdmitPatient_Cuarto donde Carto.Numero de Cuarto=AdmitPatient_Cuarto.Numero de Cuarto y Doctor.DoctorID=AdmitPatient_Cuarto.DoctorID y Registro de Paciente.PacienteID=AdmitPatient_Cuarto.PacienteID y Registro de Paciente.PacienteID = '" + table_click + "'";   
            pst=con.prepareStatement(sql);
            rs=  pst.executeQuery();
            if(rs.next()){
                this.hide();
                Patient_Discharge_room frm = new Patient_Discharge_room();
                frm.setVisible(true);
                String add1=rs.getString("DoctorID");
                frm.txtDoctorID.setText(add1);
                String add2=rs.getString("Nombre de Doctor");
                frm.txtDoctorName.setText(add2);
                String add3=rs.getString("PacienteID");
                frm.PatientID.setText(add3);
                String add5=rs.getString("Nombre de Paciente");
                frm.txtPatientName.setText(add5);
                String add6=rs.getString("Genero");
                frm.txtGender.setText(add6);
                String add7=rs.getString("BG");
                frm.txtBloodGroup.setText(add7);
                String add9=rs.getString("Enfermedad");
                frm.txtDisease.setText(add9);
                String add11=rs.getString("Fecha de ADmicion");
                frm.txtAdmitDate.setText(add11);
                String add14=rs.getString("Numero de Cuarto");
                frm.txtRoomNo.setText(add14);
                          
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
        }
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
            java.util.logging.Logger.getLogger(Patient_Admit_roomRec2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient_Admit_roomRec2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient_Admit_roomRec2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient_Admit_roomRec2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patient_Admit_roomRec2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

