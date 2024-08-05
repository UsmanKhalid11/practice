public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        print("name","address");
    }

    public static void print(String ...name){
        for(String item:name){
            System.out.println(item);
        }
    }
}