import java.util.Objects;

public class ObjectAsMapKey {
     private int id ;
     private String name;

    public ObjectAsMapKey(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return id==obj.getId() && Objects.equals(name,obj.getName());
    }

    @Override
    public String toString() {
        return "ObjectAsMapKey{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
