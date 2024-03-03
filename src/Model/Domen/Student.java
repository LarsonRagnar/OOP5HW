package Model.Domen;

public class Student extends Person implements Comparable<Student> {
    private int id;
    private static int idGenerator;
    
    public Student(String name, int age) {
        super(name, age);
        idGenerator++;
        this.id=idGenerator;
    }


    public int getId() {
        return id;
    }
    @Override
    public String toString(){
        return "Student{" + "id="+ id +" name=" + super.getName() + " age=" + super.getAge() + "}";
    }

/**
 * @apiNote переопределение Метода сортировки по возрасту и по ID
 * @param o ткущий студент
 * @return
 */
    @Override
    public int compareTo(Student o) {
        System.out.println(this.getName() + " - " + o.getName());
        if (this.getAge()>o.getAge()) return 1;
        if (this.getAge()<o.getAge()) return -1;
        if (this.getId()<o.getId()) return -1;
        if (this.getId()>o.getId()) return 1;

        return 0;

    }


}
