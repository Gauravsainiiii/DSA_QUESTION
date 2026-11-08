import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    private static class CheckInInfo {
        String stationName;
        int checkInTime;
        
        CheckInInfo(String stationName, int checkInTime) {
            this.stationName = stationName;
            this.checkInTime = checkInTime;
        }
    }
    private static class RouteStats {
        double totalTime;
        int tripCount;
        
        RouteStats(double totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }
    private final Map<Integer, CheckInInfo> checkInMap;
    private final Map<String, RouteStats> routeStatsMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeStatsMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo checkIn = checkInMap.remove(id);
        
        String startStation = checkIn.stationName;
        int startTime = checkIn.checkInTime;
        int travelTime = t - startTime;
        String routeKey = startStation + "->" + stationName;
        RouteStats stats = routeStatsMap.getOrDefault(routeKey, new RouteStats(0.0, 0));
        stats.totalTime += travelTime;
        stats.tripCount += 1;
        
        routeStatsMap.put(routeKey, stats);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteStats stats = routeStatsMap.get(routeKey);
        return stats.totalTime / stats.tripCount;
    }
}
