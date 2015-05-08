package com.github.rmnasri.repository;

import com.github.rmnasri.model.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by riadh on 04/05/15.
 */
@RepositoryRestResource
public interface RecetteRepository extends CrudRepository<Recette, Long> {
}
