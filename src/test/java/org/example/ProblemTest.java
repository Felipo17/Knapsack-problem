package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class ProblemTest {

    @Test
    public void testAtLeastOneItemMeetsRestrictions() {
        Problem problem = new Problem(10, 1, 1, 10);
        Result result = problem.solve(15);
        assertTrue(result.getItemCounts().stream().anyMatch(count -> count > 0), "At least one item should meet the restrictions.");
    }

    @Test
    public void testNoItemsMeetsRestrictions() {
        Problem problem = new Problem(10, 1, 1, 10);
        Result result = problem.solve(1);
        assertTrue(result.getItemCounts().stream().allMatch(count -> count == 0), "No items should meet the restrictions");
    }

    @Test
    public void testItemsWithinRange() {
        Problem problem = new Problem(10, 1, 1, 10);
        List<Item> items = problem.getItems();
        for (Item item : items) {
            assertTrue(item.getValue() >= 1 && item.getValue() <= 10, "Item value should be within range 1-10.");
            assertTrue(item.getWeight() >= 1 && item.getValue() <= 10, "Item weight should be within range 1-10.");
        }
    }

    @Test
    public void testCorrectResultForGivenInstance() {
        Problem problem = new Problem(10, 1, 1, 10);
        Result result = problem.solve(15);
        assertEquals(15, result.getTotalWeight(), "Total weight should be 15.");
        assertEquals(33, result.getTotalValue(), "Total value should be 33.");
    }
}