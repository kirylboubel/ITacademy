package by.itacademy;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher extends BasePersonEntity {
    @ManyToMany(mappedBy = "teachers")
    private List<School> schools;

    @OneToMany(mappedBy = "groupOwner")
    private List<StudentGroup> studentGroups;

    @OneToMany(mappedBy = "teacher")
    private List<StudentGroupSubjectLink> studentGroupSubjectLinks;

    @OneToMany(mappedBy = "roomOwner")
    private List<GroupRoom> groupRooms;

    @OneToMany(mappedBy = "teacher")
    private List<Lesson> lessons;

    public Teacher() {
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(final List<School> schools) {
        this.schools = schools;
    }

    public List<StudentGroup> getStudentGroups() {
        return studentGroups;
    }

    public void setStudentGroups(final List<StudentGroup> studentGroups) {
        this.studentGroups = studentGroups;
    }

    public List<StudentGroupSubjectLink> getStudentGroupSubjectLinks() {
        return studentGroupSubjectLinks;
    }

    public void setStudentGroupSubjectLinks(final List<StudentGroupSubjectLink> studentGroupSubjectLinks) {
        this.studentGroupSubjectLinks = studentGroupSubjectLinks;
    }

    public List<GroupRoom> getGroupRooms() {
        return groupRooms;
    }

    public void setGroupRooms(final List<GroupRoom> groupRooms) {
        this.groupRooms = groupRooms;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(final List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
