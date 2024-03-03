package Controller.Interfaces;

import java.util.List;

import Model.Domen.Student;

public interface iGetModel {
    public List<Student> getAllStudent();
    public boolean delStudent(Integer idStudent);
    public boolean isStudentExist(Integer idStudent);
    
}
