package com.furniturestoreapi.accessingDataJPA;

import com.furniturestoreapi.models.Section;
import org.springframework.data.repository.CrudRepository;

public interface SectionRepository extends CrudRepository<Section, Long> {
}
