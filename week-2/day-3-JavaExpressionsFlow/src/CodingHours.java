public class CodingHours {
    public static void main(String[] args) {
        int codingWeekWorkdays = 5;
        int codingHoursOfStudent = 6;
        int semesterOfStudent = 17;
        int studentHours = codingHoursOfStudent * codingWeekWorkdays * semesterOfStudent;
        int standardHours = 52 * semesterOfStudent;

        System.out.println("Coding hours of student during semester: " + studentHours);
        System.out.println("Average % of coding hours in the semester is: " + ((float) studentHours / standardHours * 100) + "%");
    }
}
