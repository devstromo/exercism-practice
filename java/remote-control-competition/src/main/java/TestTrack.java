import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.List;

public class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(ProductionRemoteControlCar prc1, ProductionRemoteControlCar prc2) {
        List<ProductionRemoteControlCar> cardsRanked = new ArrayList<>(List.of(prc1, prc2));
        sort(cardsRanked);
        return cardsRanked;
    }
}
