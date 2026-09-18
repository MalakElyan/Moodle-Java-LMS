package malak_220226982fx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import malak_220226982fx.Question;

/**
 *
 * @author NEW
 */
public class YesNoQuestion extends Question {
    
    private boolean answer;
    private boolean studentAnswer;

    public YesNoQuestion( int id, String questionText,boolean answer, double marks) {
        super(id, questionText, marks);
        this.answer = answer;
    }

    public YesNoQuestion(int id, String questionText, double marks) {
        super(id, questionText, marks);
    }

    
    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    @Override
    public String toString (){
      return "#"+getId()+"-"+getQuestionText()+" \tMarks("+getMarks()+") Answer: "+answer;        
    }

    public boolean getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(boolean studentAnswer) {
        this.studentAnswer = studentAnswer;
    }
   
    
    
    
    
}
