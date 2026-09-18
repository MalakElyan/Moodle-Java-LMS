/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malak_220226982fx;

/**
 *
 * @author NEW
 */
import java.util.ArrayList;
import java.util.List;



public class Admin extends User {
    
    private List<Teacher> teachers;
    private List<Student> students;

    public Admin(List<Teacher> teachers, List<Student> students, String username, String password, String name, String gender, String birthdate) {
        super(username, password, name, gender, birthdate);
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

   public void addTeacher(Teacher teacher){
        this.teachers.add(teacher);
    }
    
    public void addStudent (Student student){
        this.students.add(student);
    }
    
    public List <Teacher> viewAllteachers (){
        return teachers;
    }
    
    public List <Student> viewAllstudents (){
        return students;
    }
    
}
