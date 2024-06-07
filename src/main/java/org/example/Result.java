package org.example;

import java.util.List;

public class Result {
    private List<Item> items;
    private List<Integer> itemCounts;
    private int totalValue;
    private int totalWeight;

    public Result(List<Item> items, List<Integer> itemCounts, int totalValue, int totalWeight) {
        this.items = items;
        this.itemCounts = itemCounts;
        this.totalValue = totalValue;
        this.totalWeight = totalWeight;
    }

    public List<Integer> getItemCounts() {
        return itemCounts;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Selected items:\n");
        for (int i = 0; i < items.size(); i++) {
            if (itemCounts.get(i) > 0) {
                result.append(String.format("No: %d value: %d weight: %d count: %d%n",items.get(i).getIndex(), items.get(i).getValue(), items.get(i).getWeight(), itemCounts.get(i)));
            }
        }
        result.append(String.format("Total weight: %d%n", totalWeight));
        result.append(String.format("Total value: %d%n", totalValue));
        return result.toString();
    }
}
