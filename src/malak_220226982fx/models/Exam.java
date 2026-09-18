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
import malak_220226982fx.ExamResult;
import java.util.ArrayList;
import java.util.List;



public class Exam {
    
    private int id;
    private String name;
    private int numQuestions;
    private double minPassAverage;
    private ArrayList<Question> questions;
    private List<ExamResult> results;
    private List<Student> students;


    public Exam() {
    }

    
    public Exam(int id, String name, int numQuestions, double minPassAverage) {
        this.id = id;
        this.name = name;
        this.numQuestions = numQuestions;
        this.minPassAverage = minPassAverage;
        this.questions = new ArrayList<>();
        this.results = new ArrayList<>();
        this.students = new ArrayList<>();
    }    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumQuestions() {
        return numQuestions;
    }

    public void setNumQuestions(int numQuestions) {
        this.numQuestions = numQuestions;
    }

    public double getMinPassAverage() {
        return minPassAverage;
    }

    public void setMinPassAverage(double minPassAverage) {
        this.minPassAverage = minPassAverage;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public List<ExamResult> getResults() {
        return results;
    }

    public void setResults(List<ExamResult> results) {
        this.results = results;
    }
    
    
    public void addQuestion(Question question) {
        if (question != null) {
            questions.add(question);
        }
    }
    
    
    @Override
    public String toString() {
        return "Exam:" + "Exam Id = " + id + " name = " + name +" numQuestions = " + numQuestions + " minPassAverage = "+ minPassAverage 
                +"\n questions = " + questions;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    

}
