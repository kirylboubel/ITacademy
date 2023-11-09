package by.itacademy;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "lesson")
public class Lesson extends BaseEntity {

    @Column(name = "name", nullable = false, length = 20)
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "lesson_teacher",
            joinColumns = @JoinColumn(
                    name = "teacher_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__lesson_teacher__teacher__id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "lesson_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__lesson_teacher__lesson__id")
            )
    )
    private List <Teacher> teachers;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "lesson_group",
            joinColumns = @JoinColumn(
                    name = "group_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__lesson_group__group__id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "lesson_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__lesson_group__lesson__id")
            )
    )
    private List<Group> groups;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "lesson_subject",
            joinColumns = @JoinColumn(
                    name = "subject_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__lesson_subject__subject__id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "lesson_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__lesson_subject__lesson__id")
            )
    )
    private List<Subject> subjects;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "group_room_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk__lesson__group_room__id")
    )
    private GroupRoom groupRoom;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "lesson_schedule",
            joinColumns = @JoinColumn(
                    name = "schedule_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__lesson_schedule__schedule__id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "lesson_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__lesson_schedule__lesson__id")
            )
    )
    private List <Schedule> schedules;
    @OneToMany(mappedBy = "lesson")
    private List<Assessment> assessments;
    @OneToMany(mappedBy = "lessons")
    private List<Attend> attends;
    @ManyToMany(mappedBy = "lessons")
    private List<Student> students;

}
