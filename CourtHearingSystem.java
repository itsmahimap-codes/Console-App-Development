import java.util.ArrayList;
import java.util.Scanner;

class Hearing {
    String caseNo, caseName, judge, date, time;

    Hearing(String caseNo, String caseName, String judge,
            String date, String time) {
        this.caseNo = caseNo;
        this.caseName = caseName;
        this.judge = judge;
        this.date = date;
        this.time = time;
    }

    void display() {
        System.out.println("\nCase No: " + caseNo);
        System.out.println("Case Name: " + caseName);
        System.out.println("Judge: " + judge);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
    }
}

public class CourtHearingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Hearing> hearings = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Court Hearing Scheduling System ---");
            System.out.println("1. Schedule Hearing");
            System.out.println("2. View Hearings");
            System.out.println("3. Search Hearing");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Case Number: ");
                String no = sc.nextLine();

                System.out.print("Case Name: ");
                String name = sc.nextLine();

                System.out.print("Judge Name: ");
                String judge = sc.nextLine();

                System.out.print("Hearing Date: ");
                String date = sc.nextLine();

                System.out.print("Hearing Time: ");
                String time = sc.nextLine();

                hearings.add(new Hearing(no, name, judge, date, time));
                System.out.println("Hearing scheduled successfully!");

            } else if (choice == 2) {

                if (hearings.isEmpty()) {
                    System.out.println("No hearings scheduled.");
                } else {
                    for (Hearing h : hearings)
                        h.display();
                }

            } else if (choice == 3) {

                System.out.print("Enter Case Number: ");
                String no = sc.nextLine();

                boolean found = false;

                for (Hearing h : hearings) {
                    if (h.caseNo.equalsIgnoreCase(no)) {
                        h.display();
                        found = true;
                    }
                }

                if (!found)
                    System.out.println("Hearing not found.");

            } else if (choice == 4) {
                System.out.println("Thank you!");
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
