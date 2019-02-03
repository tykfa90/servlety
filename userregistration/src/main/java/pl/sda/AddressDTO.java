package pl.sda;

public class AddressDTO {
    private Long id;
    private String city;
    private String street;
    private String houseNo;

    public AddressDTO() {
    }

    public AddressDTO(Address address) {
        this.city = address.getCity();
        this.street = address.getStreet();
        this.houseNo = address.getHouseNo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    @Override
    public String toString() {
        return city + ", " + street + " " + houseNo;
    }
}
