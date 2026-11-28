import java.util.*;

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeSet<String> foodItems = new TreeSet<>();
        TreeMap<Integer, Map<String, Integer>> tableOrders = new TreeMap<>();

        for (List<String> order : orders) {
            int tableNumber = Integer.parseInt(order.get(1));
            String foodItem = order.get(2);

            foodItems.add(foodItem);

            tableOrders.putIfAbsent(tableNumber, new HashMap<>());
            Map<String, Integer> itemCounts = tableOrders.get(tableNumber);
            itemCounts.put(foodItem, itemCounts.getOrDefault(foodItem, 0) + 1);
        }

        List<List<String>> result = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(foodItems);
        result.add(header);

        for (Map.Entry<Integer, Map<String, Integer>> entry : tableOrders.entrySet()) {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(entry.getKey()));
            
            Map<String, Integer> itemCounts = entry.getValue();
            for (String food : foodItems) {
                row.add(String.valueOf(itemCounts.getOrDefault(food, 0)));
            }
            
            result.add(row);
        }

        return result;
    }
}
