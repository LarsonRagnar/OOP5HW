package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Domen.Student;

public class FileModelClass implements iGetModel {
    private String fileName;
    public FileModelClass(String fileName){
        this.fileName=fileName;
        try(FileWriter fw =new FileWriter(fileName,true))
        {
            fw.flush();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void saveAllStudentToFile(List<Student> students)
    {
        try(FileWriter fw = new FileWriter(fileName, true))
        {
            for(Student pers : students)
            {
                fw.write(pers.getName()+";"+pers.getAge()+";"+pers.getId());
                fw.append('\n');
            }
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    @Override
    public List<Student> getAllStudent() {
        List<Student> students =new ArrayList<Student>();
        try
        {
            File file =new File(fileName);
            FileReader fr=new FileReader(file);
            BufferedReader reader=new BufferedReader(fr);
            String line=reader.readLine();
            while (line!=null) {
                String[] param=line.split(";");
                Student pers=new Student(param[0], Integer.parseInt(param[1]));
                students.add(pers);
                line=reader.readLine();
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return students;
    }
    /**
     * @apiNote удаление студента
     */
    @Override
    public boolean delStudent(Integer idStudent) {
        List<Student> students=getAllStudent();
        boolean studentIsExist=false;
        for (int i = 0; i < students.size(); i++) {
            Student student=students.get(i);
            if (student.getId()==idStudent) {
                studentIsExist=true;
                students.remove(i);
                break;
            }
        }if (studentIsExist) {
            saveAllStudentToFile(students);
            
        }
        return studentIsExist;
    }
    @Override
    public boolean isStudentExist(Integer idStudent) {
        List<Student> students = getAllStudent();
        for (Student student : students) {
            if (student.getId() == idStudent) {
                return true;
            }
        }
        return false;
    }

    }



