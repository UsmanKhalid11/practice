import javax.xml.crypto.Data;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
////testing time difference for linked list collision and non collision when collision happens it takes extra time for retrieval
public class IterationTest {
    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        Map<ObjectAsMapKey,String> map = new HashMap<>();
        for( int i=0;i<=7;i++){
            map.put( new ObjectAsMapKey(UUID.randomUUID().toString(),"Nabeel"),"developer");

        }
        System.out.println(System.currentTimeMillis()-start);
        int [] arr={1,2,3,4};
        System.out.println(arr[2]);
    }
}
