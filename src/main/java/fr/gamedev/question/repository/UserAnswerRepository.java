/**
 *
 */
package fr.gamedev.question.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.gamedev.question.data.Question;
import fr.gamedev.question.data.User;
import fr.gamedev.question.data.UserAnswer;

/**
 * @author djer1
 *
 */
@RepositoryRestResource(collectionResourceRel = "userAnswer", path = "userAnswer")
public interface UserAnswerRepository extends PagingAndSortingRepository<UserAnswer, Long> {

//    @Query("SELECT ua FROM UserAnswer ua WHERE ua.user=:user and ua.answer.question=:question ")
//    List<UserAnswer> findByQuestionAndUser(@Param("question") Question question, @Param("user") User user);

    Optional<UserAnswer> findTopByAnswerQuestionAndUserAndDateNotNullOrderByDateDesc(Question question, User user);
}
