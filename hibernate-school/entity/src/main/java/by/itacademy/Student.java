package by.itacademy;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "student")
public class Student extends BasePersonEntity{
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "group_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk__student__group__id")
    )
    private Group group;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "parent_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk__student__parent__id")
    )
    private Parent parent;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_lesson",
            joinColumns = @JoinColumn(
                    name = "lesson_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__student_lesson__lesson__id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__student_lesson__student__id")
            )
    )
    private List<Lesson> lessons;
    @OneToMany(mappedBy = "student")
    private List<Assessment> assessments;
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(
//            name = "attend_id",
//            referencedColumnName = "id",
//            nullable = false,
//            foreignKey = @ForeignKey(name = "fk__student__attend__id")
//    )
    @OneToMany(mappedBy = "student")
    private List<Attend> attends;
    @ManyToMany(mappedBy = "students")
    private List<School> schools;
}
