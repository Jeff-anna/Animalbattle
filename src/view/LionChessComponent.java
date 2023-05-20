package view;

import model.PlayerColor;

import javax.swing.*;
import java.awt.*;

public class LionChessComponent extends ChessComponent {
    private boolean selected;

    public LionChessComponent(PlayerColor owner, int size) {
        super(owner,7, size);
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


