package Sapper;

class Flag {
    private Matrix flagmap;
    void start(){
        flagmap = new Matrix(Box.CLOSED);

    }

    Box get (Coord coord){
        return flagmap.getMatrix(coord);
    }

    public void setOpenedToBox(Coord coord) {
        flagmap.setMatrix(coord, Box.OPENED);
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
}
