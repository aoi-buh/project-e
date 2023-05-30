package src;

public class World {
    
    private final int WORLD_HEIGHT = 64;

    private WorldLayer[] world;
    
    public World() {
        this.world = new WorldLayer[WORLD_HEIGHT];
    }

    public WorldLayer getLayer(int layer) {
        return (layer < 0 ||
                layer > WORLD_HEIGHT - 1) ?
                null : 
                this.world[layer];
    }

    public QuarterWorldLayer getQuarterWorldLayer(int absoluteX, int absoluteY, int absoluteZ) {
        WorldLayer layer = getLayer(absoluteZ);

        if (absoluteX > -1 &&                                           // 1 | 0
            absoluteY > -1) {                                           // -----
                return layer.getQuarter(0);                       // 2 | 3
            }
        if (absoluteX < 0 &&
            absoluteY > -1) {
                return layer.getQuarter(1);
            }
        if (absoluteX < 0 &&
            absoluteY < 0) {
                return layer.getQuarter(2);
            }
        if (absoluteX > -1 &&
            absoluteY < 0) {
                return layer.getQuarter(3);
            }
        return null;
    }

    public UnitLayer getUnitLayer(int absoluteX, int absoluteY, int absoluteZ) {
        QuarterWorldLayer quarterWorldLayer = getQuarterWorldLayer(absoluteX, absoluteY, absoluteZ);

        
    }
}
