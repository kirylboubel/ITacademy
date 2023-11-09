package by.itacademy;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "group_room")
public class GroupRoom extends BaseEntity{
    @Column(name = "name", nullable = false, length = 10)
    private String name;
    @ManyToMany(mappedBy = "groupRooms")
    private List<Group> groups;
    @OneToMany(mappedBy = "groupRoom")
    private List <Teacher> teachers;
    @ManyToMany(mappedBy = "groupRooms")
    private List<Schedule> scheduleList;
    @OneToMany(mappedBy = "groupRoom")
    private List<Lesson> lessons;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "school_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk__group_room__school__id")
    )
    private School school;
}
