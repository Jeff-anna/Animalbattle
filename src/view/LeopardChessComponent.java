package view;


import model.PlayerColor;

import javax.swing.*;
import java.awt.*;

/**
 * This is the equivalent of the ChessPiece class,
 * but this class only cares how to draw Chess on ChessboardComponent
 */
public class LeopardChessComponent extends ChessComponent {
    private boolean selected;

    public LeopardChessComponent(PlayerColor owner, int size) {
        super(owner,5, size);
        this.selected = false;
    }

    public int getRank() {
        return super.getRank();
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}

