public class SecondsInADay {
    public static void main(String[] args) {
        int currentHours = 14;
        int currentMinutes = 34;
        int currentSeconds = 42;
        int remainingSeconds = ((24%14)*60*60) + ((60%34)*60) + (60%42);
        System.out.println(remainingSeconds);

    }
}
