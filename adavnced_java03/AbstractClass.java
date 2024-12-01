package adavnced_java03;

    abstract class Car{
        public abstract void drive();
        public void playMusic(){
            System.out.println("playing music");
        }
    }

public abstract class AbstractClass extends Car {}
