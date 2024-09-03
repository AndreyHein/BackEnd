package de.ait.wordrepetitor.card_group.service;

import de.ait.wordrepetitor.card_group.entity.CardGroup;
import de.ait.wordrepetitor.word_card.dto.WordCardResponseDTO;
import de.ait.wordrepetitor.word_card.entity.WordCard;

import java.util.List;
import java.util.Set;

public interface CardGroupService {
    CardGroup createNewGroup(CardGroup group);
    CardGroup getGroupById(Long id);
    List<CardGroup> getAllGroups();
    List<WordCardResponseDTO> getWordCardsByGroupId(Long groupId);
    CardGroup updateGroup(Long id, CardGroup group);
    CardGroup deleteGroup(Long id);
}
