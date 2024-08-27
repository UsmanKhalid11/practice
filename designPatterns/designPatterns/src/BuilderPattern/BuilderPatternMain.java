package BuilderPattern;


public class BuilderPatternMain {
    public static void main(String[] args) {
        //an example of creational desing pattern
        ///Builder design pattern used to create object step by step.
        ///mostly used to create a complex object so that complex part can be created seprately
        ///also can be used to create immutable object
        //it consist of a class which in this case is computer
        //the constructor of class will be private so that only builder is used
        //constructor of class will have builder as param and values will be set by builder
        //builder will have set mehods that will return build class and a build method that returns orignal class to be built
        Computer com = new Computer.ComputerBuilder().setCpu("Intel i3")
                .setGpu("Rtx 3080").setRam("16gb").setHardDisk("ssd").build();
    }
}
