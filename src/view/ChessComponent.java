package view;
import model.PlayerColor;
import javax.swing.*;
import java.awt.*;
/**
 * This is the equivalent of the ChessPiece class,
 * but this class only cares how to draw Chess on ChessboardComponent
 */
public class ChessComponent extends JComponent {
    private PlayerColor owner;
    private int rank;
    private final String[] names = {"鼠","猫","狗","狼","豹","虎","狮","象"};
    private boolean selected;
    public ChessComponent(PlayerColor owner,int rank, int size) {
        this.owner = owner;
        this.rank = rank;
        this.selected = false;
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
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Font font = new Font("楷体", Font.PLAIN, getWidth() / 2);
        g2.setFont(font);
        g2.setColor(owner.getColor());
        g2.drawString(names[rank-1], getWidth() / 4, getHeight() * 5 / 8);
        if (isSelected()) { // Highlights the model if selected.
            g.setColor(Color.RED);
            g.drawOval(0, 0, getWidth() , getHeight());
        }
    }
}