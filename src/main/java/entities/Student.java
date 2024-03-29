package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name = "Student.deleteAllRows", query = "DELETE from Student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String studentID;
    private String color;

    public Student(String name, String studentID, String color) {
        this.name = name;
        this.studentID = studentID;
        this.color = color;
    }
    
    public Student() {
    }

    public String getName() {
        return name;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getColor() {
        return color;
    }
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}