package QuestionAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
final class MongoDBQuestionService implements QuestionService {

    private final QuestionRepository repository;

    @Autowired
    MongoDBQuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public QuestionDTO create(QuestionDTO question) {
        Question persisted = Question.getBuilder()
                .question(question.getQuestion())
                .answer(question.getAnswer())
                .build();
        persisted = repository.save(persisted);
        return convertToDTO(persisted);
    }

    @Override
    public QuestionDTO delete(String id) {
        Question deleted = findQuestionById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }

    @Override
    public List<QuestionDTO> findAll() {
        List<Question> questionEntries = repository.findAll();
        return convertToDTOs(questionEntries);
    }

    private List<QuestionDTO> convertToDTOs(List<Question> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }

    @Override
    public QuestionDTO findById(String id) {
        Question found = findQuestionById(id);
        return convertToDTO(found);
    }

    @Override
    public QuestionDTO update(QuestionDTO question) {
        Question updated = findQuestionById(question.getId());
        updated.update(question.getQuestion(), question.getAnswer());
        updated = repository.save(updated);
        return convertToDTO(updated);
    }

    private Question findQuestionById(String id) {
        Optional<Question> result = repository.findOneById(id);
        return result.orElseThrow(() -> new QuestionNotFoundException(id));

    }

    private QuestionDTO convertToDTO(Question model) {
        QuestionDTO dto = new QuestionDTO();

        dto.setId(model.getId());
        dto.setQuestion(model.getQuestion());
        dto.setAnswer(model.getAnswer());

        return dto;
    }
}