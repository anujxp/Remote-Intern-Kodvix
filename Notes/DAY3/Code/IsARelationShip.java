

class Engine{
    private String engineName = "turbo";
    
    public String startEngine(){
        return this.engineName + "is started ";
    }    
}

class Car extends Engine{
    
    private String Model = "bmw8";
    public void drive(){
        System.out.println(Model + " is Starting using Engine" + startEngine());
    }
    

}

class Main{
    public static void main(String[] args) {
        Car car = new Car();
        car.drive();
    }
}
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}
class IsARelationShip {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.bark();
    }
}

