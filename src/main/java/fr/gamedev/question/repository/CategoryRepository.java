package fr.gamedev.question.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.gamedev.question.data.Category;

/**
 * @author TeamG2
 *
 */
@RepositoryRestResource(collectionResourceRel = "category", path = "category")
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

}
