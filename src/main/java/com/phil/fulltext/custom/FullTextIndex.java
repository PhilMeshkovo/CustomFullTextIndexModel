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
            token = token.replaceAll("\\p{Punct}", "").trim();
            if (token.length() == 0) {
                continue;
            }
            if (index.containsKey(token)) {
                index.get(token).add(document);
            } else {
                var set = new HashSet<Document>();
                set.add(document);
                index.put(token, set);
            }
        }
    }

    public Set<Document> search(String text) {
        Set<Document> documentSet = new HashSet<>();
        String[] splitedText = text.split("\\s");
        for (String string : splitedText) {
            string = string.replaceAll("\\p{Punct}", "").trim();
            if (string.length() == 0) {
                continue;
            }
            documentSet.addAll(index.getOrDefault(string.toLowerCase(), new HashSet<>()));
        }
        return documentSet;
    }

    private List<String> getTokens(Document document) {
        return Arrays.stream(document.getText().split("\\s"))
                .map(String::toLowerCase).collect(Collectors.toList());
    }
}
