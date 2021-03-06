package Point_package;

import java.io.*;
import java.util.Vector;
import java.util.Scanner;

public class Point_operationimpl implements Point_interface{
	public Vector<Point> initialization(){
		Vector<Point> a=new Vector<Point>();
		return a;
	}
	public void addPoint(Vector<Point> a, double x, double y, double z, int mat){
		Point t=new Point(x,y,z,mat);
		a.add(t);
	}
	public void removePoint(Vector<Point> a, double x, double y, double z, int mat){
		for(int i=0;i<a.size();i++){
			double x1=Math.abs(x-a.get(i).getX());
			double y1=Math.abs(y-a.get(i).getY());
			double z1=Math.abs(z-a.get(i).getZ());
			if(x1<0.001&&y1<0.001&&z1<0.001&&(mat==a.get(i).getMat())){
				a.remove(i);
				System.out.println("sha bi");
				return;
			}
		}

	}
	/* test  */
	public void print(Vector<Point> a){
		for(int i=0;i<a.size();i++){
			System.out.println(a.get(i).getX()+" "+a.get(i).getY()+" "+a.get(i).getZ()+" "+a.get(i).getMat());
		}
	}
	public Vector<Point> readio() {
		File file = new File("pointlist.txt");
		FileInputStream fis = null;
		Vector<Point> a = null;
		try {
			fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			a=(Vector<Point>) ois.readObject();
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		}

		return a;
	}
	public void writeio(Vector<Point> a){
		String oo="pointlist.txt";
		File file1=new java.io.File(oo);
		if(file1.exists()){
			file1.delete();
		}
		try {
			file1.createNewFile();
			FileOutputStream fos = new FileOutputStream(file1);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(a);
			oos.flush();
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/*  test */
	public static void main(String args[]) throws IOException{
/*		Point_operationimpl xx=new Point_operationimpl();
		Vector<Point> a=xx.initialization();
		xx.addPoint(a, 0.1, 0.2, 0.3, 1);
		xx.addPoint(a, 0.2, 0.3, 0.4, 4);
		xx.addPoint(a, 0.2,0.4,0.5, 3);
		xx.print(a);
		xx.writeio(a);
		
		System.out.println();
		Vector<Point> b=xx.readio();
		xx.print(b);*/
	}
}
