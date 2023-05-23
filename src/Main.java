import controller.GameController;
import model.BackgroundMusic;
import model.Chessboard;
import view.ChessGameFrame;
import view.StartFrame;

import javax.swing.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StartFrame sf=new StartFrame(1100,800);
            sf.setVisible(true);
        });
    }
}
