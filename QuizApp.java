import java.util.*;

class Question {
    String questionText;
    List<String> options;
    int correctAnswerIndex; // 0-based index

    public Question(String questionText, List<String> options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public boolean isCorrect(int answerIndex) {
        return answerIndex == correctAnswerIndex;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Create quiz questions
        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                /* questionText */ "Which of the following is not a feature of Java?",
                /* options */ Arrays.asList("Object-Oriented", "Platform Dependent", "Automatic Memory Management",
                        "Secure"),
                /* correctAnswerIndex */ 1));

        questions.add(new Question(
                /* questionText */ "Which interface does java.util.HashMap implement?",
                /* options */ Arrays.asList("List", "Map", "Set", "Collection"),
                /* correctAnswerIndex */ 1));

        questions.add(new Question(
                /* questionText */ "What will happen if you try to compile and run: int x = 5 / 0;",
                /* options */ Arrays.asList("Prints 0", "Compile-time error", "Run-time error", "Prints infinity"),
                /* correctAnswerIndex */ 2));

        questions.add(new Question(
                /* questionText */ "Which keyword is used to prevent a method from being overridden?",
                /* options */ Arrays.asList("static", "final", "const", "volatile"),
                /* correctAnswerIndex */ 1));

        questions.add(new Question(
                /* questionText */ "What is the output of: System.out.println(10 + 20 + \"Java\" + 10 + 20);",
                /* options */ Arrays.asList("30Java30", "Java1020", "30Java1020", "Java3030"),
                /* correctAnswerIndex */ 2));

        questions.add(new Question(
                /* questionText */ "Which collection class is synchronized?",
                /* options */ Arrays.asList("ArrayList", "HashMap", "Vector", "HashSet"),
                /* correctAnswerIndex */ 2));

        questions.add(new Question(
                /* questionText */ "Which of the following is true about constructors?",
                /* options */ Arrays.asList("They have no return type", "They must have a void return type",
                        "They can be abstract", "They must be static"),
                /* correctAnswerIndex */ 0));

        questions.add(new Question(
                /* questionText */ "Which method is called before an object is garbage collected?",
                /* options */ Arrays.asList("final()", "finalize()", "delete()", "destroy()"),
                /* correctAnswerIndex */ 1));

        questions.add(new Question(
                /* questionText */ "Which package contains the Random class?",
                /* options */ Arrays.asList("java.util", "java.io", "java.lang", "java.math"),
                /* correctAnswerIndex */ 0));

        questions.add(new Question(
                /* questionText */ "What will happen if main method is declared as private?",
                /* options */ Arrays.asList("Compile-time error", "Run-time error", "Program runs normally",
                        "JVM ignores it"),
                /* correctAnswerIndex */ 1));

        int score = 0;

        // Step 2: Iterate through questions
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.questionText);

            for (int j = 0; j < q.options.size(); j++) {
                System.out.println((j + 1) + ". " + q.options.get(j));
            }

            System.out.print("Enter your answer (1-" + q.options.size() + "): ");
            int answer = sc.nextInt() - 1; // converting to 0-based index

            if (q.isCorrect(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer is: " + q.options.get(q.correctAnswerIndex));
            }
        }

        // Step 3: Display result
        System.out.println("\n===== QUIZ RESULT =====");
        System.out.println("Your score: " + score + "/" + questions.size());
        if (score == questions.size()) {
            System.out.println("Excellent! You got all correct!");
        } else if (score >= questions.size() / 2) {
            System.out.println("Good job!");
        } else {
            System.out.println("Keep practicing!");
        }

        sc.close();
    }
}
