package src;

public class WorldLayer {
    private QuarterWorldLayer[] planeList;

    public WorldLayer() {
        this.planeList = new QuarterWorldLayer[4];
    }

    public QuarterWorldLayer getQuarter(int index) {
        return (index < 0 ||
                index > planeList.length) ?
                null :
                planeList[index];
    }
}
