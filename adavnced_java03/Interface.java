package adavnced_java03;

interface A{
    int age=21;//static aand final
    void show();
    void config();
}

public class Interface implements A{
   
    public void show(){
    System.out.println("show useing interface");
   } 
   
   public void config(){
    System.out.println("config useing interface");
   }

}
