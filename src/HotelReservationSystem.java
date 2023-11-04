import java.util.concurrent.*;
import java.util.*;

public class HotelReservationSystem {
    
    static class Hotel {
        private final Set<Integer> availableRooms;

        public Hotel(int totalRooms) {
            this.availableRooms = ConcurrentHashMap.newKeySet(totalRooms);
            for (int i = 1; i <= totalRooms; i++) {
                availableRooms.add(i);
            }
        }

        public boolean bookRoom() {
            Iterator<Integer> iterator = availableRooms.iterator();
            if (iterator.hasNext()) {
                int room = iterator.next();
                iterator.remove();
                System.out.println("Room " + room + " booked!");
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        final Hotel hotel = new Hotel(100);  // Hotel with 5 rooms
        ExecutorService executor = Executors.newFixedThreadPool(10);  // 10 guests trying to book concurrently

        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                if (hotel.bookRoom()) {
                    System.out.println(Thread.currentThread().getName() + ": Successfully booked a room!");
                } else {
                    System.out.println(Thread.currentThread().getName() + ": No rooms available!");
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Reservation system shutdown.");
    }
}
