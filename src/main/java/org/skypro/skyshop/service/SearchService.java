package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private StorageService storageService;


    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }



    public Set<SearchResult> search(String searchQuery){

        List<Searchable> allItems = storageService.getAllItems();

        System.out.println("Результаты поиска по: " + searchQuery);
        Set<SearchResult> results = allItems.stream()
                .filter(o -> o != null && o.getSearchTerm().toLowerCase().contains(searchQuery.toLowerCase()))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toCollection(() -> new TreeSet<>(searchableComparator)));

        return results;
    }

    private static final Comparator<SearchResult> searchableComparator = (e1, e2) -> {
        int nameLenghtCompare = Integer.compare(e2.getName().length(), e1.getName().length());
        if (nameLenghtCompare != 0) {
            return nameLenghtCompare;
        }
        return e1.getName().compareTo(e2.getName());
    };
}
