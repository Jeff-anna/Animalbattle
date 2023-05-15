package view;


import controller.GameController;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static model.Constant.CHESSBOARD_COL_SIZE;
import static model.Constant.CHESSBOARD_ROW_SIZE;

/**
 * This class represents the checkerboard component object on the panel
 */
public class ChessboardComponent extends JComponent {
    private final CellComponent[][] gridComponents = new CellComponent[CHESSBOARD_ROW_SIZE.getNum()][CHESSBOARD_COL_SIZE.getNum()];
    private final int CHESS_SIZE;
    private final Set<ChessboardPoint> riverCell = new HashSet<>();
    private final Set<ChessboardPoint> trapCell = new HashSet<>();
    private final Set<ChessboardPoint> homeCell = new HashSet<>();

    private GameController gameController;

    public ChessboardComponent(int chessSize) {
        CHESS_SIZE = chessSize;
        int width = CHESS_SIZE * 7;
        int height = CHESS_SIZE * 9;
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);// Allow mouse events to occur
        setLayout(null); // Use absolute layout.D
        setSize(width, height);
        System.out.printf("chessboard width, height = [%d : %d], chess size = %d\n", width, height, CHESS_SIZE);

        initiateGridComponents();
    }


    /**
     * This method represents how to initiate ChessComponent
     * according to Chessboard information
     */
    public void initiateChessComponent(Chessboard chessboard) {
        Cell[][] grid = chessboard.getGrid();
        for (int i = 0; i < CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < CHESSBOARD_COL_SIZE.getNum(); j++) {
                // TODO: Implement the initialization checkerboard

                if (grid[i][j].getPiece() != null) {
                    ChessPiece chessPiece = grid[i][j].getPiece();
                    System.out.println(chessPiece.getOwner());
                    if(chessPiece.getName().equals("Elephant")) {
                        gridComponents[i][j].add(
                                new ElephantChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    }else if(chessPiece.getName().equals("Lion")) {
                        gridComponents[i][j].add(
                                new LionChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    }else if(chessPiece.getName().equals("Tiger")) {
                        gridComponents[i][j].add(
                                new TigerChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    }else if(chessPiece.getName().equals("Leopard")) {
                        gridComponents[i][j].add(
                                new LeopardChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    }else if(chessPiece.getName().equals("Wolf")) {
                        gridComponents[i][j].add(
                                new WolfChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    }else if(chessPiece.getName().equals("Dog")) {
                        gridComponents[i][j].add(
                                new DogChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    }else if(chessPiece.getName().equals("Cat")) {
                        gridComponents[i][j].add(
                                new CatChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    }else if(chessPiece.getName().equals("Mouse")) {
                        gridComponents[i][j].add(
                                new MouseChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    }else if(chessPiece.getName().equals("Trap")) {
                        gridComponents[i][j].add(
                                new TrapChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    }else if(chessPiece.getName().equals("Home")) {
                        gridComponents[i][j].add(
                                new HomeChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    }
                }
            }
        }

    }

    public void initiateGridComponents() {

        riverCell.add(new ChessboardPoint(3,1));
        riverCell.add(new ChessboardPoint(3,2));
        riverCell.add(new ChessboardPoint(4,1));
        riverCell.add(new ChessboardPoint(4,2));
        riverCell.add(new ChessboardPoint(5,1));
        riverCell.add(new ChessboardPoint(5,2));

        riverCell.add(new ChessboardPoint(3,4));
        riverCell.add(new ChessboardPoint(3,5));
        riverCell.add(new ChessboardPoint(4,4));
        riverCell.add(new ChessboardPoint(4,5));
        riverCell.add(new ChessboardPoint(5,4));
        riverCell.add(new ChessboardPoint(5,5));
        trapCell.add(new ChessboardPoint(0,2));
        trapCell.add(new ChessboardPoint(0,4));
        trapCell.add(new ChessboardPoint(1,3));
        trapCell.add(new ChessboardPoint(8,2));
        trapCell.add(new ChessboardPoint(8,4));
        trapCell.add(new ChessboardPoint(7,3));
        homeCell.add(new ChessboardPoint(0,3));
        homeCell.add(new ChessboardPoint(8,3));

        //CHESSBOARDPOINT REPRESENTS THE LOCATION
        for (int i = 0; i < CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < CHESSBOARD_COL_SIZE.getNum(); j++) {
                ChessboardPoint temp = new ChessboardPoint(i, j);
                //CELLCOMPONENT IS TO BE SETTLED IN GRID,GRIDCOMPONENT IS LIKE A MAP,CELL IS LIKE A BOX
                CellComponent cell;
                //IF IT IS IN RIVER+REFACTOR THE GRID USING CELL
                if (riverCell.contains(temp)) {
                    cell = new CellComponent(Color.CYAN, calculatePoint(i, j), CHESS_SIZE);
                    //ADD(CELL)MEANS WHAT????????????WHA DOSE THIS REFERS TO????????????
                    this.add(cell);
                } else if(trapCell.contains(temp)){
                    cell=new CellComponent(Color.BLACK,calculatePoint(i,j),CHESS_SIZE);
                    this.add(cell);
                }else if(homeCell.contains(temp)){
                    cell=new CellComponent(Color.green,calculatePoint(i,j),CHESS_SIZE);
                    this.add(cell);
                }else{
                    cell = new CellComponent(Color.LIGHT_GRAY, calculatePoint(i, j), CHESS_SIZE);
                    this.add(cell);
                }

                //GIVE THE REFACTORED CELL BACK TO THE GRID
                gridComponents[i][j] = cell;
            }
        }
    }
    //??????????WHY CONTROLLER NEEDS TO BE REGISTERED????????
    public void registerController(GameController gameController) {
        this.gameController = gameController;
    }

    public void setChessComponentAtGrid(ChessboardPoint point, JComponent chess) {
        //I NEVER SEE THIS METHOD BEFORE DOSE IT MEAN GET A CELL AT THE POINT AND THEN PUT THE CHESS INTO THE CELL??????
        getGridComponentAt(point).add(chess);
        //IF THIS EQUALS PUT CHESS INTO THE CELL???????????????????????
    }

    public ElephantChessComponent removeChessComponentAtGrid1(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        ElephantChessComponent chess = (ElephantChessComponent) getGridComponentAt(point).getComponents()[0];//GETCOMPONENT MEANS GET THE CHESS IN IT?WHY BOTHER USE[0]????????????
        getGridComponentAt(point).removeAll();
        //WHY NEED REVALIDATE?SOUNDS LIKE IT CONCEALED  THE BOX
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }
    public MouseChessComponent removeChessComponentAtGrid2(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        MouseChessComponent chess = (MouseChessComponent) getGridComponentAt(point).getComponents()[0];//GETCOMPONENT MEANS GET THE CHESS IN IT?WHY BOTHER USE[0]????????????
        getGridComponentAt(point).removeAll();
        //WHY NEED REVALIDATE?SOUNDS LIKE IT CONCEALED  THE BOX
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }public CatChessComponent removeChessComponentAtGrid3(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        CatChessComponent chess = (CatChessComponent) getGridComponentAt(point).getComponents()[0];//GETCOMPONENT MEANS GET THE CHESS IN IT?WHY BOTHER USE[0]????????????
        getGridComponentAt(point).removeAll();
        //WHY NEED REVALIDATE?SOUNDS LIKE IT CONCEALED  THE BOX
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }public DogChessComponent removeChessComponentAtGrid4(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        DogChessComponent chess = (DogChessComponent) getGridComponentAt(point).getComponents()[0];//GETCOMPONENT MEANS GET THE CHESS IN IT?WHY BOTHER USE[0]????????????
        getGridComponentAt(point).removeAll();
        //WHY NEED REVALIDATE?SOUNDS LIKE IT CONCEALED  THE BOX
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }public WolfChessComponent removeChessComponentAtGrid5(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        WolfChessComponent chess = (WolfChessComponent) getGridComponentAt(point).getComponents()[0];//GETCOMPONENT MEANS GET THE CHESS IN IT?WHY BOTHER USE[0]????????????
        getGridComponentAt(point).removeAll();
        //WHY NEED REVALIDATE?SOUNDS LIKE IT CONCEALED  THE BOX
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }public LeopardChessComponent removeChessComponentAtGrid6(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        LeopardChessComponent chess = (LeopardChessComponent) getGridComponentAt(point).getComponents()[0];//GETCOMPONENT MEANS GET THE CHESS IN IT?WHY BOTHER USE[0]????????????
        getGridComponentAt(point).removeAll();
        //WHY NEED REVALIDATE?SOUNDS LIKE IT CONCEALED  THE BOX
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }public TigerChessComponent removeChessComponentAtGrid7(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        TigerChessComponent chess = (TigerChessComponent) getGridComponentAt(point).getComponents()[0];//GETCOMPONENT MEANS GET THE CHESS IN IT?WHY BOTHER USE[0]????????????
        getGridComponentAt(point).removeAll();
        //WHY NEED REVALIDATE?SOUNDS LIKE IT CONCEALED  THE BOX
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }public LionChessComponent removeChessComponentAtGrid8(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        LionChessComponent chess = (LionChessComponent) getGridComponentAt(point).getComponents()[0];//GETCOMPONENT MEANS GET THE CHESS IN IT?WHY BOTHER USE[0]????????????
        getGridComponentAt(point).removeAll();
        //WHY NEED REVALIDATE?SOUNDS LIKE IT CONCEALED  THE BOX
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }

    //GRID'S COMPONENT IS CELL,GRID IS A MAP
    //I CHANGED THE PRIVATE INTO PUBLIC
    public CellComponent getGridComponentAt(ChessboardPoint point) {
        return gridComponents[point.getRow()][point.getCol()];
    }

    private ChessboardPoint getChessboardPoint(Point point) {
        System.out.println("[" + point.y/CHESS_SIZE +  ", " +point.x/CHESS_SIZE + "] Clicked");
        return new ChessboardPoint(point.y/CHESS_SIZE, point.x/CHESS_SIZE);
    }
    //LOCALIZATION THE ASKED POINT
    private Point calculatePoint(int row, int col) {
        return new Point(col * CHESS_SIZE, row * CHESS_SIZE);
    }

    //USED IN REPAINT IN GAMECONTROLLER????????????
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //NO NEED TO KNOW
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    @Override
    protected void processMouseEvent(MouseEvent e) {
        if (e.getID() == MouseEvent.MOUSE_PRESSED) {
            JComponent clickedComponent = (JComponent) getComponentAt(e.getX(), e.getY());
            if (clickedComponent.getComponentCount() == 0) {
                System.out.print("None chess here and ");
                gameController.onPlayerClickCell(getChessboardPoint(e.getPoint()), (CellComponent) clickedComponent);
            } else {
                System.out.print("One chess here and ");
                if(clickedComponent.getComponents()[0] instanceof ElephantChessComponent){
                    gameController.onPlayerClickChessPiece1(getChessboardPoint(e.getPoint()), (ElephantChessComponent) clickedComponent.getComponents()[0]);
                }else if(clickedComponent.getComponents()[0] instanceof LionChessComponent){
                    gameController.onPlayerClickChessPiece2(getChessboardPoint(e.getPoint()), (LionChessComponent) clickedComponent.getComponents()[0]);
                }else if(clickedComponent.getComponents()[0] instanceof TigerChessComponent){
                    gameController.onPlayerClickChessPiece3(getChessboardPoint(e.getPoint()), (TigerChessComponent) clickedComponent.getComponents()[0]);
                }else if(clickedComponent.getComponents()[0] instanceof LeopardChessComponent){
                    gameController.onPlayerClickChessPiece4(getChessboardPoint(e.getPoint()), (LeopardChessComponent) clickedComponent.getComponents()[0]);
                }else if(clickedComponent.getComponents()[0] instanceof WolfChessComponent){
                    gameController.onPlayerClickChessPiece5(getChessboardPoint(e.getPoint()), (WolfChessComponent) clickedComponent.getComponents()[0]);
                }else if(clickedComponent.getComponents()[0] instanceof DogChessComponent){
                    gameController.onPlayerClickChessPiece6(getChessboardPoint(e.getPoint()), (DogChessComponent) clickedComponent.getComponents()[0]);
                }else if(clickedComponent.getComponents()[0] instanceof CatChessComponent){
                    gameController.onPlayerClickChessPiece7(getChessboardPoint(e.getPoint()), (CatChessComponent) clickedComponent.getComponents()[0]);
                }else if(clickedComponent.getComponents()[0] instanceof MouseChessComponent){
                    gameController.onPlayerClickChessPiece8(getChessboardPoint(e.getPoint()), (MouseChessComponent) clickedComponent.getComponents()[0]);
                }
            }
        }
    }
}
