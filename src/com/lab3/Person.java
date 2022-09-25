package com.lab3;

import java.util.Objects;

public class Person {

  private int yearsOld;
  private String name;

  public String getName() {
    return name;
  }

  public int getYearsOld() {
    return yearsOld;
  }

  public boolean setName(String name) {
    if (name != null) {
      this.name = name;
      return true;
    }
    return false;

  }

  public boolean setYearsOld(int years_old) {
    if (years_old >= 0 & years_old < 150) {
      this.yearsOld = years_old;
      return true;
    }
    return false;
  }

  public Person(int yearsOld, String name) {
    if (yearsOld >= 0 & yearsOld < 150 & name != null) {
      this.yearsOld = yearsOld;
      this.name = name;
    }
  }

  public Person() {
    this.yearsOld = -1;
    this.name = "Unnamed";
  }

  @Override
  public String toString() {
    return String.format("""
        Человек %s
        %d лет
        ************************""", this.name, this.yearsOld);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return this.yearsOld == person.yearsOld && this.name.equals(person.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, yearsOld);
  }

}
