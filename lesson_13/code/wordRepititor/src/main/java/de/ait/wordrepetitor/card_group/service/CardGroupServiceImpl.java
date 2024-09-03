package de.ait.wordrepetitor.card_group.service;

import de.ait.wordrepetitor.card_group.entity.CardGroup;
import de.ait.wordrepetitor.card_group.repository.CardGroupRepository;
import de.ait.wordrepetitor.exception.GroupNotFoundException;
import de.ait.wordrepetitor.word_card.dto.WordCardResponseDTO;
import de.ait.wordrepetitor.word_card.entity.WordCard;
import de.ait.wordrepetitor.word_card.repository.WordCardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CardGroupServiceImpl implements CardGroupService {

    private final CardGroupRepository groupRepository;
    private final ModelMapper mapper;

    @Override
    @Transactional
    public CardGroup createNewGroup(CardGroup group) {
        return groupRepository.save(group);
    }

    @Override
    public CardGroup getGroupById(Long id) {
        return groupRepository.findById(id).orElseThrow(() -> new GroupNotFoundException(String.format("Product id %d not found", id)));
    }

    @Override
    public List<CardGroup> getAllGroups() {
        return groupRepository.findAll();
    }


    @Override
    public List<WordCardResponseDTO> getWordCardsByGroupId(Long groupId) {
        CardGroup group = getGroupById(groupId);
        return group.getCards().stream()
                .map(card -> mapper.map(card, WordCardResponseDTO.class))
                .toList();
    }

    @Override
    @Transactional
    public CardGroup updateGroup(Long id, CardGroup group) {
        CardGroup entity = getGroupById(id);
        if (entity == null) {
            throw new GroupNotFoundException(String.format("Product id %d not found", id));
        }
        entity.setTitle(group.getTitle());
        return groupRepository.save(entity);
    }
    @Override
    @Transactional
    public CardGroup deleteGroup(Long id) {
        CardGroup entity = getGroupById(id);
        groupRepository.delete(entity);
        return entity;
    }
}
