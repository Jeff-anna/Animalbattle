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
 *
 */
public class GameController implements GameListener {


    private Chessboard model;
    private ChessboardComponent view;
    private PlayerColor currentPlayer;

    // Record whether there is a selected piece before
    private ChessboardPoint selectedPoint;
    private int turn=1;


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
        return false;
    }


    // click an empty cell
    @Override
    public void onPlayerClickCell(ChessboardPoint point, CellComponent component) {
        if (selectedPoint != null && model.isValidMove(selectedPoint, point)) {
            model.moveChessPiece(selectedPoint, point);
            if(view.getGridComponentAt(selectedPoint).getComponent(0) instanceof ChessComponent) {
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGrid(selectedPoint));
            }
            selectedPoint = null;
            swapColor();
            view.repaint();
            turn++;
            ChessGameFrame.getTurnlabel().setText(String.format("Turn: %d",turn));
            if(turn%2==1) {
                ChessGameFrame.getPlayerlabel().setText(String.format("Player: Blue"));
            }else{
                ChessGameFrame.getPlayerlabel().setText(String.format("Player: Red"));
            }
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
               // view.showAvailableCell(point);
            }
        } else if (selectedPoint.equals(point)) {
            selectedPoint = null;
            component.setSelected(false);
            component.repaint();
            component.revalidate();
            view.repaint();
            view.revalidate();
            //view.removeAvailableCell();
        }
        else if(model.isValidCapture(selectedPoint, point)){
            model.captureChessPiece(selectedPoint, point);
            view.removeChessComponentAtGrid(point);
            view.setChessComponentAtGrid(point, view.removeChessComponentAtGrid(selectedPoint));
            selectedPoint = null;
            swapColor();
            view.repaint();
            view.revalidate();
            component.revalidate();
            turn++;
            ChessGameFrame.getTurnlabel().setText(String.format("Turn: %d",turn));
            if(turn%2==1) {
                ChessGameFrame.getPlayerlabel().setText(String.format("Player: Blue"));
            }else{
                ChessGameFrame.getPlayerlabel().setText(String.format("Player: Red"));
            }
        }
    }
    public static void loadGameFromFile(String path){

    }
    public void reset(){
        model.initGrid();
        model.initPieces();
        view.removeChessComponent();
        view.initiateChessComponent(model);
        currentPlayer=PlayerColor.BLUE;
        view.turnlable.setText("Turn: 1");
        view.playerlable.setText("player: Blue");
        turn=1;
        selectedPoint=null;
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
