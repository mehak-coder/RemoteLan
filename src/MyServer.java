
import com.vmm.JHTTPServer;
import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyServer extends JHTTPServer {

    public MyServer(int port) throws IOException {
        super(port);
    }

    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) {
        Response res = null;
        String ans = "";

        if (uri.contains("/connect")) {
            String osname = System.getProperty("os.name");
            System.out.println(osname);
            ans = osname;
            System.out.println(ans);
            res = new Response(HTTP_OK, "text/plain", ans);
        } else if (uri.contains("/GetResource")) {
            uri = uri.substring(1);
            uri = uri.substring(uri.indexOf("/") + 1);
            res = sendCompleteFile(uri);
            System.out.println(uri);

        } else if (uri.contains("/Login")) {
            String u = parms.getProperty("username");
            System.out.println("username" + u);
            String p = parms.getProperty("password");
//            File f = new File("F:\\VMM\\logindetails.txt");
            File f = new File("src/files/logindetails.txt");
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                while (true) {
                    String user = br.readLine();
                    System.out.println("in while" + user);
                    String pass = br.readLine();

                    String s2 = user.substring(user.indexOf(":") + 1);
                    System.out.println("After substring" + s2);
                    if (user.substring(user.indexOf(":") + 1).equals(u) && pass.substring(pass.indexOf(":") + 1).equals(p)) {
                        String osname = System.getProperty("os.name");
                        String osversion = System.getProperty("os.version");
                        String n = System.getenv("NUMBER_OF_PROCESSORS");
                        long maxMemory = new File("/").getTotalSpace();
                        long memorySize = ((com.sun.management.OperatingSystemMXBean) ManagementFactory
                                .getOperatingSystemMXBean()).getTotalPhysicalMemorySize();

                        //ans="correct credentials";
                        ans = ans + osname + "::" + osversion + "::" + n + "::" + maxMemory + "::" + memorySize;
                        System.out.println(ans);
                    } else {
                        ans = "fail";
                    }

                    if (br.readLine() == null) {
                        break;
                    }
                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (uri.contains("/shutdown")) {
            res = new Response(HTTP_OK, "text/plain", "Shutting down !");
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("shutdown -s");
//                System.exit(0);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.contains("/logoff")) {
            res = new Response(HTTP_OK, "text/plain", "Logging off !");

            String shutdownCmd = "shutdown -l";
            try {
                Process child = Runtime.getRuntime().exec(shutdownCmd);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (uri.contains("/restart")) {
            res = new Response(HTTP_OK, "text/plain", "Restarting !");

            String shutdownCmd = "shutdown -r";
            try {
                Process child = Runtime.getRuntime().exec(shutdownCmd);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (uri.contains("/sendscreensize")) {
            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            int w = (int) d.getWidth();
            int h = (int) d.getHeight();
            ans = w + "::" + h;
            res = new Response(HTTP_OK, "text/plain", ans);
        } else if (uri.contains("/mousemoved")) {
            int x = Integer.parseInt(parms.getProperty("x"));
            int y = Integer.parseInt(parms.getProperty("y"));
            System.out.println("x :" + x + "y : " + y);
            try {
                Robot r = new Robot();
                r.mouseMove(x, y);
                res = new Response(HTTP_OK, "text/plain", "mouse moved");
            } catch (Exception ex) {
//                Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }

        } else if (uri.contains("/mouseclicked")) {
            int btn = Integer.parseInt(parms.getProperty("btn"));
            System.out.println("Button: " + btn);
            try {
                Robot rb = new Robot();
                if (btn == MouseEvent.BUTTON1) {
                    rb.mousePress(MouseEvent.BUTTON1_MASK);
//                    rb.mouseRelease(btn);
                    rb.mouseRelease(MouseEvent.BUTTON1_MASK);

                } else if (btn == MouseEvent.BUTTON2) {
                    rb.mousePress(MouseEvent.BUTTON2);
//                    rb.mouseRelease(btn);
                    rb.mouseRelease(MouseEvent.BUTTON2_MASK);

                } else if (btn == MouseEvent.BUTTON3) {
                    rb.mousePress(MouseEvent.BUTTON3_MASK);
//                    rb.mouseRelease(btn);
                    rb.mouseRelease(MouseEvent.BUTTON3_MASK);

                }
                res = new Response(HTTP_OK, "text/plain", "mouse clicked");
            } catch (Exception ex) {
//                Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }

        } else if (uri.contains("/mousedragged")) {
            int x = Integer.parseInt(parms.getProperty("x"));
            int y = Integer.parseInt(parms.getProperty("y"));
            System.out.println("x :" + x + "y : " + y);
            try {
                Robot r = new Robot();
                r.mousePress(MouseEvent.BUTTON1_MASK);
                r.mouseMove(x, y);
//                r.mouseRelease(MouseEvent.BUTTON1);
                res = new Response(HTTP_OK, "text/plain", "mouse dragged");
            } catch (Exception ex) {
//                Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }

        } else if (uri.contains("/mousereleased")) {
            int btn = Integer.parseInt(parms.getProperty("btn"));
            try {

                Robot r = new Robot();
                r.mouseRelease(MouseEvent.BUTTON1_MASK);
                res = new Response(HTTP_OK, "text/plain", "mouse released");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.contains("/keyreleased")) {
            int keycode = Integer.parseInt(parms.getProperty("keycode"));
            try {
                Robot rb = new Robot();
                rb.keyPress(keycode);
                rb.keyRelease(keycode);
                res = new Response(HTTP_OK, "text/plain", "key pressed");

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (uri.contains("/sendmessage")) {
            String msg = parms.getProperty("message");
            System.out.println(msg);
            MessageFrame obj = new MessageFrame();
//          Dialog jdialog=new Dialog(obj,"",true);  
            obj.lbmsg.setText(msg);
            try {
                Thread.sleep(5000);
                obj.dispose();

            } catch (Exception e) {
                e.printStackTrace();
            }
            res = new Response(HTTP_OK, "text/plain", "ok");
        } else {
            res = new Response(HTTP_OK, "text/plain", "hello");

        }

        return res; //To change body of generated methods, choose Tools | Templates.
    }

}
