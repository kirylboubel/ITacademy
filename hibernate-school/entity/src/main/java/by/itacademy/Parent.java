package by.itacademy;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "parent")
public class Parent extends BasePersonEntity {
    @ManyToMany(mappedBy = "parents")
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(final List<Student> students) {
        this.students = students;
    }
}
