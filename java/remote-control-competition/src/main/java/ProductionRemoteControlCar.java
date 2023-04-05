class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    int race;

    int numberOfVictories;

    public void drive() {
        race++;
    }

    public int getDistanceTravelled() {
        return race * 10;
    }

    public int getNumberOfVictories() {
        throw new UnsupportedOperationException("Please implement the ProductionRemoteControlCar.getNumberOfVictories() method");
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar other) {
        return Integer.compare(numberOfVictories, other.numberOfVictories);
    }
}
