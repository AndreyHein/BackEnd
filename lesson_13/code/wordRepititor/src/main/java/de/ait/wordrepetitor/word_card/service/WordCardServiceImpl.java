package de.ait.wordrepetitor.word_card.service;

import de.ait.wordrepetitor.card_group.entity.CardGroup;
import de.ait.wordrepetitor.exception.WordCardNotFoundException;
import de.ait.wordrepetitor.word_card.dto.WordCardRequestDTO;
import de.ait.wordrepetitor.word_card.dto.WordCardResponseDTO;
import de.ait.wordrepetitor.word_card.entity.WordCard;
import de.ait.wordrepetitor.word_card.repository.WordCardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class WordCardServiceImpl implements WordCardService {
    private final WordCardRepository cardRepository;
    private final ModelMapper mapper;

    @Override
    public WordCardResponseDTO getById(Long id) {
        WordCard entity = cardRepository.findById(id).orElseThrow(() -> new WordCardNotFoundException(String.format("Card with id %d not found", id)));
        return mapper.map(entity, WordCardResponseDTO.class);
    }

    @Override
    public List<WordCardResponseDTO> getAllWordCards() {
        return cardRepository.findAll().stream()
                .map(w_c -> mapper.map(w_c, WordCardResponseDTO.class))
                .toList();
    }

    @Override
    public WordCardResponseDTO createWordCard(WordCardRequestDTO dto) {
        WordCard entity = mapper.map(dto, WordCard.class);
        entity = cardRepository.save(entity);
        return mapper.map(entity, WordCardResponseDTO.class);
    }

    @Override
    @Transactional
    public WordCardResponseDTO updateWordCard(Long id, WordCardRequestDTO dto) {
        WordCard entity = mapper.map(dto, WordCard.class);
        entity.setId(id);
        entity = cardRepository.save(entity);
        return mapper.map(entity, WordCardResponseDTO.class);
    }

    @Override
    public List<WordCardResponseDTO> getWordCards(String word) {
        if (word == null || word.isEmpty()) {
            return getAllWordCards();
        } else {
            WordCard entity = cardRepository.findByWord(word);
            if (entity == null) {
                throw  new WordCardNotFoundException(String.format("Word = '%s' not found", word));
            }
            return List.of(mapper.map(entity, WordCardResponseDTO.class));
        }
    }

    @Override
    public List<CardGroup> getGroupsByCardId(Long cardId) {
        WordCard card = cardRepository.findById(cardId).orElseThrow(() -> new WordCardNotFoundException("WordCard with id " + cardId + " not found"));
        return card.getGroups().stream()
                .toList();
    }
}
