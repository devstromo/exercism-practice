import java.util.stream.Collectors;
import java.util.stream.IntStream;

class BeerSong {

    public BeerSong() {
    }

    public String sing(int start, int count) {
        return IntStream.range(0, count)
          .mapToObj(i -> convert(start - i))
          .collect(Collectors.joining("\n")) + "\n";
    }

    public String singSong() {
        return sing(99, 100);
    }

    private String convert(int verse) {
        if (verse == 0) {
            return "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n";
        }
        var header = verse + " " + ((verse == 1) ? "bottle" : "bottles");
        var value = header + " of beer on the wall, " + header + " of beer.\n";
        if (verse - 1 == 0) {
            value += "Take it down and pass it around, no more bottles of beer on the wall.\n";
        } else {
            value += "Take one down and pass it around, " + (verse - 1) + " " + ((verse - 1 == 1) ? "bottle" : "bottles") + " of beer on the wall.\n";
        }
        return value;
    }
}
