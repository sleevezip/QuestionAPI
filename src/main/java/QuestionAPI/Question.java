package QuestionAPI;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.util.Assert;

import static com.mongodb.assertions.Assertions.notNull;
import static com.mongodb.assertions.Assertions.isTrue;
import static org.springframework.util.Assert.notEmpty;

final class Question {
    static final int MAX_LENGTH_QUESTION = 500;
    static final int MAX_LENGTH_ANSWER = 100;

    @Id
    private String id;

    private String question;

    private String answer;

    private Date createdAt = new Date();

/*    public Question() {}*/

    private Question(Builder builder){
        this.question = builder.question;
        this.answer = builder.answer;
    }

    static Builder getBuilder(){
        return new Builder();
    }

    public String getId(){
        return id;
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer(){
        return answer;
    }

    public void update(String question, String answer){
        checkQuestionAndAnswer(question, answer);

        this.question = question;
        this.answer = answer;
    }

    static class Builder {

        private String question;

        private String answer;

        private Builder () {}

        Builder question(String question) {
            this.question = question;
            return this;
        }

        Builder answer(String answer) {
            this.answer = answer;
            return this;
        }

        Question build() {
            Question build = new Question(this);
            build.getQuestion();
            build.getAnswer();

            return build;
        }
    }

    private void checkQuestionAndAnswer(String question, String answer) {
        notNull(question, "Question cannot be null");
        notNull(answer, "Answer cannot be null");
   }
}


