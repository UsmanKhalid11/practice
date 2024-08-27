package FactoryDesignPattern;

public class FactoryDesignPatternMain {
    public static void main(String[] args) {
        //is a type of creational design pattern
        //delegates object creation to subclass at runtime based on some param.
        //has four parts
        //product which in our case is Ianimel
        //concrete products that extend products and in our case are duck and lion
        //factory which in our case is Ianimefactory
        //concrete factory that is used for object creation which in our case is AnimelFactory
        IAnimalFactory animalFactory= new AnimalFactory();
        IAnimel lion=animalFactory.getAnimel("Lion");
        IAnimel duck=animalFactory.getAnimel("Duck");
    }

}
