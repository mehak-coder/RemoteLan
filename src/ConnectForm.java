
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ConnectForm extends javax.swing.JFrame {

    int alsize;
    ArrayList<PC> al = new ArrayList<>();

    public ConnectForm() {
        initComponents();
        setSize(800, 700);
        jScrollPane1.setSize(700,560);
        mainpanel.setPreferredSize(new Dimension(690,570));
        getContentPane().setBackground(new java.awt.Color(204,255,255));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btconnect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btconnect.setText("Connect");
        btconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btconnectActionPerformed(evt);
            }
        });
        getContentPane().add(btconnect);
        btconnect.setBounds(80, 50, 150, 30);

        mainpanel.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 428, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 100, 750, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btconnectActionPerformed

        btconnect.setEnabled(false);
        new Thread(new MakeThreads()).start();
    }//GEN-LAST:event_btconnectActionPerformed

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
            java.util.logging.Logger.getLogger(ConnectForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConnectForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConnectForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnectForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnectForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btconnect;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainpanel;
    // End of variables declaration//GEN-END:variables
class MakeThreads implements Runnable {

        public void run() {
            int c = 1;
            for (int i = 1; i <= 17; i++) {
                Thread t[] = new Thread[15];
                for (int j = 1; j <= 15; j++) {
                    new Thread(new Job(Credentials.ip + c)).start();
                    c++;
                }
                for (int k = 1; k <= 15; k++) {
                    try {
                        t[k].join();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
            //     new Thread(new fillPanels()).start();

        }
    }

    class fillPanels implements Runnable {

        int x = 10;
        int y = 10;

        public void run() {
            OSPanel op[] = new OSPanel[alsize];
            for (int i = 0; i < alsize; i++) {
                op[i] = new OSPanel();
                String connectedip=al.get(i).ip;
                op[i].setBounds(x, y, 200, 200);
                op[i].lbip.setText(al.get(i).ip);
                op[i].lbos.setText(al.get(i).os);
                System.out.println("Image"+al.get(i).img);
//                try {
//                    URL url=new URL("http://"+al.get(i).ip+":8000/GetResource/"+al.get(i).img);
//                    BufferedImage img=ImageIO.read(url);
                    op[i].lbimg.setIcon(new ImageIcon(al.get(i).img));
//                } catch (Exception ex) {
//               ex.printStackTrace();
//                }
                
                op[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
//                        dispose();
                        ClientLogin obj=new ClientLogin(connectedip);
                    }
                    
});

                mainpanel.add(op[i]);
                if (x < 400) {
                    x = x + 220;
                } else {
                    y = y + 220;
                    x = 10;
                }
                repaint();
                mainpanel.repaint();
                op[i].repaint();
            }
        }
    }

    public class Job implements Runnable {

        String ip;

        Job(String ip) {
            this.ip = ip;
            System.out.println(ip);
        }

        @Override
        public void run() {
            try {

                //    System.out.println(Credentials.ip+i);
                HttpResponse httpres = Unirest.get("http://" + ip + ":8000/connect")
                        .asString();
                if (httpres.getStatus() == 2000) {
                    String s = httpres.getBody().toString();
                    System.out.println("Response"+s);
                    String photo = "";
//                if(s1.equals("ok")){
//                    String os=st.nextToken();
                    if (s.contains("Window")) {
//               op[i].lbimg.setIcon(new ImageIcon("src/Images/windows.jpg")); 
                        photo = "src/Images/windows.jpg";
                    } else if (s.contains("Mac")) {
//               op[i].lbimg.setIcon(new ImageIcon("src/Images/mac.png")); 
                        photo = "src/Images/mac.png";
                    } else if (s.contains("Linux")) {
                        //   op[i].lbimg.setIcon(new ImageIcon("src/Images/linux.png"));
                        photo = "src/Images/linux.png";
                    }
                    al.add(new PC(ip, s, photo));
                    System.out.println("ArrayList:" + al.size());
//                }
                }
                alsize = al.size();
                new Thread(new fillPanels()).start();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

}
