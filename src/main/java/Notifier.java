import javax.swing.JOptionPane;
import java.awt.Toolkit;

public class Notifier {

    public static void notifySuccess(String targetUrl) {
        // Optional: play a beep sound
        Toolkit.getDefaultToolkit().beep();

        // Show popup dialog
        JOptionPane.showMessageDialog(
                null,
                "Ping successful for:\n" + targetUrl,
                "Ping OK",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
