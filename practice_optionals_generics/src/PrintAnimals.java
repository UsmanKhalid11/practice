//we can use any word we want besides T but mostly T is used so use that.T is short for type
public class PrintAnimals<T extends Animal> {
    T printable;

    public PrintAnimals(T printable) {
        this.printable = printable;
    }
    public void sysOut(){
        System.out.println(this.printable);
    }
}
