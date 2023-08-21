/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrame;

import LibraryManagement.ConnectMSSQL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AsadullauhSojib
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    

    public void getBookDetails() {
        int bookId = Integer.parseInt(issue_txt_bookId.getText());
        try {
            Connection con = ConnectMSSQL.connectDB();
            String sql = "select * from book_details where bookId =?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, bookId);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                issue_bookId.setText(rs.getString("bookId"));
                issue_bookName.setText(rs.getString("bookName"));
                issue_author.setText(rs.getString("author"));
                issue_quantity.setText(rs.getString("quantity"));
            } else {
                issue_bookError.setText("Invalid Book ID!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getStudentDetails() {
        int studentId = Integer.parseInt(issue_txt_studentId.getText());
        try {
            Connection con = ConnectMSSQL.connectDB();
            String sql = "select * from student_details where studentId =?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, studentId);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                issue_studentId.setText(rs.getString("studentId"));
                issue_studentName.setText(rs.getString("name"));
                issue_department.setText(rs.getString("department"));
                issue_branch.setText(rs.getString("branch"));
            } else {
                issue_studentError.setText("Invalid Student ID!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean issueBook(){
        boolean isIssued = false;
        int bookId = Integer.parseInt(issue_txt_bookId.getText());
        int studentId=Integer.parseInt(issue_txt_studentId.getText());
        
        String bookName = issue_bookName.getText();
        String studentName = issue_studentName.getText();
        
        java.util.Date issueDate = issue_issueDate.getDatoFecha();
        java.util.Date dueDate = issue_dueDate.getDatoFecha();
        
        Long l1 = issueDate.getTime();
        Long l2=dueDate.getTime();
        
        Date sqlIssueDate = new Date(l1);
        Date sqlDueDate = new Date(l2); 
        
          
//          Date issueDate = (Date) issue_issueDate.getDatoFecha();
//          Date dueDate = (Date) issue_dueDate.getDatoFecha();
//          
          try {
              Connection con = ConnectMSSQL.connectDB();
              String sql = "insert into issue_book_details (bookId,bookName,studentId,studentName,"
                      + "issueDate,dueDate) values(?,?,?,?,?,?)";
              PreparedStatement pst = con.prepareStatement(sql);
              
              pst.setInt(1, bookId);
              pst.setString(2, bookName);
              pst.setInt(3, studentId);
              pst.setString(4, studentName);
              pst.setDate(5, sqlIssueDate);
              pst.setDate(6, sqlDueDate);
              //pst.setString(7, "pending");
              
              int rowCount = pst.executeUpdate();
              if(rowCount>0){
                  isIssued = true;
              }else
                  isIssued=false;
              
              
            } catch (Exception e) {
                  e.printStackTrace();
            }
          return isIssued;
        
        }
    
    public void updateBookCount(){
        int bookId = Integer.parseInt(issue_txt_bookId.getText());
        try {
            Connection con = ConnectMSSQL.connectDB();
            String sql = "update book_details set quantity = quantity-1 where bookId=?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, bookId);
            
            int rowCount =pst.executeUpdate();
            
            if(rowCount>0){
                JOptionPane.showMessageDialog(this, "Book Count Updated");
                int iniCount = Integer.parseInt(issue_quantity.getText());
                issue_quantity.setText(Integer.toString(iniCount-1));
                
            }else
                JOptionPane.showMessageDialog(this, "Can't Update Book Count");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public boolean isAlreadyIssued(){
        boolean isAlreadyIssued = false;
        int bookId = Integer.parseInt(issue_bookId.getText());
        int studentID = Integer.parseInt(issue_studentId.getText());
        try {
            Connection con = ConnectMSSQL.connectDB();
            String sql = "Select * from issue_book_details where bookId=? and studentId = ? and state= ?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, bookId);
            pst.setInt(2, studentID);
            pst.setString(3, "pending");
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()){
                isAlreadyIssued=true;
            }else
                isAlreadyIssued= false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAlreadyIssued;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        issue_branch = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        issue_studentId = new javax.swing.JLabel();
        issue_studentName = new javax.swing.JLabel();
        issue_department = new javax.swing.JLabel();
        issue_studentError = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        issue_bookId = new javax.swing.JLabel();
        issue_quantity = new javax.swing.JLabel();
        issue_author = new javax.swing.JLabel();
        issue_bookName = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        issue_bookError = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        issue_txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        issue_txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel18 = new javax.swing.JLabel();
        issue_issueDate = new rojeru_san.componentes.RSDateChooser();
        rSDateChooser2 = new rojeru_san.componentes.RSDateChooser();
        jLabel19 = new javax.swing.JLabel();
        issue_dueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel20 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 0, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("STXihei", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 204));
        jLabel2.setText("Branch");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, -1, -1));

        jLabel3.setFont(new java.awt.Font("STXihei", 0, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 204));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel3.setText("Student Details");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        issue_branch.setFont(new java.awt.Font("STXihei", 0, 20)); // NOI18N
        issue_branch.setForeground(new java.awt.Color(255, 255, 204));
        jPanel2.add(issue_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, 240, 30));

        jLabel5.setFont(new java.awt.Font("STXihei", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 204));
        jLabel5.setText("Student Name");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        jLabel6.setFont(new java.awt.Font("STXihei", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 204));
        jLabel6.setText("Department");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, -1, -1));

        jLabel13.setFont(new java.awt.Font("STXihei", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 204));
        jLabel13.setText("Student ID");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        issue_studentId.setFont(new java.awt.Font("STXihei", 0, 20)); // NOI18N
        issue_studentId.setForeground(new java.awt.Color(255, 255, 204));
        jPanel2.add(issue_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 240, 30));

        issue_studentName.setFont(new java.awt.Font("STXihei", 0, 20)); // NOI18N
        issue_studentName.setForeground(new java.awt.Color(255, 255, 204));
        jPanel2.add(issue_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 240, 30));

        issue_department.setFont(new java.awt.Font("STXihei", 0, 20)); // NOI18N
        issue_department.setForeground(new java.awt.Color(255, 255, 204));
        jPanel2.add(issue_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 240, 30));

        issue_studentError.setFont(new java.awt.Font("STXihei", 0, 20)); // NOI18N
        issue_studentError.setForeground(new java.awt.Color(255, 255, 102));
        jPanel2.add(issue_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, 350, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 420, 800));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(51, 0, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 204));
        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 204));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel7.setText("Back");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, 30));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 50));

        jLabel9.setFont(new java.awt.Font("STXihei", 0, 25)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 204));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel9.setText("Book Details");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        jLabel10.setFont(new java.awt.Font("STXihei", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 204));
        jLabel10.setText("Book ID");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        jLabel11.setFont(new java.awt.Font("STXihei", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 204));
        jLabel11.setText("Book Name");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        jLabel12.setFont(new java.awt.Font("STXihei", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 204));
        jLabel12.setText("Author");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, -1, -1));

        issue_bookId.setFont(new java.awt.Font("STXihei", 0, 20)); // NOI18N
        issue_bookId.setForeground(new java.awt.Color(255, 255, 204));
        jPanel4.add(issue_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 240, 30));

        issue_quantity.setFont(new java.awt.Font("STXihei", 0, 20)); // NOI18N
        issue_quantity.setForeground(new java.awt.Color(255, 255, 204));
        jPanel4.add(issue_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, 240, 30));

        issue_author.setFont(new java.awt.Font("STXihei", 0, 20)); // NOI18N
        issue_author.setForeground(new java.awt.Color(255, 255, 204));
        jPanel4.add(issue_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 240, 30));

        issue_bookName.setFont(new java.awt.Font("STXihei", 0, 20)); // NOI18N
        issue_bookName.setForeground(new java.awt.Color(255, 255, 204));
        jPanel4.add(issue_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 240, 30));

        jLabel14.setFont(new java.awt.Font("STXihei", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 204));
        jLabel14.setText("Quantity");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, -1, -1));

        issue_bookError.setFont(new java.awt.Font("STXihei", 0, 20)); // NOI18N
        issue_bookError.setForeground(new java.awt.Color(255, 255, 0));
        jPanel4.add(issue_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, 330, 50));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 800));

        jLabel4.setFont(new java.awt.Font("STXihei", 0, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 51));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel4.setText("Issue Books");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 90, -1, -1));

        jPanel7.setBackground(new java.awt.Color(51, 0, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("STXinwei", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText(" X");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 10, 50, -1));

        issue_txt_bookId.setBackground(new java.awt.Color(240, 240, 240));
        issue_txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 0, 51)));
        issue_txt_bookId.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        issue_txt_bookId.setPhColor(new java.awt.Color(51, 0, 51));
        issue_txt_bookId.setPlaceholder("Enter Book ID...");
        issue_txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                issue_txt_bookIdFocusLost(evt);
            }
        });
        issue_txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issue_txt_bookIdActionPerformed(evt);
            }
        });
        jPanel1.add(issue_txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 252, 320, 30));

        jLabel16.setFont(new java.awt.Font("STXihei", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 0, 51));
        jLabel16.setText("Book ID");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 260, -1, -1));

        jLabel17.setFont(new java.awt.Font("STXihei", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 0, 51));
        jLabel17.setText("Issue Date");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 440, -1, -1));

        issue_txt_studentId.setBackground(new java.awt.Color(240, 240, 240));
        issue_txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 0, 51)));
        issue_txt_studentId.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        issue_txt_studentId.setPhColor(new java.awt.Color(51, 0, 51));
        issue_txt_studentId.setPlaceholder("Enter Student ID...");
        issue_txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                issue_txt_studentIdFocusLost(evt);
            }
        });
        issue_txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issue_txt_studentIdActionPerformed(evt);
            }
        });
        jPanel1.add(issue_txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 340, 320, 30));

        jLabel18.setFont(new java.awt.Font("STXihei", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 0, 51));
        jLabel18.setText("Student ID");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 350, -1, -1));

        issue_issueDate.setBackground(new java.awt.Color(51, 0, 51));
        issue_issueDate.setColorBackground(new java.awt.Color(51, 0, 51));
        issue_issueDate.setColorForeground(new java.awt.Color(51, 0, 51));
        issue_issueDate.setColorSelForeground(new java.awt.Color(240, 240, 240));
        issue_issueDate.setColorTextDiaActual(new java.awt.Color(240, 240, 240));
        issue_issueDate.setFont(new java.awt.Font("STXihei", 0, 17)); // NOI18N
        issue_issueDate.setFuente(new java.awt.Font("STXihei", 0, 12)); // NOI18N
        issue_issueDate.setPlaceholder("Select Issued Date...");
        jPanel1.add(issue_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 430, 320, -1));

        rSDateChooser2.setBackground(new java.awt.Color(51, 0, 51));
        rSDateChooser2.setColorBackground(new java.awt.Color(51, 0, 51));
        rSDateChooser2.setColorForeground(new java.awt.Color(51, 0, 51));
        rSDateChooser2.setFont(new java.awt.Font("STXihei", 0, 17)); // NOI18N
        rSDateChooser2.setFuente(new java.awt.Font("STXihei", 0, 12)); // NOI18N
        rSDateChooser2.setPlaceholder("Select Issued Date...");
        jPanel1.add(rSDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 430, 320, -1));

        jLabel19.setFont(new java.awt.Font("STXihei", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 0, 51));
        jLabel19.setText("Issue Date");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 440, -1, -1));

        issue_dueDate.setBackground(new java.awt.Color(51, 0, 51));
        issue_dueDate.setColorBackground(new java.awt.Color(51, 0, 51));
        issue_dueDate.setColorForeground(new java.awt.Color(51, 0, 51));
        issue_dueDate.setFont(new java.awt.Font("STXihei", 0, 17)); // NOI18N
        issue_dueDate.setFuente(new java.awt.Font("STXihei", 0, 12)); // NOI18N
        issue_dueDate.setPlaceholder("Select Due Date...");
        jPanel1.add(issue_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 530, 320, -1));

        jLabel20.setFont(new java.awt.Font("STXihei", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 0, 51));
        jLabel20.setText("Due Date");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 540, -1, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(51, 0, 51));
        rSMaterialButtonCircle2.setForeground(new java.awt.Color(255, 255, 204));
        rSMaterialButtonCircle2.setText("ISSUE BOOK");
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
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 630, 270, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 800));

        setSize(new java.awt.Dimension(1408, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void issue_txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_issue_txt_bookIdFocusLost
        // TODO add your handling code here:
        if (!issue_txt_bookId.getText().equals("")) {
            getBookDetails();
        }

    }//GEN-LAST:event_issue_txt_bookIdFocusLost

    private void issue_txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issue_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_issue_txt_bookIdActionPerformed

    private void issue_txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_issue_txt_studentIdFocusLost
        // TODO add your handling code here:
        if (!issue_txt_studentId.getText().equals("")) {
            getStudentDetails();
        }
    }//GEN-LAST:event_issue_txt_studentIdFocusLost

    private void issue_txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issue_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_issue_txt_studentIdActionPerformed

    private void rSMaterialButtonCircle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle2MouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        //TODO add your handling code here:
        if (issue_quantity.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Book is not available");

        }else
            
            if (isAlreadyIssued() ==false){
                if (issueBook() == true) {
                    JOptionPane.showMessageDialog(this, "Book Issued Successfully");
                    updateBookCount();
                }else
                    JOptionPane.showMessageDialog(this, "Can't Issue this book");
            }else
                JOptionPane.showMessageDialog(this, "This student already has this book");
                
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel issue_author;
    private javax.swing.JLabel issue_bookError;
    private javax.swing.JLabel issue_bookId;
    private javax.swing.JLabel issue_bookName;
    private javax.swing.JLabel issue_branch;
    private javax.swing.JLabel issue_department;
    private rojeru_san.componentes.RSDateChooser issue_dueDate;
    private rojeru_san.componentes.RSDateChooser issue_issueDate;
    private javax.swing.JLabel issue_quantity;
    private javax.swing.JLabel issue_studentError;
    private javax.swing.JLabel issue_studentId;
    private javax.swing.JLabel issue_studentName;
    private app.bolivia.swing.JCTextField issue_txt_bookId;
    private app.bolivia.swing.JCTextField issue_txt_studentId;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private rojeru_san.componentes.RSDateChooser rSDateChooser2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle2;
    // End of variables declaration//GEN-END:variables
}
