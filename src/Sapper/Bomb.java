package Sapper;

import org.w3c.dom.ranges.Range;

public class Bomb {
    private Matrix bombMap;
    private int totalBombs;

    Bomb(int totalBombs){
        this.totalBombs = totalBombs;
    }

    void start() {
        bombMap = new Matrix(Box.ZERO);
        for (int i = 0; i < totalBombs; i++) {
            placeBomb();
        }
    }

    Box get (Coord coord){
        return bombMap.getMatrix(coord);
    }

    private void placeBomb() {
        Coord coord = Ranges.getRandomCoord();
        bombMap.setMatrix(coord,Box.BOMB);
        for (Coord around: Ranges.getCoordsAround(coord))
            bombMap.setMatrix(around, Box.NUM1);
    }
}
