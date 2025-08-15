import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Question class
class Question {
    String questionText;
    String[] options;
    int correctOption; // index starting from 1

    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public boolean checkAnswer(int userAnswer) {
        return userAnswer == correctOption;
    }
}

// Main Quiz App
public class OnlineQuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create quiz questions
        List<Question> quiz = new ArrayList<>();
        quiz.add(new Question(
                "Which language is used for Android app development?",
                new String[]{"1. Python", "2. Java", "3. C#", "4. Ruby"},
                2
        ));
        quiz.add(new Question(
                "What does HTML stand for?",
                new String[]{"1. Hyper Trainer Marking Language", "2. Hyper Text Markup Language", "3. Hyper Text Marketing Language", "4. Hyper Text Markup Leveler"},
                2
        ));
        quiz.add(new Question(
                "Which company developed Java?",
                new String[]{"1. Microsoft", "2. Sun Microsystems", "3. Apple", "4. Google"},
                2
        ));
        quiz.add(new Question(
                "Which data structure uses FIFO principle?",
                new String[]{"1. Stack", "2. Queue", "3. Tree", "4. Graph"},
                2
        ));
        quiz.add(new Question(
                "What is the size of an int in Java?",
                new String[]{"1. 2 bytes", "2. 4 bytes", "3. 8 bytes", "4. 16 bytes"},
                2
        ));

        // Quiz logic
        int score = 0;
        System.out.println("===== Welcome to the Online Quiz =====\n");

        for (int i = 0; i < quiz.size(); i++) {
            Question q = quiz.get(i);
            System.out.println((i + 1) + ". " + q.questionText);
            for (String option : q.options) {
                System.out.println(option);
            }
            System.out.print("Your answer (1-4): ");
            int userAnswer = sc.nextInt();

            if (q.checkAnswer(userAnswer)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: Option " + q.correctOption + "\n");
            }
        }

        // Final score
        System.out.println("===== Quiz Finished =====");
        System.out.println("Your score: " + score + " out of " + quiz.size());
        double percentage = ((double) score / quiz.size()) * 100;
        System.out.println("Percentage: " + percentage + "%");

        // Simple result message
        if (percentage >= 80) {
            System.out.println("🏆 Excellent work!");
        } else if (percentage >= 50) {
            System.out.println("👍 Good job!");
        } else {
            System.out.println("📚 Keep practicing!");
        }

        sc.close();
    }
}
