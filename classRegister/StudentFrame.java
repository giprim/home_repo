
package classRegister;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author GIPRIM
 */
public class StudentFrame extends javax.swing.JFrame {
    
    private final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=GITECK;integratedSecurity=true";
     
    public String getfname = getfNameString();
    public String getlname = getlNameString();
     
    private static String fNameString;
    private static String lNameString;

    
    // getter and setter for fNameString and lNameString so that I can use it in the AboutStudent Class;
    public static String getfNameString() {
        return fNameString;
    }

    public void setfNameString(String fNameString) {
        this.fNameString = fNameString;
    }

    public static String getlNameString() {
        return lNameString;
    }

    public void setlNameString(String lNameString) {
        
        this.lNameString = lNameString;
    }

    
    
    
    /**
     * Creates new form StudentFrame
     */
    public StudentFrame() {
        initComponents();
        favicon();
        
    }
    
    private void favicon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("collegeLcolor.png")));
    }

    
    
    // CHECK IF SURE NAME FROM THE SEARCH FIELD EXIST IN THE DATABASE > TABLE > STUDENT
    private void searchTheInput(){
        
            final String SELECT_QUERY = "SELECT * FROM STUDENT WHERE FIRSTNAME=? AND LASTNAME=?" ;
            
            ResultSet resultSet = null;
            try(
                    Connection connection = DriverManager.getConnection(DATABASE_URL);
                    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
               ){
                //nameTokens is an array which is then splitted by space (idiot you already knew this!)
                String[] nameTokens = getResultTxt.getText().split(" ");
                
                // used to insert the missing values for the sql (?) 
                //the setString method takes 2 arguments an int and the value with a matching dataType
                
                preparedStatement.setString(1,nameTokens[0]);
                preparedStatement.setString(2,nameTokens[1]);
                
                // with this line of code we run the query
                resultSet = preparedStatement.executeQuery();
                
                if(resultSet.next()){
                    fNameString = resultSet.getString("FIRSTNAME");
                    lNameString = resultSet.getString("LASTNAME");
                    
                    new AboutStudent().setVisible(true);
                    
                    // HERE WE DISPLAY A POPUP BOX GIVING US UPDATE IF THE SEARCHED FIRSTNAME AND LASTNAME WAS FOUND
                    //JOptionPane.showMessageDialog(this, "Student Found", "Edit form", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(this, "Student Not Found", "Edit form", JOptionPane.WARNING_MESSAGE);
                }
                
                
                
            }catch(SQLException e){
                //here, if there seems to be any error, this will come up
                JOptionPane.showMessageDialog(this, "Database Error", "Edit form", JOptionPane.ERROR_MESSAGE);
            }
            //here we close the connection to the SQL server
            finally{
                try{
                    resultSet.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
      
    }//end of searchTheInput() method
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        getResultTxt = new javax.swing.JTextField();
        studentListBtn = new javax.swing.JButton();
        attendanceBtn = new javax.swing.JButton();
        assessmentBtn = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GI TECK COLLEGE > STUDENT");
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(500, 270));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Info");

        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classRegister/-search.png"))); // NOI18N
        jButton1.setText("Result");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Get a student's result using their full name");

        getResultTxt.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        studentListBtn.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        studentListBtn.setForeground(new java.awt.Color(0, 153, 153));
        studentListBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classRegister/student1.png"))); // NOI18N
        studentListBtn.setText("List of Students");
        studentListBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentListBtnActionPerformed(evt);
            }
        });

        attendanceBtn.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        attendanceBtn.setForeground(new java.awt.Color(0, 153, 153));
        attendanceBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classRegister/attendance.png"))); // NOI18N
        attendanceBtn.setText("Attendance");
        attendanceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendanceBtnActionPerformed(evt);
            }
        });

        assessmentBtn.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        assessmentBtn.setForeground(new java.awt.Color(0, 153, 153));
        assessmentBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classRegister/book.png"))); // NOI18N
        assessmentBtn.setText("Assessment");
        assessmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assessmentBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(studentListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(assessmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(attendanceBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(getResultTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(getResultTxt))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assessmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attendanceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //calling the AttendanceFrame() Frame
    private void attendanceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendanceBtnActionPerformed
     
        new AttendanceFrame().setVisible(true);
    }//GEN-LAST:event_attendanceBtnActionPerformed

    //calling the ListOfStudentsFrame() Frame
    private void studentListBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentListBtnActionPerformed
        
        new ListOfStudentsFrame().setVisible(true);
    }//GEN-LAST:event_studentListBtnActionPerformed

    //calling the AssessmentTable() Frame
    private void assessmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assessmentBtnActionPerformed
             
        new AssessmentTable().setVisible(true);
    }//GEN-LAST:event_assessmentBtnActionPerformed

   
    
   
    // making sure searchTextField is not empty then call the method searchTheInput()
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!getResultTxt.getText().equals("")){
            
            searchTheInput();
           
            getResultTxt.setText("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assessmentBtn;
    private javax.swing.JButton attendanceBtn;
    private javax.swing.JTextField getResultTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton studentListBtn;
    // End of variables declaration//GEN-END:variables
}