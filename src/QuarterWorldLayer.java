package src;

import java.util.ArrayList;

public class QuarterWorldLayer {

    private ArrayList<ArrayList<UnitLayer>> unitPlanList;

    public QuarterWorldLayer() {
        this.unitPlanList = new ArrayList<ArrayList<UnitLayer>>();
    }

    public UnitLayer getUnitPlane(int relativeX, int relativeY) {
        if (relativeX > unitPlanList.size() ||
            relativeY > unitPlanList.get(relativeX).size()) {
            return null;
        }
        return unitPlanList.get(relativeX).get(relativeY);
    }
}
