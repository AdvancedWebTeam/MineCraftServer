package Person_package;

import java.io.Serializable;
import java.util.UUID;

public class Person implements Serializable{
   private String id;
   private double x;
   private double y;
   private double z;
   private double rotation;
   public Person(double x,double y,double z,double rotation){
	   UUID uuid = UUID.randomUUID();
	   id= UUID.randomUUID().toString();
	   this.x=x;
	   this.y=y;
	   this.z=z;
	   this.rotation =rotation;
   }
   public Person(String id, double x, double y,double z, double rotation) {
       this.id = id;
       this.x = x;
       this.y = y;
       this.z = z;
       this.rotation = rotation;
   }
   public String getId(){
	   return id;
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
   public double getRotation() { return rotation;}
   public void setX(double x){
	   this.x=x;
   }
   public void setY(double y){
	   this.y=y;
   }
   public void setZ(double z){
	   this.z=z;
   }
   public void setRotation(double rotation) {this.rotation = rotation;}

}
