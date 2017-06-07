package Point_package;

import Point_package.Point;

/**
 * Created by lyz on 17-6-1.
 */
public class Action {
    int action; //0: add, 1: remove
    double x;
    double y;
    double z;
    int material;
    public Action(Point p) {
        action = 0;
        this.x = p.getX();
        this.y = p.getY();
        this.z = p.getZ();
    }
    Action(Point p, int action) {
        this.action = action;
        this.x = p.getX();
        this.y = p.getY();
        this.z = p.getZ();
    }
    boolean isAddition() {
        return (action==0);
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public int getMaterial() {
        return material;
    }

    public void setMaterial(int material) {
        this.material = material;
    }
}
