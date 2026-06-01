package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CountMentions3433 {
    int[] users;
    int[] mentions;
    int currTimestamp = 0;

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        // 0表示在线
        users = new int[numberOfUsers];
        mentions = new int[numberOfUsers];

        List<List<String>> sortableEvents = getLists(events);

        for (List<String> event: sortableEvents) {
            int timestamp = Integer.parseInt(event.get(1));
            currTimestamp = Math.max(timestamp, currTimestamp);

            if (event.getFirst().equals("MESSAGE")) {
                for (String message: event.get(2).split(" ")) {
                    handleMessage(message);
                }
            } else {
                int userId = Integer.parseInt(event.get(2));
                users[userId] = currTimestamp + 60;
            }
        }

        return mentions;
    }

    private static List<List<String>> getLists(List<List<String>> events) {
        List<List<String>> sortableEvents = new ArrayList<>(events);
        sortableEvents.sort(new Comparator<List<String>>() {
                @Override
                public int compare(List<String> o1, List<String> o2) {
                    int num1 = Integer.parseInt(o1.get(1));
                    int num2 = Integer.parseInt(o2.get(1));
                    int numCompare = Integer.compare(num1, num2);

                    if (num1 == num2) {
                        return o2.getFirst().compareTo(o1.getFirst());
                    }

                    return numCompare;
                }
            }
        );
        return sortableEvents;
    }

    private void handleMessage(String message){
        if (message.equals("ALL")) {
            for (int i = 0; i < mentions.length; i++) {
                mentions[i] += 1;
            }
        }
        else if (message.equals("HERE")){
            for (int i = 0; i < mentions.length; i++) {
                if (users[i] <= currTimestamp) {
                    mentions[i] += 1;
                }
            }
        }
        else {
            int userId = Integer.parseInt(message.split("id")[1]);
                mentions[userId] += 1;
        }
    }

    public static void main(String[] args) {
        List<List<String>> events = Arrays.asList(
                Arrays.asList("MESSAGE", "1", "id0 id1"),
                Arrays.asList("MESSAGE", "5", "id2"),
                Arrays.asList("MESSAGE", "6", "ALL"),
                Arrays.asList("OFFLINE", "5", "2")
        );
        CountMentions3433 alg = new CountMentions3433();
        System.out.println(Arrays.toString(alg.countMentions(3, events)));
    }
}
