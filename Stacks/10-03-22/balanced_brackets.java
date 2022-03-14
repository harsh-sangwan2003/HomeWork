import java.util.Scanner;
import java.util.Stack;

public class balanced_brackets {

    public static boolean isValid(String s) {

        Stack<Character> st = new Stack<>();
        boolean flag = true;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[')
                st.push(ch);

            else if (ch == ')') {

                flag = handle(st, '(');

                if (!flag)
                    return false;
            }

            else if (ch == '}') {

                flag = handle(st, '{');

                if (!flag)
                    return false;
            }

            else if (ch == ']') {

                flag = handle(st, '[');

                if (!flag)
                    return false;
            }
        }

        if (st.size() == 0)
            return true;

        return false;
    }

    public static boolean handle(Stack<Character> st, char ch) {

        if (st.size() == 0)
            return false;

        if (st.peek() != ch)
            return false;

        st.pop();
        return true;
    }

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        boolean ans = isValid(str);

        if (ans)
            System.out.println("true");

        else
            System.out.println("false");

        scn.close();
    }

}