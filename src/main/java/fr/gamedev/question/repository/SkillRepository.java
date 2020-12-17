package fr.gamedev.question.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.gamedev.question.data.Skill;

/**
 * @author TeamG2
 *
 */
@RepositoryRestResource(collectionResourceRel = "skill", path = "skill")
public interface SkillRepository extends PagingAndSortingRepository<Skill, Long> {

}
