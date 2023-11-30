package by.itacademy;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subject")
public class Subject extends BaseEntity {
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "school_subject",
            joinColumns = @JoinColumn(
                    name = "school_id",
                    referencedColumnName = "id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk__school_subject__school_id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "subject_id",
                    referencedColumnName = "id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk__school_subject__subject_id")
            )
    )
    private List<School> schools;

    @OneToMany(mappedBy = "subject")
    private List<StudentGroupSubjectLink> studentGroupSubjectLinks;

    @OneToMany(mappedBy = "subject")
    private List<Lesson> lessons;

    public Subject() {
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(final List<School> schools) {
        this.schools = schools;
    }

    public List<StudentGroupSubjectLink> getStudentGroupSubjectLinks() {
        return studentGroupSubjectLinks;
    }

    public void setStudentGroupSubjectLinks(final List<StudentGroupSubjectLink> studentGroupSubjectLinks) {
        this.studentGroupSubjectLinks = studentGroupSubjectLinks;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(final List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "subject id: " + getId() + ", subject name: " + getName();
    }
}
