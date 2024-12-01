import quizz_app02.*;
import adavnced_java03.*;

enum Laptops{
    Mac(200),Hp(100),Thinkpad(50);
    private int price;
    
    private Laptops(int price){
        this.price=price;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
}


class Toyota extends AbstractClass{
    @Override
    public void drive(){
        System.out.println("driving toyota");
    }       
}

public class Main {

    public static void main(String[] args){
        System.out.println("start");
        //Quizz App
        
        /*QuestionService service=new QuestionService();
        service.playQuizz();
        service.printScore();*/
        
        //Advanced Java
        /*Toyota car1 = new Toyota();
        car1.drive();*/
        
        //enums
        Laptops thinkPad = Laptops.Thinkpad;
        System.out.println(thinkPad+" : "+thinkPad.getPrice());
        System.out.println(thinkPad.ordinal());
    
        
    
    }
    
}

