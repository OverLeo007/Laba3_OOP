package com.lab3;

import java.util.Objects;

public class Student extends Person {

  private int course;
  private String faculty;

  public Student(int years_old, String name, int course, String faculty) {
    super(years_old, name);
    if (course > 0 & course <= 5 & faculty != null) {
      this.course = course;
      this.faculty = faculty;
    }
  }

  public Student(Person person) {
    super(person.getYearsOld(), person.getName());
  }

  public Student() {
    super();
    this.course = -1;
    this.faculty = "Unknown";
  }

  public String getFaculty() {
    return faculty;
  }

  public int getCourse() {
    return course;
  }

  public boolean setFaculty(String faculty) {
    if (faculty != null) {
      this.faculty = faculty;
      return true;
    }
    return false;
  }

  public boolean setCourse(int course) {
    if (course > 0 & course <= 5) {
      this.course = course;
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return String.format("""
            Студент %s
            %d лет
            Факультет: %s
            %d курс обучения
            ************************""",
        super.getName(),
        super.getYearsOld(),
        this.getFaculty(),
        this.getCourse());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Student student = (Student) o;
    return this.getCourse() == student.getCourse() && this.getFaculty().equals(student.getFaculty());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.faculty, this.course);
  }

}
