/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrame;

import LibraryManagement.ConnectMSSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AsadullauhSojib
 */
public class ViewAllRecord extends javax.swing.JFrame {

    /**
     * Creates new form ViewAllRecord
     */
    DefaultTableModel model;

    public ViewAllRecord() {
        initComponents();
        setStudentDetailsToTable();
    }

    public void setStudentDetailsToTable() {
        try {
            Connection con = ConnectMSSQL.connectDB();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from issue_book_details ");

            while (rs.next()) {
                String id = rs.getString("issueId");
                String bookName = rs.getString("bookName");
                String studentName = rs.getString("studentName");
                String issueDate = rs.getString("issueDate");
                String dueDate = rs.getString("dueDate");
                String state = rs.getString("state");

                Object[] obj = {id, bookName, studentName, issueDate, dueDate, state};
                model = (DefaultTableModel) tbl_bookDetails.getModel();
                model.addRow(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void clearTable() { //not to get the previoius data
        DefaultTableModel model = (DefaultTableModel) tbl_bookDetails.getModel();
        model.setRowCount(0);
    }

    public void search() {
        Date ufromDate = date_fromDate.getDatoFecha();
       Date utoDate = date_toDate.getDatoFecha();

        long l1 = ufromDate.getTime();
        long l2 = utoDate.getTime();

        java.sql.Date sqlFromDate = new java.sql.Date(l1);
        java.sql.Date sqlToDate = new java.sql.Date(l2);

        try {
            Connection con = ConnectMSSQL.connectDB();
            String sql = "select * from issue_book_details where issueDate BETWEEN ? and ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setDate(1, sqlFromDate);
            pst.setDate(2, sqlToDate);

            ResultSet rs = pst.executeQuery();
            if (rs.next() == false) {
                JOptionPane.showMessageDialog(this, "No Record Found");
            } else {
                while (rs.next()) {
                    String id = rs.getString("issueId");
                    String bookName = rs.getString("bookName");
                    String studentName = rs.getString("studentName");
                    String issueDate = rs.getString("issueDate");
                    String dueDate = rs.getString("dueDate");
                    String state = rs.getString("state");

                    Object[] obj = {id, bookName, studentName, issueDate, dueDate, state};
                    model = (DefaultTableModel) tbl_bookDetails.getModel();
                    model.addRow(obj);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        date_toDate = new rojeru_san.componentes.RSDateChooser();
        jLabel21 = new javax.swing.JLabel();
        date_fromDate = new rojeru_san.componentes.RSDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        Panel_table = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojerusan.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("STXihei", 0, 25)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 204));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel9.setText("View All Record");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, -1));

        jLabel20.setFont(new java.awt.Font("STXihei", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 204));
        jLabel20.setText("Issue Date To");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, 40));

        date_toDate.setBackground(new java.awt.Color(51, 0, 51));
        date_toDate.setColorBackground(new java.awt.Color(51, 0, 51));
        date_toDate.setColorForeground(new java.awt.Color(51, 0, 51));
        date_toDate.setColorSelForeground(new java.awt.Color(0, 102, 102));
        date_toDate.setColorTextDiaActual(new java.awt.Color(0, 102, 102));
        date_toDate.setFont(new java.awt.Font("STXihei", 0, 17)); // NOI18N
        date_toDate.setFuente(new java.awt.Font("STXihei", 0, 12)); // NOI18N
        date_toDate.setPlaceholder("To...");
        jPanel1.add(date_toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 320, -1));

        jLabel21.setFont(new java.awt.Font("STXihei", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 204));
        jLabel21.setText("Issue Date From");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 40));

        date_fromDate.setBackground(new java.awt.Color(51, 0, 51));
        date_fromDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 102)));
        date_fromDate.setColorBackground(new java.awt.Color(51, 0, 51));
        date_fromDate.setColorForeground(new java.awt.Color(51, 0, 51));
        date_fromDate.setColorSelForeground(new java.awt.Color(0, 102, 102));
        date_fromDate.setColorTextDiaActual(new java.awt.Color(0, 102, 102));
        date_fromDate.setFont(new java.awt.Font("STXihei", 0, 17)); // NOI18N
        date_fromDate.setFuente(new java.awt.Font("STXihei", 0, 12)); // NOI18N
        date_fromDate.setPlaceholder("From...");
        jPanel1.add(date_fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 320, -1));

        jPanel3.setBackground(new java.awt.Color(51, 0, 51));
        jPanel3.setForeground(new java.awt.Color(255, 255, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 204));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("Back");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 50));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("STXinwei", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 0, 50, 50));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 255, 204));
        rSMaterialButtonCircle2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 204)));
        rSMaterialButtonCircle2.setForeground(new java.awt.Color(51, 0, 51));
        rSMaterialButtonCircle2.setText("View All");
        rSMaterialButtonCircle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle2MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 190, 200, 60));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 255, 204));
        rSMaterialButtonCircle3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 204)));
        rSMaterialButtonCircle3.setForeground(new java.awt.Color(51, 0, 51));
        rSMaterialButtonCircle3.setText("SEARCH");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 190, 200, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 280));

        Panel_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Name", "Student Name", "Issue Date", "Due Date", "State"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(51, 51, 0));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(204, 255, 204));
        tbl_bookDetails.setColorBordeHead(new java.awt.Color(204, 255, 204));
        tbl_bookDetails.setColorFilasBackgound1(new java.awt.Color(204, 255, 204));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(204, 255, 204));
        tbl_bookDetails.setColorFilasForeground1(new java.awt.Color(51, 0, 0));
        tbl_bookDetails.setColorFilasForeground2(new java.awt.Color(51, 51, 0));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        tbl_bookDetails.setFont(new java.awt.Font("STXihei", 0, 25)); // NOI18N
        tbl_bookDetails.setFuenteFilas(new java.awt.Font("STXihei", 0, 18)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("STXihei", 1, 20)); // NOI18N
        tbl_bookDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_bookDetails.setRowHeight(40);
        tbl_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_bookDetails);

        Panel_table.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 1220, 410));

        getContentPane().add(Panel_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 1480, 580));

        setSize(new java.awt.Dimension(1481, 857));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailsMouseClicked
        // TODO add your handling code here:
        int rowNo = tbl_bookDetails.getSelectedRow();

    }//GEN-LAST:event_tbl_bookDetailsMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
       if (date_fromDate.getDatoFecha() != null && date_toDate.getDatoFecha() != null) {
            clearTable();
            search();
        }else{
            JOptionPane.showMessageDialog(this,"Plese Select Date");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2MouseClicked
       clearTable();
       setStudentDetailsToTable();
       
    }//GEN-LAST:event_rSMaterialButtonCircle2MouseClicked

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
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAllRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_table;
    private rojeru_san.componentes.RSDateChooser date_fromDate;
    private rojeru_san.componentes.RSDateChooser date_toDate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSTableMetro tbl_bookDetails;
    // End of variables declaration//GEN-END:variables
}
