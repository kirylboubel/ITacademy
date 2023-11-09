package by.itacademy;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "group")
public class Group extends BaseEntity {
    @Column(name = "name", nullable = false, length = 10)
    private String name;
    @OneToMany(mappedBy = "group")
    private List<Student> students;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "group_assessment",
            joinColumns = @JoinColumn(
                    name = "assessment_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__group_assessment__assessment__id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "group_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__group_assessment__group__id")
            )
    )
    private List<Assessment> assessments;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "group_teacher",
            joinColumns = @JoinColumn(
                    name = "teacher_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__group_teacher__teacher__id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "group_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__group_teacher__group__id")
            )
    )
    private List<Teacher> teachers;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "group_parent",
            joinColumns = @JoinColumn(
                    name = "parent_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__group_parent__parent__id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "group_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__group_parent__group__id")
            )
    )
    private List<Parent> parents;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "group_subject",
            joinColumns = @JoinColumn(
                    name = "subject_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__group_subject__subject__id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "group_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__group_subject__group__id")
            )
    )
    private List<Subject> subjects;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "group_group_room",
            joinColumns = @JoinColumn(
                    name = "group_room_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__group_group_room__group_room__id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "group_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__group_group_room__group__id")
            )
    )
    private List<GroupRoom> groupRooms;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "group_schedule",
            joinColumns = @JoinColumn(
                    name = "schedule_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__group_schedule__schedule__id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "group_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__group_schedule__group__id")
            )
    )
    private List <Schedule> schedules;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "school_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk__group__school__id")
    )
    private School school;
    @ManyToMany(mappedBy = "groups")
    private List<Lesson> lessons;
}
