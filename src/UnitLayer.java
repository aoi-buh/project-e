package src;

public class UnitLayer {
    
    private final int PLANE_DIMENSION = 64;

    private Unit[][] plane;

    public UnitLayer() {

        Unit[][] plane = new Unit[PLANE_DIMENSION][PLANE_DIMENSION];






        this.plane = plane;
    }

    public Unit getRUnit(int relativeX, int relativeY) {
        return this.plane[relativeX][relativeY];
    }

}
