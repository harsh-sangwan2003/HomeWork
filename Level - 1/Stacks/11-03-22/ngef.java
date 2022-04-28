import java.util.Scanner;
import java.util.HashMap;
import java.util.Stack;

public class ngef {

    public static int[] freqArr(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int val : arr) {

            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        Stack<Integer> st = new Stack<>();
        int[] nge = new int[arr.length];
        nge[arr.length - 1] = -1;
        st.push(arr.length - 1);

        for (int i = arr.length - 2; i >= 0; i--) {

            while (st.size() != 0 && map.get(arr[i]) >= map.get(arr[st.peek()]))
                st.pop();

            if (st.size() == 0)
                nge[i] = -1;

            else
                nge[i] = arr[st.peek()];

            st.push(i);
        }

        return nge;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] res = freqArr(arr);

        for (int val : res)
            System.out.print(val + " ");

        scn.close();
    }
}