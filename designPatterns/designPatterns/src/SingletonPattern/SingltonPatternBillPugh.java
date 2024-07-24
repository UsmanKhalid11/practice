package SingletonPattern;
//we can use Bil pugh method in which we use nested class in this way the code will not be in danger
//due to multiple threads and will not be in danger of memory usage because the object will be only
//instantiated when inner static class is refrenced as inner static class is only loaded when it is
//refrenced
public class SingltonPatternBillPugh {
    private SingltonPatternBillPugh(){}
    private static class SingltonPatternBillPughHelper{
        private static  SingltonPatternBillPugh singltonPatternBillPugh=new SingltonPatternBillPugh();
    }
    public static SingltonPatternBillPugh getSingltonPatternBillPugh(){
        return SingltonPatternBillPughHelper.singltonPatternBillPugh;
    }
}
