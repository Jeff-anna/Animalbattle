package view;


import model.PlayerColor;

import javax.swing.*;
import java.awt.*;

/**
 * This is the equivalent of the ChessPiece class,
 * but this class only cares how to draw Chess on ChessboardComponent
 */
public class MouseChessComponent extends ChessComponent {
    private boolean selected;

    public MouseChessComponent(PlayerColor owner, int size) {
        super(owner,1,size);
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
        return super.getRank();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon pic = new ImageIcon("resource\\chesspicture\\redmouse.jpg");
        if (owner == PlayerColor.BLUE){
            pic = new ImageIcon("resource\\chesspicture\\bluemouse.jpg");
        }
        Image image = pic.getImage();
        pic = new ImageIcon(image.getScaledInstance(size, size,Image.SCALE_SMOOTH));
        JLabel label = new JLabel(pic);
        label.setSize(size, size);
        //bgLabel.setLocation(0, 0);
        add(label);
    }

}
