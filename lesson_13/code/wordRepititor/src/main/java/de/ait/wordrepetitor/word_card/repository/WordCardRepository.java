package de.ait.wordrepetitor.word_card.repository;

import de.ait.wordrepetitor.word_card.entity.WordCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordCardRepository extends JpaRepository<WordCard, Long> {
}
