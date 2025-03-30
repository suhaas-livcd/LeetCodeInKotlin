package greedy;


//{ Driver Code Starts //Initial Template for Java

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.solve(a);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// Driver Code Ends
// User function Template for Java
class Solution {
    public static int totalElements(Integer[] arr) {
        // code here
        int l = 0;
        int r = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (r < arr.length) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            if (map.size() > 2) { // Move l and remove
                map.put(arr[l], map.getOrDefault(arr[l], 0) - 1);

                if (map.get(arr[l]) < 0) {
                    map.remove(arr[l]);
                }
                l += 1;
            }

            if (map.size() <= 2) {
                max = Math.max(max, r - l + 1);
            }
            r += 1;
        }

        return max;
    }

    public int solve(int[] a) {
        return 0;
    }
}

