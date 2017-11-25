package ba.enox.zal;
import java.util.ArrayList;
import java.util.List;

public class SplitMessages {

    public int solution(String s, int k) {
        String[] words = s.split(" ");

        List<String> message = new ArrayList<>();
        List<List<String>> parts = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            final String currentWord = words[i];
            if (currentWord.length() > k) {
                return -1;
            }

            if ((numberOfCharacters(createList(message, currentWord)) > k && message.size() > 0)) {
                parts.add(new ArrayList<>(message));
                message.clear();
                i--;
                continue;
            }

            if (i == words.length - 1) {
                parts.add(addWord(new ArrayList<>(), currentWord));
                continue;
            }

            message = addWord(message, currentWord);
        }

        return parts.size();
    }

    private List<String> addWord(List<String> message, String word) {
        List<String> newMessage = new ArrayList<>(message);
        newMessage.add(word);
        newMessage.add(" ");
        return newMessage;
    }

    private int numberOfCharacters(List<String> words) {
        return words.stream().mapToInt(String::length).sum();
    }

    private List<String> createList(List<String> list, String element) {
        List<String> newList = new ArrayList<>(list);
        newList.add(element);
        return newList;
    }

}