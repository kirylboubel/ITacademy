package by.itacademy;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "student_group")
public class StudentGroup extends BaseEntity {
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "school_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk__student_group__school__id")
    )
    private School school;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "group_owner_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk__student_group__teacher__id")
    )
    private Teacher groupOwner;

    @OneToMany(mappedBy = "studentGroup")
    private List<StudentGroupSubjectLink> studentGroupSubjectLinks;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_group_student_link",
            joinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk__student_group_student_link__student__id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_group_id",
                    referencedColumnName = "id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk__student_group_student_link__student_group__id")
            )
    )
    private List<Student> students;

    @OneToMany(mappedBy = "studentGroup")
    private List<GroupRoom> groupRooms;

    @OneToMany(mappedBy = "studentGroup")
    private List<Lesson> lessons;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(final School school) {
        this.school = school;
    }

    public Teacher getGroupOwner() {
        return groupOwner;
    }

    public void setGroupOwner(final Teacher groupOwner) {
        this.groupOwner = groupOwner;
    }

    public List<StudentGroupSubjectLink> getStudentGroupSubjectLinks() {
        return studentGroupSubjectLinks;
    }

    public void setStudentGroupSubjectLinks(final List<StudentGroupSubjectLink> studentGroupSubjectLinks) {
        this.studentGroupSubjectLinks = studentGroupSubjectLinks;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(final List<Student> students) {
        this.students = students;
    }

    public List<GroupRoom> getGroupRooms() {
        return groupRooms;
    }

    public void setGroupRooms(final List<GroupRoom> groupRooms) {
        this.groupRooms = groupRooms;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(final List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
