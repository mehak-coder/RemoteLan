
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AdminSetPassword extends javax.swing.JFrame {

    public AdminSetPassword() {
        initComponents();
        setSize(500,500);
                getContentPane().setBackground(new java.awt.Color(204,255,255));

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfusername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfpass = new javax.swing.JPasswordField();
        btsetpass = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 30, 130, 50);
        getContentPane().add(tfusername);
        tfusername.setBounds(180, 40, 170, 30);

        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 100, 90, 30);
        getContentPane().add(tfpass);
        tfpass.setBounds(180, 100, 170, 30);

        btsetpass.setText("Set Password");
        btsetpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsetpassActionPerformed(evt);
            }
        });
        getContentPane().add(btsetpass);
        btsetpass.setBounds(80, 183, 190, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btsetpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsetpassActionPerformed
       
        String user=tfusername.getText();
        String pass=tfpass.getText();
        if(user.isEmpty() || pass.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "All fields are required !");
        }
        else{
        File f=new File("src/files/logindetails.txt");
        try {
           // f.createNewFile();
                        PrintWriter pw=new PrintWriter(f);
                        pw.println("Username:"+user);
                        pw.println("Password:"+pass);
                        pw.flush();
                        pw.close();
                        dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        } 
    }//GEN-LAST:event_btsetpassActionPerformed

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
            java.util.logging.Logger.getLogger(AdminSetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminSetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminSetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminSetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminSetPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btsetpass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField tfpass;
    private javax.swing.JTextField tfusername;
    // End of variables declaration//GEN-END:variables
}
