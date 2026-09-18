package malak_220226982fx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author NEW
 */
import java.util.List;


public class Teacher extends User {
    
    private double salary;
    private String Field;
    private List <Student> students;
    private List <Question> questions;
    private List <Exam> exams;
    private List <ExamResult> examsResult;

    public Teacher(double salary, String Field, List<Student> students, List<Question> questions, List<Exam> exams, List<ExamResult> examsResult, String username, String password, String name, String gender, String birthdate) {
        super(username, password, name, gender, birthdate);
        this.salary = salary;
        this.Field = Field;
        this.students = students;
        this.questions = questions;
        this.exams = exams;
        this.examsResult = examsResult;
    }

    public Teacher(double salary, String Field, String username, String password, String name, String gender, String birthdate) {
        super(username, password, name, gender, birthdate);
        this.salary = salary;
        this.Field = Field;
    }
    
    

    

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    
    public String getField() {
        return Field;
    }

    public void setField(String Field) {
        this.Field = Field;
    }

    public List <Student> getStudents() {
        return students;
    }

    public void setStudents(List <Student> students) {
        this.students = students;
    }

    public List <Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List <Question> questions) {
        this.questions = questions;
    }

    public List <Exam> getExams() {
        return exams;
    }

    public void setExams(List <Exam> exams) {
        this.exams = exams;
    }
    
    public List <ExamResult> getExamsResult() {
        return examsResult;
    }

    public void setExamsResult(List <ExamResult> examsResult) {
        this.examsResult = examsResult;
    }
    
    public void addStudent (Student student){
        this.students.add(student);
    }
    
    public List <Student> viewAllstudents(){
        return students;
    }
    
    public void addQuestion (Question qestion){
        this.questions.add(qestion);
    }
    
    public void editQuestion (Question oldQuestion, Question newQuestion){
        int index = questions.indexOf(oldQuestion);
        if (index != -1) {
        questions.set(index, newQuestion);
        }
    }
        
    public List <Question> viewAllquestions(){
        return questions;
    }
    
    public void addExam (Exam exam){
        this.exams.add(exam);
    }
    
    public List <Exam> viewAllexams (){
        return exams;
    }
    
    public void viewExamresuls( Exam exam){
        
      
    }

    @Override
    public String toString (){
      return "#"+getUsername()+ " "+getPassword()+" "+getName()+" "+getBirthdate()+
              " "+getGender()+" "+getSalary()+" "+getField();
              
    }
}
    
 

