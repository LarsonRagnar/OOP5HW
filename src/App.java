import java.util.ArrayList;
import java.util.List;
import Controller.ControllerClass;
import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.FileModelClass;
import Model.ModelClass;
import Model.ModelClassHash;
import Model.Domen.Student;
import View.ViewClass;
import View.ViewClassEng;

public class App {
    public static void main(String[] args) throws Exception {
        List<Student> students =new ArrayList<>();
        Student student1= new Student("Ivan", 20);
        Student student2= new Student("Misha", 32);
        Student student3= new Student("Raya", 44);
        Student student4= new Student("leha", 18);
        Student student5= new Student("sasha", 21);
        Student student6= new Student("anna", 21);
        Student student7= new Student("dasha", 21);
        students.add(student7);
        students.add(student6);
        students.add(student5);
        students.add(student4);
        students.add(student3);
        students.add(student2);
        students.add(student1);

        FileModelClass fmClass=new FileModelClass("StudentDB.csv");
        fmClass.saveAllStudentToFile(students);
        iGetView view =new ViewClassEng();
        iGetModel model=new ModelClass(students);
        ControllerClass controller=new ControllerClass(fmClass, view);
        controller.update();
        iGetModel hashModel = new ModelClassHash(new ArrayList<>(students));
        System.out.println(hashModel);

        // controller.run();

    }
}
