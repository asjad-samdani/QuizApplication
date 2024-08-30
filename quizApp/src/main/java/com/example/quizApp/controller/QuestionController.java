package com.example.quizApp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizApp.entity.Question;
import com.example.quizApp.server.QuizService;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuizService quizService;

    @GetMapping("/allQuestions")
    public ResponseEntity<?> getAllQuestions() {
        List<Question> allQuestions = quizService.getAllQuestions();
        if (allQuestions.isEmpty()) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Question Not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

        } else {
            return ResponseEntity.ok(allQuestions);
        }

    }

    @GetMapping("/category/{category}")
    public ResponseEntity<?> getQuestionsByCategory(@PathVariable String category) {
        List<Question> allQuestionsBycategory = quizService.getAllQuestionsBycategory(category);
        if (allQuestionsBycategory.isEmpty()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("Message", "Category questions not available");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);

        } else {
            return ResponseEntity.ok(allQuestionsBycategory);
        }

    }

    // Sorting the Question
    @GetMapping("/sortQuestion/{category}")
    public ResponseEntity<?> getMethodName(@PathVariable String category) {
        List<Question> questions = quizService.findBooksWithSorting(category);
        if (questions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(questions);

    }

    @PostMapping("/addQuestions")
    public ResponseEntity<?> addQuestins(@RequestBody List<Question> addQuestions) {

        List<Question> updateBookById = quizService.addAllQuestions(addQuestions);
        return ResponseEntity.status(HttpStatus.CREATED).body(updateBookById);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> putMethodName(@RequestBody Question question, @PathVariable Integer id) {
        Map<String, String> response = new HashMap<>();
        Question updatedQuestion = quizService.updateQuestion(question, id);
        if (updatedQuestion != null) {

            response.put("message", "Updated Successfully!");
            return ResponseEntity.ok(response);

        } else {
            response.put("message", "Question not found or update failed");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Integer id) {
        Map<String, String> response = new HashMap<>();

        boolean isDeleted = quizService.deleteBookById(id);
        if (isDeleted) {
            response.put("message", "Question deleted successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Id not found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
