package de.ait.wordrepetitor.word_card.entity;

import de.ait.wordrepetitor.card_group.entity.CardGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "word_card")
public class WordCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "language")
    private String language;
    @Column(name = "word")
    private String word;
    @Column(name = "example")
    private String example;
    @Column(name = "translate_language")
    private String translateLanguage;
    @Column(name = "translation")
    private String translation;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name = "word_group",
                joinColumns = @JoinColumn(name = "word_id"),
                inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<CardGroup> groups;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordCard wordCard = (WordCard) o;
        return Objects.equals(id, wordCard.id) && Objects.equals(language, wordCard.language) && Objects.equals(word, wordCard.word) && Objects.equals(translateLanguage, wordCard.translateLanguage) && Objects.equals(translation, wordCard.translation);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(language);
        result = 31 * result + Objects.hashCode(word);
        result = 31 * result + Objects.hashCode(translateLanguage);
        result = 31 * result + Objects.hashCode(translation);
        return result;
    }

    @Override
    public String toString() {
        return "WordCard{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", word='" + word + '\'' +
                ", example='" + example + '\'' +
                ", translateLanguage='" + translateLanguage + '\'' +
                ", translation='" + translation + '\'' +
                ", groups=" + groups +
                '}';
    }
}
