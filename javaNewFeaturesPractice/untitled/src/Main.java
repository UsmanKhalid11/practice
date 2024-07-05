import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main implements InterfaceA {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        OuterClass.Nested nested= new OuterClass.Nested();
        nested.printHello();
        Map<ObjectAsMapKey,String> map = new HashMap<>();
        ObjectAsMapKey obj1= new ObjectAsMapKey(1,"Nabeel");
        ObjectAsMapKey obj2= new ObjectAsMapKey(2,"Abdurehman");
        map.put(obj1,"Developer");
        map.put(obj2,"QA");
        System.out.println("Obj1 is "+map.get(obj1)+" and obj 2 is "+map.get(obj2));

    }
}