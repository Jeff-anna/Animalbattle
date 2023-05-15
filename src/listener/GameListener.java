package listener;

import model.ChessboardPoint;
import view.CellComponent;
import view.ElephantChessComponent;
import view.LionChessComponent;
import view.TigerChessComponent;
import view.LeopardChessComponent;
import view.WolfChessComponent;
import view.DogChessComponent;
import view.CatChessComponent;
import view.MouseChessComponent;

public interface GameListener {

    void onPlayerClickCell(ChessboardPoint point, CellComponent component);


    void onPlayerClickChessPiece1(ChessboardPoint point, ElephantChessComponent component);
    void onPlayerClickChessPiece2(ChessboardPoint point, LionChessComponent component);
    void onPlayerClickChessPiece3(ChessboardPoint point, TigerChessComponent component);
    void onPlayerClickChessPiece4(ChessboardPoint point, LeopardChessComponent component);
    void onPlayerClickChessPiece5(ChessboardPoint point, WolfChessComponent component);
    void onPlayerClickChessPiece6(ChessboardPoint point, DogChessComponent component);
    void onPlayerClickChessPiece7(ChessboardPoint point, CatChessComponent component);
    void onPlayerClickChessPiece8(ChessboardPoint point, MouseChessComponent component);

}
