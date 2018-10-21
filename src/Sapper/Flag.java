package Sapper;

class Flag {
    private Matrix flagmap;
    void start(){
        flagmap = new Matrix(Box.CLOSED);
        for (Coord around : Ranges.getCoordsAround(new Coord(4, 4)))
            flagmap.setMatrix(around, Box.OPENED);
    }

    Box get (Coord coord){
        return flagmap.getMatrix(coord);
    }

    public void setOpenedToBox(Coord coord) {
        flagmap.setMatrix(coord, Box.OPENED);
    }
}
