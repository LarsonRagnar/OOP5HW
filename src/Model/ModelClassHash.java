package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Domen.Student;

public class ModelClassHash implements iGetModel {
    private HashMap<Integer,Student> studentHashMap;
/**
 * @apiNote МЕтод преоразования в hashMap
 * @param studentHashMap
 */
    public ModelClassHash(List<Student> studentHashMap) {
        this.studentHashMap = new HashMap<>();
        for (Student student : studentHashMap) {
            this.studentHashMap.put(student.getId(),student);
        }
    }

    @Override
    public List<Student> getAllStudent() {
        return new ArrayList<>(studentHashMap.values());

    }
    @Override
    public boolean delStudent(Integer idStudent) {
        if (!isStudentExist(idStudent)) {
            return false;
        }
        studentHashMap.remove(idStudent);
        return true;
    }
    @Override
    public boolean isStudentExist(Integer idStudent) {
        return studentHashMap.containsKey(idStudent);
    }

    @Override
    public String toString() {
        return "ModelClassHash studentHashMap=" + studentHashMap ;
    }


    
}
