public class StringsPractice {

    public static void main(String[] args) {
        String s1="new";
        String s2="new";
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));

        System.out.println(s2==s1);
        //here when address is printed both show that they have same address
        //also == which checks address gives true

        StringBuilder sb= new StringBuilder();
        sb.append("new");
        StringBuilder sb2= new StringBuilder();
        sb2.append("new");
        System.out.println(System.identityHashCode(sb));
        System.out.println(System.identityHashCode(sb2));
        System.out.println(sb==sb2);
    }
}
