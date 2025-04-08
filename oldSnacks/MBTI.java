import java.util.Scanner;;

public class MBTI {
    public static void main(String[] args) {
    
        Scanner reader = new Scanner(System.in);
    
        String[] questions = {
            "Do you prefer to spend your free time with a group of people (A) or by yourself (B)?",
            "Do you feel energized after being around others (A) or need time alone to recharge (B)?",
            "Do you enjoy talking to people you've just met (A) or prefer to observe before interacting (B)?",
            "Would you rather go to a party (A) or stay home reading a book (B)?",
            "Do you prefer working in a busy, bustling environment (A) or in a quiet, focused setting (B)?",
            "Do you focus on the details and facts (A) or the big picture and possibilities (B)?",
            "Are you more likely to trust what you see (A) or imagine how things could be (B)?",
            "Do you prefer to work with tangible data and real-world information (A) or explore abstract concepts and ideas (B)?",
            "Do you prefer following established methods (A) or finding new ways to approach tasks (B)?",
            "When making decisions, do you focus more on past experiences (A) or future possibilities (B)?",
            "When making decisions, do you prioritize logic and objectivity (A) or consider the impact on people’s feelings (B)?",
            "Are you more concerned with justice and fairness (A) or with harmony and personal values (B)?",
            "Do you prefer to debate ideas (A) or maintain positive relationships (B)?",
            "When faced with a problem, do you look for a practical solution (A) or a solution that benefits everyone (B)?",
            "Do you make decisions based on facts and evidence (A) or emotions and personal values (B)?",
            "Do you prefer having a set schedule and sticking to it (A) or going with the flow and being spontaneous (B)?",
            "Do you feel more comfortable when things are planned and organized (A) or when you can be flexible and adapt (B)?",
            "Do you prefer completing tasks ahead of time (A) or leaving things open-ended until the last minute (B)?",
            "Do you like to make decisions quickly (A) or keep your options open (B)?",
            " Do you prefer to have your day structured and orderly (A) or open-ended and adaptable (B)?"
        };


int E = 0; 
int I = 0; 
int S = 0; 
int N = 0;
int T = 0; 
int F = 0; 
int J = 0; 
int P = 0; 

        System.out.println("......................................");
        System.out.println("WELCOME TO THE FREE PERSONALITY TEST");
        System.out.println("......................................");
        System.out.println("What Is Your Name ?");
        String name = reader.nextLine();

        for (int c = 0; c < questions.length; ++c){
            System.out.println("\n" + questions[c]);
           String answers = " ";

while (true){
    System.out.println("Your answer (A or B): ");
    answers = reader.nextLine().toUpperCase();

if (answers.equals("A") || answers.equals("B")){
    break;
} else {
    System.out.println("Error selection... Select (A or B)");
}

    }
if (c == 0 || c == 1 || c == 2 || c == 3 || c == 4){
    if (answers.equals("A")) E++; else I++;
    }
    if (c == 5 || c == 6 || c == 7 || c == 8 || c == 9){
        if (answers.equals("A")) S++; else N++;
}
    if (c == 10 || c == 11 || c == 12 || c == 13 || c == 14){
        if (answers.equals("A")) T++; else F++;
    }

        }
        System.out.println("\nHello," + name);
        System.out.print("Your personality type is: ");

        System.out.print((E > I ? "E" : "I"));
        System.out.print((S > N ? "S" : "N"));
        System.out.print((T > F ? "T" : "F"));
        System.out.print((J > P ? "J" : "P"));
    }
}