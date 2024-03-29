package Model;

import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Domen.Student;

public class ModelClass implements iGetModel {
    private List<Student> students;

    public ModelClass(List<Student> students) {
        this.students = students;
    }

    public List<Student> getAllStudent() {
        return students;
    }

    @Override
    public boolean delStudent(Integer idStudent) {
        for(int i=0;i<students.size();i++){
            Student student=students.get(i);
            if (student.getId()==idStudent) {
                students.remove(i);
                return true;
            }
        }
        return false;
        
    }

    @Override
    public boolean isStudentExist(Integer idStudent) {
        for (Student student : students) {
            if (student.getId() == idStudent) {
                return true;
            }
        }
        return false;
    }

    }

    

