package de.ait.wordrepetitor.word_card.controller;

import de.ait.wordrepetitor.card_group.entity.CardGroup;
import de.ait.wordrepetitor.word_card.dto.WordCardRequestDTO;
import de.ait.wordrepetitor.word_card.dto.WordCardResponseDTO;
import de.ait.wordrepetitor.word_card.service.WordCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cards")
public class WordCardController {
    private final WordCardService service;

    @GetMapping("/{id}")
    public WordCardResponseDTO getCardById(@PathVariable Long id) {
        return service.getById(id);
    }
    @GetMapping
    public List<WordCardResponseDTO> getWordCards(@RequestParam(name = "word", required = false) String word) {
        return service.getWordCards(word);
    }

    @PostMapping
    public WordCardResponseDTO createWordCard(@RequestBody WordCardRequestDTO dto) {
        return service.createWordCard(dto);
    }

    @PutMapping("/{id}")
    public WordCardResponseDTO updateWordCard(@PathVariable(name = "id") Long id, @RequestBody WordCardRequestDTO dto) {
        return service.updateWordCard(id, dto);
    }

    @GetMapping("/{cardId}/groups")
    public List<CardGroup> getGroupsByCardId(@PathVariable Long cardId) {
        return service.getGroupsByCardId(cardId);
    }
}
