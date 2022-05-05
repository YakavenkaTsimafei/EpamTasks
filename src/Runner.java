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
            if (trip == null) {
                continue;
            }
            if (trip.getTotalCoast() > maxTotalCost.getTotalCoast()) {
                maxTotalCost = trip;
            }
            trip.show();
        }
        trips[trips.length - 1].setTransportCost(150);
        for (BusinessTrip trip : trips) {
            System.out.println(trip);
        }
        System.out.println("\nMax = " + maxTotalCost);
        trips[trips.length - 1].setTransportCost(150);
        System.out.println("\nDuration = " + (trips[0].getDays() + trips[1].getDays()));
    }
}
