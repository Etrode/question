package fr.gamedev.question;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author djer1
 *
 */
@RestController
public class ResponseController {

//    @Autowired
//    QuestionRepository questionRepository;
//    
//    @Autowired
//    UserRepository userRepository;
//    
//    @GetMapping("/response")
//    public final String answer(@RequestParam final long questionId, @RequestParam final Boolean answer, @RequestParam final long userId) {
//
//        Optional<Question> questionOpt = questionRepository.findById(questionId);
//        Option<User> userOpt = userRepository.findById(userId);
//        if(questionOpt.isPresent()) {
//            
//            Question question = questionOpt.get();
//            
//            if(question.getAnswer() != null) {
//                Boolean correctAnswer = question.getAnswer().getCorrectAnswer();
//                
//                // Si answer = correctAnswer
//                if(answer.equals(correctAnswer)) {
//                    
//                }
//            }
//        }
//        
//        
//
//        
//        
//        // Si oui > Point UserAnswer addPoints
//        
//        if (answer == Boolean.TRUE) {
//            //Ajouter des points
//
//            response = "Bravo ! vous avez trouvé ! ";
//        } else {
//            //Ne pas ajouter de points
//
//            response = "Oops ! Ca n'est pas correcte";
//        }
//
//        return response;
//    }

}
