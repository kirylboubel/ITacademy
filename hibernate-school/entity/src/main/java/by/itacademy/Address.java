package by.itacademy;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "address")
public class Address extends BaseEntity{
    @Column(name = "city", nullable = false, length = 50)
    private String city;
    @Column(name = "street", nullable = false, length = 50)
    private String street;
    @Column(name = "building_number", nullable = false, length = 10)
    private String buildingNumber;
    @OneToMany(mappedBy = "address")
    private List<School> schools;
}
