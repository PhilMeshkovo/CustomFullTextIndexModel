package com.phil.fulltext.custom;

import java.util.List;
import java.util.Set;

public class FullTextSearchTest {
    public static void main(String[] args) {
        List<Document> documents = List.of(
                new Document("1", "Солнце только что встало " +
                        "небо ясное все вокруг блестит как хорошо на свежем воздухе слышишь пение " +
                        "жаворонка звонкий голосок слышен в ясной вышине"),
                new Document("2", "Вот ночная хищная птица голова у нее круглая " +
                        "клюв крючком когти острые Узнали ее это сова она живет в лесах " +
                        "или на чердаках домов ночью птица ловит мышей"),
                new Document("3", "Черепахи живут на земле и в воде они откладывают " +
                        "яйца прямо на камни черепахи не высиживают их яйца лопаются сами " +
                        "появляются маленькие черепашата а какого размера эти пресмыкающиеся " +
                        "черепахи бывают маленькие и очень большие"),
                new Document("4", "Белка бойко лазит по деревьям какая она ловкая на " +
                        "ушах у белки кисточки хвост длинный и пушистый зачем он ей белка " +
                        "прикрывается хвостом от холода он служит ей рулём при прыжках")
        );
        FullTextIndex fullTextIndex = new FullTextIndex(documents);
        String text = "у";
        Set<Document> documentSet = fullTextIndex.search(text);
        System.out.println(documentSet);
    }
}
