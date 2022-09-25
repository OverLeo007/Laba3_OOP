package com.lab3;

import java.util.Objects;

public class Employee extends Person {

  private int lengthOfWork;
  private String jobTitle;

  public Employee(int yearsOld, String name, int lengthOfWork, String jobTitle) {
    super(yearsOld, name);
    if (lengthOfWork > 0 & lengthOfWork < yearsOld & jobTitle != null) {
      this.lengthOfWork = lengthOfWork;
      this.jobTitle = jobTitle;
    }
  }

  public Employee() {
    super();
    this.lengthOfWork = -1;
    this.jobTitle = "Unknown";
  }

  public Employee(Person person) {
    super(person.getYearsOld(), person.getName());
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public int getLengthOfWork() {
    return lengthOfWork;
  }

  public boolean setJobTitle(String jobTitle) {
    if (jobTitle != null){
      this.jobTitle = jobTitle;
      return true;
    }
    return false;
  }

  public boolean setLengthOfWork(int lengthOfWork) {
    if (lengthOfWork > 0 & lengthOfWork < super.getYearsOld()){
      this.lengthOfWork = lengthOfWork;
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return String.format("""
            Сотрудник %s
            %d лет
            Должность: %s
            %d лет стажа
            ************************""",
        super.getName(),
        super.getYearsOld(),
        this.getJobTitle(),
        this.getLengthOfWork());
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
    Employee employee = (Employee) o;
    return this.getLengthOfWork() == employee.getLengthOfWork()
        && this.getJobTitle().equals(employee.getJobTitle());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.jobTitle, this.lengthOfWork);
  }


}
