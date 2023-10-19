package edu.hw3.task2;

import java.util.ArrayList;
import java.util.List;

public class BracketCluster {
    public static List<String> clusterizeString(String s) {
        if(s == null)
        {
            return List.of();
        }
        List<String> clusters = new ArrayList<>();
        StringBuilder currentCluster = new StringBuilder();
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else if (c == ')' && cnt > 0) {
                cnt--;
            }
            currentCluster.append(c);
            if (cnt == 0) {
                clusters.add(currentCluster.toString());
                currentCluster.setLength(0);
            }
        }

        return clusters;
    }
}
