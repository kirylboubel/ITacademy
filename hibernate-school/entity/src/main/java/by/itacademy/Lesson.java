package by.itacademy;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "lesson")
public class Lesson extends BaseEntity {

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk__lesson__teacher__id")
    )
    private Teacher teacher;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "student_group_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk__lesson__student_group__id")
    )
    private StudentGroup studentGroup;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "subject_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk__lesson__subject__id")
    )
    private Subject subject;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "group_room_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk__lesson__group_room__id")
    )
    private GroupRoom groupRoom;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "schedule_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk__lesson__schedule__id")
    )
    private Schedule schedule;

    @OneToMany(mappedBy = "lesson")
    private List<Assessment> assessments;

    @OneToMany(mappedBy = "lesson")
    private List<Attend> attends;

    public Lesson() {
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(final Teacher teacher) {
        this.teacher = teacher;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(final StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(final Subject subject) {
        this.subject = subject;
    }

    public GroupRoom getGroupRoom() {
        return groupRoom;
    }

    public void setGroupRoom(final GroupRoom groupRoom) {
        this.groupRoom = groupRoom;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(final Schedule schedule) {
        this.schedule = schedule;
    }

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(final List<Assessment> assessments) {
        this.assessments = assessments;
    }

    public List<Attend> getAttends() {
        return attends;
    }

    public void setAttends(final List<Attend> attends) {
        this.attends = attends;
    }
}
