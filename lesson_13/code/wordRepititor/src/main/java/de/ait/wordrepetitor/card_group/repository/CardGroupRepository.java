package de.ait.wordrepetitor.card_group.repository;

import de.ait.wordrepetitor.card_group.entity.CardGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CardGroupRepository extends JpaRepository<CardGroup, Long> {
    Optional<CardGroup> findByTitle(String title);
}
