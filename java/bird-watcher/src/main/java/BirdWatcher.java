import java.util.Arrays;

class BirdWatcher {
    private final int[] birdsPerDay;
    private final int[] temp;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
        this.temp = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return birdsPerDay;
    }

    public int getToday() {
        return temp[temp.length - 1];
    }

    public void incrementTodaysCount() {
        temp[temp.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        return Arrays.stream(temp)
          .anyMatch(birdCount -> birdCount == 0);
    }

    public int getCountForFirstDays(int numberOfDays) {
        return Arrays.stream(temp)
          .limit(numberOfDays)
          .sum();
    }

    public int getBusyDays() {
        return (int) Arrays.stream(temp)
          .filter(birdCount -> birdCount > 4)
          .count();
    }
}
