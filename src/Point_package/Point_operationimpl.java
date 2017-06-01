package Point_package;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Point_operationimpl implements Point_interface{
	public ArrayList<Point> initialization(){
		ArrayList<Point> a=new ArrayList<Point>();
		return a;
	}
	public void addpoint(ArrayList<Point> a,double x,double y,double z,int mat){
		Point t=new Point(x,y,z,mat);
		a.add(t);
	}
	public void removepoint(ArrayList<Point> a,double x,double y,double z,int mat){
		int index=-1;
		for(int i=0;i<a.size();i++){
			double x1=Math.abs(x-a.get(i).getx());
			double y1=Math.abs(y-a.get(i).gety());
			double z1=Math.abs(z-a.get(i).getz());
			if(x1<0.001&&y1<0.001&&z1<0.001&&(mat==a.get(i).getmat())){
				index=i;
			}
		}
		if(index!=-1)
			a.remove(index);
	}
	/* test  */
	public void print(ArrayList<Point> a){
		for(int i=0;i<a.size();i++){
			System.out.println(a.get(i).getx()+" "+a.get(i).gety()+" "+a.get(i).getz()+" "+a.get(i).getmat());
		}
	}
	public ArrayList<Point> readio() throws FileNotFoundException{
		ArrayList<Point> a=new ArrayList<Point>();
		File data=new File("pointlist.txt");
		Scanner input=new Scanner(data);
		int n=input.nextInt();
		for(int i=0;i<n;i++){
			double x=input.nextDouble();
			double y=input.nextDouble();
			double z=input.nextDouble();
			int mat=input.nextInt();
			Point t=new Point(x,y,z,mat);
			a.add(t);
		}
		input.close();
		return a;
	}
	public void writeio(ArrayList<Point> a) throws IOException{
		String oo="pointlist.txt";
    	File file1=new File(oo);
    	 if(file1.exists()){
			  file1.delete();
		}
    	 file1.createNewFile();
  		BufferedWriter bw=new BufferedWriter(new FileWriter(file1,true));
  		bw.write(a.size()+"\r\n");
  		for(int i=0;i<a.size();i++){
  			bw.write(a.get(i).getx()+" "+a.get(i).gety()+" "+a.get(i).getz()+" "+a.get(i).getmat()+"\r\n");
  		}
  		bw.close();
	}
	/*  test */
	public static void main(String args[]) throws IOException{
		Point_operationimpl xx=new Point_operationimpl();
		ArrayList<Point> a=xx.initialization();
		xx.addpoint(a, 0.1, 0.2, 0.3, 1);
		xx.addpoint(a, 0.2, 0.3, 0.4, 4);
		xx.addpoint(a, 0.2,0.4,0.5, 3);
		xx.print(a);
		xx.writeio(a);
		
		System.out.println();
		ArrayList<Point> b=xx.readio();
		xx.print(b);
	}
}
