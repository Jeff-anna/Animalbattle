package model;

import view.ChessboardComponent;

import java.util.List;

/**
 * This class store the real chess information.
 * The Chessboard has 9*7 cells, and each cell has a position for chess
 */
public class Chessboard {
    public Cell[][] grid;

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
        grid[8][3].setPiece(new ChessPiece(PlayerColor.RED, "Home",9));
        grid[0][3].setPiece(new ChessPiece(PlayerColor.BLUE, "Home",9));



    }
    public void initPieces(List<String>lines){
        for (int i = 0; i < Constant.CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < Constant.CHESSBOARD_COL_SIZE.getNum(); j++) {
                if(lines.get(i).charAt(j)=='r'){
                    grid[i][j].setPiece(new ChessPiece(PlayerColor.BLUE, "Home",9));
                }else if(lines.get(i).charAt(j)=='w'){
                    grid[i][j].setPiece(new ChessPiece(PlayerColor.RED, "Home",9));
                }else if(lines.get(i).charAt(j)=='t'){
                    grid[i][j].setPiece(new ChessPiece(PlayerColor.BLUE, "Trap",0));
                }else if(lines.get(i).charAt(j)=='x'){
                    grid[i][j].setPiece(new ChessPiece(PlayerColor.RED, "Trap",0));
                }else if(lines.get(i).charAt(j)=='a'){
                    grid[i][j].setPiece(new ChessPiece(PlayerColor.BLUE, "Elephant",8));
                }else if(lines.get(i).charAt(j)=='b'){
                    grid[i][j].setPiece(new ChessPiece(PlayerColor.RED, "Elephant",8));
                }else if(lines.get(i).charAt(j)=='c'){
                    grid[i][j].setPiece(new ChessPiece(PlayerColor.BLUE, "Lion",7));
                }else if(lines.get(i).charAt(j)=='d'){
                    grid[i][j].setPiece(new ChessPiece(PlayerColor.RED, "Lion",7));
                }else if(lines.get(i).charAt(j)=='e'){
                    grid[i][j].setPiece(new ChessPiece(PlayerColor.BLUE, "Tiger",6));
                }else if(lines.get(i).charAt(j)=='f'){
                    grid[i][j].setPiece(new ChessPiece(PlayerColor.RED, "Tiger",6));
                }else if(lines.get(i).charAt(j)=='g'){
                    grid[i][j].setPiece(new ChessPiece(PlayerColor.BLUE, "Leopard",5));
                }else if(lines.get(i).charAt(j)=='h'){
                    grid[i][j].setPiece(new ChessPiece(PlayerColor.RED, "Leopard",5));
                }else if(lines.get(i).charAt(j)=='i'){
                    grid[i][j].setPiece(new ChessPiece(PlayerColor.BLUE, "Wolf",4));
                }else if(lines.get(i).charAt(j)=='j'){
                    grid[i][j].setPiece(new ChessPiece(PlayerColor.RED, "Wolf",4));
                }else if(lines.get(i).charAt(j)=='k'){
                    grid[i][j].setPiece(new ChessPiece(PlayerColor.BLUE, "Dog",3));
                }else if(lines.get(i).charAt(j)=='l'){
                    grid[i][j].setPiece(new ChessPiece(PlayerColor.RED, "Dog",3));
                }else if(lines.get(i).charAt(j)=='m'){
                    grid[i][j].setPiece(new ChessPiece(PlayerColor.BLUE, "Cat",2));
                }else if(lines.get(i).charAt(j)=='n'){
                    grid[i][j].setPiece(new ChessPiece(PlayerColor.RED, "Cat",2));
                }else if(lines.get(i).charAt(j)=='o'){
                    grid[i][j].setPiece(new ChessPiece(PlayerColor.BLUE, "Mouse",1));
                }else if(lines.get(i).charAt(j)=='p'){
                    grid[i][j].setPiece(new ChessPiece(PlayerColor.RED, "Mouse",1));
                }
            }
        }
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
    public void removeAllPieces(){
        for (int i = 0; i < Constant.CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < Constant.CHESSBOARD_COL_SIZE.getNum(); j++) {
                grid[i][j].removePiece();
            }
        }
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
        if (isValidToJump(src, dest)) {
            return true;
        }
        if (!isOnLand(dest)) {
            if (isMovableToRiver(src)) {
                return calculateDistance(src, dest) == 1;
            } else return false;
        }
        return calculateDistance(src, dest) == 1;
    }


    public boolean isValidCapture(ChessboardPoint src, ChessboardPoint dest) {
        if (getChessPieceAt(dest).getRank() == 9) {
            return isValidToHome(src, dest);
        }
        else if (getChessPieceAt(dest).getRank() == 0) {
            if (getChessPieceOwner(src) != getChessPieceOwner(dest)){
                getChessPieceAt(src).setRank(1);
                return true;
            }
            return true;
        }
        else if (((isOnLand(src) && isOnLand(dest)) || (!isOnLand(src) && !isOnLand(dest)))) {
            if (isValidCapture67(src, dest)) {
                return true;
            }
            else if ((calculateDistance(src, dest) == 1) && ((getChessPieceOwner(src) != getChessPieceOwner(dest)) || getChessPieceAt(dest).getRank() == 0)) {
                if (getChessPieceAt(src).getRank() == 1 && getChessPieceAt(dest).getRank() == 8) {
                    return true;
                }
                else if (getChessPieceAt(src).getRank() == 8 && getChessPieceAt(dest).getRank() == 1) {
                    return false;
                }
                else return getChessPieceAt(src).getRank() >= getChessPieceAt(dest).getRank();
            }
        }
        return false;
    }
    public boolean isValidCapture67(ChessboardPoint src, ChessboardPoint dest) {
        if ((getChessPieceAt(src).getRank() == 6 || getChessPieceAt(src).getRank() == 7) && getChessPieceOwner(src) != getChessPieceOwner(dest)) {
            if (getChessPieceAt(src).getRank() >= getChessPieceAt(dest).getRank()) {
                return (isValidToJump(src, dest) || calculateDistance(src, dest) == 1);
            }
        }
        return false;
    }
    public boolean isValidToHome(ChessboardPoint src, ChessboardPoint dest) {
        if (getChessPieceAt(dest).getRank() == 9 && getChessPieceOwner(src) != getChessPieceOwner(dest)) {
            return calculateDistance(src, dest) == 1;
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
    public boolean isValidToJump(ChessboardPoint src, ChessboardPoint des) {
        if (getChessPieceAt(src).getRank() == 6 || getChessPieceAt(src).getRank() == 7) {
            if (src.getCol() == des.getCol() && calculateDistance(src, des) == 4) {
                if (src.getRow() >= des.getRow()) {
                    return (isOnLand(des) && NoMouseRow(src.getRow(), des.getRow(), src.getCol()));
                }else {
                    return (isOnLand(des) && NoMouseRow(des.getRow(), src.getRow(), src.getCol()));
                }
            }
            if (src.getRow() == des.getRow() && calculateDistance(src, des) == 3) {
                if (src.getCol() >= des.getCol()) {
                    return (isOnLand(des) && NoMouseCol(src.getCol(), des.getCol(), src.getRow()));
                }else {
                    return (isOnLand(des) && NoMouseCol(des.getCol(), src.getCol(), src.getRow()));
                }
            }
        }
        return false;
    }

    public boolean NoMouseRow(int big, int small, int col) {
        for (int i = small; i <= big; i++) {
            if (grid[i][col].getPiece() == null) continue;
            if (grid[i][col].getPiece().getRank() == 1) {
                return false;
            }
        }
        return true;
    }

    public boolean NoMouseCol(int big, int small, int row) {
        for (int i = small; i <= big; i++) {
            if (grid[row][i].getPiece() == null) continue;
            if (grid[row][i].getPiece().getRank() == 1) {
                return false;
            }
        }
        return true;
    }

}
