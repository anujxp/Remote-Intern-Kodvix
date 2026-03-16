class Engine {
    public String start() {
        return "Turbo Engine started";
    }
}

class MusicSystem{
    public void playMusic(){
        System.out.println("Playing music udi udi jaye");
    }
}

class Car {
    private String model = "BMW8";
    private Engine engine = new Engine(); // Car HAS-A Engine

    public void drive() {
        System.out.println(model + " is driving using: " + engine.start());
    }
}
class Main{
    public static void main(String[] args) {
        Car car = new Car();
        car.drive();
        MusicSystem ms =new MusicSystem();
        ms.playMusic();
    }
}