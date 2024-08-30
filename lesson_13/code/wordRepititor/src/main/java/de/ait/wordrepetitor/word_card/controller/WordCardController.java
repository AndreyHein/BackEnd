package de.ait.wordrepetitor.word_card.controller;

import de.ait.wordrepetitor.word_card.dto.WordCardRequestDTO;
import de.ait.wordrepetitor.word_card.dto.WordCardResponseDTO;
import de.ait.wordrepetitor.word_card.service.WordCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class WordCardController {
    private final WordCardService service;

    @GetMapping("/word_cards/{id}")
    public WordCardResponseDTO getCardById(@PathVariable Long id) {
        return service.getById(id);
    }
    @GetMapping("/word_cards")
    public List<WordCardResponseDTO> getWordCards(@RequestParam(name = "word", required = false) String word) {
        return service.getWordCards(word);
    }

    @PostMapping("/word_cards")
    public WordCardResponseDTO createWordCard(@RequestBody WordCardRequestDTO dto) {
        return service.createWordCard(dto);
    }

    @PutMapping("/word_cards/{id}")
    public WordCardResponseDTO updateWordCard(@PathVariable(name = "id") Long id, @RequestBody WordCardRequestDTO dto) {
        return service.updateWordCard(id, dto);
    }


}
