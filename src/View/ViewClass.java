package View;

import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.iGetView;
import Model.Domen.Student;

public class ViewClass implements iGetView {
    public void printAllStudent(List<Student> students){
        System.out.println("---------------Список Студентов-----------");
        for(Student s:students){
            System.out.println(s);
        }
        System.out.println("----------------------------------");

    }
    public String prompt(String msg){
        Scanner in =new Scanner(System.in);
        System.out.println(msg);
        return in.nextLine();
    }
}
