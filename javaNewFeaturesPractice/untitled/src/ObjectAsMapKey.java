import java.util.Objects;
///written for testing on how to use objects as key
public class ObjectAsMapKey {
     private String id ;
     private String name;

    public ObjectAsMapKey(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id,name);
    }
    @Override
    public boolean equals(Object o){
        if(this==o)
            return true;
        if(o==null || getClass()!=o.getClass())
            return false;
        ObjectAsMapKey obj= (ObjectAsMapKey) o;
        return Objects.equals(id,obj.getId()) && Objects.equals(name,obj.getName());
    }

    @Override
    public String toString() {
        return "ObjectAsMapKey{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
