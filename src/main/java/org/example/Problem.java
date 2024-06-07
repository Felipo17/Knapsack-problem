package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem {
    private int n;
    private int seed;
    private int lowerBound;
    private int upperBound;
    private List<Item> items;

    public Problem(int n, int seed, int lowerBound, int upperBound) {
        this.n = n;
        this.seed = seed;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.items = new ArrayList<>();
        generateItems();
    }

    private void generateItems() {
        Random random = new Random(seed);
        for (int i = 0; i < n; i++) {
            int value = lowerBound + random.nextInt(upperBound - lowerBound + 1);
            int weight = lowerBound + random.nextInt(upperBound - lowerBound + 1);
            items.add(new Item(value, weight, i));
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public void printItems() {
        for (Item item : items) {
            System.out.printf("No: %d value: %d weight: %d%n", item.getIndex(), item.getValue(), item.getWeight());
        }
    }

    public Result solve(int capacity) {
        items.sort((i1, i2) -> Double.compare(i2.getValueToWeightRatio(), i1.getValueToWeightRatio()));
        List<Integer> itemCounts = new ArrayList<>();
        int totalValue = 0;
        int totalWeight = 0;

        for (Item item : items) {
            int count = 0;
            while (totalWeight + item.getWeight() <= capacity) {
                totalWeight += item.getWeight();
                totalValue += item.getValue();
                count++;
            }
            itemCounts.add(count);
        }

        return new Result(items, itemCounts, totalValue, totalWeight);
    }

    @Override
    public String toString() {
        return "Problem{" +
                "items=" + items +
                '}';
    }
}
