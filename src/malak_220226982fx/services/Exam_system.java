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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;



public class Exam_system {

    public static ArrayList<Exam> getExams() {
        return exams;
    }

    public static void setExams(ArrayList<Exam> aExams) {
        exams = aExams;
    }

    private ArrayList<Teacher> teacher;
    private ArrayList<Student> student;
    private static ArrayList<Exam> exams;
    private static ArrayList<Question> questions;
    private ArrayList<YesNoQuestion> yesNoQuestion;
    private ArrayList<MCQQuestion> mCQQuestion;
    private ArrayList<FillTheBlankQuestion> fillTheBlankQuestion;
    private ArrayList<ExamResult> examResult;
    private ArrayList<Studentanswers> studentanswers;

    public Exam_system() {
        teacher = new ArrayList<>();
        student = new ArrayList<>();
        exams = new ArrayList<>();
        questions = new ArrayList<>();
        yesNoQuestion = new ArrayList<>();
        mCQQuestion = new ArrayList<>();
        fillTheBlankQuestion = new ArrayList<>();
        examResult = new ArrayList<>();
        studentanswers=new ArrayList<>();
    }

    public ArrayList<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(ArrayList<Teacher> teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getStudent() {
        return student;
    }

    public void setStudent(ArrayList<Student> student) {
        this.student = student;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        Exam_system.questions = questions;
    }

    public ArrayList<YesNoQuestion> getYesNoQuestion() {
        return yesNoQuestion;
    }

    public void setYesNoQuestion(ArrayList<YesNoQuestion> yesNoQuestion) {
        this.yesNoQuestion = yesNoQuestion;
    }

    public ArrayList<MCQQuestion> getmCQQuestion() {
        return mCQQuestion;
    }

    public void setmCQQuestion(ArrayList<MCQQuestion> mCQQuestion) {
        this.mCQQuestion = mCQQuestion;
    }

    public ArrayList<FillTheBlankQuestion> getFillTheBlankQuestion() {
        return fillTheBlankQuestion;
    }

    public void setFillTheBlankQuestion(ArrayList<FillTheBlankQuestion> fillTheBlankQuestion) {
        this.fillTheBlankQuestion = fillTheBlankQuestion;
    }

    public ArrayList<Exam> getExam() {
        return exams;
    }

    public void setExam(ArrayList<Exam> exams) {
        Exam_system.exams = exams;
    }

    public ArrayList<ExamResult> getExamResult() {
        return examResult;
    }

    public void setExamResult(ArrayList<ExamResult> examResult) {
        this.examResult = examResult;
    }
    
     public ArrayList<Studentanswers> getStudentanswers() {
        return studentanswers;
    }

    public void setStudentanswers(ArrayList<Studentanswers> studentanswers) {
        this.studentanswers = studentanswers;
    }


    private static Exam_system instance;

    public static Exam_system getInstance() {
        if (instance == null) {
            instance = new Exam_system();
        }
        return instance;
    }

    private final String[] admins = {"admin", "admin"};
    private final String[][] students = {{"s1", "123456"}, {"s2", "123456"}, {"s3", "123456"}};
    private final String[][] teachers = {{"JafarAgha", "112233"}, {"MohDalo", "112233"}, {"EtafHadda", "112233"}, {"HashemSaqqa", "112233"}};

    
    public String validateLogin(String username, String password) {
        if (username.equals(admins[0]) && password.equals(admins[1])) {
            return "admin";
        }

        for (String[] studentt : students) {
            if (username.equals(studentt[0]) && password.equals(studentt[1])) {
                return "student";
            }
        }

        for (String[] teacherr : teachers) {
            if (username.equals(teacherr[0]) && password.equals(teacherr[1])) {
                return "teacher";
            }
        }

        for (Student savedStudent : student) {
            if (username.equals(savedStudent.getUsername()) && password.equals(savedStudent.getPassword())) {
                return "student";
            }
        }

        for (Teacher savedTeacher : teacher) {
            if (username.equals(savedTeacher.getUsername()) && password.equals(savedTeacher.getPassword())) {
                return "teacher";
            }
        }

        return "invalid";
    }

    public void addTeacher(Teacher teacher) {
        this.teacher.add(teacher);
    }

    public void addStudent(Student student) {
        this.student.add(student);
    }

    public List<Teacher> viewAllteachers() {
        return teacher;
    }

    public List<Student> viewAllstudents() {
        return student;
    }

    public void createYesNoQuestion(int Id, String Questiontext, boolean Answer, double Marks) {
    YesNoQuestion y = new YesNoQuestion(Id, Questiontext, Answer, Marks);
    addQuestion(y);
    yesNoQuestion.add(y);
    }
    
    public void createFillBlankQuestion(int Id, String Questiontext, String Answer, double Marks) {
    FillTheBlankQuestion f = new FillTheBlankQuestion(Id, Questiontext, Answer, Marks);
    addQuestion(f);
    fillTheBlankQuestion.add(f);   
    }
    
    public void createMCQQuestion(int id, String questionText, int answer, double marks, List<String> choices) {
    MCQQuestion m = new MCQQuestion(id, questionText, answer, marks);
    for (String choice : choices) {
        m.addChoice(choice);
    }
    addQuestion(m);
    mCQQuestion.add(m);
    System.out.println("Answer choices:");
    List<String> questionChoices = m.getChoices();
    for (int i = 0; i < questionChoices.size(); i++) {
    String choice = questionChoices.get(i);
    System.out.print((i + 1) + ". " + choice);
    if (i < questionChoices.size() - 1) {
        System.out.print(", ");
    }
    }
    }
    
    public void addQuestion(Question question) {
        if (question != null) {
            questions.add(question);
            System.out.println("Question added successfully.");
        }
    }

    public List<Question> viewAllQuestions() {
        return questions;
    }

    public void editQuestion(int questionId, String newQuestionText, double newMark, String newAnswer, List<String> newChoices) {
    Question question = getQuestionById(questionId);
    if (question instanceof MCQQuestion) {
    MCQQuestion mcqQuestion = (MCQQuestion) question;
    int answer = Integer.parseInt(newAnswer);
    mcqQuestion.setAnswer(answer);
    mcqQuestion.setChoices(newChoices);
    } else if (question instanceof FillTheBlankQuestion) {
    FillTheBlankQuestion fillQuestion = (FillTheBlankQuestion) question;
    fillQuestion.setAnswer(newAnswer);
} else if (question instanceof YesNoQuestion) {
    YesNoQuestion yesNoQuestion = (YesNoQuestion) question;
    boolean answer = Boolean.parseBoolean(newAnswer);
    yesNoQuestion.setAnswer(answer);
}
    question.setQuestionText(newQuestionText);
    question.setMarks(newMark);
}



    public Question getQuestionById(int questionId) {
        for (Question Q : questions) {
            if (Q.getId() == questionId) {
                return Q;
            }
        }
        return null;
    }

    
    public void addExam(int examId, String examName, int numQuestions, double minPassAverage, HashMap<String, Integer> allowedQuestionTypes) {
    if (questions.size() < numQuestions) {
        System.out.println("There are not enough questions of the selected type to add.");
        return;
    }

    ArrayList<Question> selectedQuestions = new ArrayList<>();
    HashSet<String> selectedQuestionTypes = new HashSet<>();

    HashMap<String, List<Question>> questionsByType = new HashMap<>();
    for (Question q : questions) {
        for (String allowedType : allowedQuestionTypes.keySet()) {
            if ((allowedType.equals("YES_NO") && q instanceof YesNoQuestion)
                    || (allowedType.equals("MCQ") && q instanceof MCQQuestion)
                    || (allowedType.equals("FILL_BLANK") && q instanceof FillTheBlankQuestion)) {
                List<Question> typeQuestions = questionsByType.getOrDefault(allowedType, new ArrayList<>());
                typeQuestions.add(q);
                questionsByType.put(allowedType, typeQuestions);
                break;
            }
        }
    }

    for (String allowedType : allowedQuestionTypes.keySet()) {
        int numQuestionsOfType = allowedQuestionTypes.get(allowedType);
        List<Question> typeQuestions = questionsByType.getOrDefault(allowedType, new ArrayList<>());
        if (typeQuestions.size() >= numQuestionsOfType) {
            Collections.shuffle(typeQuestions);
            selectedQuestions.addAll(typeQuestions.subList(0, numQuestionsOfType));
            selectedQuestionTypes.add(allowedType);
        }
    }

    if (selectedQuestions.size() < numQuestions || selectedQuestionTypes.size() < allowedQuestionTypes.size()) {
        System.out.println("There are not enough questions of the selected type to add.");
    } else {
        Collections.shuffle(selectedQuestions);
        List<Question> examQuestions = new ArrayList<>();
        examQuestions.addAll(selectedQuestions.subList(0, numQuestions));

        Exam e = new Exam(examId, examName, numQuestions, minPassAverage);
        for (Question question : examQuestions) {
            e.addQuestion(question);
        }

        exams.add(e);
        System.out.println("Exam added successfully.");
    }
}
    
        public List<Exam> viewAllExams() {
        return exams;
        }
        
    public String viewAllExamsResultAsString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Exam Results:");
    sb.append("\n");

    for (Exam exam : exams) {
        sb.append("Exam ID: " + exam.getId());
        sb.append("\n");
        sb.append("Exam Name: " + exam.getName());
        sb.append("\n");
        sb.append("Number of Questions: " + exam.getNumQuestions());
        sb.append("\n");

        double minPassAverage = exam.getMinPassAverage();
        sb.append("Minimum Passing Average: " + minPassAverage);
        sb.append("\n");

        sb.append("Students who passed the exam:");
        sb.append("\n");

        for (ExamResult eR : examResult) {
            if (eR.getId() == exam.getId() && eR.getMark() >= minPassAverage) {
                sb.append("Student ID: " + eR.getUniversityId());
                sb.append("\n");
                sb.append("Student Name: " + eR.getUniversityId());
                sb.append("\n");
                sb.append("Student Mark: " + eR.getMark());
                sb.append("\n");
            }
        }
        sb.append("------------------------");
        sb.append("\n");
    }

    return sb.toString();
}

        public void viewAllStudentsExamResults() {
        for (Student student : student) {
        System.out.println("Student ID: " + student.getUniversityId());
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Gender: " + student.getGender());
        System.out.println("Student Birthday: " + student.getBirthdate());
        System.out.println();
        
        boolean hasResults = false;
        for (Exam exam : exams) {
        double minPassAverage = exam.getMinPassAverage();
        for (ExamResult eR : examResult) {
        if (eR.getId() == exam.getId() && eR.getUniversityId() == student.getUniversityId() && eR.getMark() >= minPassAverage) {
        System.out.println("Exam ID: " + exam.getId());
        System.out.println("Exam Name: " + exam.getName());
        System.out.println("Minimum Passing Average: " + minPassAverage);
        System.out.println("Student Mark: " + eR.getMark());
        hasResults = true;
        }
       }
        System.out.println("------------------------");
       }
    if (!hasResults) {
        System.out.println("No exam results found for this student or the student has not passed any exams.");
    }
   }
 }
     
        

        public void exportExamToFile(int examId, String filePath) {
        Exam exam = getExamById(examId);
        if (exam == null) {
        System.out.println("Exam not found!");
        return;
        }

        try (PrintWriter writer = new PrintWriter(filePath)) {
        // Write the exam details to the file
        writer.write("Exam ID: " + exam.getId() + "\n");
        writer.write("Exam Name: " + exam.getName() + "\n");
        writer.write("Number of Questions: " + exam.getNumQuestions() + "\n");
        writer.write("Minimum Passing Average: " + exam.getMinPassAverage() + "\n\n");

        // Write the questions and their details
        for (Question question : exam.getQuestions()) {
        if (question instanceof YesNoQuestion) {
        writer.write("Question Type: Yes_No\n");
        writer.write("Question ID: " + question.getId() + "\n");
        writer.write("Question Text: " + question.getQuestionText() + "\n");
        writer.write("Question Marks: " + question.getMarks() + "\n\n");
        } else if (question instanceof MCQQuestion) {
        writer.write("Question Type: MCQ\n");
        MCQQuestion mcqQuestion = (MCQQuestion) question;
        List<String> choices = mcqQuestion.getChoices();
        writer.println("Question Choices:");
        for (String choice : choices) {
            writer.println(choice);
        }
        writer.write("Question ID: " + question.getId() + "\n");
        writer.write("Question Text: " + question.getQuestionText() + "\n");
        writer.write("Question Marks: " + question.getMarks() + "\n\n");
        } else if (question instanceof FillTheBlankQuestion) {
        writer.write("Question Type: FillBlank\n");
        writer.write("Question ID: " + question.getId() + "\n");
        writer.write("Question Text: " + question.getQuestionText() + "\n");
        writer.write("Question Marks: " + question.getMarks() + "\n\n");
        }
        }
         System.out.println("Exam exported successfully!");
        } catch (IOException e) {
        System.out.println("Error exporting exam to file: " + e.getMessage());
        }
        }
        
        

     public void saveExamQuestionAnswer(int universityId, int examId, int questionId, String answer) {
     Exam exam = getExamById(examId);
     if (exam == null || answer == null) {
        return;
     }
    Question question = getQuestionById(questionId);
    if (question == null) {
        return;
    }

    Studentanswers studentAnswer;
    if (question instanceof YesNoQuestion) {
        studentAnswer = new Studentanswers(examId, universityId, questionId, Boolean.parseBoolean(answer));
    } else if (question instanceof MCQQuestion) {
        try {
            studentAnswer = new Studentanswers(examId, universityId, questionId, Integer.parseInt(answer));
        } catch (NumberFormatException ex) {
            return;
        }
    } else {
        studentAnswer = new Studentanswers(examId, universityId, questionId, answer);
    }
    studentanswers.add(studentAnswer);

}
     
     public void saveExamMark(int universityId, int examId,double marks){

        // إنشاء كائن من ExamResult وتعيين القيم المناسبة
        ExamResult eR = new ExamResult(examId, universityId, marks);

        // إضافة كائن ExamResult إلى قائمة examResult
        examResult.add(eR);
     }

       
      public Exam getExamById(int examId) {
      for (Exam e : exams) {
      if (e.getId() == examId) {
      return e;
      }
      }
      return null;
      }
      
     
        
        

//        public void viewResultDetails() {
//        System.out.print("Enter Student Id: ");
//        int studentId = scanner.nextInt();
//        scanner.nextLine();
//        System.out.print("Enter Exam Id: ");
//        int examId = scanner.nextInt();
//        scanner.nextLine();
//
//        ExamResult result = getResultByExamAndStudentId(examId, studentId);
//        if (result == null) {
//        System.out.println("Result not found!");
//        return;
//        }
//
//        Exam exam = getExamById(examId);
//        if (exam == null) {
//        System.out.println("Exam not found!");
//        return;
//        }
//
//        List<Question>questions = exam.getQuestions();
//        if (questions.isEmpty()) {
//        System.out.println("No questions found for this exam!");
//        return;
//        }
//
//        // Find the corresponding Studentanswers objects
//        List<Studentanswers> studentAnswersList = new ArrayList<>();
//        for (Studentanswers sa : studentanswers) {
//        if (sa.getUniversityId() == studentId && sa.getId() == examId) {
//            studentAnswersList.add(sa);
//        }
//        }
//
//        System.out.println("Result Details for Exam: " + examId + " and Student: " + studentId + " and Total Mark" + result.getMark());
//        System.out.println("====================================");
//
//
//        int questionCount = 0; // تعيين متغير لتتبع عدد الأسئلة المعروضة
//        for (Question question : questions) {
//        System.out.println("Question: " + question.getQuestionText());
//        if (questionCount < studentAnswersList.size()) { // التحقق من وجود إجابة للسؤال الحالي
//        Studentanswers sa = studentAnswersList.get(questionCount);
//        String studentAnswer = getStudentAnswer(sa);
//        System.out.println("Student's Answer: " + studentAnswer);
//    //    } else {
//    //        System.out.println("Student's Answer: N/A");
//    //    }
//
//        double questionObtainedMark = 0; // درجة السؤال المحصل عليها
//        String correctAnswer;
//        if (question instanceof YesNoQuestion) {
//        correctAnswer = String.valueOf(((YesNoQuestion) question).getAnswer());
//        } else if (question instanceof MCQQuestion) {
//        correctAnswer = String.valueOf(((MCQQuestion) question).getAnswer());
//        } else if (question instanceof FillTheBlankQuestion) {
//        correctAnswer = ((FillTheBlankQuestion) question).getAnswer();
//        } else {
//        correctAnswer = "N/A";
//        }
//
//        if (studentAnswer.equals(correctAnswer)) {
//        questionObtainedMark = question.getMarks();
//        }
//
//        System.out.println("Correct Solution: " + correctAnswer);
//        System.out.println("Marks Obtained: " + questionObtainedMark);
//        } else {
//        System.out.println("Student's Answer: N/A");
//        System.out.println("Correct Solution: N/A");
//        System.out.println("Marks Obtained: 0");
//        }
//        System.out.println("------------------------------------");
//        questionCount++; // زيادة عدد الأسئلة المعروضة بمقدار 1
//        }
//        }
//
//       // Helper method to get the student's answer based on the Studentanswers object
//       private String getStudentAnswer(Studentanswers sa) {
//       if (sa.isAnswerb()) {
//       return String.valueOf(sa.isAnswerb());
//       } else if (sa.getAnsweri() != 0) {
//       return String.valueOf(sa.getAnsweri());
//       } else {
//       return sa.getAnswers();
//       }
//       }
//
//      public ExamResult getResultByExamAndStudentId(int examId, int studentId) {
//      for (ExamResult result : examResult) {
//      if (result.getId() == examId && result.getUniversityId() == studentId) {
//      return result;
//      }
//      }
//      return null; // Return null if the result is not found
//      }
//
//      public Exam getExamById(int examId) {
//      for (Exam e : exams) {
//      if (e.getId() == examId) {
//      return e;
//      }
//      }
//      return null;
//      }
//       
//       
//        
      public Student getStudentById(int universityId) {
      for (Student s : student) {
      if (s.getUniversityId() == universityId) {
      return s;
      }
      }
      return null;
      }
//
//      public void editStudent(int universityId, String newPassword, String newName, String newbirthdate) {
//      Student s = getStudentById(universityId);
//      s.setPassword(newPassword);
//      s.setName(newName);
//      s.setBirthdate(newbirthdate);
//      }
//    
//    
//    
//    public double getAverageExamResult(int studentId) {
//    double totalMarks = 0;
//    int examCount = 0;
//    
//    for (ExamResult examResult : examResult) {
//    if (examResult.getUniversityId() == studentId) {
//    totalMarks += examResult.getMark();
//    examCount++;
//    }
//    }    
//    if (examCount > 0) {
//    return totalMarks / examCount;
//    } else {
//    return 0; // Return 0 if the student has no exam results
//    }
//    }
//
//    
//    
//    public void exportAllStudentsExamResultsToFile(String filePath) throws IOException {
//    try (FileWriter writer = new FileWriter(filePath)) {
//    writer.write("Exam Results for All Students:\n\n");
//
//    for (Student student : student) {
//    writer.write("Student ID: " + student.getUniversityId() + "\n");
//    writer.write("Student Name: " + student.getName() + "\n");
//    writer.write("Student Gender: " + student.getGender() + "\n");
//    writer.write("Student Birthday: " + student.getBirthdate() + "\n\n");
//    writer.write("Exam Results:\n");
//    boolean hasResults = false;
//
//    for (ExamResult examResult : examResult) {
//    if (examResult.getUniversityId() == student.getUniversityId()) {
//    Exam exam = getExamById(examResult.getId());
//    if (exam != null) {
//    writer.write("Exam ID: " + exam.getId() + "\n");
//    writer.write("Exam Name: " + exam.getName() + "\n");
//    writer.write("Student Mark: " + examResult.getMark() + "\n\n");
//    hasResults = true;
//    }
//    }
//    }
//    if (!hasResults) {
//    writer.write("No exam results found for this student.\n");
//    }
//    writer.write("------------------------\n");
//    }
//    System.out.println("Exam results exported to file successfully!");
//    }}
//
//    
//    public List<Student> getTopStudentsByAverageResult(int limit) {
//    List<Student> topStudents = new ArrayList<>(student);
//    
//    // Sort the students based on their average exam results
//    topStudents.sort(Comparator.comparingDouble(student -> getAverageExamResult(student.getUniversityId())));
//    Collections.reverse(topStudents); // Reverse the list to have the highest average result first
//    
//    // Limit the list to the specified number of top students
//    if (topStudents.size() > limit) {
//        topStudents = topStudents.subList(0, limit);
//    }
//    
//    return topStudents;
//    }
//
//    public void exploreStudentRank(int studentId) {
//    double studentAverageResult = getAverageExamResult(studentId);
//    System.out.println("Student ID: " + studentId);
//    System.out.println("Student Average Result: " + studentAverageResult);
//    
//    List<Student> topStudents = getTopStudentsByAverageResult(5); // Get the top 5 students
//    System.out.println("\nTop 5 Students in Average Exam Results:");
//    for (int i = 0; i < topStudents.size(); i++) {
//    Student topStudent = topStudents.get(i);
//    System.out.println((i + 1) + ". Student ID: " + topStudent.getUniversityId() +
//    ", Average Result: " + getAverageExamResult(topStudent.getUniversityId()));
//    }
//    }
//
//    /*
//        public void exportExamToJSONFile(int examId, String filePath) {
//        Exam exam = getExamById(examId);
//        if (exam == null) {
//        System.out.println("Exam not found!");
//        return;
//        }
//
//       JSONObject examJson = new JSONObject();
//       examJson.put("id", exam.getId());
//       examJson.put("name", exam.getName());
//       examJson.put("numQuestions", exam.getNumQuestions());
//       examJson.put("minPassAverage", exam.getMinPassAverage());
//
//      JSONArray questionsJson = new JSONArray();
//      for (Question question : exam.getQuestions()) {
//        JSONObject questionJson = new JSONObject();
//        questionJson.put("id", question.getId());
//        questionJson.put("questionText", question.getQuestionText());
//        questionJson.put("marks", question.getMarks());
//
//        if (question instanceof YesNoQuestion) {
//            questionJson.put("type", "YesNo");
//        } else if (question instanceof MCQQuestion) {
//            questionJson.put("type", "MCQ");
//            MCQQuestion mcqQuestion = (MCQQuestion) question;
//            List<String> choices = mcqQuestion.getChoices();
//            JSONArray choicesJson = new JSONArray();
//            for (String choice : choices) {
//                choicesJson.add(choice);
//            }
//            questionJson.put("choices", choicesJson);
//        } else if (question instanceof FillTheBlankQuestion) {
//            questionJson.put("type", "FillBlank");
//        }
//
//        questionsJson.add(questionJson);
//    }
//
//    examJson.put("questions", questionsJson);
//
//    try (FileWriter file = new FileWriter(filePath)) {
//        file.write(examJson.toJSONString());
//        System.out.println("Exam exported successfully!");
//    } catch (IOException e) {
//        System.out.println("Error exporting exam to file: " + e.getMessage());
//    }
//}
//
//     */
//    
////      public void displayExamResults() {
////    for (ExamResult examResult : examResult) {
////        System.out.println("Exam Information:");
////        for (Exam exam : examResult.getExams()) {
////            System.out.println("Exam ID: " + exam.getId());
////            System.out.println("Exam Name: " + exam.getName());
////            System.out.println("Number of Questions: " + exam.getNumQuestions());
////            System.out.println("Minimum Passing Average: " + exam.getMinPassAverage());
////
////            System.out.println("Results for Passed Students:");
////            boolean passedStudentsExist = false;
////            for (int i = 0; i < examResult.getStudent().size(); i++) {
////                Student currentStudent = examResult.getStudent().get(i);
////                if (hasPassedExam(currentStudent, exam)) {
////                    passedStudentsExist = true;
////                    System.out.println("Student Name: " + currentStudent.getName());
////                    System.out.println("Student ID: " + currentStudent.getUniversityId());
////                    System.out.println("Total Marks: " + examResult.getMarks().get(i));
////                    System.out.println();
////                }
////            }
////
////            if (!passedStudentsExist) {
////                System.out.println("No students passed the exam.");
////            }
////
////            System.out.println(); // Add a line break between exams
////        }
////    }
////}
////
////
////
////    public boolean hasPassedExam(Student students, Exam exam) {
////    int studentIndex = student.indexOf(students);
////    if (studentIndex >= 0 && studentIndex < marks.size()) {
////        double studentMarks = marks.get(studentIndex);
////        return studentMarks >= exam.getMinPassAverage();
////    }
////    return false;
////}
//
//     
// 
//public void displayAndSolveExamQuestions() {
//    System.out.print("Enter Exam Id: ");
//    int examId = scanner.nextInt();
//    Exam exam = getExamById(examId);
//    if (exam == null) {
//        System.out.println("Exam not found!");
//        return;
//    }
//
//    System.out.println("Exam ID: " + exam.getId());
//    System.out.println("Exam name: " + exam.getName());
//
//    for (Question question : exam.getQuestions()) {
//        System.out.println("Question ID: " + question.getId());
//        System.out.println("Question Text: " + question.getQuestionText());
//        System.out.println("Question Marks: " + question.getMarks());
//
//        if (question instanceof YesNoQuestion) {
//            System.out.println("Question Type: YES_NO");
//            System.out.print("Write the answer (true/false): ");
//            boolean answer = scanner.nextBoolean();
//            // قم بمعالجة الإجابة هنا
//        } else if (question instanceof MCQQuestion) {
//            System.out.println("Question Type: MCQ");
//            MCQQuestion mcqQuestion = (MCQQuestion) question;
//            System.out.println("Choices:");
//            for (String choice : mcqQuestion.getChoices()) {
//                System.out.println(choice);
//            }
//            System.out.print("Write the answer (enter choice number): ");
//            int answer = scanner.nextInt();
//            // قم بمعالجة الإجابة هنا
//        } else if (question instanceof FillTheBlankQuestion) {
//            System.out.println("Question Type: FILL_BLANK");
//            System.out.print("Write the answer: ");
//            String answer = scanner.next();
//            // قم بمعالجة الإجابة هنا
//        }
//
//        System.out.println(); // فصل الأسئلة
//    }
//}
//
//   
//    
//    

    
}
