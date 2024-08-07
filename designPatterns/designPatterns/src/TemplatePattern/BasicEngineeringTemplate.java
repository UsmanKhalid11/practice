package TemplatePattern;

public abstract  class BasicEngineeringTemplate {
    public void papers(){
    Maths();
    Comms();
    degreeSpecific();
    }
    public void Maths(){
        System.out.println("Mathematics");
    }
    public void Comms(){
        System.out.println("Communication Skills");
    }
    public  abstract void degreeSpecific();
}
