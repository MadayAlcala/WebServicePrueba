
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Prueba {
    //private static final Logger LOG = Logger.getLogger(Prueba.class.getName());

    public static void main(String[] args) {

        try {
            String line;
            String mp4File = "D:\\UsuariosIlegales\\osa\\Sources\\videos\\test.mp4";
            String mp3File = "D:\\UsuariosIlegales\\osa\\Sources\\targets\\testeandodesdejava2.mp3";

            // ffmpeg -i input.mp4 output.avi as it's on www.ffmpeg.org
            String cmd = "ffmpeg -i " + mp4File + " " + mp3File;
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(p.getErrorStream()));
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            p.waitFor();
            System.out.println("Video converted successfully!");
            in.close();
        } catch (IOException | InterruptedException e) {
            //LOG.log(Level.SEVERE, null, e);
        }
    }
}
