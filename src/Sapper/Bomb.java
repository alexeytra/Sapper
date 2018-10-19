package Sapper;

public class Bomb {
    private Matrix bombMap;
    private int totalBombs;

    Bomb(int totalBombs){
        this.totalBombs = totalBombs;
    }

    void start() {
        bombMap = new Matrix(Box.ZERO);
        placeBomb();
    }

    Box get (Coord coord){
        return bombMap.getMatrix(coord);
    }

    private void placeBomb() {
        bombMap.setMatrix(new Coord(4, 4),Box.BOMB);
    }
}
