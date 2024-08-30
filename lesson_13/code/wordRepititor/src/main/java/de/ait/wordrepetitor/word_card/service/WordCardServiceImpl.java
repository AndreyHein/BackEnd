package de.ait.wordrepetitor.word_card.service;

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

@RequiredArgsConstructor
@Service
public class WordCardServiceImpl implements WordCardService {
    private final WordCardRepository repository;
    private final ModelMapper mapper;

    @Override
    public WordCardResponseDTO getById(Long id) {
        WordCard entity = repository.findById(id).orElseThrow(() -> new WordCardNotFoundException(String.format("Card with id %d not found", id)));
        return mapper.map(entity, WordCardResponseDTO.class);
    }

    @Override
    public List<WordCardResponseDTO> getAllWordCards() {
        return repository.findAll().stream()
                .map(w_c -> mapper.map(w_c, WordCardResponseDTO.class))
                .toList();
    }

    @Override
    public WordCardResponseDTO createWordCard(WordCardRequestDTO dto) {
        WordCard entity = mapper.map(dto, WordCard.class);
        entity = repository.save(entity);
        return mapper.map(entity, WordCardResponseDTO.class);
    }

    @Override
    @Transactional
    public WordCardResponseDTO updateWordCard(Long id, WordCardRequestDTO dto) {
        WordCard entity = mapper.map(dto, WordCard.class);
        entity.setId(id);
        entity = repository.save(entity);
        return mapper.map(entity, WordCardResponseDTO.class);
    }

    @Override
    public List<WordCardResponseDTO> getWordCards(String word) {
        if (word == null || word.isEmpty()) {
            return getAllWordCards();
        } else {
            WordCard entity = repository.findByWord(word);
            if (entity == null) {
                throw  new WordCardNotFoundException(String.format("Word = '%s' not found", word));
            }
            return List.of(mapper.map(entity, WordCardResponseDTO.class));
        }
    }
}
