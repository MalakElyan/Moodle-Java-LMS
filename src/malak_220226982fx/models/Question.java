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



public class Question {
    
    private int id;
    private String questionText;
    private double marks;
    private ArrayList<String>answerChoices;
    private int correctAnswer;
    
    public Question(int id, String questionText, double marks) {
        this.id = id;
        this.questionText = questionText;
        this.marks = marks;
        
    }

    public Question() {
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
    
     public ArrayList<String> getAnswerChoices() {
        return answerChoices;
    }

    public void setAnswerChoices(ArrayList<String> answerChoices) {
        this.answerChoices = answerChoices;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    
//    public Question getQuestionById(int questionId){
//        for (Question Q : exam_system.getQuestions()){
//        if (Q.getId() == questionId){   
//            return Q;
//        } 
//        }
//          return null;
//        }   
//    
    @Override
    public String toString (){
      return "#"+getId()+"-"+getQuestionText()+" \tMarks("+getMarks()+")";        
    }

}
