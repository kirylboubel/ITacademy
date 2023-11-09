package by.itacademy;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "parent")
public class Parent extends BasePersonEntity{
    @OneToMany(mappedBy = "parent")
    private List <Student> students;
    @ManyToMany(mappedBy = "parents")
    private List<Group> groups;
}
