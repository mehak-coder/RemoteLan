
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ViewServerScreen extends javax.swing.JFrame implements MouseListener, MouseMotionListener, KeyListener {

    String ip;
    Dimension d;

    public ViewServerScreen(String ip) {
        this.ip = ip;
        initComponents();
     d = Toolkit.getDefaultToolkit().getScreenSize();        
        
        try {

            HttpResponse<String> httpres = Unirest.get("http://" + ip + ":8000/sendscreensize").asString();
            if (httpres.getStatus() == 200) {
                String s = httpres.getBody();
                StringTokenizer st = new StringTokenizer(s, "::");
                int sw = Integer.parseInt(st.nextToken());
                int sh = Integer.parseInt(st.nextToken());
                setSize((int)d.getWidth(),(int)d.getHeight());
                jScrollPane1.setSize((int)d.getWidth()-10,(int)d.getHeight()-70);
                jScrollPane1.setLocation(0,0);
                System.out.println("Width: " + sw + " " + "Height: " + sh);
                //lbphoto.setSize(w,h);
                lbphoto.setBounds(0, 0, sw, sh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        lbphoto.addMouseListener(this);
        lbphoto.addMouseMotionListener(this);
        this.addKeyListener(this);
        new Thread(new PhotoClient()).start();
//                getContentPane().setBackground(new java.awt.Color(204,255,255));

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lbphoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lbphoto.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jScrollPane1.setViewportView(lbphoto);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 400, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ViewServerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewServerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewServerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewServerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new ViewServerScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbphoto;
    // End of variables declaration//GEN-END:variables
class PhotoClient implements Runnable {

        public void run() {
                while (true) {

                    try {
                        HttpResponse httpResponse = Unirest.get("http://" + ip + ":9000/sendscreenshot").asString();
                        if (httpResponse.getBody().equals("done")) {
                            //System.out.println("done");
                            URL url = new URL("http://" + ip + ":9000/GetResource/src/Images/screenshot.jpg");
                            BufferedImage img = ImageIO.read(url);
                            BufferedImage newimg = resize(img, lbphoto.getWidth(), lbphoto.getHeight());
                            System.out.println(lbphoto.getWidth() + " " + lbphoto.getHeight());
                            lbphoto.setIcon(new ImageIcon(img));

                        }

                        Thread.sleep(500);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

            }
        
    
}
BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
 @Override
        public void mouseClicked(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
        int btn=e.getButton();
        try{
          HttpResponse<String> httpResponse = Unirest.get("http://"+ip+":8000/mouseclicked")
                    .queryString("btn", btn)
                    
                    .asString();
           if(httpResponse.getStatus()==200){
               System.out.println(httpResponse.getBody());
           }
            
        } catch (Exception ex) {
            ex.printStackTrace();
//Logger.getLogger(FetchScreenShotServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
        public void mousePressed(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }

    @Override
        public void mouseReleased(MouseEvent e) {
    try {
        int btn=e.getButton();
        //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        HttpResponse <String> httpResponse =Unirest.get("http://"+ip+":8000/mousereleased")
                .queryString("btn",btn)
                .asString();
        if(httpResponse.getStatus()==200){
            System.out.println(httpResponse.getBody());
        }
    } catch (Exception ex) {
//        Logger.getLogger(ViewServerScreen.class.getName()).log(Level.SEVERE, null, ex);
    ex.printStackTrace();
    }

    }

    @Override
        public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
        public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
        public void mouseDragged(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try {
            //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            HttpResponse<String> httpResponse = Unirest.get("http://"+ip+":8000/mousedragged")
                    .queryString("x", e.getX()+"")
                    .queryString("y", e.getY()+"")
                    .asString();
           if(httpResponse.getStatus()==200){
               System.out.println(httpResponse.getBody());
           }
            
        } catch (Exception ex) {
            ex.printStackTrace();
//Logger.getLogger(FetchScreenShotServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
        public void mouseMoved(MouseEvent e) {
        try {
            //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                       System.out.println("Values : "+e.getX()+" "+e.getY());

            HttpResponse<String> httpResponse = Unirest.get("http://"+ip+":8000/mousemoved")
                    .queryString("x", e.getX()+"")
                    .queryString("y", e.getY()+"")
                    .asString();
           if(httpResponse.getStatus()==200){
               System.out.println(httpResponse.getBody());
           }
            
        } catch (Exception ex) {
            ex.printStackTrace();
//Logger.getLogger(FetchScreenShotServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
        public void keyTyped(KeyEvent e) {
    }//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.


    @Override
        public void keyPressed(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
        public void keyReleased(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   int keycode=e.getKeyCode();
   HttpResponse<String> httpResponse;
    try {
        httpResponse = Unirest.get("http://"+ip+":8000/keyreleased")
                .queryString("keycode", keycode)
                .asString();
        if(httpResponse.getStatus()==200){
               System.out.println(httpResponse.getBody());
           }
    } catch (Exception ex) {
//        Logger.getLogger(ViewServerScreen.class.getName()).log(Level.SEVERE, null, ex);
    ex.printStackTrace();
    }
           
    }

}
