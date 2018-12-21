package QuestionAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/question")
final class QuestionController {

    private final QuestionService service;

    @Autowired
    QuestionController(QuestionService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    QuestionDTO create(@RequestBody @Valid QuestionDTO questionEntry) {
        return service.create(questionEntry);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    QuestionDTO delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    List<QuestionDTO> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    QuestionDTO findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    QuestionDTO update(@RequestBody @Valid QuestionDTO questionEntry) {
        return service.update(questionEntry);
    }

//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public void handleQuestionNotFound(QuestionNotFoundException ex) {
//    }
}