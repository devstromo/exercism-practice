public class ExperimentalRemoteControlCar implements RemoteControlCar {
    int race;

    public void drive() {
        race++;
    }

    public int getDistanceTravelled() {
        return race * 20;
    }
}
