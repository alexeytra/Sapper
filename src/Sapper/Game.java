package Sapper;

import org.ietf.jgss.GSSManager;
import org.w3c.dom.ranges.Range;

public class Game {

    private Bomb bomb;
    private Flag flag;
    private GameState state;

    public Game(int cols, int rows, int bombs){
        Ranges.setSize(new Coord(cols, rows));
        bomb = new Bomb(bombs);
        flag = new Flag();
    }

    public Box getBox(Coord coord) {
        if (flag.get(coord) == Box.OPENED)
            return bomb.get(coord);
        else
            return flag.get(coord);
    }

    public void start() {
        bomb.start();
        flag.start();
        state = GameState.PLAYED;
    }

    public void pressLeftButton(Coord coord) {
        openBox(coord);
        checkWinner();
    }

    private void openBox(Coord coord) {
        switch (flag.get(coord)){
            case OPENED: return;
            case FLAGED: return;
            case CLOSED:
                switch (bomb.get(coord)){
                    case ZERO: openBoxAround(coord) ;return;
                    case BOMB: openBombs(coord); return;
                        default: flag.setOpenedToBox(coord);return;
                }
        }
    }

    private void openBombs(Coord coord) {
        state = GameState.BOMBED;
        flag.setBombedToBox(coord);
        for (Coord coord1 : Ranges.getAllCoords()){
            if (bomb.get(coord1) == Box.BOMB)
                flag.setOpenedToClosedBombBox(coord1);
            else
                flag.setNoBombToFlagedSafeBox(coord1);
        }
    }


    private void checkWinner(){
        if (state == GameState.PLAYED)
            if (flag.getCountOfCloseBoxes() == bomb.getTotalBombs())
                state = GameState.WINNER;
    }

    private void openBoxAround(Coord coord) {
        flag.setOpenedToBox(coord);
        for (Coord around : Ranges.getCoordsAround(coord))
            openBox(around);

    }

    public void pressRightButton(Coord coord) {
        flag.toggleFlagedToBox(coord);
    }

    public GameState getState() {
        return state;
    }
}
