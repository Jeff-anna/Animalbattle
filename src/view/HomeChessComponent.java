package view;


import model.PlayerColor;

import javax.swing.*;
import java.awt.*;

/**
 * This is the equivalent of the ChessPiece class,
 * but this class only cares how to draw Chess on ChessboardComponent
 */
public class HomeChessComponent extends ChessComponent {
    private PlayerColor owner;
    //USE GETRANK TO GET RANK TO JUDGE IF THE CHESS CAN EAT ANOTHER
    private final int rank=0;

    private boolean selected;

    public HomeChessComponent(PlayerColor owner, int size) {
        super(owner,0,size);
        this.owner=owner;
        this.size=size;
        this.selected = false;
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
        g2.drawString("家", getWidth() / 4, getHeight() * 5 / 8); // FIXME: Use library to find the correct offset.
        if (isSelected()) { // Highlights the model if selected.
            g.setColor(Color.WHITE);
            //THIS X Y MEANS RELATIVE TO THE CENTER OF THE CHESS
            g.drawOval(0, 0, getWidth() , getHeight());
        }
    }
}
