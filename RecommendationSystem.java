import java.io.*;
import java.util.*;

/*
 * CODTECH Internship Task - 4
 * AI-Based Recommendation System
 *
 * Simple Collaborative Filtering
 * Suggests items based on similar users
 */

public class RecommendationSystem {

    // user -> (item -> rating)
    static Map<String, Map<String, Integer>> data = new HashMap<>();

    public static void main(String[] args) throws Exception {

        loadData("ratings.csv");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter user name: ");
        String user = sc.nextLine();

        recommend(user);

        sc.close();
    }

    // Load CSV file
    static void loadData(String fileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");

            String user = parts[0];
            String item = parts[1];
            int rating = Integer.parseInt(parts[2]);

            data.putIfAbsent(user, new HashMap<>());
            data.get(user).put(item, rating);
        }

        br.close();
    }

    // Recommend items
    static void recommend(String targetUser) {

        if (!data.containsKey(targetUser)) {
            System.out.println("User not found!");
            return;
        }

        Map<String, Integer> targetRatings = data.get(targetUser);
        Map<String, Integer> scores = new HashMap<>();

        // compare with other users
        for (String otherUser : data.keySet()) {

            if (otherUser.equals(targetUser))
                continue;

            Map<String, Integer> otherRatings = data.get(otherUser);

            for (String item : otherRatings.keySet()) {

                // recommend items not rated by target user
                if (!targetRatings.containsKey(item)) {
                    scores.put(item, scores.getOrDefault(item, 0) + otherRatings.get(item));
                }
            }
        }

        System.out.println("\n===== Recommended Items =====");

        scores.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(3)
                .forEach(e -> System.out.println(e.getKey()));
    }
              }
