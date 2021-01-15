
import java.util.*;

public class QuestionandAnswers {
    
    private String question;
   // private List<String> answers=new ArrayList<>();
    List<String> answers=new ArrayList<String>();
    
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public List<String> getAnswers() {
        return answers;
    }
    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
    
    @Override
    public String toString() {
        return "QuestionandAnswers [question=" + question + ", answers=" + answers + "]";
    }
    
    
 
}
