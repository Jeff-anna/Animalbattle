package model;

/**
 * This class store the real chess information.
 * The Chessboard has 9*7 cells, and each cell has a position for chess
 */
public class Chessboard {
    private Cell[][] grid;

    public Chessboard() {
        this.grid =
                new Cell[Constant.CHESSBOARD_ROW_SIZE.getNum()][Constant.CHESSBOARD_COL_SIZE.getNum()];//19X19

        initGrid();
        initPieces();
    }

    public void initGrid() {
        for (int i = 0; i < Constant.CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < Constant.CHESSBOARD_COL_SIZE.getNum(); j++) {
                grid[i][j] = new Cell();
            }
        }
    }
    //MORE NEW CHESS NEEDED
    public void initPieces() {
        grid[2][6].setPiece(new ChessPiece(PlayerColor.BLUE, "Elephant",8));
        grid[6][0].setPiece(new ChessPiece(PlayerColor.RED, "Elephant",8));
        grid[0][0].setPiece(new ChessPiece(PlayerColor.BLUE, "Lion",7));
        grid[8][6].setPiece(new ChessPiece(PlayerColor.RED, "Lion",7));
        grid[1][1].setPiece(new ChessPiece(PlayerColor.BLUE, "Dog",3));
        grid[7][5].setPiece(new ChessPiece(PlayerColor.RED, "Dog",3));
        grid[6][6].setPiece(new ChessPiece(PlayerColor.RED, "Mouse",1));
        grid[2][0].setPiece(new ChessPiece(PlayerColor.BLUE, "Mouse",1));
        grid[6][4].setPiece(new ChessPiece(PlayerColor.RED, "Leopard",5));
        grid[2][2].setPiece(new ChessPiece(PlayerColor.BLUE, "Leopard",5));
        grid[0][6].setPiece(new ChessPiece(PlayerColor.BLUE, "Tiger",6));
        grid[8][0].setPiece(new ChessPiece(PlayerColor.RED, "Tiger",6));
        grid[1][5].setPiece(new ChessPiece(PlayerColor.BLUE, "Cat",2));
        grid[7][1].setPiece(new ChessPiece(PlayerColor.RED, "Cat",2));
        grid[6][2].setPiece(new ChessPiece(PlayerColor.RED, "Wolf",4));
        grid[2][4].setPiece(new ChessPiece(PlayerColor.BLUE, "Wolf",4));
        grid[0][4].setPiece(new ChessPiece(PlayerColor.BLUE, "Trap",0));
        grid[0][2].setPiece(new ChessPiece(PlayerColor.BLUE, "Trap",0));
        grid[1][3].setPiece(new ChessPiece(PlayerColor.BLUE, "Trap",0));
        grid[8][2].setPiece(new ChessPiece(PlayerColor.RED, "Trap",0));
        grid[8][4].setPiece(new ChessPiece(PlayerColor.RED, "Trap",0));
        grid[7][3].setPiece(new ChessPiece(PlayerColor.RED, "Trap",0));
        grid[8][3].setPiece(new ChessPiece(PlayerColor.RED, "Home",0));
        grid[0][3].setPiece(new ChessPiece(PlayerColor.BLUE, "Home",0));



    }

    private  ChessPiece getChessPieceAt(ChessboardPoint point) {
        return getGridAt(point).getPiece();
    }

    private  Cell getGridAt(ChessboardPoint point) {
        return grid[point.getRow()][point.getCol()];
    }

    private int calculateDistance(ChessboardPoint src, ChessboardPoint dest) {
        return Math.abs(src.getRow() - dest.getRow()) + Math.abs(src.getCol() - dest.getCol());
    }
    private ChessPiece removeChessPiece(ChessboardPoint point) {
        ChessPiece chessPiece = getChessPieceAt(point);
        getGridAt(point).removePiece();
        return chessPiece;
    }

    private void setChessPiece(ChessboardPoint point, ChessPiece chessPiece) {
        getGridAt(point).setPiece(chessPiece);
    }

    public void moveChessPiece(ChessboardPoint src, ChessboardPoint dest) {
        if (!isValidMove(src, dest)) {
            throw new IllegalArgumentException("Illegal chess move!");
        }
        setChessPiece(dest, removeChessPiece(src));
    }

    public void captureChessPiece(ChessboardPoint src, ChessboardPoint dest) {
        if (!isValidCapture(src, dest)) {
            throw new IllegalArgumentException("Illegal chess capture!");
        }
        if (isValidCapture(src, dest)) {
            removeChessPiece(dest);
            moveChessPiece(src, dest);
        }
    }

    public Cell[][] getGrid() {
        return grid;
    }
    public PlayerColor getChessPieceOwner(ChessboardPoint point) {
        return getGridAt(point).getPiece().getOwner();
    }

    public boolean isValidMove(ChessboardPoint src, ChessboardPoint dest) {
        if (getChessPieceAt(src) == null || getChessPieceAt(dest) != null) {
            return false;
        }
        if (!isOnLand(dest)) {
            if (isMovableToRiver(src)) {
                return calculateDistance(src, dest) == 1;
            }else return false;
        }
        return calculateDistance(src, dest) == 1;
    }


    public boolean isValidCapture(ChessboardPoint src, ChessboardPoint dest) {
        if (getChessPieceAt(dest).getRank() == 0) {
            return true;
        }
        if (!getChessPieceOwner(src).equals(getChessPieceOwner(dest)) && isValidToJump(src, dest)){
            if (getChessPieceAt(src).getRank() == 6 || getChessPieceAt(src).getRank() == 7) {
                return getChessPieceAt(src).getRank() >= getChessPieceAt(dest).getRank();
            }
        }
        if (!getChessPieceOwner(src).equals(getChessPieceOwner(dest)) && calculateDistance(src, dest) == 1) {
            if (isOnLand(src) && getChessPieceAt(src).getRank() != 1 && getChessPieceAt(dest).getRank() != 1) {
                return getChessPieceAt(src).getRank() >= getChessPieceAt(dest).getRank();
            }else if (isOnLand(src)) {
                if (getChessPieceAt(src).getRank() == 1 && getChessPieceAt(dest).getRank() == 8) {
                    return true;
                }
                if (getChessPieceAt(src).getRank() != 8 && getChessPieceAt(src).getRank() >= getChessPieceAt(dest).getRank()) {
                    return true;
                }
                if (getChessPieceAt(src).getRank() == 8 && getChessPieceAt(dest).getRank() == 1) {
                    return false;
                }
            }else if (!isOnLand(src)) {
                return !isOnLand(dest);
            }
            return false;
        }
        return false;
    }
    public boolean isOnLand(ChessboardPoint src){
        if(src.getRow() >= 3 && src.getRow() <= 5) {
            return src.getCol() != 1 && src.getCol() != 2 && src.getCol() != 4 && src.getCol() != 5;
        }
        return true;
    }
    public boolean isMovableToRiver(ChessboardPoint src){
        return getChessPieceAt(src).getRank() == 1;
    }
    public boolean isValidToJump(ChessboardPoint src, ChessboardPoint des){
        if (getChessPieceAt(src).getRank() == 6 || getChessPieceAt(src).getRank() == 7){
            return isOnLand(des);
        }
        return false;
    }
    public boolean isMovable(ChessboardPoint point){
        if(getChessPieceAt(point)!=null){
            return false;
        }
        return true;
    }
}
