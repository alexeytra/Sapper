package Sapper;

class Flag {
    private Matrix flagmap;
    void start(){
        flagmap = new Matrix(Box.CLOSED);
    }

    Box get (Coord coord){
        return flagmap.getMatrix(coord);
    }
}
