package com.phil.fulltext.custom;

import java.util.List;
import java.util.Set;

public class FullTextSearchTest {
    public static void main(String[] args) {
        List<Document> documents = List.of(
                new Document("1", "Я вышел на опушку леса спустя час, " +
                        "но путешественников и след простыл."),
                new Document("2", "Вот ночная хищная птица голова у нее круглая " +
                        "клюв крючком когти острые Узнали ее это сова она живет в лесах " +
                        "или на чердаках домов ночью птица ловит мышей"),
                new Document("3", "Черепахи живут на земле и в воде они откладывают " +
                        "яйца прямо на камни черепахи не высиживают их яйца лопаются сами " +
                        "появляются маленькие черепашата а какого размера эти пресмыкающиеся " +
                        "черепахи бывают маленькие и очень большие"),
                new Document("4", "Он вдруг осознал: дальше не стоит и пытаться. "),
                new Document("4", "Кто желает — тот получит.")
        );
        FullTextIndex fullTextIndex = new FullTextIndex(documents);
        String text = "простыл.";
        Set<Document> documentSet = fullTextIndex.search(text);
        System.out.println(documentSet);
    }
}
