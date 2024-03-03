package Controller.Interfaces;

import java.util.List;

import Model.Domen.Student;

public interface iGetView {
   public void printAllStudent(List<Student> getStudents);
   public String prompt(String msg);
}
