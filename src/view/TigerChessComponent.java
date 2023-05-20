package view;


import model.PlayerColor;

import javax.swing.*;
import java.awt.*;

/**
 * This is the equivalent of the ChessPiece class,
 * but this class only cares how to draw Chess on ChessboardComponent
 */
public class TigerChessComponent extends ChessComponent {
    private boolean selected;

    public TigerChessComponent(PlayerColor owner, int size) {
        super(owner,6, size);
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

}

