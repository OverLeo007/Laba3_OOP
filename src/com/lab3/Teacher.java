package com.lab3;

import java.util.Objects;

public class Teacher extends Person{

  private int groupCount;
  private String department;

  public Teacher(int years_old, String name, int groupCount, String department) {
    super(years_old, name);
    if (groupCount > 0 & department != null){
      this.department = department;
      this.groupCount = groupCount;
    }
  }

  public Teacher(){
    super();
    this.groupCount = -1;
    this.department = "Unknown";
  }

  public Teacher(Person person) {
    super(person.getYearsOld(), person.getName());
  }

  public String getDepartment() {
    return department;
  }

  public int getGroupCount() {
    return groupCount;
  }

  public boolean setDepartment(String department) {
    if (department != null){
      this.department = department;
      return true;
    }
    return false;
  }

  public boolean setGroupCount(int groupCount) {
    if (groupCount > 0){
      this.groupCount = groupCount;
      return true;
    }
    return false;
  }

  @Override
  public String toString(){
    return String.format("""
            Преподаватель %s
            %d лет
            Кафедра: %s
            %d групп обучает
            ************************""",
        super.getName(),
        super.getYearsOld(),
        this.getDepartment(),
        this.getGroupCount());
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
    Teacher teacher = (Teacher) o;
    return this.getGroupCount() == teacher.getGroupCount()
        && this.getDepartment().equals(teacher.getDepartment());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.department, this.groupCount);
  }
}
