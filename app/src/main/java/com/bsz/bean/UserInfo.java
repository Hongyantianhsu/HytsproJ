package com.bsz.bean;

/**
 * Created by sunyan on 16/11/29.
 */
public class UserInfo {
    private String name;
    private int age;
    private String[] course;//课程

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getCourse() {
        return course;
    }

    public void setCourse(String[] course) {
        this.course = course;
    }
}
