package QuestionAPI;

import com.sun.istack.internal.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.convert.DataSizeUnit;
import javax.validation.constraints.Size;

import javax.validation.constraints.Size;

public final class QuestionDTO {

    private String id;

    @Size(max = Question.MAX_LENGTH_QUESTION)
    private String question;

    @NotNull
    @Size(max = Question.MAX_LENGTH_ANSWER)
    private String answer;

    public String getId() {
        return id;
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer(){
        return answer;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }

    @Override
    public String toString() {
        return String.format(
                "QuestionDTO[id=%s, description=%s, title=%s]",
                this.id,
                this.question,
                this.answer
        );
    }
}
