package com.allstate.entities;

import com.allstate.enums.Department;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "klasses")
@Data
public class Klass {
    private int id;
    private int version;
    private String name;
    private Date semester;
    private int credits;
    private Department department;
    private double fee;
    private Date created;
    private Date modified;
    private Teacher teacher;
    private List<Grade> grades;
    private List<Student> students;

    public Klass() {
    }

    public Klass(String name, Date semester, int credits, Department department, double fee) {
        this.name = name;
        this.semester = semester;
        this.credits = credits;
        this.department = department;
        this.fee = fee;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @Size(min = 1)
    @NotNull
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public Date getSemester() {
        return semester;
    }
    public void setSemester(Date semester) {
        this.semester = semester;
    }

    @Min(value = 0)
    @NotNull
    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Column(columnDefinition = "ENUM('SCIENCE', 'ENGINEERING', 'LITERATURE', 'PHILOSOPHY')")
    @Enumerated(EnumType.STRING)
    @NotNull
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    @DecimalMin(value = "0")
    @NotNull
    public double getFee() {
        return fee;
    }
    public void setFee(double fee) {
        this.fee = fee;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }

    @ManyToOne
    @JoinColumn(name="teacher_id")
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @OneToMany(mappedBy = "klass")
    @JsonIgnore
    public List<Grade> getGrades() {
        return grades;
    }
    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    @ManyToMany(mappedBy="klasses")
    @JsonIgnore
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
