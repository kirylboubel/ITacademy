package by.itacademy;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subject")
public class Subject extends BaseEntity{
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "subject_assessment",
            joinColumns = @JoinColumn(
                    name = "assessment_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__subject_assessment__assessment__id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "subject_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__subject_assessment__subject__id")
            )
    )
    private List <Assessment> assessments;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "subject_teacher",
            joinColumns = @JoinColumn(
                    name = "teacher_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__subject_teacher__teacher__id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "subject_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__subject_teacher__subject__id")
            )
    )
    private List<Teacher> teachers;
    @ManyToMany(mappedBy = "subjects")
    private List<Group> groups;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "school_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk__subject__school_id")
    )
    private School school;
    @ManyToMany(mappedBy = "subjects")
    private List<Lesson> lessons;
}
