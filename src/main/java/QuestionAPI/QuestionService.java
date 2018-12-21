package QuestionAPI;

import java.util.List;

interface QuestionService {

    QuestionDTO create(QuestionDTO question);
    QuestionDTO delete(String id);
    List<QuestionDTO> findAll();
    QuestionDTO findById(String id);
    QuestionDTO update(QuestionDTO question);
}
