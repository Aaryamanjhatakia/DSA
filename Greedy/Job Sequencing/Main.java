import java.io.*;
import java.lang.*;
import java.util.*;

class job {
    int id, profit, deadline;

    job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class solve {
    // return array of size 2 having the 0th element equal to the count and 1st ele
    // equal to max profit
    int[] JobScheduling(job arr[], int n) {
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

        int maxi = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxi) {
                maxi = arr[i].deadline;
            }
        }

        int result[] = new int[maxi + 1];

        for (int i = 0; i <= maxi; i++) {
            result[i] = -1;

        }

        int countJobs = 0, jobProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {
                // free slot found
                if (result[j] == -1) {
                    result[j] = i;
                    countJobs++;
                    jobProfit += arr[i].profit;
                    break;
                }
            }
        }

        int ans[] = new int[2];
        ans[0] = countJobs;
        ans[1] = jobProfit;
        return ans;
    }
}

class Main {
    public static void main(String[] args) throws IOException {

        // size of array
        job[] arr = new job[4];
        arr[0] = new job(1, 4, 20);
        arr[1] = new job(2, 1, 10);
        arr[2] = new job(3, 2, 40);
        arr[3] = new job(4, 2, 30);

        solve ob = new solve();

        // function call
        int[] res = ob.JobScheduling(arr, 4);
        System.out.println(res[0] + " " + res[1]);

    }
}