package Controller;

import java.util.ArrayList;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;

import Model.Domen.Student;

public class ControllerClass {

    private iGetModel model;
    private iGetView view;
    private List<Student> bufferStudentList=new ArrayList<Student>();
    public ControllerClass(iGetModel model, iGetView view) {
        this.model = model;
        this.view = view;
    }
    private boolean testData(List<Student> students){
        if (students.size()>0) {
            return true;
            
        }else{
            return false;
        }
    }

    public void update(){
        //MVC
        // view.printAllStudent(model.getStudents());


        //MVP
        bufferStudentList=model.getAllStudent();
        if (testData(bufferStudentList)) {
            view.printAllStudent(bufferStudentList);
        }else{
            System.out.println("--------список студентов пуст-------");
        }


    }
    public void run(){
        Command com= Command.NONE;
        boolean getNewIteration= true;
        while (getNewIteration) {
            String command=view.prompt("Введите команду: ");
            com=Command.valueOf(command.toUpperCase());
            switch (com) {
                case EXIT:
                    getNewIteration=false;
                    System.out.println("Выход из программы");
                    break;
                case LIST:
                    view.printAllStudent(model.getAllStudent());
                    break;
                case DELETE:
                    operationDelete();
                    break;

                


            
            }
        }

    }
    private void operationDelete() {
        Integer idStudent = Integer.parseInt(
                view.prompt("Введите id студента для удаления: "));
        boolean isDeleted = false;
        if (isDeleted) {
            System.out.println("Студент ID=" + idStudent + " успешно удалён.");
        } else {
            System.out.println("Студент ID=" + idStudent + " такая запись не найдена.");
        }
    }


}
