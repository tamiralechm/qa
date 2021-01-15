import java.util.*;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class QandAImplementation {
    // List<String> Answer=new ArrayList<String>();
    private static Scanner scan = new Scanner(System.in).useDelimiter("\r");
    private static Map<String, List<String>> queAs = new HashMap<>();

    // ask questions to get answer
    public static void askQuestions() {
        QuestionandAnswers QA = new QuestionandAnswers();
        System.out.print("ask question: ");
        String askedQuestion = scan.next();

        // check if the question already exists in the map
        if (!queAs.containsKey(askedQuestion)) {
            System.out.println("the question you asked is not in the system,lets add it");
            QA.setQuestion(askedQuestion);
            System.out.println("add answer to the question");
            String answer = scan.next();
            List<String> newAns = Pattern.compile("-").splitAsStream(answer).collect(Collectors.toList());
            QA.getAnswers().addAll(newAns);
            queAs.put(askedQuestion, newAns);
            System.out.println(queAs);
         } else {
            System.out.println("anser= " + queAs.get(askedQuestion));// values of the answers
        }

    }

    public static void addQuesandAns() {
        QuestionandAnswers QA = new QuestionandAnswers();
        System.out.print("add question: ");
        String question = scan.next();
        if (!validateInput(question)) {
            System.out.println("you exceeded character limit");
        }

        QA.setQuestion(question);
        System.out.print("add answers: ");
        String input = scan.next();

        // accept the input and split to store it as list
        List<String> answers = Arrays.asList(input.split("-"));
        for (String str : answers) {
            if (!validateInput(str)) {
                System.out.println("your amswer exceeded character limit,pls modify it");
            }
        }
        QA.getAnswers().addAll(answers);
        queAs.put(QA.getQuestion(), QA.answers);
        System.out.println(queAs);
        return;
    }

    // check the length of string not to exceed 255
    private static boolean validateInput(String questionoranswer) {
        return questionoranswer.length() > 255 ? false : true;
    }

    // menu of the main services
    public static int menu(Scanner sc) {
        int options;
        System.out.println("*****choose one option*****");
        System.out.println("option1- add questions and answers");
        System.out.println("option2- Ask questions");
        options = sc.nextInt();
        return options;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int choice = menu(sc);
            switch (choice) {
            case 1:
                System.out.println("you chose to create question and answer list...");
                addQuesandAns();
                break;
            case 2:
                askQuestions();
                break;
            default:
                System.out.println("invalid choice");
            }
        }
    }
}
