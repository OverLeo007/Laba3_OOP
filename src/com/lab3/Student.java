package com.lab3;

import java.util.Objects;

/**
 * Класс студента
 */
public class Student extends Person {

  /**
   * Номер курса студента
   */
  private int course;
  /**
   * Факультет студента
   */
  private String faculty;

  /**
   * Конструктор Student с параметрами
   *
   * @param years_old возраст студента
   * @param name имя студента
   * @param course номер курса студента
   * @param faculty факультет студента
   */
  public Student(int years_old, String name, int course, String faculty) {
    super(years_old, name);
    if (course > 0 & course <= 5 & faculty != null) {
      this.course = course;
      this.faculty = faculty;
    }
  }

  /**
   * Конструктор Student от Person
   * @param person исходный человек с заполненными полями
   */
  public Student(Person person) {
    super(person.getYearsOld(), person.getName());
  }

  /**
   * Конструктор Student без параметров
   */
  public Student() {
    super();
    this.course = -1;
    this.faculty = "Unknown";
  }

  /**
   * Геттер факультета студента
   *
   * @return факультет студента
   */
  public String getFaculty() {
    return faculty;
  }

  /**
   * Геттер номера курса студента
   *
   * @return номер курса студента
   */
  public int getCourse() {
    return course;
  }

  /**
   * Сеттер факультета студента
   *
   * @param faculty факультет студента
   * @return true при корректном факультете false при некорректном
   */
  public boolean setFaculty(String faculty) {
    if (faculty != null) {
      this.faculty = faculty;
      return true;
    }
    return false;
  }

  /**
   * Сеттер номера курса студента
   *
   * @param course номер курса студента
   * @return true при корректном номере false при некорректном
   */
  public boolean setCourse(int course) {
    if (course > 0 & course <= 5) {
      this.course = course;
      return true;
    }
    return false;
  }

  /**
   * Метод строкового представления Student
   */
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

  /**
   * Метод сравнения Employee с Student
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
    Student student = (Student) o;
    return this.getCourse() == student.getCourse() && this.getFaculty()
        .equals(student.getFaculty());
  }

  /**
   * Метод получения хэш-кода объекта
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.faculty, this.course);
  }
}