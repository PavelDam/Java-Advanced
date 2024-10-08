package _01_WorkingWithAbstraction.Exercise.P06_GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Bag {
    private long bagCapacity;
    private Map<String, LinkedHashMap<String, Long>> bag;

    public Bag(long bagCapacity) {
        this.bagCapacity = bagCapacity;
        this.bag = new LinkedHashMap<>();
    }

    public void add( long amount, String currentItem) {
        String itemName = getItemName(currentItem);

        if (checkAmountsOfItems(itemName, amount)) {
            if (!bag.containsKey(itemName)) {
                bag.put((itemName), new LinkedHashMap<>());
            }

            if (!bag.get(itemName).containsKey(currentItem)) {
                bag.get(itemName).put(currentItem, 0L);
            }

            bag.get(itemName).put(currentItem, bag.get(itemName).get(currentItem) + amount);

        }
    }
    private boolean isFull(long amount) {
        return bagCapacity < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + amount;
    }

    private boolean checkName(String itemName) {
        return itemName == null;
    }

    private boolean checkAmountsOfItems(String itemName, long amount) {
        if (!isFull(amount)&& !checkName(itemName)) {
            switch (itemName) {
                case "Gem":
                    if (!bag.containsKey(itemName)) {
                        if (bag.containsKey("Gold")) {
                            if (amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else if (bag.get(itemName).values().stream().mapToLong(e -> e).sum() + amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        return false;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(itemName)) {
                        if (bag.containsKey("Gem")) {
                            if (amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else if (bag.get(itemName).values().stream().mapToLong(e -> e).sum() + amount > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        return false;
                    }
                    break;
            }
            return true;
        }
        return false;
    }
    private  String getItemName(String currentItem) {
        String itemName = null;

        if (currentItem.length() == 3) {
            itemName = "Cash";
        } else if (currentItem.toLowerCase().endsWith("gem")) {
            itemName = "Gem";
        } else if (currentItem.toLowerCase().equals("gold")) {
            itemName = "Gold";
        }
        return itemName;
    }

    public void print() {
        StringBuilder builder = new StringBuilder();
        if (!bag.isEmpty()) {
            for (var item : bag.entrySet()) {
                Long sumValues = item.getValue().values().stream().mapToLong(l -> l).sum();

                builder.append(String.format("<%s> $%s", item.getKey(), sumValues)).append(System.lineSeparator());

                item.getValue().entrySet().stream()
                        .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                        .forEach(i -> builder.append(String.format("##" + i.getKey() + " - " + i.getValue())).append(System.lineSeparator()));
            }
            System.out.println(builder);
        }
    }
}
