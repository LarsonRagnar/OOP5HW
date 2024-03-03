package View;

import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.iGetView;
import Model.Domen.Student;
/**
 * @apiNote Вариант класса на English 
 */
public class ViewClassEng implements iGetView {
    public void printAllStudent(List<Student> students){
        System.out.println("---------------List Student-----------");
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

