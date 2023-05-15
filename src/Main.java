import controller.GameController;
import model.Chessboard;
import view.ChessGameFrame;
import javax.swing.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame start=new JFrame();
            start.setSize(1100,810);
            start.setVisible(true);
            start.setLocationRelativeTo(null);
            JPanel jp=new JPanel(new FlowLayout());
            JButton begin=new JButton("Begin");
            begin.setSize(300,100);
            begin.setVisible(true);
            jp.add(begin);
            start.add(jp);
            start.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            ChessGameFrame mainFrame = new ChessGameFrame(1100, 810);
            GameController gameController = new GameController(mainFrame.getChessboardComponent(), new Chessboard());
            mainFrame.setVisible(true);
        });
    }
}
