import java.util.*;

class TweetCounts {


    private Map<String, TreeMap<Integer, Integer>> map;

    public TweetCounts() {
        map = new HashMap<>();
    }
    
    public void recordTweet(String tweetName, int time) {
        map.putIfAbsent(tweetName, new TreeMap<>());
        TreeMap<Integer, Integer> timeMap = map.get(tweetName);
        timeMap.put(time, timeMap.getOrDefault(time, 0) + 1);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
    
        int interval;
        if (freq.equals("minute")) {
            interval = 60;
        } else if (freq.equals("hour")) {
            interval = 3600;
        } else { 
            interval = 86400;
        }

        
        int totalBuckets = ((endTime - startTime) / interval) + 1;
        int[] result = new int[totalBuckets];

        if (!map.containsKey(tweetName)) {
            List<Integer> list = new ArrayList<>();
            for (int count : result) list.add(count);
            return list;
        }

        TreeMap<Integer, Integer> timeMap = map.get(tweetName);
        

        Map<Integer, Integer> subMap = timeMap.subMap(startTime, true, endTime, true);

        for (Map.Entry<Integer, Integer> entry : subMap.entrySet()) {
            int time = entry.getKey();
            int count = entry.getValue();
            
            
            int bucketIndex = (time - startTime) / interval;
            result[bucketIndex] += count;
        }

        List<Integer> list = new ArrayList<>();
        for (int count : result) {
            list.add(count);
        }
        return list;
    }
}