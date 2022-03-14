import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Stack;

public class nser {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] ngl = solve(a);
        display(ngl);

        br.close();
    }

    public static int[] solve(int[] arr) {
        // solve
        int[] nse = new int[arr.length];
        nse[arr.length - 1] = -1;
        Stack<Integer> st = new Stack<>();
        st.push(arr.length - 1);

        for (int i = arr.length - 2; i >= 0; i--) {

            while (st.size() != 0 && arr[i] <= arr[st.peek()])
                st.pop();

            if (st.size() == 0)
                nse[i] = -1;

            else
                nse[i] = arr[st.peek()];

            st.push(i);
        }

        return nse;
    }

}