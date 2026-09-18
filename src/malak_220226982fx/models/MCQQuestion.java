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
import java.util.ArrayList;
import java.util.List;


public class MCQQuestion extends Question {
    
    private List <String> choices;
    private int answer;
     

    public MCQQuestion( int id, String questionText,int answer, double marks) {
        super(id, questionText, marks);
        this.choices = new ArrayList<>();
        this.answer = answer;
    }
    
    public MCQQuestion(int id, String questionText, double marks) {
        super(id, questionText, marks);
        this.choices = new ArrayList<>();
        
    }

    public List <String> getChoices() {
        return choices;
    }

    public void setChoices(List <String> choices) {
        this.choices = choices;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public void addChoice(String choice) {
        choices.add(choice);
    }
   
    
    
    @Override
    public String toString (){
      return "#"+getId()+"-"+getQuestionText()+" \tmark("+getMarks()+")\n"+getChoices()+" Correct answer: "+
              answer;        
    }
}
