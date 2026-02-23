package arrays;

public class Leet849MaxDistanceToClosest {

    public static void main(String[] args) {
        int[] seats = {1, 0, 0, 0, 0, 0, 1, 0, 1};
        System.out.println("Max distance to closest "+maxDistToClosest(seats));
    }

    private static int maxDistToClosest(int[] seats) {
        int maxDistance = 0;
        int lastOccupiedSeat = -1;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (lastOccupiedSeat == -1) {
                    maxDistance = i; // Span from the start to the first seated person
                } else {
                    int distance = (i - lastOccupiedSeat) / 2; // Distance between two seated individuals
                    maxDistance = Math.max(maxDistance, distance);
                }
                lastOccupiedSeat = i;
            }
        }

        // Check distance from the last seated person to the end of the row
        if (lastOccupiedSeat != -1) {
            maxDistance = Math.max(maxDistance, seats.length - 1 - lastOccupiedSeat);
        }

        return maxDistance;
    }
}
