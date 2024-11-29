package quizz_app02;

import java.util.Scanner;

public class QuestionService {
    
    private Question questions[]=new Question[4];

    String selected[] =  new String[4];

    public QuestionService(){
        questions[0]=new Question(1, "what the extension for java files", "js", "py", "java", "c", "3");
        questions[1]=new Question(2, "what the exension fot python files", "js", "py", "java", "c", "2");
        questions[2]=new Question(3, "what the extension for java script files", "js", "py", "java", "c", "1");
        questions[3]=new Question(4, "what the extension for c files", "js", "py", "java", "c", "4");
    }

    public void playQuizz(){
        int index=0;
        for(Question q : questions){
            System.out.println("Question number "+q.getId()+" "+q.getQuestion());            
            System.out.println("1. "+q.getOpt1());
            System.out.println("2. "+q.getOpt2());
            System.out.println("3. "+q.getOpt3());
            System.out.println("4."+q.getOpt4());
            System.out.println("use numbers of option: ");
            Scanner sc = new Scanner(System.in);
            selected[index] = sc.nextLine();
            index++;
        }

        for(String s:selected){
            System.out.println(s);
        }
    }
    int score=0;
    public void printScore(){
        for(int i=0;i<selected.length;i++){
            
            if(selected[i].equals(questions[i].getAnswer())){
                score++;
            }
        }
        System.out.println("your score is: "+score);
    }
    public Question[] getQuestions() {
        return questions;
    }
}
