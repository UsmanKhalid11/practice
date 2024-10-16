public class CheckingFinalize {
///finalize is called by gc when object is removed from memory
    @Override
    public void finalize() throws Throwable{

        System.out.println("running garbage collector");
    }
}
