public class FootballMatchReports {
    public static String onField(int shirtNum) {
        if (shirtNum < 1 || shirtNum > 11) {
            throw new IllegalArgumentException();
        }
        switch (shirtNum) {
        case 1:
            return "goalie";
        case 2:
            return "left back";
        case 3:
        case 4:
            return "center back";
        case 5:
            return "right back";
        case 6:
        case 7:
        case 8:
            return "midfielder";
        case 9:
            return "left wing";
        case 10:
            return "striker";
        default:
            return "right wing";
        }
    }
}
