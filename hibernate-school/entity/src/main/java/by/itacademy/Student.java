package by.itacademy;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "student")
public class Student extends BasePersonEntity {
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_parent",
            joinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk__student_parent__student__id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "parent_id",
                    referencedColumnName = "id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk__student_parent__parent__id")
            )
    )
    private List<Parent> parents;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_school",
            joinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk__student_school__student__id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "school_id",
                    referencedColumnName = "id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk__student_school__school__id")
            )
    )
    private List<School> schools;

    @ManyToMany(mappedBy = "students")
    private List<StudentGroup> studentGroups;

    @OneToMany(mappedBy = "student")
    private List<Assessment> assessments;

    @OneToMany(mappedBy = "student")
    private List<Attend> attends;

    public Student() {
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(final List<Parent> parents) {
        this.parents = parents;
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(final List<School> schools) {
        this.schools = schools;
    }

    public List<StudentGroup> getStudentGroups() {
        return studentGroups;
    }

    public void setStudentGroups(final List<StudentGroup> studentGroups) {
        this.studentGroups = studentGroups;
    }

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(final List<Assessment> assessments) {
        this.assessments = assessments;
    }

    public List<Attend> getAttends() {
        return attends;
    }

    public void setAttends(final List<Attend> attends) {
        this.attends = attends;
    }
}
