import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cat {
    public static void main(String[] args) {
        int[] arr  = new int[] {1, 2, 3, 1, 2, 2, 3, 3, 3, 1, 4, 4, 5};
        int a = findMaxLength(arr);
        System.out.println(a);
    }
    public static int findMaxLength(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, right = 0, maxLen = 0;
        while (right < arr.length) {
            freq.put(arr[right], freq.getOrDefault(arr[right], 0) + 1);
            while (left <= right && isBoring(freq)) {
                freq.put(arr[left], freq.get(arr[left]) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
    private static boolean isBoring(Map<Integer, Integer> freq) {
        Collection<Integer> counts = freq.values();
        int maxCount = Collections.max(counts);
        int minCount = Collections.min(counts);
        if (maxCount == minCount) {
            return true;
        }
        int maxCountFreq = Collections.frequency(counts, maxCount);
        int minCountFreq = Collections.frequency(counts, minCount);
        if (maxCountFreq == 1 && maxCount - 1 == minCount && minCountFreq == counts.size() - 1) {
            return true;
        }
        return minCountFreq == 1 && minCount == 1 && maxCountFreq == counts.size() - 1;
    }
}

