import java.util.Scanner;

public class jobscheduling {
    public static void main(String[] args) {
        int n;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number of Processes: ");
        n = sc.nextInt();

        int at[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the Arrival time: ");
            at[i] = sc.nextInt();
        }

        int bt[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the Burst time: ");
            bt[i] = sc.nextInt();
        }

        // completion time logic
        int ct[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ct[i] = at[i] + bt[i];
            } else {
                if (at[i] > ct[i - 1]) {
                    ct[i] = at[i] + bt[i];
                } else
                    ct[i] = ct[i - 1] + bt[i];
            }
        }

        // turn around time logic
        int tat[] = new int[n];
        for (int i = 0; i < n; i++) {
            tat[i] = ct[i] - at[i];
        }

        int wt[] = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = tat[i] - bt[i];
        }

        System.out.println();
        System.out.println("process No.\tArrival Time\tBurst Time\tCompletion Time\t"
                + "TurnAroundTime\tWaitingTime");
        System.out.println("--------------------------------------------------------"
                + "---------------------------");

        float total_tat = 0;
        float total_wt = 0;

        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "\t\t" + at[i] + "\t\t" + bt[i] + "\t\t" + ct[i] +
                    "\t\t" + tat[i] + "\t\t" + wt[i]);

            System.out.println();
            total_tat += tat[i];

            total_wt += wt[i];
        }

        System.out.println("Average Turn Around Time: " + total_tat / n);
        System.out.println("Average Waiting Time: " + total_wt / n);

    }
}
