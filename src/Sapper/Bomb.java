package Sapper;

import org.w3c.dom.ranges.Range;

public class Bomb {
    private Matrix bombMap;
    private int totalBombs;

    Bomb(int totalBombs){
        this.totalBombs = totalBombs;
        fixBombCount();
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

    private void fixBombCount() {
        int maxBombs = Ranges.getSize().x * Ranges.getSize().y / 2;
        if (totalBombs > maxBombs)
            totalBombs = maxBombs;
    }

    private void placeBomb() {
        while (true){
            Coord coord = Ranges.getRandomCoord();
            if (bombMap.getMatrix(coord) == Box.BOMB)
                continue;
            bombMap.setMatrix(coord,Box.BOMB);
            incnumbersAroundBomb(coord);
            break;
        }
    }

    private void incnumbersAroundBomb(Coord coord){
        for (Coord around: Ranges.getCoordsAround(coord))
            if (Box.BOMB != bombMap.getMatrix(around))
                bombMap.setMatrix(around, bombMap.getMatrix(around).getNextNumberBomb());
    }

    public int getTotalBombs() {
        return totalBombs;
    }
}
