package de.ait.wordrepetitor.word_card.controller;

import de.ait.wordrepetitor.word_card.dto.WordCardRequestDTO;
import de.ait.wordrepetitor.word_card.dto.WordCardResponseDTO;
import de.ait.wordrepetitor.word_card.service.WordCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WordCardController {
    private final WordCardService service;

    @GetMapping("/api/word_cards")
    public List<WordCardResponseDTO> getWordCards() {
        return service.getAllWordCards();
    }

    @PostMapping("/api/word_cards")
    public WordCardResponseDTO createWordCard(@RequestBody WordCardRequestDTO dto) {
        return service.createWordCard(dto);
    }
}
