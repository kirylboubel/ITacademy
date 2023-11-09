package by.itacademy;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "assessment")
public class Assessment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "value", length = 2)
    private Integer value;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "lesson_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk__assessment__lesson__id")
    )
    private Lesson lesson;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk__assessment__student__id")
    )
    private Student student;
    @ManyToMany(mappedBy = "assessments")
    private List<Group> groups;
    @ManyToMany(mappedBy = "assessments")
    private List<Subject> subjects;
    @ManyToMany(mappedBy = "assessments")
    private List<Teacher> teachers;
}
