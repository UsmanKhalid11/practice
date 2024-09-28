package TemplatePattern;

public class TemplateDesignPatternMain {
    public static void main(String[] args) {
        // Template design patter we define some functionality in parent class and then some
        // functionality definition is deffered to child class here parent class is BasicEngineeringTemplate
        // two papers comunication skills and maths will be same for all engineering class
        // in degree specific paper a subject unique to that degree is defined
        // so it will be defined by child class
        System.out.println("Computer Science papers are");
        BasicEngineeringTemplate basicEngineeringTemplate= new ComputerScience();
        basicEngineeringTemplate.papers();
        System.out.println("Electronics papers are");
        basicEngineeringTemplate= new Electronics();
        basicEngineeringTemplate.papers();

    }

}
