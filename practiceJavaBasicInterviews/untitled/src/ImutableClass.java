import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//creating immutable class we make class and feilds final
// initialize them in constructors
//and access them through only getters
// if you have things like lists/non primitive data types(except strings) make them final in constructor give them copy of list for initialization
// and the return unmodifieable list
public final class ImutableClass {

    private final String name;
    private final int age;

    private final List<String> hobbies;

    private final Address address;

    public ImutableClass(String name, int age, List<String> hobbies,Address address) {
        this.name = name;
        this.age = age;
        this.hobbies = new ArrayList<>( hobbies);//this will give copy of list insted of orignal list
        this.address= new Address(address);//this will give copy of list insted of orignal list
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getHobbies() {
        return Collections.unmodifiableList(hobbies);  //return unmodifieable list
    }

    public Address getAddress() {
        return new Address( address);
    }

    @Override
    public String toString() {
        return "ImutableClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                ", address=" + address +
                '}';
    }
}
