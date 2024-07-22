package ObserverPattern.ObserverPatternWithMultipleSubjects;


/*writing this example when an observer observes multiple subjects
 */
public class ObserverPatternMain {
    public static void main(String[] args) {
        //we create 2 observers that are observing subject 2
        Observer1 ob1=new Observer1();
        Observer2 ob2= new Observer2();
        Observer3 ob3= new Observer3();
        Subject1 sub1= new Subject1();
        Subject2 sub2= new Subject2();
        //we need to register these observers with subject
        //now you see observer 2 is registered with both subjects
        sub1.register(ob1);
        sub1.register(ob2);
        sub2.register(ob2);
        sub2.register(ob3);
        // now let us see what happens when we update the flag in subjects
        sub1.setFlag(7);
        sub2.setFlag(9);
        /*
        output is
        as you can see oserver 2 is registered in both subjects so it will be notified
        for both subjects we can differ it by subject names
        From observer 1 Value updated is7 in subject Subject1
        From observer 2 Value updated is7 in subject Subject1
        From observer 2 Value updated is9 in subject Subject2
        From observer 3 Value updated is9 in subject Subject2
         */
    }
}
