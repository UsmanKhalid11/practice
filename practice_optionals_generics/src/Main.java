import java.util.Optional;
//https://www.youtube.com/watch?v=vKVzRbsMnTQ
public class Main {
    //practicing optionals
    public static void main(String[] args) {
        //used basically when we are expecting that resultant object can be null but we
        // have to call some get function that can end up throwing null exception.
        // before optionals we use to handle it using if else statement now optional can handle it
        //optional can either be empty or with object you are requesting
        //basically optional.get can be used to get element from optional but if optional is empty it will give nosuch element exception
        //we can use optional.ispresent method to check whether optional is empty or not.
        // but it bacame same as before i.e the null check to prevent nullexception
        //by returning optional we are telling the user that response could be empty and user can handel it on their side
        if(checkNullCar().isPresent())
          System.out.println(checkNullCar().get().company);
        //optionals have many other methods like optional.orElse(defaultValue) method it returns object if object is there or else returns default value given in parameter
         System.out.println(checkNullCar().orElse(new Car()));
        //optional.orElseGet is used for lambda
         System.out.println(checkNullCar().orElseGet(()->{
            Car car= new Car();
            car.company="hyundai";
            car.model="sonata";
            return car;
        }));
        // optional.map can be used to transform our return object to other type which can bes used to handle specific field of objecr
        //here we transformed car object to string and used or else method ont that
        System.out.println(checkNullCar().map(Car::getCompany).orElse(""));
        Optional<String> newop=null;
        System.out.println(newop.isPresent());
    }

    public static Optional<Car>checkNullCar(){
        Car car=null;
        //Optional.of for object that cannot be null
        //Optional.ofNullable if object can be null
        //Optional.empty to creat empty object
        return Optional.ofNullable(car);
    }
}