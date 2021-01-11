package fr.gamedev.question;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.gamedev.question.data.Answer;
import fr.gamedev.question.data.Question;
import fr.gamedev.question.data.User;
import fr.gamedev.question.data.UserAnswer;
import fr.gamedev.question.repository.QuestionRepository;
import fr.gamedev.question.repository.UserAnswerRepository;
import fr.gamedev.question.repository.UserRepository;

/**
 * @author djer1
 *
 */
@RestController
public class ResponseController {

    /**
     * Injection QuestionRepository.
     */
    @Autowired
    private QuestionRepository questionRepository;

    /**
     * Injection UserRepository.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Injection UserAnswerRepository.
     */
    @Autowired
    private UserAnswerRepository userAnswerRepository;

    /**
     * Log.
     */
    private final Logger log = LoggerFactory.getLogger(ResponseController.class);

    @GetMapping("/response")
    public final String answer(@RequestParam final long questionId, @RequestParam final Boolean answer,
            @RequestParam final long userId) {

        final long pointsCorrectAnswer = 5;

        Optional<Question> questionOpt = questionRepository.findById(questionId);
        Optional<User> userOpt = userRepository.findById(userId);
        String response;

        if (questionOpt.isPresent() && userOpt.isPresent()) {

            Question question = questionOpt.get();

            if (question.getAnswer() != null) {
                // A changer : on récupère à partir de AnswerRepository > .findByQuestion(question)
                Answer answerEntity = question.getAnswer();
                Boolean correctAnswer = answerEntity.getCorrectAnswer();

                UserAnswer userAnwser = new UserAnswer();
                userAnwser.setAnswer(answerEntity);
                userAnwser.setUser(userOpt.get());
                // Si answer = correctAnswer
                if (answer.equals(correctAnswer)) {
                    userAnwser.setPoints(pointsCorrectAnswer);
                    userAnswerRepository.save(userAnwser);
                    response = "Bravo ! Vous avez trouvé ! ";
                } else {
                    // Réponse incorrecte
                    userAnwser.setPoints(0);
                    userAnswerRepository.save(userAnwser);
                    response = "Oops ! Réponse incorrecte";
                }
            } else {
                log.error("La question id = " + questionId + " n'a pas de réponse associée.");
                response = "Une erreur est survenue";
            }
        } else {
            log.error("Le userId ou le questionId est incorrect");
            response = "Une erreur est survenue";
        }
        return response;
    }

}
