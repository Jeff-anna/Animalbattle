package view;
import model.PlayerColor;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * This is the equivalent of the ChessPiece class,
 * but this class only cares how to draw Chess on ChessboardComponent
 */
public class ChessComponent extends JComponent {
    public PlayerColor owner;
    private int rank;
    int size;
    private final String[] names = {"鼠","猫","狗","狼","豹","虎","狮","象"};
    private boolean selected;
    public ChessComponent(PlayerColor owner,int rank, int size) {
        this.owner = owner;
        this.rank = rank;
        this.selected = false;
        this.size=size;
        setSize(size/2, size/2);
        setLocation(0,0);
        setVisible(true);
    }
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getRank() {
        return rank;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isSelected()) { // Highlights the model if selected.
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(new Color(255, 255, 255));
            RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(1, 1,
                    this.getWidth() - 1, this.getHeight() - 1, size / 4, size / 4);
            g2d.fill(roundedRectangle);
        }
    }
}