package com.allstate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "registrations")
@Data
public class Registration {
    private int id;
    private int version;
    private Date created;
    private Date modified;
    // associations ***
    private Student student;
    private Klass klass;

    public Registration() {
    }

    public Registration(Student student, Klass klass) {
        this.student = student;
        this.klass = klass;
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

    // --------------------------------------------------------------------- //
    // --------------------------------------------------------------------- //
    // --------------------------------------------------------------------- //

    @ManyToOne
    @JoinColumn(name="student_id")
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne
    @JoinColumn(name="klass_id")
    public Klass getKlass() {
        return klass;
    }
    public void setKlass(Klass klass) {
        this.klass = klass;
    }
}
