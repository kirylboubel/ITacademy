package by.itacademy;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "group_room")
public class GroupRoom extends BaseEntity {
    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "student_group_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk__group_room__student_group__id")
    )
    private StudentGroup studentGroup;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "room_owner_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk__group_room__teacher__id")
    )
    private Teacher roomOwner;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "school_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk__group_room__school__id")
    )
    private School school;

    @OneToMany(mappedBy = "groupRoom")
    private List<Lesson> lessons;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(final StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public Teacher getRoomOwner() {
        return roomOwner;
    }

    public void setRoomOwner(final Teacher roomOwner) {
        this.roomOwner = roomOwner;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(final School school) {
        this.school = school;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(final List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
