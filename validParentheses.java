class Solution {
       public static boolean isValid(String s) {
        Stack<Character> openStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                openStack.push(c);
            } else {
                if (openStack.isEmpty()) {
                    return false;
                } else {
                    int tmp;
                    if (c == ')') {
                        tmp = 1;
                    } else {
                        tmp = 2;
                    }

                    char checkChar = (char) (openStack.pop() + tmp);

                    if (checkChar != c) {
                        return false;
                    }
                }
            }
        }
        if (!openStack.isEmpty()) {
            return false;
        }
        return true;
    }
}