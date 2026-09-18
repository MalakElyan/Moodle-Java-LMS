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
public class FillTheBlankQuestion extends Question {
   
  private String answer;
  
    public FillTheBlankQuestion( int id, String questionText,String answer, double marks) {
        super(id, questionText, marks);
        this.answer = answer;
    }

    public FillTheBlankQuestion(int id, String questionText, double marks) {
        super(id, questionText, marks);
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString (){
      return "#"+getId()+"-"+getQuestionText()+" \tMarks("+getMarks()+") Answer: "+answer;        
    }
    
}
