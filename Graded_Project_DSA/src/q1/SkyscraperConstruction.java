package q1;

import java.util.Scanner;

public class SkyscraperConstruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total number of floors in the building: ");
        int n = scanner.nextInt();

        int[] floors = new int[n];
        System.out.println("Enter the floor sizes given by factories on each day:");
        for (int i = 0; i < n; i++) {
            System.out.print("Day " + (i+1) + ": ");
            floors[i] = scanner.nextInt();
        }

        ConstructionAnalyzer analyzer = new ConstructionAnalyzer();
        String[] assemblyOrder = analyzer.getAssemblyOrder(floors);

        System.out.println("The order of construction is as follows:");
        for (int i = 0; i < n; i++) {
            System.out.print("Day " + (i+1) + ": ");
            if (assemblyOrder[i] == null) {
                System.out.println();
            } else {
                System.out.println(assemblyOrder[i]);
            }
        }

        scanner.close();
    }
}
