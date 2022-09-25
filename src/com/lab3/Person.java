package com.lab3;

import java.util.Objects;

/**
 * Класс человека
 */
public class Person {


  /**
   * Сколько человеку лет
   */
  private int yearsOld;
  /**
   * Имя человека
   */
  private String name;


  /**
   * Конструктор Person с параметрами
   *
   * @param name     имя человека
   * @param yearsOld возраст человека
   */
  public Person(int yearsOld, String name) {
    if (yearsOld >= 0 & yearsOld < 150 & name != null) {
      this.yearsOld = yearsOld;
      this.name = name;
    }
  }

  /**
   * Конструктор Person без параметров
   */
  public Person() {
    this.yearsOld = -1;
    this.name = "Unnamed";
  }

  /**
   * Геттер имени человека
   *
   * @return Имя человека
   */
  public String getName() {
    return name;
  }

  /**
   * Геттер возраста человека
   *
   * @return возраст человека
   */
  public int getYearsOld() {
    return yearsOld;
  }

  /**
   * Сеттер имени человека
   *
   * @param name имя человека
   * @return true при корректном имени false при некорректном
   */
  public boolean setName(String name) {
    if (name != null) {
      this.name = name;
      return true;
    }
    return false;

  }

  /**
   * Сеттер возраста человека
   *
   * @param years_old возраст человека
   * @return true при корректном возрасте false при некорректном
   */
  public boolean setYearsOld(int years_old) {
    if (years_old >= 0 & years_old < 150) {
      this.yearsOld = years_old;
      return true;
    }
    return false;
  }


  /**
   * Метод строкового представления Person
   */
  @Override
  public String toString() {
    return String.format("""
        Человек %s
        %d лет
        ************************""", this.name, this.yearsOld);
  }

  /**
   * Метод сравнения Person с Object
   */
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

  /**
   * Метод получения хэш-кода объекта
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, yearsOld);
  }
}