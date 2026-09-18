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
public class Studentanswers {
    
     private int id;
     private int universityId;
    private int questionId;
     private boolean answerb;
     private int answeri;
     private String answers;

    public Studentanswers(int id, int universityId, boolean answerb) {
        this(id, universityId, 0, answerb);
    }

    public Studentanswers(int id, int universityId, int questionId, boolean answerb) {
        this.id = id;
        this.universityId = universityId;
        this.questionId = questionId;
        this.answerb = answerb;
    }

    public Studentanswers(int id, int universityId, int answeri) {
        this(id, universityId, 0, answeri);
    }

    public Studentanswers(int id, int universityId, int questionId, int answeri) {
        this.id = id;
        this.universityId = universityId;
        this.questionId = questionId;
        this.answeri = answeri;
    }

    public Studentanswers(int id, int universityId, String answers) {
        this(id, universityId, 0, answers);
    }

    public Studentanswers(int id, int universityId, int questionId, String answers) {
        this.id = id;
        this.universityId = universityId;
        this.questionId = questionId;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public boolean isAnswerb() {
        return answerb;
    }

    public void setAnswerb(boolean answerb) {
        this.answerb = answerb;
    }

    public int getAnsweri() {
        return answeri;
    }

    public void setAnsweri(int answeri) {
        this.answeri = answeri;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }
     
     
    
}

