package Sapper;

class Flag {
    private Matrix flagmap;
    private int countOfClosedBoxes;

    void start(){
        flagmap = new Matrix(Box.CLOSED);
        countOfClosedBoxes = Ranges.getSize().x * Ranges.getSize().y;
    }

    Box get (Coord coord){
        return flagmap.getMatrix(coord);
    }

    public void setOpenedToBox(Coord coord) {
        flagmap.setMatrix(coord, Box.OPENED);
        countOfClosedBoxes--;
    }

    public void setFlagedToBox(Coord coord) {
        flagmap.setMatrix(coord, Box.FLAGED);
    }

    public void toggleFlagedToBox(Coord coord) {
        switch (flagmap.getMatrix(coord)){
            case FLAGED: setClosedToBox(coord); break;
            case CLOSED: setFlagedToBox(coord); break;
        }
    }

    private void setClosedToBox(Coord coord) {
        flagmap.setMatrix(coord, Box.CLOSED);
    }

    public int getCountOfCloseBoxes() {
        return countOfClosedBoxes;
    }

    public void setBombedToBox(Coord coord) {
        flagmap.setMatrix(coord, Box.BOMBED);
    }

    public void setOpenedToClosedBombBox(Coord coord1) {
        if (flagmap.getMatrix(coord1) == Box.CLOSED)
            flagmap.setMatrix(coord1, Box.OPENED);
    }

    public void setNoBombToFlagedSafeBox(Coord coord1) {
        if (flagmap.getMatrix(coord1) == Box.FLAGED)
            flagmap.setMatrix(coord1, Box.NOBOMB);
    }
}
