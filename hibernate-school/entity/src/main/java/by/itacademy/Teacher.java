package by.itacademy;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher extends BasePersonEntity {
    @ManyToMany(mappedBy = "teachers")
    private List<Subject> subjects;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "teacher_assessment",
            joinColumns = @JoinColumn(
                    name = "assessment_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__teacher_assessment__assessment__id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "teacher_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__teacher_assessment__teacher__id")
            )
    )
    private List<Assessment> assessments;
    @ManyToMany(mappedBy = "teachers")
    private List<Lesson> lessons;
    @ManyToMany(mappedBy = "teachers")
    private List<Group> groups;
    @ManyToMany(mappedBy = "teachers")
    private List<School> schools;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "group_room_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk__teacher__group_room__id")
    )
    private GroupRoom groupRoom;
}
