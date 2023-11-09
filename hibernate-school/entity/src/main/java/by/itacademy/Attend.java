package by.itacademy;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "attend")
public class Attend extends BaseEntity{
    @Column(name = "visited", nullable = false)
    private boolean visited;
    @OneToMany(mappedBy = "attends")
    private List<Lesson> lessons;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk__attend__student__id")
    )
    private Student student;
}
