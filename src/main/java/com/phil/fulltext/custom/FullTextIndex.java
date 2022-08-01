package com.phil.fulltext.custom;

import java.util.*;
import java.util.stream.Collectors;

public class FullTextIndex {
    private static HashMap<String, HashSet<Document>> index = new HashMap<>();
    private List<Document> documents;

    public FullTextIndex(List<Document> documents) {
        this.documents = documents;
        this.documents.forEach(this::addStringToIndex);
    }

    private void addStringToIndex(Document document) {
        for (String token : getTokens(document)) {
            if (index.containsKey(token)) {
                index.get(token).add(document);
            }
            else {
                var set = new HashSet<Document>();
                set.add(document);
                index.put(token, set);
            }
        }
    }

    public Set<Document> search(String text) {
        return index.get(text.toLowerCase());
    }

    private List<String> getTokens(Document document) {
        return Arrays.stream(document.getText().split("\\s"))
                .map(String::toLowerCase).collect(Collectors.toList());
    }
}
