public class Address{

    private String houseNo ;
    private String society ;
    private String city;

    public Address(String houseNo, String society, String city) {
        this.houseNo = houseNo;
        this.society = society;
        this.city = city;
    }

    public Address(Address address) {
        this.houseNo =address.getHouseNo();
        this.society = address.getSociety();
        this.city = address.getCity();
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getSociety() {
        return society;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNo='" + houseNo + '\'' +
                ", society='" + society + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
