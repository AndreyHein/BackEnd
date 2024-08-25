package de.ait.wordrepetitor.word_card.service;

import de.ait.wordrepetitor.word_card.dto.WordCardRequestDTO;
import de.ait.wordrepetitor.word_card.dto.WordCardResponseDTO;

import java.util.List;

public interface WordCardService {
    List<WordCardResponseDTO> getAllWordCards();
    WordCardResponseDTO createWordCard(WordCardRequestDTO dto);
}
