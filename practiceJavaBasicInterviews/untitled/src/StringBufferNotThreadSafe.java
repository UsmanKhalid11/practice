public class StringBufferNotThreadSafe {


    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder();

        Runnable log=()->{
            for (int i =0; i <100 ; i++) {
                synchronized (sb) {
                    sb.append(Thread.currentThread().getName()).append(" ").append(i).append("\n");
                }
            }
        };
        Thread t1= new Thread(log,"thread1");
        Thread t2= new Thread(log,"thread2");
        t1.start();
        t2.start();
        try {
            t1.join();///main thread waits until t1 is executed
            t2.join();///main thread waits until t2 is executed but t1 and t2 can execute simultaneously
                      // they will not wait for each other joins only make the main thread to wait for that
                      // specific thread
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sb.toString());



    }
}
