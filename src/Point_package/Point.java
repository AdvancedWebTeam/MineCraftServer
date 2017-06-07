package Point_package;

import java.io.Serializable;

public class Point implements Serializable{
	private double x;
	private double y;
	private double z;
	private int material;
	public Point(double x,double y,double z,int mat){
		this.x=x;
		this.y=y;
		this.z=z;
		material=mat;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public double getZ(){
		return z;
	}
	public int getMat(){
		return material;
	}
}
