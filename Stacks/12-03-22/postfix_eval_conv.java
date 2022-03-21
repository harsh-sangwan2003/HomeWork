import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Stack;

public class postfix_eval_conv {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {

            char ch = exp.charAt(i);

            if (Character.isDigit(ch)) {
                st.push(ch - '0');
                infix.push(ch + "");
                prefix.push(ch + "");
            }

            else {

                int v2 = st.pop();
                int v1 = st.pop();
                st.push(calc(v1, v2, ch));

                String prev2 = prefix.pop();
                String prev1 = prefix.pop();
                prefix.push(ch + prev1 + prev2);

                String inv2 = infix.pop();
                String inv1 = infix.pop();
                infix.push("(" + inv1 + ch + inv2 + ")");

            }
        }

        System.out.println(st.pop());
        System.out.println(infix.pop());
        System.out.println(prefix.pop());
    }

    public static int calc(int v1, int v2, char ch) {

        if (ch == '+')
            return v1 + v2;

        else if (ch == '-')
            return v1 - v2;

        else if (ch == '*')
            return v1 * v2;

        else
            return v1 / v2;
    }
}