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

    //TODO grp2 by DJE : JavaDoc : le . (point) demandé par CheckStyle devrait ête à la fin de votre texte. Cette règle à pour but de rapeler que la partie "description" de la javadoc doit une être une **phrase** (donc avec un point à la fin).
    /**.
     * Injection QuestionRepository
     */
    @Autowired
    private QuestionRepository questionRepository;

    /**.
     * Injection UserRepository
     */
    @Autowired
    private UserRepository userRepository;

    /**.
     * Injection UserAnswerRepository
     */
    @Autowired
    private UserAnswerRepository userAnswerRepository;

    /**.
     * Log
     */
    private final Logger log = LoggerFactory.getLogger(ResponseController.class);

    @GetMapping("/response")
    public final String answer(@RequestParam final long questionId, @RequestParam final Boolean answer,
            @RequestParam final long userId) {

        final long pointsCorrectAnswer = 5;

        Optional<Question> questionOpt = questionRepository.findById(questionId);
        Optional<User> userOpt = userRepository.findById(userId);

        if (questionOpt.isPresent() && userOpt.isPresent()) {

            Question question = questionOpt.get();

            if (question.getAnswer() != null) {
                Answer answerEntity = question.getAnswer();
                Boolean correctAnswer = answerEntity.getCorrectAnswer();

                // Si answer = correctAnswer
                if (answer.equals(correctAnswer)) {
                    UserAnswer userAnwser = new UserAnswer();
                    userAnwser.setAnswer(answerEntity);
                    userAnwser.setUser(userOpt.get());
                    userAnwser.setPoints(pointsCorrectAnswer);
                    userAnswerRepository.save(userAnwser);
                    return "Bravo ! Cous avez trouvé ! ";
                } else {
                    // Réponse incorrecte
                    //TODO grp2 by DJE : cleanCode : Une grosse partie de ce code est comune avec le bloc précédent et pourrait etre mutualisé avant le bloc if/else.
                    UserAnswer userAnwser = new UserAnswer();
                    userAnwser.setAnswer(answerEntity);
                    userAnwser.setUser(userOpt.get());
                    userAnwser.setPoints(0);
                    userAnswerRepository.save(userAnwser);
                    return "Oops ! Réponse incorrecte";
                }
            } else {
                log.error("La question id = " + questionId + " n'a pas de réponse associée.");
                return "Une erreur est survenue";
            }
        }
        //TODO grp2 by DJE : Algo : attention cette log n'est pas dans un "else" elle se produit donc tout le temps !
        log.error("Le userId ou le questionId est incorrect");
        return "Une erreur est survenue";
    }

}
