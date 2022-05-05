import by.epam.lab.BusinessTrip;

public class Runner {

    public static void main(String[] args) {

        BusinessTrip[] trips = {new BusinessTrip("Anton", 5, 7),
                new BusinessTrip("Lena", 305, 101),
                null,
                new BusinessTrip("Dima", 100, 3),
                new BusinessTrip()};

        BusinessTrip maxTotalCost = trips[0];
        for (BusinessTrip trip : trips) {
            if (trip != null) {
                trip.show();
                if (trip.getTotalCoast() > maxTotalCost.getTotalCoast()) {
                    maxTotalCost = trip;
                }
            }
        }
        System.out.println("Max = " + maxTotalCost + "\n");
        trips[trips.length - 1].setTransportCost(150);
        System.out.println("Duration = " + (trips[0].getDays() + trips[1].getDays()) + "\n");
        for (BusinessTrip trip : trips) {
            System.out.println(trip);
        }
    }
}
