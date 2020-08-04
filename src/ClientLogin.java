
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClientLogin extends javax.swing.JFrame {

    String ip;

    public ClientLogin() {
        initComponents();
        setSize(700, 700);
        setVisible(true);
    }

    public ClientLogin(String ip) {
        initComponents();
        this.ip = ip;
        loginpanel.setVisible(false);
        detailspanel.setVisible(false);
        optionspanel.setVisible(false);
        setSize(700, 700);
                getContentPane().setBackground(new java.awt.Color(204,255,255));

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btlogin = new javax.swing.JButton();
        loginpanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfuser = new javax.swing.JTextField();
        tfpass = new javax.swing.JPasswordField();
        btconnect = new javax.swing.JButton();
        detailspanel = new javax.swing.JPanel();
        lbos = new javax.swing.JLabel();
        lbversion = new javax.swing.JLabel();
        lbprocessors = new javax.swing.JLabel();
        lbspace = new javax.swing.JLabel();
        lbmemory = new javax.swing.JLabel();
        optionspanel = new javax.swing.JPanel();
        btshutdown = new javax.swing.JButton();
        btrestart = new javax.swing.JButton();
        btlogoff = new javax.swing.JButton();
        btviewscreen = new javax.swing.JButton();
        btsendmessage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btlogin.setText("Login");
        btlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btloginActionPerformed(evt);
            }
        });
        getContentPane().add(btlogin);
        btlogin.setBounds(230, 20, 130, 40);

        loginpanel.setBackground(new java.awt.Color(255, 255, 153));
        loginpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        loginpanel.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Username");
        loginpanel.add(jLabel1);
        jLabel1.setBounds(10, 30, 100, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Password");
        loginpanel.add(jLabel2);
        jLabel2.setBounds(10, 90, 100, 40);
        loginpanel.add(tfuser);
        tfuser.setBounds(110, 30, 140, 30);
        loginpanel.add(tfpass);
        tfpass.setBounds(110, 90, 140, 30);

        btconnect.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btconnect.setText("Connect");
        btconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btconnectActionPerformed(evt);
            }
        });
        loginpanel.add(btconnect);
        btconnect.setBounds(70, 150, 120, 40);

        getContentPane().add(loginpanel);
        loginpanel.setBounds(20, 90, 280, 230);

        detailspanel.setBackground(new java.awt.Color(255, 204, 204));
        detailspanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        detailspanel.setLayout(null);

        lbos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbos.setText("jLabel3");
        detailspanel.add(lbos);
        lbos.setBounds(30, 20, 230, 30);

        lbversion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbversion.setText("jLabel3");
        detailspanel.add(lbversion);
        lbversion.setBounds(30, 60, 250, 40);

        lbprocessors.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbprocessors.setText("jLabel3");
        detailspanel.add(lbprocessors);
        lbprocessors.setBounds(30, 110, 240, 40);

        lbspace.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbspace.setText("jLabel3");
        detailspanel.add(lbspace);
        lbspace.setBounds(30, 160, 230, 40);

        lbmemory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbmemory.setText("jLabel3");
        detailspanel.add(lbmemory);
        lbmemory.setBounds(30, 210, 230, 40);

        getContentPane().add(detailspanel);
        detailspanel.setBounds(360, 90, 320, 270);

        optionspanel.setBackground(new java.awt.Color(204, 255, 204));
        optionspanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        optionspanel.setLayout(null);

        btshutdown.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btshutdown.setText("Shut down");
        btshutdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btshutdownActionPerformed(evt);
            }
        });
        optionspanel.add(btshutdown);
        btshutdown.setBounds(20, 30, 130, 40);

        btrestart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btrestart.setText("Restart");
        btrestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btrestartActionPerformed(evt);
            }
        });
        optionspanel.add(btrestart);
        btrestart.setBounds(370, 30, 150, 40);

        btlogoff.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btlogoff.setText("Log Off");
        btlogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlogoffActionPerformed(evt);
            }
        });
        optionspanel.add(btlogoff);
        btlogoff.setBounds(20, 90, 130, 40);

        btviewscreen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btviewscreen.setText("View Screen");
        btviewscreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btviewscreenActionPerformed(evt);
            }
        });
        optionspanel.add(btviewscreen);
        btviewscreen.setBounds(370, 90, 150, 40);

        btsendmessage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btsendmessage.setText("Send Message");
        btsendmessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsendmessageActionPerformed(evt);
            }
        });
        optionspanel.add(btsendmessage);
        btsendmessage.setBounds(190, 63, 160, 40);

        getContentPane().add(optionspanel);
        optionspanel.setBounds(70, 400, 550, 170);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btconnectActionPerformed
        
        String user = tfuser.getText();
        String pass = tfpass.getText();
        try {
            HttpResponse<String> httpres = Unirest.get("http://" + ip + ":8000/Login")
                    .queryString("username", user)
                    .queryString("password", pass)
                    .asString();
            if (httpres.getStatus() == 200) {
//            JOptionPane.showMessageDialog(this, httpres.getBody());
                String s = httpres.getBody();
if(s.equals("fail")){
    JOptionPane.showMessageDialog(this, "Wrong username or password");
}
else{
                detailspanel.setVisible(true);
                                optionspanel.setVisible(true);
                                loginpanel.setVisible(false);
                StringTokenizer st = new StringTokenizer(s, "::");
                while (st.hasMoreTokens()) {
                    String os = st.nextToken();
                    String osversion = st.nextToken();
                    String n = st.nextToken();
                    String space = st.nextToken();
                    String memory = st.nextToken();

                    lbos.setText("OS : " + os);
                    lbversion.setText("Version : " + osversion);
                    lbprocessors.setText("Processors : " + n);
                    lbspace.setText("Space : " + space+" bytes");
                    lbmemory.setText("Memory : " + memory+" bytes");
                }
}
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btconnectActionPerformed

    private void btloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btloginActionPerformed
        loginpanel.setVisible(true);
    }//GEN-LAST:event_btloginActionPerformed

    private void btshutdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btshutdownActionPerformed
        try {
            HttpResponse<String> httpresponse=Unirest.get("http://"+ip+":8000/shutdown").asString();
            if(httpresponse.getStatus()==200){
                JOptionPane.showMessageDialog(this, httpresponse.getBody());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
       
    }//GEN-LAST:event_btshutdownActionPerformed

    private void btlogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlogoffActionPerformed
     try {
            HttpResponse<String> httpresponse=Unirest.get("http://"+ip+":8000/logoff").asString();
            if(httpresponse.getStatus()==200){
                JOptionPane.showMessageDialog(this, httpresponse.getBody());
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
       
    }//GEN-LAST:event_btlogoffActionPerformed

    private void btrestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btrestartActionPerformed
     try {
            HttpResponse<String> httpresponse=Unirest.get("http://"+ip+":8000/restart").asString();
            if(httpresponse.getStatus()==200){
                JOptionPane.showMessageDialog(this, httpresponse.getBody());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btrestartActionPerformed

    private void btviewscreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btviewscreenActionPerformed
      
        
        ViewServerScreen obj=new ViewServerScreen(ip);
    }//GEN-LAST:event_btviewscreenActionPerformed

    private void btsendmessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsendmessageActionPerformed
        String ans=JOptionPane.showInputDialog(ClientLogin.this,"Enter your message : ");
        try {
            HttpResponse<String> httpres=Unirest.get("http://"+ip+":8000/sendmessage")
                    .queryString("message",ans)
                    .asString();
            if(httpres.getStatus()==200){
                if(httpres.getBody().equals("ok")){
                    JOptionPane.showMessageDialog(this, "Message sent !");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btsendmessageActionPerformed

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
            java.util.logging.Logger.getLogger(ClientLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btconnect;
    private javax.swing.JButton btlogin;
    private javax.swing.JButton btlogoff;
    private javax.swing.JButton btrestart;
    private javax.swing.JButton btsendmessage;
    private javax.swing.JButton btshutdown;
    private javax.swing.JButton btviewscreen;
    private javax.swing.JPanel detailspanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbmemory;
    private javax.swing.JLabel lbos;
    private javax.swing.JLabel lbprocessors;
    private javax.swing.JLabel lbspace;
    private javax.swing.JLabel lbversion;
    private javax.swing.JPanel loginpanel;
    private javax.swing.JPanel optionspanel;
    private javax.swing.JPasswordField tfpass;
    private javax.swing.JTextField tfuser;
    // End of variables declaration//GEN-END:variables
}
