package Point_package;


import java.util.Vector;

public interface Point_interface {
	Vector<Point> initialization();
	void addPoint(Vector<Point> a, double x, double y, double z, int mat);
	void removePoint(Vector<Point> a, double x, double y, double z, int mat);
	void print(Vector<Point> a);
	Vector<Point> readio();
	void writeio(Vector<Point> a);
}
