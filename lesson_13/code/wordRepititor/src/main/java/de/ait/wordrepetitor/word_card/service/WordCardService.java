package de.ait.wordrepetitor.word_card.service;

import de.ait.wordrepetitor.card_group.entity.CardGroup;
import de.ait.wordrepetitor.word_card.dto.WordCardRequestDTO;
import de.ait.wordrepetitor.word_card.dto.WordCardResponseDTO;

import java.util.List;

public interface WordCardService {
    List<WordCardResponseDTO> getAllWordCards();
    WordCardResponseDTO createWordCard(WordCardRequestDTO dto);
    WordCardResponseDTO updateWordCard(Long id, WordCardRequestDTO dto);
    List<WordCardResponseDTO> getWordCards(String word);
    List<CardGroup> getGroupsByCardId(Long cardId);
    WordCardResponseDTO getById(Long id);
}
