package q1;

import java.util.*;

public class ConstructionAnalyzer {
    public String[] getAssemblyOrder(int[] floors) {
        int n = floors.length;
        String[] assemblyOrder = new String[n];

        PriorityQueue<Integer> unplacedFloors = new PriorityQueue<>(Collections.reverseOrder());
        Stack<Integer> placedFloors = new Stack<>();

        for (int i = 0; i < n; i++) {
            unplacedFloors.add(floors[i]);
            while (!unplacedFloors.isEmpty() && unplacedFloors.peek() == placedFloors.size() + 1) {
                int floor = unplacedFloors.poll();
                placedFloors.push(floor);
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < placedFloors.size(); j++) {
                sb.append(placedFloors.get(j)).append(" ");
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
                assemblyOrder[i] = sb.toString();
            }
        }
        return assemblyOrder;
    }
}
