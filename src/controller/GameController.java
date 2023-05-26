package controller;


import listener.GameListener;
import model.Constant;
import model.PlayerColor;
import model.Chessboard;
import model.ChessboardPoint;
import view.*;
import view.ChessGameFrame;

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

    private boolean win() {
        // TODO: Check the board if there is a winner
        for (int i = 0; i < Constant.CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < Constant.CHESSBOARD_COL_SIZE.getNum(); j++) {

            }
        }
        return false;
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
                ChessGameFrame.getPlayerlabel().setText(String.format("Player: Blue"));
            } else {
                ChessGameFrame.getPlayerlabel().setText(String.format("Player: Red"));
            }
            ChessGameFrame.getSelectedlabel().setText(String.format("Selected: "));
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
                        ChessGameFrame.getSelectedlabel().setText(String.format("Selected: 蓝狼"));
                    } else {
                        ChessGameFrame.getSelectedlabel().setText(String.format("Selected: 红狼"));
                    }
                } else if (component instanceof MouseChessComponent) {
                    if (component.owner == PlayerColor.BLUE) {
                        ChessGameFrame.getSelectedlabel().setText(String.format("Selected: 蓝鼠"));
                    } else {
                        ChessGameFrame.getSelectedlabel().setText(String.format("Selected: 红鼠"));
                    }
                } else if (component instanceof CatChessComponent) {
                    if (component.owner == PlayerColor.BLUE) {
                        ChessGameFrame.getSelectedlabel().setText(String.format("Selected: 蓝猫"));
                    } else {
                        ChessGameFrame.getSelectedlabel().setText(String.format("Selected: 红猫"));
                    }
                } else if (component instanceof DogChessComponent) {
                    if (component.owner == PlayerColor.BLUE) {
                        ChessGameFrame.getSelectedlabel().setText(String.format("Selected: 蓝狗"));
                    } else {
                        ChessGameFrame.getSelectedlabel().setText(String.format("Selected: 红狗"));
                    }
                } else if (component instanceof LeopardChessComponent) {
                    if (component.owner == PlayerColor.BLUE) {
                        ChessGameFrame.getSelectedlabel().setText(String.format("Selected: 蓝豹"));
                    } else {
                        ChessGameFrame.getSelectedlabel().setText(String.format("Selected: 红豹"));
                    }
                } else if (component instanceof TigerChessComponent) {
                    if (component.owner == PlayerColor.BLUE) {
                        ChessGameFrame.getSelectedlabel().setText(String.format("Selected: 蓝虎"));
                    } else {
                        ChessGameFrame.getSelectedlabel().setText(String.format("Selected: 红虎"));
                    }
                } else if (component instanceof LionChessComponent) {
                    if (component.owner == PlayerColor.BLUE) {
                        ChessGameFrame.getSelectedlabel().setText(String.format("Selected: 蓝狮"));
                    } else {
                        ChessGameFrame.getSelectedlabel().setText(String.format("Selected: 红狮"));
                    }
                } else if (component instanceof ElephantChessComponent) {
                    if (component.owner == PlayerColor.BLUE) {
                        ChessGameFrame.getSelectedlabel().setText(String.format("Selected: 蓝象"));
                    } else {
                        ChessGameFrame.getSelectedlabel().setText(String.format("Selected: 红象"));
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
            ChessGameFrame.getSelectedlabel().setText(String.format("Selected: "));

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
            ChessGameFrame.getTurnlabel().setText(String.format("Turn: %d", (turn+1)/2));

            if (turn % 2 == 1) {
                ChessGameFrame.getPlayerlabel().setText(String.format("Player: Blue"));
            } else {
                ChessGameFrame.getPlayerlabel().setText(String.format("Player: Red"));
            }
            ChessGameFrame.getSelectedlabel().setText(String.format("Selected: "));
            view.removeAvailableCell();

        }
    }

    public static void loadGameFromFile(String path) {

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
