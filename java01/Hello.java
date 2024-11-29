class Sum{
    public int sum(int a, int b){
        int result=a+b;
        return result;
    }    
}
class Array {
    public void printArray(int array[]){
        int len = array.length;
        for(int i=0;i<len;i++){
            System.out.print(array[i]+", ");
        }
    }
    
}

class Array2D{
    public void printArray2d(int [][]array2d){
        int leni = array2d.length;
        int lenj = array2d[1].length;
        for(int i = 0; i < leni;i++){
            for(int j = 0;j<lenj;j++){
                System.out.print(array2d[i][j]+" ");
            }
            System.out.println();
        }
    }
}

class Person{
    String name;
    int edad;
    public Person(String name, int edad){
        this.name=name;
        this.edad=edad;
    }
}

class ObjectArray{
    public void showPersons(Person persons[]){
        for(int i=0;i<persons.length;i++){
            System.out.println(persons[i].name+" "+persons[i].edad);
        }
    }
}

public class Hello{
    public static void main(String[] args ){
        System.out.println("class practice");
        Sum sum = new Sum();
        int result=sum.sum(5, 6);
        System.out.println(result);
       
        System.out.println("array practice");
        Array array = new Array();
        int[] arrayE={1,2,2,3,4,5,6};
        array.printArray(arrayE);
       
        System.out.println();
        System.out.println("array2d practice");
        Array2D array2d=new Array2D();
        int array2dE[][] = new int[3][3];
        array2d.printArray2d(array2dE);

        System.out.println("Object arrays");
        Person person1=new Person("ellio", 29);
        Person person2= new Person("mr robot", 56);
        Person[] persons = new Person[2];
        persons[0]=person1;
        persons[1]=person2;
        ObjectArray obArray = new ObjectArray();
        obArray.showPersons(persons);

    }
}