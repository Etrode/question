package fr.gamedev.question.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.gamedev.question.data.Tag;

/**
 * @author TeamG2
 *
 */
@RepositoryRestResource(collectionResourceRel = "tag", path = "tag")
public interface TagRepository extends PagingAndSortingRepository<Tag, Long> {

}
