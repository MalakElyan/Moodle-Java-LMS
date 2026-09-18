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
import java.util.List;




public class Student extends User {
    
    private int universityId;
    private int grades;
    private List<ExamResult> results;
    
    public Student(int universityId,String username, String password, String name, String gender, String birthdate) {
        super(username, password, name, gender, birthdate);
        this.universityId = universityId;
    }

    public Student(int grades) {
        this.grades = grades;
    }
    
    
    
    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }
    
     public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }
    
    public List<ExamResult> getResults() {
        return results;
    }

    public void addResult(ExamResult result) {
        results.add(result);
    }

    @Override
    public String toString(){
     return "#"+getUsername()+ " "+getPassword()+" "+getName()+" "+getUniversityId()+
             " "+getBirthdate()+ " " +getGender();
             
   
    }

}
