import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Stack;

public class prefix_eval_conv {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // code

        Stack<String> in = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<Integer> st = new Stack<>();

        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                in.push(ch + "");
                post.push(ch + "");
                st.push(ch - '0');
            }

            else {
                String inv1 = in.pop();
                String inv2 = in.pop();
                in.push("(" + inv1 + ch + inv2 + ")");

                String postv1 = post.pop();
                String postv2 = post.pop();
                post.push(postv1 + postv2 + ch);

                int v1 = st.pop();
                int v2 = st.pop();
                st.push(operation(v1, v2, ch));
            }
        }

        System.out.println(st.pop());
        System.out.println(in.pop());
        System.out.println(post.pop());

        br.close();
    }

    public static int operation(int v1, int v2, char op) {

        if (op == '+')
            return v1 + v2;

        else if (op == '-')
            return v1 - v2;

        else if (op == '*')
            return v1 * v2;

        else
            return v1 / v2;
    }
}