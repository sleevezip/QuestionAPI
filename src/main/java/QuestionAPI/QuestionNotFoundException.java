package QuestionAPI;

public class QuestionNotFoundException extends RuntimeException {

    public QuestionNotFoundException(String id) {
        super(String.format("No question found with id: <%s>", id));
    }
}
