package QuestionAPI;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

interface QuestionRepository extends Repository<Question, String> {
    void delete(Question deleted);

    List<Question> findAll();

    Optional<Question> findOneById(String id);

    Question save(Question saved);
}
