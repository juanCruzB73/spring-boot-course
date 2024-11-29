import quizz_app02.QuestionService;

public class Main {

    public static void main(String[] args){
        System.out.println("start");
        //Quizz App
        QuestionService service=new QuestionService();
        service.playQuizz();
        service.printScore();
    }
    
}

