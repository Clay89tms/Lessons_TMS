package org.example.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.Position;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "keyTeacher")
    private String keyRandomTeacher;

    @Column(name = "teacher_name")
    private String name;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "man")
    private Boolean isMan;

    @Column(name = "position")
    private Position position;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "computer", column = @Column(name = "p_comp"))
//            ,
//            @AttributeOverride(name = "address.street", column = @Column(name = "address.st."))
    })
    private Property property;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;
}
