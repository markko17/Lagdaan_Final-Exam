import java.util.Stack;

public class CreatureSortingAnalysisandStack {

    // variable declaring for creature and power level 
    static class Creature {
        String creature;
        int powerLevel;

        Creature(String creature, int powerLevel) {
            this.creature = creature;
            this.powerLevel = powerLevel;
        }

        @Override
        public String toString() {
            return creature + " - Power Level: " + powerLevel;
        }
    }

    // Bubble Sort in descending order
    public static void BubbleSortDescending(Creature[] creatures) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (creatures[j].powerLevel < creatures[j + 1].powerLevel) {
                    // Swap
                    Creature temp = creatures[j];
                    creatures[j] = creatures[j + 1];
                    creatures[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort in ascending order
    public static void selectionSortAscending(Creature[] creatures) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (creatures[j].powerLevel < creatures[minIndex].powerLevel) {
                    minIndex = j;
                }
            }
            // Swap
            Creature temp = creatures[minIndex];
            creatures[minIndex] = creatures[i];
            creatures[i] = temp;
        }
    }

    // Push sorted creatures onto a stack and pop them
    public static void useStack(Creature[] creatures) {
        Stack<Creature> stack = new Stack<>();

        // Push all creatures onto the stack
        for (Creature creature : creatures) {
            stack.push(creature);
        }

        // Pop and display each creature
        System.out.println("\nStack Implementation: Popping Creatures:");
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
    }

    public static void main(String[] args) {
        // Input data
        Creature[] creatures = {
            new Creature( "Dragon", 95),
            new Creature("Griffin", 88),
            new Creature("Unicorn", 78),
            new Creature("Phoenix", 92),
            new Creature("Centaur", 85),
        };

        // Bubble Sort - Descending Order
        Creature[] bubbleSortedCreatures = creatures.clone();
        BubbleSortDescending(bubbleSortedCreatures);
        System.out.println("**Bubble Sort: Descending Order by Power Level**");
        for (Creature creature : bubbleSortedCreatures) {
            System.out.println(creature);
        }

        // Selection Sort - Ascending Order
        Creature[] selectionSortedCreatures = creatures.clone();
        selectionSortAscending(selectionSortedCreatures);
        System.out.println("\n***Selection Sort: Ascending Order by Power Level***");
        for (Creature creature : selectionSortedCreatures) {
            System.out.println(creature);
        }

        // Stack Implementation using Bubble Sort result
        useStack(bubbleSortedCreatures);
    }
}