package by.itacademy;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "school")
public class School extends BaseEntity {
    @Column(name = "name", length = 250, nullable = false)
    private String name;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "address_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk__school__address__id")
    )
    private Address address;
    @OneToMany(mappedBy = "school")
    private List<Group> groups;
    @OneToMany(mappedBy = "school")
    private List<Schedule> schedules;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "school_teacher",
            joinColumns = @JoinColumn(
                    name = "teacher_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__school_teacher__teacher__id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "school_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__school_teacher__school__id")
            )
    )
    private List<Teacher> teachers;
    @OneToMany(mappedBy = "school")
    private List<GroupRoom> groupRooms;
    @OneToMany(mappedBy = "school")
    private List<Subject> subjects;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "school_student",
            joinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__school_student__student__id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "school_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__school_student__school__id")
            )
    )
    private List<Student> students;
}
