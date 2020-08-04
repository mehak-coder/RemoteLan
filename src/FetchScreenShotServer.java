
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.vmm.JHTTPServer;
import static com.vmm.NanoHTTPD.HTTP_OK;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class FetchScreenShotServer extends JHTTPServer {

    public FetchScreenShotServer(int port) throws IOException {
        super(port);
    }

    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) {
        Response res = null;
        String ans = "";

        if (uri.contains("/sendscreenshot")) {
            try {
                Robot r = new Robot();
                String path = "src/Images/screenshot.jpg";
                Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                BufferedImage img = r.createScreenCapture(capture);
                ImageIO.write(img, "jpg", new File(path));
                System.out.println("Screenshot captured");
                res = new Response(HTTP_OK, "text/plain", "done");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (uri.contains("/GetResource")) {
            uri = uri.substring(1);
            uri = uri.substring(uri.indexOf("/") + 1);
            res = sendCompleteFile(uri);
            System.out.println(uri);
        } else {
            res = new Response(HTTP_OK, "text/plain", "hello");

        }
        return res; //To change body of generated methods, choose Tools | Templates.

    }

    
}