package com.allstate.dtos;

import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;

import java.util.List;

public class EnrollDto {
    public List<String> emails;
    public Teacher teacher;
    public Klass klass;
}
