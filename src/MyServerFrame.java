
import java.awt.AWTException;
import static java.awt.Frame.ICONIFIED;
import static java.awt.Frame.MAXIMIZED_BOTH;
import static java.awt.Frame.NORMAL;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class MyServerFrame extends javax.swing.JFrame {

    MyServer obj;
    FetchScreenShotServer obj1;
    TrayIcon trayIcon;
    SystemTray tray;

    public MyServerFrame() {
        initComponents();
        addToSystemTray();
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new java.awt.Color(204,255,255));

        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btstart = new javax.swing.JButton();
        btstop = new javax.swing.JButton();
        btsetpassword = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btstart.setText("Start Server");
        btstart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btstartActionPerformed(evt);
            }
        });
        getContentPane().add(btstart);
        btstart.setBounds(70, 50, 180, 40);

        btstop.setText("Stop Server");
        btstop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btstopActionPerformed(evt);
            }
        });
        getContentPane().add(btstop);
        btstop.setBounds(70, 140, 180, 40);

        btsetpassword.setText("Set Password");
        btsetpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsetpasswordActionPerformed(evt);
            }
        });
        getContentPane().add(btsetpassword);
        btsetpassword.setBounds(70, 210, 180, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btstartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btstartActionPerformed
        try {
            obj = new MyServer(8000);
            obj1 = new FetchScreenShotServer(9000);
            btstart.setEnabled(false);
            btstop.setEnabled(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btstartActionPerformed

    private void btstopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btstopActionPerformed
        obj.shutdown();
        obj1.shutdown();
        btstop.setEnabled(false);
        btstart.setEnabled(true);
    }//GEN-LAST:event_btstopActionPerformed

    private void btsetpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsetpasswordActionPerformed
        AdminSetPassword obj = new AdminSetPassword();
    }//GEN-LAST:event_btsetpasswordActionPerformed

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
            java.util.logging.Logger.getLogger(MyServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyServerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btsetpassword;
    private javax.swing.JButton btstart;
    private javax.swing.JButton btstop;
    // End of variables declaration//GEN-END:variables
void addToSystemTray() {
        try {
            System.out.println("setting look and feel");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Unable to set LookAndFeel");
        }
        if (SystemTray.isSupported()) {
            System.out.println("system tray supported");
            tray = SystemTray.getSystemTray();

            Image image = Toolkit.getDefaultToolkit().getImage("src/Images/windows.jpg");
            ActionListener exitListener;
            exitListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
//                    String pass = "123";
                    File f = new File("src/files/logindetails.txt");
                    try {
                        FileReader fr = new FileReader(f);
                        BufferedReader br = new BufferedReader(fr);
//                        while (true) {
                        String user = br.readLine();
                        String pass = br.readLine();
                        pass = pass.substring(pass.indexOf(":") + 1);
                        String password = JOptionPane.showInputDialog(MyServerFrame.this, "Enter password");
                        if (password.equals(pass)) {
                            System.out.println("Exiting....");
                            System.exit(0);
//                                if (br.readLine() == null) {
//                                    break;
//                                }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Wrong password !");
                        }
//                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }

            };
            PopupMenu popup = new PopupMenu();
            MenuItem defaultItem = new MenuItem("Exit");
            defaultItem.addActionListener(exitListener);
            popup.add(defaultItem);
            defaultItem = new MenuItem("Open");
            defaultItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setVisible(true);
                    tray.remove(trayIcon);

                    setExtendedState(JFrame.NORMAL);
                }
            });
            popup.add(defaultItem);
            trayIcon = new TrayIcon(image, "SystemTray Demo", popup);
            trayIcon.setImageAutoSize(true);
        } else {
            System.out.println("system tray not supported");
        }
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    tray.add(trayIcon);
                    setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });
        addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                if (e.getNewState() == ICONIFIED) {
                    try {
                        tray.add(trayIcon);
                    } catch (AWTException ex) {
                        ex.printStackTrace();
                    }
                    setVisible(false);
                    System.out.println("added to SystemTray");
                }
                if (e.getNewState() == 7) {
                    try {
                        tray.add(trayIcon);
                        setVisible(false);
                        System.out.println("added to SystemTray");
                    } catch (AWTException ex) {
                        System.out.println("unable to add to system tray");
                    }
                }
                if (e.getNewState() == MAXIMIZED_BOTH) {
                    tray.remove(trayIcon);
                    setVisible(true);
                    System.out.println("Tray icon removed");
                }
                if (e.getNewState() == NORMAL) {
                    tray.remove(trayIcon);
                    setVisible(true);
                    System.out.println("Tray icon removed");
                }
            }
        });
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/Images/windows.jpg"));

        setVisible(true);
        setSize(300, 200);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
