package core_java.assigment_problems;

public class WarehouseInventoryBalancer {

    /**
     * Analyzes inventory across two sections, checking balance and finding highest-quantity item.
     *
     * @param sectionA Item quantities in Section A
     * @param sectionB Item quantities in Section B
     */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null) {
            System.out.println("Invalid inventory data.");
            return;
        }

        int totalA = 0;
        int totalB = 0;

        int maxQuantity = Integer.MIN_VALUE;
        String maxSection = "";
        int maxItemIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxQuantity) {
                maxQuantity = sectionA[i];
                maxSection = "Section A";
                maxItemIndex = i + 1; // 1-based item index
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > maxQuantity) {
                maxQuantity = sectionB[i];
                maxSection = "Section B";
                maxItemIndex = i + 1; // 1-based item index
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, maxQuantity, maxSection, maxItemIndex);
    }

    public static void main(String[] args) {
        System.out.println("--- Warehouse Inventory Balancer ---");
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        System.out.println("Sample Test:");
        analyzeInventory(sectionA, sectionB);

        System.out.println("\nUnbalanced Test:");
        int[] secA2 = {40, 20, 10};
        int[] secB2 = {30, 20, 5};
        analyzeInventory(secA2, secB2);
    }
}
