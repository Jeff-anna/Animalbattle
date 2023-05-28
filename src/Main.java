import view.StartFrame;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StartFrame sf=new StartFrame(1100,800);
            sf.setVisible(true);
        });
    }
}
