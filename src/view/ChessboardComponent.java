package view;


import controller.GameController;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;

import static model.Constant.CHESSBOARD_COL_SIZE;
import static model.Constant.CHESSBOARD_ROW_SIZE;

/**
 * This class represents the checkerboard component object on the panel
 */
public class ChessboardComponent extends JComponent {
    public static final Color springGrass = new Color(86, 200, 73);
    public static final Color springRiver = new Color(161, 227, 255);
    public static final Color autumnGrass = new Color(199, 203, 113);
    public static final Color autumnRiver = new Color(115, 195, 186);

    public static final Color trapColor = new Color(189, 166, 164);
    public static final Color denColor = new Color(198, 200, 178);
    public final CellComponent[][] gridComponents = new CellComponent[CHESSBOARD_ROW_SIZE.getNum()][CHESSBOARD_COL_SIZE.getNum()];
    private final int CHESS_SIZE;
    private final Set<ChessboardPoint> riverCell = new HashSet<>();
    private final Set<ChessboardPoint> trapCell = new HashSet<>();
    private final Set<ChessboardPoint> homeCell = new HashSet<>();
    private static final Set<ChessboardPoint> availableCell = new HashSet<>();

    private  GameController gameController;
    public JLabel turnlable;
    public JLabel playerlable;
    public ChessboardComponent(int chessSize,JLabel turnlable,JLabel playerlable) {
        this.CHESS_SIZE = chessSize;
        this.turnlable=turnlable;
        this.playerlable=playerlable;
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
                    if (chessPiece.getName().equals("Elephant")) {
                        gridComponents[i][j].add(
                                new ElephantChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    } else if (chessPiece.getName().equals("Lion")) {
                        gridComponents[i][j].add(
                                new LionChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    } else if (chessPiece.getName().equals("Tiger")) {
                        gridComponents[i][j].add(
                                new TigerChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    } else if (chessPiece.getName().equals("Leopard")) {
                        gridComponents[i][j].add(
                                new LeopardChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    } else if (chessPiece.getName().equals("Wolf")) {
                        gridComponents[i][j].add(
                                new WolfChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    } else if (chessPiece.getName().equals("Dog")) {
                        gridComponents[i][j].add(
                                new DogChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    } else if (chessPiece.getName().equals("Cat")) {
                        gridComponents[i][j].add(
                                new CatChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    } else if (chessPiece.getName().equals("Mouse")) {
                        gridComponents[i][j].add(
                                new MouseChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    } else if (chessPiece.getName().equals("Trap")) {
                        gridComponents[i][j].add(
                                new TrapChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    } else if (chessPiece.getName().equals("Home")) {
                        gridComponents[i][j].add(
                                new HomeChessComponent(chessPiece.getOwner(), CHESS_SIZE));
                    }
                }
            }
        }

    }

    public void removeChessComponent() {
        for (int i = 0; i < CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < CHESSBOARD_COL_SIZE.getNum(); j++) {
                try {
                    gridComponents[i][j].remove(0);
                } catch (Exception e){}
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
                CellComponent cell;
                if (riverCell.contains(temp)) {
                    cell = new CellComponent(CellType.SPRING_RIVER, calculatePoint(i, j), CHESS_SIZE);
                    //ADD(CELL)MEANS WHAT????????????WHA DOSE THIS REFERS TO????????????
                    this.add(cell);
                } else if(trapCell.contains(temp)){
                    cell=new CellComponent(CellType.TRAP,calculatePoint(i,j),CHESS_SIZE);
                    this.add(cell);
                }else if(homeCell.contains(temp)){
                    cell=new CellComponent(CellType.DEN,calculatePoint(i,j),CHESS_SIZE);
                    this.add(cell);
                }else{
                    cell = new CellComponent(CellType.SPRING_GRASS, calculatePoint(i, j), CHESS_SIZE);
                    this.add(cell);
                }

                //GIVE THE REFACTORED CELL BACK TO THE GRID
                gridComponents[i][j] = cell;
            }
        }
    }
    public  void showAvailableCell(ChessboardPoint point){
        ChessboardPoint[] a=new ChessboardPoint[4];
        ChessboardPoint down=new ChessboardPoint(point.getRow()+1, point.getCol() );
        ChessboardPoint up=new ChessboardPoint(point.getRow()-1, point.getCol() );
        ChessboardPoint right=new ChessboardPoint(point.getRow(), point.getCol()+1 );
        ChessboardPoint left=new ChessboardPoint(point.getRow(), point.getCol()-1 );
        a[0]=down;a[1]=up;a[2]=right;a[3]=left;
        availableCell.add(down);
        availableCell.add(up);
        availableCell.add(right);
        availableCell.add(left);
        for(ChessboardPoint b:a) {
            if (!isMovable(b)) {
                availableCell.remove(b);
            }
        }
        for (int i = 0; i < CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < CHESSBOARD_COL_SIZE.getNum(); j++) {
                ChessboardPoint temp = new ChessboardPoint(i, j);
                CellComponent cell;
                if (availableCell.contains(temp)) {
                  //  getGridComponentAt(temp).setColor();
                    //把原有cell背景颜色设置为黄色
                    //getGridComponentAt(temp).set
                }
            }
        }

    }
    public void removeAvailableCell(){
        for (int i = 0; i < CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < CHESSBOARD_COL_SIZE.getNum(); j++) {
                ChessboardPoint temp = new ChessboardPoint(i, j);
                if (availableCell.contains(temp)) {
                    //把原有cell背景颜色恢复
                    //this.remove(getGridComponentAt(temp));
                }
            }
        }
        availableCell.clear();
    }
    public void registerController(GameController gameController) {
        this.gameController = gameController;
    }

    public GameController getGameController() {
        return gameController;
    }

    public void setChessComponentAtGrid(ChessboardPoint point, JComponent chess) {
        //I NEVER SEE THIS METHOD BEFORE DOSE IT MEAN GET A CELL AT THE POINT AND THEN PUT THE CHESS INTO THE CELL??????
        getGridComponentAt(point).add(chess);
        //IF THIS EQUALS PUT CHESS INTO THE CELL???????????????????????
    }

    public ChessComponent removeChessComponentAtGrid(ChessboardPoint point) {
        ChessComponent chess = (ChessComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }

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
                    if (clickedComponent.getComponents()[0] instanceof ChessComponent) {
                        gameController.onPlayerClickChessPiece(getChessboardPoint(e.getPoint()), (ChessComponent) clickedComponent.getComponents()[0]);
                    }
                }

        }
    }
    private ChessComponent getChessComponentAt(ChessboardPoint point){
          ChessComponent chess = (ChessComponent) getGridComponentAt(point).getComponents()[0];
          return chess;
    }

    private boolean isMovable(ChessboardPoint point){
        boolean a=true;
        try{
            if(getChessComponentAt(point)!=null){
                a= false;
            }
        }catch (Exception e){
            a=true;
        }
        if(riverCell.contains(point)){
            a=false;
        }
        return a;
    }
}
