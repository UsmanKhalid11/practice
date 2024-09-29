import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImmutableMain {

    public static void main(String[] args) {
        List<String> hobbies=new ArrayList<>(List.of("games","computerbuilding","coding"));
        Address address=new Address("11110","j town","islamabad");
        ImutableClass imutableClass= new ImutableClass("usman",28, hobbies ,address);
        System.out.println(imutableClass);
        address.setCity("faislabad");
        hobbies.add("cricket");

        System.out.println(imutableClass);

        final List<String > arrList;
        arrList=new ArrayList<>(List.of("games","computerbuilding","coding"));
        System.out.println(arrList);
        arrList.set(2,"test");
        System.out.println(arrList);
        //arrList=new ArrayList<>(List.of("games","computerbuilding","coding"));   final array list refrence cannot be changed but value can be changed
    }
}
