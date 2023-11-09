package by.itacademy;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {
    @Column(name = "start_date", nullable = false)
    private OffsetDateTime startDate;
    @Column(name = "endDate", nullable = false)
    public OffsetDateTime endDate;
    @ManyToMany(mappedBy = "schedules")
    private List<Lesson> lessons;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "school_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk__schedule__school__id")
    )
    private School school;
    @ManyToMany(mappedBy = "schedules")
    private List<Group> groups;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "schedule_group_room",
            joinColumns = @JoinColumn(
                    name = "group_room_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__schedule_group_room__group_room__id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "schedule_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk__schedule_group_room__schedule__id")
            )
    )
    private List<GroupRoom> groupRooms;
}
