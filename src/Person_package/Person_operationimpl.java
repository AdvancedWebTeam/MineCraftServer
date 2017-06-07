package Person_package;

import java.io.*;
import java.util.ArrayList;

public class Person_operationimpl implements Person_interface{

	@Override
	public ArrayList<Person> initialization() {
		ArrayList<Person> a=new ArrayList<Person>();
		return a;
	}

	@Override
	public void addPerson(ArrayList<Person> a, String id, double x, double y, double z, double movementX) {
		a.add(new Person(id, x, y, z, movementX));
	}

	@Override
	public String addPerson(ArrayList<Person> a, double x, double y, double z, double movementX) {
		Person p = new Person(x,y,z,movementX);
		a.add(p);
		return p.getId();
	}


	@Override
	public void removePerson(ArrayList<Person> a, String id) {
		// TODO Auto-generated method stub
		for(int i=0;i<a.size();i++){
		   if(a.get(i).getId().equals(id)){
			   a.remove(i);
			   return;
		   }
		}
		
	}

	@Override
	public void changePerson(ArrayList<Person> a, String id, double x,
							 double y, double z, double movementX) {
		// TODO Auto-generated method stub

		for(int i=0;i<a.size();i++){
		   if(a.get(i).getId().equals(id)){

			   a.get(i).setX(x);
			   a.get(i).setY(y);
			   a.get(i).setZ(z);
			   a.get(i).setRotation(movementX);
			   return;
		   }
		}
		addPerson(a,id,x,y,z,movementX);

	}

	@Override
	public void print(ArrayList<Person> a) {
		// TODO Auto-generated method stub
		for(int i=0;i<a.size();i++){
			System.out.println(a.get(i).getId()+" "+a.get(i).getX()+" "+a.get(i).getY()+" "+a.get(i).getZ()+" "+a.get(i).getRotation());
		}
	}

	@Override
	public ArrayList<Person> readio() {
		File file = new File("personlist.txt");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Person> a=(ArrayList<Person>) ois.readObject();
			return a;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void writeio(ArrayList<Person> a) {
		String oo="personlist.txt";
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
/*	public static void main(String args[]){
		Person_operationimpl xx=new Person_operationimpl();
		
		ArrayList<Person> a=xx.initialization();
		xx.addPerson(a, 0.111, 0.222, 0.33, 0.4);
		xx.addPerson(a, 0, 1, 2, 3);
		xx.print(a);
	}
     */
}
