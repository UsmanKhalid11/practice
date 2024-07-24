package SingletonPattern;
//it is lazy initialization because object will be create only when we ask for it using getSingletonPatternLazy function
//lazy initialization will have an issue though because two threads might access the function and create two objects
//for this we can make function synchronized

public class SingletonPatternLazy {
    private static SingletonPatternLazy singletonPatternLazy;
    private SingletonPatternLazy(){

    }
    public static SingletonPatternLazy getSingletonPatternLazy(){
        if(singletonPatternLazy==null) {
            synchronized (SingletonPatternLazy.class) {
                singletonPatternLazy = new SingletonPatternLazy();
                System.out.println("New Object created");
            }
        }else
            System.out.println("The object already exists");
        return singletonPatternLazy;
    }
}
