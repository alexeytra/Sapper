package Sapper;

class Matrix {
    private Box[][] matrix;

    Matrix (Box defaultBox) {
        matrix = new Box[Ranges.getSize().x][Ranges.getSize().y];
        for (Coord coord: Ranges.getAllCoords())
            matrix[coord.x][coord.y] = defaultBox;
    }

    public Box getMatrix(Coord coord) {
        if (Ranges.inRange(coord))
            return matrix[coord.x][coord.y];
        return null;
    }

    void setMatrix(Coord coord, Box box) {
        if (Ranges.inRange(coord))
            matrix[coord.x][coord.y] = box;

    }
}
