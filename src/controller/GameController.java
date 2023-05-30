package controller;


import listener.GameListener;
import model.*;
import view.*;
import view.ChessGameFrame;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Controller is the connection between model and view,
 * when a Controller receive a request from a view, the Controller
 * analyzes and then hands over to the model for processing
 * [in this demo the request methods are onPlayerClickCell() and onPlayerClickChessPiece()]
 */
public class GameController implements GameListener {


    private Chessboard model;
    private ChessboardComponent view;
    private PlayerColor currentPlayer;

    // Record whether there is a selected piece before
    private ChessboardPoint selectedPoint;
    private int turn = 1;


    public GameController(ChessboardComponent view, Chessboard model) {
        this.view = view;
        this.model = model;
        this.currentPlayer = PlayerColor.BLUE;
        //WHY IT NEEDS TO BE REGISTERED???????????
        view.registerController(this);
        //WHAT IS NEEDED IN FURTHER STEPS???????????????
        initialize();
        view.initiateChessComponent(model);
        view.repaint();
    }

    private void initialize() {
        for (int i = 0; i < Constant.CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < Constant.CHESSBOARD_COL_SIZE.getNum(); j++) {

            }
        }
    }

    // after a valid move swap the player
    private void swapColor() {
        currentPlayer = currentPlayer == PlayerColor.BLUE ? PlayerColor.RED : PlayerColor.BLUE;
    }

    public int win() {
        if (model.grid[8][3].getPiece().getOwner().equals(PlayerColor.BLUE)) {
            return 1;
        }
        if (model.grid[0][3].getPiece().getOwner().equals(PlayerColor.RED)) {
            return 2;
        }
        int RedWin = 2, BlueWin = 1;
        for (int i = 0; i < Constant.CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < Constant.CHESSBOARD_COL_SIZE.getNum(); j++) {
                try {
                    if (model.grid[i][j].getPiece().getOwner().equals(PlayerColor.RED)) {
                        if (model.grid[i][j].getPiece().getRank() != 0 && model.grid[i][j].getPiece().getRank() != 9) {
                            BlueWin = 0;
                        }
                    }
                    if (model.grid[i][j].getPiece().getOwner().equals(PlayerColor.BLUE)) {
                        if (model.grid[i][j].getPiece().getRank() != 0 && model.grid[i][j].getPiece().getRank() != 9) {
                            RedWin = 0;
                        }
                    }
                }catch(Exception e){
                }
            }
        }
        if (RedWin == 2) {
            return 2;
        }
        if (BlueWin == 1) {
            return 1;
        }
        return 0;
    }


    // click an empty cell
    @Override
    public void onPlayerClickCell(ChessboardPoint point, CellComponent component) {
        if (selectedPoint != null && model.isValidMove(selectedPoint, point)) {
            model.moveChessPiece(selectedPoint, point);
            if (view.getGridComponentAt(selectedPoint).getComponent(0) instanceof ChessComponent) {
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGrid(selectedPoint));
            }
            selectedPoint = null;
            swapColor();
            view.repaint();
            turn++;

            ChessGameFrame.getTurnlabel().setText(String.format("Turn: %d", (turn+1)/2));

            if (turn % 2 == 1) {
                ChessGameFrame.getPlayerlabel().setText("Player: Blue");
            } else {
                ChessGameFrame.getPlayerlabel().setText("Player: Red");
            }
            ChessGameFrame.getSelectedlabel().setText("Selected: ");
            view.removeAvailableCell();

            // TODO: if the chess enter Dens or Traps and so on
        }
    }

    // click a cell with a chess
    @Override
    public void onPlayerClickChessPiece(ChessboardPoint point, ChessComponent component) {
        if (selectedPoint == null) {
            if (model.getChessPieceOwner(point).equals(currentPlayer)) {
                selectedPoint = point;
                component.setSelected(true);
                component.revalidate();
                component.repaint();
                view.repaint();
                view.revalidate();
                if(component.getRank()!=1&&component.getRank()!=6&&component.getRank()!=7) {
                    view.showAvailableCell(point);
                }else if(component.getRank()==7||component.getRank()==6){
                    view.show67AvailableCell(point);
                }else{
                    view.showMouseAvailable(point);
                }
                if (component instanceof WolfChessComponent) {
                    if (component.owner == PlayerColor.BLUE) {
                        ChessGameFrame.getSelectedlabel().setText("Selected: 蓝狼");
                    } else {
                        ChessGameFrame.getSelectedlabel().setText("Selected: 红狼");
                    }
                } else if (component instanceof MouseChessComponent) {
                    if (component.owner == PlayerColor.BLUE) {
                        ChessGameFrame.getSelectedlabel().setText("Selected: 蓝鼠");
                    } else {
                        ChessGameFrame.getSelectedlabel().setText("Selected: 红鼠");
                    }
                } else if (component instanceof CatChessComponent) {
                    if (component.owner == PlayerColor.BLUE) {
                        ChessGameFrame.getSelectedlabel().setText("Selected: 蓝猫");
                    } else {
                        ChessGameFrame.getSelectedlabel().setText("Selected: 红猫");
                    }
                } else if (component instanceof DogChessComponent) {
                    if (component.owner == PlayerColor.BLUE) {
                        ChessGameFrame.getSelectedlabel().setText("Selected: 蓝狗");
                    } else {
                        ChessGameFrame.getSelectedlabel().setText("Selected: 红狗");
                    }
                } else if (component instanceof LeopardChessComponent) {
                    if (component.owner == PlayerColor.BLUE) {
                        ChessGameFrame.getSelectedlabel().setText("Selected: 蓝豹");
                    } else {
                        ChessGameFrame.getSelectedlabel().setText("Selected: 红豹");
                    }
                } else if (component instanceof TigerChessComponent) {
                    if (component.owner == PlayerColor.BLUE) {
                        ChessGameFrame.getSelectedlabel().setText("Selected: 蓝虎");
                    } else {
                        ChessGameFrame.getSelectedlabel().setText("Selected: 红虎");
                    }
                } else if (component instanceof LionChessComponent) {
                    if (component.owner == PlayerColor.BLUE) {
                        ChessGameFrame.getSelectedlabel().setText("Selected: 蓝狮");
                    } else {
                        ChessGameFrame.getSelectedlabel().setText("Selected: 红狮");
                    }
                } else if (component instanceof ElephantChessComponent) {
                    if (component.owner == PlayerColor.BLUE) {
                        ChessGameFrame.getSelectedlabel().setText("Selected: 蓝象");
                    } else {
                        ChessGameFrame.getSelectedlabel().setText("Selected: 红象");
                    }
                }
            }
        } else if (selectedPoint.equals(point)) {
            selectedPoint = null;
            component.setSelected(false);
            component.repaint();
            component.revalidate();
            view.repaint();
            view.revalidate();
            view.removeAvailableCell();
            ChessGameFrame.getSelectedlabel().setText("Selected: ");

        } else if (model.isValidCapture(selectedPoint, point)) {
            model.captureChessPiece(selectedPoint, point);
            view.removeChessComponentAtGrid(point);
            view.setChessComponentAtGrid(point, view.removeChessComponentAtGrid(selectedPoint));
            selectedPoint = null;
            swapColor();
            view.repaint();
            view.revalidate();
            component.revalidate();
            turn++;
            if(win()==1){
                ChessGameFrame.getWinlabel().setText("Winner: Blue");
                view.removeChessComponent();

            }else if(win()==2){
                ChessGameFrame.getWinlabel().setText("Winner: Red");
                view.removeChessComponent();
            }
            ChessGameFrame.getTurnlabel().setText(String.format("Turn: %d", (turn+1)/2));

            if (turn % 2 == 1) {
                ChessGameFrame.getPlayerlabel().setText("Player: Blue");
            } else {
                ChessGameFrame.getPlayerlabel().setText("Player: Red");
            }
            ChessGameFrame.getSelectedlabel().setText("Selected: ");
            view.removeAvailableCell();

        }
    }

    public void saveGameToFile(){
        File file = new File("resource/load.txt");
        try {
            FileWriter writer=new FileWriter(file);
            for (int i = 0; i < Constant.CHESSBOARD_ROW_SIZE.getNum(); i++) {
                for (int j = 0; j < Constant.CHESSBOARD_COL_SIZE.getNum(); j++) {
                    if(model.grid[i][j].getPiece()==null){
                        writer.write("v");
                    }else if(model.grid[i][j].getPiece().getRank()==8&&model.grid[i][j].getPiece().getOwner()==PlayerColor.BLUE){
                        writer.write("a");
                    }else if(model.grid[i][j].getPiece().getRank()==8&&model.grid[i][j].getPiece().getOwner()==PlayerColor.RED){
                        writer.write("b");
                    }else if(model.grid[i][j].getPiece().getRank()==7&&model.grid[i][j].getPiece().getOwner()==PlayerColor.BLUE){
                        writer.write("c");
                    }else if(model.grid[i][j].getPiece().getRank()==7&&model.grid[i][j].getPiece().getOwner()==PlayerColor.RED){
                        writer.write("d");
                    }else if(model.grid[i][j].getPiece().getRank()==6&&model.grid[i][j].getPiece().getOwner()==PlayerColor.BLUE){
                        writer.write("e");
                    }else if(model.grid[i][j].getPiece().getRank()==6&&model.grid[i][j].getPiece().getOwner()==PlayerColor.RED){
                        writer.write("f");
                    }else if(model.grid[i][j].getPiece().getRank()==5&&model.grid[i][j].getPiece().getOwner()==PlayerColor.BLUE){
                        writer.write("g");
                    }else if(model.grid[i][j].getPiece().getRank()==5&&model.grid[i][j].getPiece().getOwner()==PlayerColor.RED){
                        writer.write("h");
                    }else if(model.grid[i][j].getPiece().getRank()==4&&model.grid[i][j].getPiece().getOwner()==PlayerColor.BLUE){
                        writer.write("i");
                    }else if(model.grid[i][j].getPiece().getRank()==4&&model.grid[i][j].getPiece().getOwner()==PlayerColor.RED){
                        writer.write("j");
                    }else if(model.grid[i][j].getPiece().getRank()==3&&model.grid[i][j].getPiece().getOwner()==PlayerColor.BLUE){
                        writer.write("k");
                    }else if(model.grid[i][j].getPiece().getRank()==3&&model.grid[i][j].getPiece().getOwner()==PlayerColor.RED){
                        writer.write("l");
                    }else if(model.grid[i][j].getPiece().getRank()==2&&model.grid[i][j].getPiece().getOwner()==PlayerColor.BLUE){
                        writer.write("m");
                    }else if(model.grid[i][j].getPiece().getRank()==2&&model.grid[i][j].getPiece().getOwner()==PlayerColor.RED){
                        writer.write("n");
                    }else if(model.grid[i][j].getPiece().getRank()==1&&model.grid[i][j].getPiece().getOwner()==PlayerColor.BLUE){
                        writer.write("o");
                    }else if(model.grid[i][j].getPiece().getRank()==1&&model.grid[i][j].getPiece().getOwner()==PlayerColor.RED){
                        writer.write("p");
                    }else if(model.grid[i][j].getPiece().getRank()==0&&model.grid[i][j].getPiece().getOwner()==PlayerColor.BLUE){
                        writer.write("t");
                    }else if(model.grid[i][j].getPiece().getRank()==0&&model.grid[i][j].getPiece().getOwner()==PlayerColor.RED){
                        writer.write("x");
                    }else if(model.grid[i][j].getPiece().getRank()==9&&model.grid[i][j].getPiece().getOwner()==PlayerColor.BLUE){
                        writer.write("r");
                    }else if(model.grid[i][j].getPiece().getRank()==9&&model.grid[i][j].getPiece().getOwner()==PlayerColor.RED){
                        writer.write("w");
                    }
                }
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        }catch(Exception e){
        }
    }
    public void loadGameFromFile(String path) {
        try{
            List<String> lines= Files.readAllLines(Path.of(path));
            if(lines.size() == 0) return;
            model.removeAllPieces();
            model.initPieces(lines);
            view.removeChessComponent();
            view.initiateChessComponent(model);
            currentPlayer = PlayerColor.BLUE;
            view.turnlable.setText("Turn: 1");
            view.playerlable.setText("player: Blue");
            turn = 1;
            selectedPoint = null;
            view.repaint();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void reset() {
        model.initGrid();
        model.initPieces();
        view.removeChessComponent();
        view.initiateChessComponent(model);
        currentPlayer = PlayerColor.BLUE;
        view.turnlable.setText("Turn: 1");
        view.playerlable.setText("player: Blue");
        turn = 1;
        selectedPoint = null;
        view.repaint();
        view.revalidate();
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
