package fr.gamedev.question.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.gamedev.question.data.Answer;
import fr.gamedev.question.data.Question;

/**
 * @author djer1
 *
 */
@RepositoryRestResource(collectionResourceRel = "answer", path = "answer")
public interface AnswerRepository extends PagingAndSortingRepository<Answer, Long> {

    Optional<Answer> findByQuestion(Question question);
}
