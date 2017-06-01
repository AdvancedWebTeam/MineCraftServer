package Point_package;

public class Point {
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
	public double getx(){
		return x;
	}
	public double gety(){
		return y;
	}
	public double getz(){
		return z;
	}
	public int getmat(){
		return material;
	}
}
