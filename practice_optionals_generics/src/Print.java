//we can use any word we want besides T but mostly T is used so use that.T is short for type
public class Print<T> {
    T printable;

    public Print(T printable) {
        this.printable = printable;
    }
    public void sysOut(){
        System.out.println(this.printable);
    }
}
