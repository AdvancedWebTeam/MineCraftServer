package Point_package;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface Point_interface {
	ArrayList<Point> initialization();
	void addPoint(ArrayList<Point> a, double x, double y, double z, int mat);
	void removePoint(ArrayList<Point> a, double x, double y, double z, int mat);
	void print(ArrayList<Point> a);
	ArrayList<Point> readio();
	void writeio(ArrayList<Point> a);
}
