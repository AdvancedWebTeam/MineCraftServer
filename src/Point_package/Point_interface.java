package Point_package;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface Point_interface {
	public ArrayList<Point> initialization();
	public void addpoint(ArrayList<Point> a, double x, double y, double z, int mat);
	public void removepoint(ArrayList<Point> a, double x, double y, double z, int mat);
	public void print(ArrayList<Point> a);
	public ArrayList<Point> readio() throws FileNotFoundException;
	public void writeio(ArrayList<Point> a) throws IOException;
}
