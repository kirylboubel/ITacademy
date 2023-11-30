package by.itacademy;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "school")
public class School extends BaseEntity {
    @Column(name = "name", length = 250, nullable = false)
    private String name;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "address_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk__school__address__id")
    )
    private Address address;

    @ManyToMany(mappedBy = "schools")
    private List<Student> students;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "school_teacher",
            joinColumns = @JoinColumn(
                    name = "teacher_id",
                    referencedColumnName = "id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk__school_teacher__teacher__id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "school_id",
                    referencedColumnName = "id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk__school_teacher__school__id")
            )
    )
    private List<Teacher> teachers;

    @OneToMany(mappedBy = "school")
    private List<StudentGroup> studentGroups;

    @OneToMany(mappedBy = "school")
    private List<Schedule> schedules;

    @OneToMany(mappedBy = "school")
    private List<GroupRoom> groupRooms;
    @ManyToMany(mappedBy = "schools")
    private List<Subject> subjects;

    public School() {
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(final List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(final List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<StudentGroup> getStudentGroups() {
        return studentGroups;
    }

    public void setStudentGroups(final List<StudentGroup> studentGroups) {
        this.studentGroups = studentGroups;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(final List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<GroupRoom> getGroupRooms() {
        return groupRooms;
    }

    public void setGroupRooms(final List<GroupRoom> groupRooms) {
        this.groupRooms = groupRooms;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "school id: " + getId() + ", school name: " + getName() + ", school address: " + getAddress().toString();
    }
}
