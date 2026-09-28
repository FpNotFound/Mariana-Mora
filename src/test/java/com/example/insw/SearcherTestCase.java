package com.example.insw;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class SearcherTestCase {

    @Test
    void searchWord_whenWordExists_returnsTrue() {
        Searcher searcher = new Searcher();

        List<String> list = Arrays.asList(
                "java",
                "python",
                "c++"
        );

        boolean result = searcher.searchWord("java", list);

        assertTrue(result);
    }

    @Test
    void searchWord_whenWordDoesNotExist_returnsFalse() {
        Searcher searcher = new Searcher();

        List<String> list = Arrays.asList(
                "java",
                "python",
                "c++"
        );

        boolean result = searcher.searchWord("javascript", list);

        assertFalse(result);
    }

    @Test
    void getWordByIndex_whenIndexIsValid_returnsCorrectWord() {
        Searcher searcher = new Searcher();

        List<String> list = Arrays.asList(
                "java",
                "python",
                "c++"
        );

        String result = searcher.getWordByIndex(list, 1);

        assertEquals("python", result);
    }

    @Test
    void getWordByIndex_whenIndexIsNegative_returnsNull() {
        Searcher searcher = new Searcher();

        List<String> list = Arrays.asList(
                "java",
                "python",
                "c++"
        );

        String result = searcher.getWordByIndex(list, -1);

        assertNull(result);
    }

    @Test
    void getWordByIndex_whenIndexIsTooLarge_returnsNull() {
        Searcher searcher = new Searcher();

        List<String> list = Arrays.asList(
                "java",
                "python",
                "c++"
        );

        String result = searcher.getWordByIndex(list, 10);

        assertNull(result);
    }

    @Test
    void searchByPrefix_returnsWordsStartingWithPrefix() {
        Searcher searcher = new Searcher();

        List<String> list = Arrays.asList(
                "java",
                "javascript",
                "python",
                "javadoc",
                "c++"
        );

        List<String> result = searcher.searchByPrefix("java", list);

        assertEquals(
                Arrays.asList(
                        "java",
                        "javascript",
                        "javadoc"
                ),
                result
        );
    }

    @Test
    void searchByPrefix_doesNotIncludeWordsWithoutPrefix() {
        Searcher searcher = new Searcher();

        List<String> list = Arrays.asList(
                "java",
                "javascript",
                "python",
                "c++"
        );

        List<String> result = searcher.searchByPrefix("java", list);

        assertFalse(result.contains("python"));
        assertFalse(result.contains("c++"));
    }

    @Test
    void filterByKeyword_returnsElementsContainingKeyword() {
        Searcher searcher = new Searcher();

        List<String> list = Arrays.asList(
                "programacion java",
                "programacion python",
                "matematicas",
                "historia"
        );

        List<String> result =
                searcher.filterByKeyword("programacion", list);

        assertEquals(
                Arrays.asList(
                        "programacion java",
                        "programacion python"
                ),
                result
        );
    }

    @Test
    void filterByKeyword_whenKeywordDoesNotExist_returnsEmptyList() {
        Searcher searcher = new Searcher();

        List<String> list = Arrays.asList(
                "java",
                "python",
                "c++"
        );

        List<String> result =
                searcher.filterByKeyword("javascript", list);

        assertTrue(result.isEmpty());
    }

@Test
void searchExactPhrase_whenPhraseIsNotFirst_returnsTrue() {
    Searcher searcher = new Searcher();

    List<String> list = Arrays.asList(
            "hola",
            "mundo",
            "java"
    );

    boolean result = searcher.searchExactPhrase("mundo", list);

    assertTrue(result);
}

}
