package view;

import model.CellType;
import view.ChessboardComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * This is the equivalent of the Cell class,
 * but this class only cares how to draw Cells on ChessboardComponent
 */

public class CellComponent extends JPanel {
    public Color background;
    int size;
    public boolean availableStep;//由controller里面的方法设定
    public boolean mouseAt;//同boardview里方法设定
    public CellType type;

    public CellComponent(CellType type, Point location, int size) {
        setLayout(new GridLayout(1,1));
        setLocation(location);
        setSize(size, size);
        this.type=type;
        this.size=size;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        if (type == CellType.SPRING_GRASS) g.setColor(ChessboardComponent.springGrass);
        else if (type == CellType.SPRING_RIVER) g.setColor(ChessboardComponent.springRiver);
        else if (type == CellType.AUTUMN_GRASS) g.setColor(ChessboardComponent.autumnGrass);
        else if (type == CellType.AUTUMN_RIVER) g.setColor(ChessboardComponent.autumnRiver);
        else if (type == CellType.TRAP) g.setColor(ChessboardComponent.trapColor);
        else if (type == CellType.DEN) g.setColor(ChessboardComponent.denColor);
        else g.setColor(background);
        g.fillRect(1, 1, this.getWidth() - 1, this.getHeight() - 1);

        if (availableStep) { // Highlights the model if selected.
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(new Color(255, 253, 87, 150));
            RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(1, 1,
                    this.getWidth() - 1, this.getHeight() - 1, size / 4, size / 4);
            g2d.fill(roundedRectangle);
        }

        if (mouseAt){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(new Color(255, 172, 155, 120));
            RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(1, 1,
                    this.getWidth() - 1, this.getHeight() - 1, size / 4, size / 4);
            g2d.fill(roundedRectangle);
        }
    }


}
