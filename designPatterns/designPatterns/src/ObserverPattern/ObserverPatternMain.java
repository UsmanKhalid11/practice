package ObserverPattern;


/*observer patterns are behavioral pattern in which differen observers observe a subject and
 then if a change happens in subject they are notified. for this observers register themselves
 with subject. and then they un register when they no longer need to be notified
 */
public class ObserverPatternMain {
    public static void main(String[] args) {
        //we create 2 observers that are observing subject 1
        Observer1 ob1=new Observer1();
        Observer2 ob2= new Observer2();
        Subject1 sub1= new Subject1();
        //we need to register these observers with subject
        sub1.register(ob1);
        sub1.register(ob2);
        // now let us see what happens when we update the flag in subject
        sub1.setFlag(7);
        /*
        we get output
        From observer 1 Value updated is7
        From observer 2 Value updated is7
        i.e both observers were notified
        */
        sub1.unregister(ob1);
        // now we unregister one observer and see what happens
        sub1.setFlag(9);
        /*
        we get output
        From observer 2 Value updated is9
        because observer 1 was unregistered so only observer 2 is notified
         */
    }
}
