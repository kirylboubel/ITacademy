package by.itacademy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "address")
public class Address extends BaseEntity {
    @Column(name = "city", nullable = false, length = 30)
    private String city;
    @Column(name = "street", nullable = false, length = 30)
    private String street;
    @Column(name = "building_number", nullable = false, length = 10)
    private String buildingNumber;
    @OneToMany(mappedBy = "address")
    private List<School> schools;

    public Address() {
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

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(final String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(final List<School> schools) {
        this.schools = schools;
    }

    @Override
    public String toString() {
        return "city: " + getCity() + ", street: " + getStreet() + ", building number: " + getBuildingNumber();
    }
}
