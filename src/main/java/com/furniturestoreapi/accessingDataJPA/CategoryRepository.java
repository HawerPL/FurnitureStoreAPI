package com.furniturestoreapi.accessingDataJPA;

import com.furniturestoreapi.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT c FROM Category c WHERE c.Name = categories", nativeQuery = true)
    Set<Category> findAllByName(Set<Category> categories);
}
