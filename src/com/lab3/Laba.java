package com.lab3;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;

public class Laba {

  public static void main(String[] args) {

    UI myUI = new UI();

    myUI.menu();
  }

}

interface menuEnum {

  int ADD_PERSON = 1,
      DELETE_PERSON = 2,
      PRINT_PERSONS = 3,
      COMPARE_PERSONS = 4,
      EXIT = 5;

  int ADD_STUDENT = 2,
      ADD_TEACHER = 3,
      ADD_EMPLOYEE = 4;

}

class UI implements menuEnum {

  /**
   * Поток вывода, поддерживающий русские символы
   */
  private final PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);

  /**
   * Экземпляр класса содержащего методы ввода разных типов
   */
  private final Inputer inp = new Inputer();

  /**
   * Основной список людей
   */
  private final ArrayList<Person> persons = new ArrayList<>();

  public void menu() {

    int choice;

    do {
      this.out.println("""
          1. Добавить человека
          2. Удалить человека
          3. Вывести всех людей
          4. Сравнить двух людей
          5. Выход
          """);

      choice = inp.getInt();
      switch (choice) {
        case ADD_PERSON -> personAdder();
        case DELETE_PERSON -> deletePerson();
        case PRINT_PERSONS -> printPersons();
        case COMPARE_PERSONS -> comparator();
        default -> {
          if (choice != EXIT) {
            this.out.println("Некорректный ввод");
          }
        }
      }

    } while (choice != EXIT);

  }

  private void personAdder() {
    int choice;

    do {
      this.out.println("""
          1. Добавить человека
          2. Добавить студента
          3. Добавить преподавателя
          4. Добавить сотрудника
          5. Выйти в главное меню
          """);

      choice = inp.getInt();
      switch (choice) {
        case ADD_PERSON -> adderHandler(1);
        case ADD_STUDENT -> adderHandler(2);
        case ADD_TEACHER -> adderHandler(3);
        case ADD_EMPLOYEE -> adderHandler(4);
        default -> {
          if (choice != EXIT) {
            this.out.println("Некорректный ввод");
          }
        }
      }

    } while (choice != EXIT);
  }


  private void adderHandler(int human_type) {
    String data_answer = null;

    while (true) {
      out.println("Добавлять с входными данными (y/n)?");
      data_answer = inp.getString();
      if (data_answer == null) {
        continue;
      }
      if (data_answer.equals("y") || data_answer.equals("n")) {
        break;
      }
    }
    Person new_person = new Person();
    if (Objects.equals(data_answer, "y")) {
      boolean isName = false, isYO = false;
      while (!(isName & isYO)) {
        if (!isName) {
          this.out.println("Введите имя человека");
          isName = new_person.setName(this.inp.getString());
          if (!isName) {
            this.out.println("Некорректный ввод");
          }
        }

        if (!isYO) {
          this.out.println("Введите возраст человека");
          isYO = new_person.setYearsOld(this.inp.getInt());
          if (!isYO) {
            this.out.println("Некорректный ввод");
          }
        }
      }
    }

    switch (human_type) {
      case ADD_PERSON -> addPerson(new_person);
      case ADD_STUDENT -> addStudent(new_person);
      case ADD_TEACHER -> addTeacher(new_person);
      case ADD_EMPLOYEE -> addEmployee(new_person);
      default -> this.out.println("???");
    }
  }

  private void addPerson(Person person) {
    this.persons.add(person);
  }

  private void addStudent(Person person) {
    if (person.getYearsOld() == -1) {
      this.persons.add(new Student());
      return;
    }

    Student newStudent = new Student(person);

    boolean isCourse = false, isFaculty = false;

    while (!(isCourse & isFaculty)) {
      if (!isFaculty) {
        this.out.println("Введите факультет студента");
        isFaculty = newStudent.setFaculty(this.inp.getString());
        if (!isFaculty) {
          this.out.println("Некорректный ввод");
        }
      }

      if (!isCourse) {
        this.out.println("Введите курс студента (1-5)");
        isCourse = newStudent.setCourse(this.inp.getInt());
        if (!isCourse) {
          this.out.println("Некорректный ввод");
        }
      }
    }

    this.persons.add(newStudent);
  }

  private void addTeacher(Person person) {
    if (person.getYearsOld() == -1) {
      this.persons.add(new Teacher());
      return;
    }

    Teacher newTeacher = new Teacher(person);

    boolean isGroupCount = false, isDepartment = false;

    while (!(isGroupCount & isDepartment)) {
      if (!isDepartment) {
        this.out.println("Введите кафедру преподавателя");
        isDepartment = newTeacher.setDepartment(this.inp.getString());
        if (!isDepartment) {
          this.out.println("Некорректный ввод");
        }
      }

      if (!isGroupCount) {
        this.out.println("Введите кол-во групп которые ведет преподаватель");
        isGroupCount = newTeacher.setGroupCount(this.inp.getInt());
        if (!isGroupCount) {
          this.out.println("Некорректный ввод");
        }
      }
    }

    this.persons.add(newTeacher);
  }

  private void addEmployee(Person person) {
    if (person.getYearsOld() == -1) {
      this.persons.add(new Teacher());
      return;
    }

    Employee newEmployee = new Employee(person);

    boolean isLengthOfWork = false, isJobTitle = false;

    while (!(isLengthOfWork & isJobTitle)) {
      if (!isJobTitle) {
        this.out.println("Введите должность сотрудника");
        isJobTitle = newEmployee.setJobTitle(this.inp.getString());
        if (!isJobTitle) {
          this.out.println("Некорректный ввод");
        }
      }

      if (!isLengthOfWork) {
        this.out.println("Введите стаж сотрудника");
        isLengthOfWork = newEmployee.setLengthOfWork(this.inp.getInt());
        if (!isLengthOfWork) {
          this.out.println("Некорректный ввод");
        }
      }
    }

    this.persons.add(newEmployee);
  }

  private void deletePerson() {
    out.println("Введите индекс человека в списке:");
    int index = inp.getInt();
    if (index < 1 || index > persons.size()) {
      out.println("Некорректный индекс");
    } else {
      this.out.println(persons.get(index - 1).getName() + " удален из списка");
      persons.remove(index - 1);
    }
  }

  private void printPersons() {
    if (persons.isEmpty()) {
      out.println("Ни одного человека не добавлено");
      return;
    }

    int num = 1;
    for (Person person : persons) {
      out.printf("№%d\n", num++);
      out.println(person);
    }
  }

  private void comparator() {
    int index1 = 1, index2 = 1;
    boolean isIndex1 = false, isIndex2 = false;

    while (!(isIndex1 & isIndex2)) {
      if (!isIndex1) {
        this.out.println("Введите индекс первого человека");
        index1 = inp.getInt();
        if (index1 > 1 || index1 < persons.size()) {
          isIndex1 = true;
        } else {
          out.println("Некорректный индекс");
        }
      }

      if (!isIndex2) {
        this.out.println("Введите индекс второго человека");
        index2 = inp.getInt();
        if (index2 > 1 || index2 < persons.size()) {
          isIndex2 = true;
        } else {
          out.println("Некорректный индекс");
        }
      }
    }
    if (persons.get(index1 - 1).equals(persons.get(index2 - 1))) {
      out.printf("Люди под номером %d и %d индентичны друг другу\n", index1, index2);
    } else {
      out.printf("Люди под номером %d и %d индентичны отличаются друг от друга\n", index1,
          index2);
    }
  }

}
