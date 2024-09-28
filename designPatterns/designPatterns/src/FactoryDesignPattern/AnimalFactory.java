package FactoryDesignPattern;

import java.lang.runtime.SwitchBootstraps;

public class AnimalFactory implements IAnimalFactory{
    @Override
    public IAnimel getAnimel(String animel) {
        switch (animel) {
            case "Lion":
                return new Lion();
            case "Duck":
                return new Duck();
            default:
                return null;
        }

    }
}
