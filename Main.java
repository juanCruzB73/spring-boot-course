import quizz_app02.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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
        /*
        Laptops thinkPad = Laptops.Thinkpad;
        System.out.println(thinkPad+" : "+thinkPad.getPrice());
        System.out.println(thinkPad.ordinal());
        */

        //array list
        /*List<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(521);
        nums.add(321321);
        nums.add(4545);
        nums.add(8516);
        nums.add(50034165);
        
        System.out.println(nums.get(0));
        System.out.println(nums.indexOf(1));*/
        
        //HashSet
        /*System.out.println("HashSet");
        Set<Integer> nums = new HashSet<Integer>();
        nums.add(145);
        nums.add(298);
        nums.add(85492455);
        nums.add(3325);
        for(int n: nums){
            System.out.println(n);
        }
        //TreeSet
        System.out.println("TreeSet");
        Set<Integer> nums2 = new TreeSet<Integer>();
        nums2.add(145);
        nums2.add(298);
        nums2.add(3325);
        for(int n: nums2){
            System.out.println(n);
        }
        //Iterator
        System.out.println("iterator");
        Iterator<Integer> nums3 = nums.iterator();
        while (nums3.hasNext()) {
            System.out.println(nums3.next());
        }
        //Map
        Map<String,Integer>students=new HashMap();
        
        students.put("elliot", 100);
        students.put("Darlene", 100);
        students.put("sas", 100);
        System.out.println(students.keySet());
        System.out.println(students.get("elliot"));
        */
        //sort
        /*Comparator<Integer> comparator = (Integer i, Integer j)->(i%10 > j%10) ? 1 : -1;

       Collections.sort(nums,comparator);

       //forEach
       nums.forEach(n->System.out.print(n+", "));
        */        
    }
    
}

