

public class CheckingFinalizeMain {

    public static void main(String[] args) {
        CheckingFinalize cf = new CheckingFinalize();
        cf= null;//object is eligible for garbage collection when its refrence is null
        System.gc();//suggest to run garbage collector
    }
}
