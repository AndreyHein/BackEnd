package de.ait.wordrepetitor.card_group.controller;

import de.ait.wordrepetitor.card_group.entity.CardGroup;
import de.ait.wordrepetitor.card_group.service.CardGroupService;
import de.ait.wordrepetitor.word_card.dto.WordCardResponseDTO;
import de.ait.wordrepetitor.word_card.entity.WordCard;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/groups")
public class CardGroupController {

    private final CardGroupService service;
    private final ModelMapper mapper;

    @GetMapping
    public List<CardGroup> getCardGroups() {
        return service.getAllGroups();
    }

    @GetMapping("/{id}")
    public CardGroup getCardGroupById(@PathVariable Long id) {
        return service.getGroupById(id);
    }

    @PostMapping
    public CardGroup addCardGroup(@RequestBody CardGroup group) {
        return service.createNewGroup(group);
    }

    @PutMapping("/{id}")
    public CardGroup updateCardGroup(@PathVariable Long id, @RequestBody CardGroup group) {
        return service.updateGroup(id, group);
    }

    @DeleteMapping("/{id}")
    public CardGroup deleteCardGroup(@PathVariable Long id) {
        return service.deleteGroup(id);
    }

    @GetMapping("/{groupId}/cards")
    public List<WordCardResponseDTO> getWordCardsByGroupId(@PathVariable Long groupId) {
        return service.getWordCardsByGroupId(groupId);
    }
}
