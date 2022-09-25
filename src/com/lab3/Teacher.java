package com.lab3;

import java.util.Objects;

/**
 * Класс преподавателя
 */
public class Teacher extends Person {

  /**
   * Количество групп у преподавателя
   */
  private int groupCount;
  /**
   * Кафедра преподавателя
   */
  private String department;

  /**
   * Конструктор Teacher с параметрами
   *
   * @param name       имя преподавателя
   * @param yearsOld   возраст преподавателя
   * @param department кафедра преподавателя
   * @param groupCount количество групп у преподавателя
   */
  public Teacher(int yearsOld, String name, int groupCount, String department) {
    super(yearsOld, name);
    if (groupCount > 0 & department != null) {
      this.department = department;
      this.groupCount = groupCount;
    }
  }

  /**
   * Конструктор Teacher без параметров
   */
  public Teacher() {
    super();
    this.groupCount = -1;
    this.department = "Unknown";
  }

  /**
   * Конструктор Teacher от Person
   *
   * @param person исходный человек с заполненными полями
   */
  public Teacher(Person person) {
    super(person.getYearsOld(), person.getName());
  }

  /**
   * Геттер кафедры преподавателя
   *
   * @return кафедра преподавателя
   */
  public String getDepartment() {
    return department;
  }

  /**
   * Геттер количества групп у преподавателя
   *
   * @return количество групп у преподавателя
   */
  public int getGroupCount() {
    return groupCount;
  }

  /**
   * Сеттер кафедры преподавателя
   *
   * @param department кафедра преподавателя
   * @return true при корректной кафедре false при некорректной
   */
  public boolean setDepartment(String department) {
    if (department != null) {
      this.department = department;
      return true;
    }
    return false;
  }

  /**
   * Сеттер количества групп у преподавателя
   *
   * @param groupCount количество групп у преподавателя
   * @return true при корректном количестве false при некорректном
   */
  public boolean setGroupCount(int groupCount) {
    if (groupCount > 0) {
      this.groupCount = groupCount;
      return true;
    }
    return false;
  }

  /**
   * Метод строкового представления Teacher
   */
  @Override
  public String toString() {
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

  /**
   * Метод сравнения Teacher с Object
   */
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

  /**
   * Метод получения хэш-кода объекта
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.department, this.groupCount);
  }
}