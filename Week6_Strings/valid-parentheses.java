class Solution {
    public boolean isValid(String s) {
        /* Complement map to map bracket to its conjugate */
        Map<Character, Character> complement = new HashMap<>();
        complement.put('(', ')');
        complement.put('[', ']');
        complement.put('{', '}');
        
        /* Initialize stack */
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            /**
             * If character classified as left bracket
             * push it into the stack
             */ 
            if (complement.containsKey(ch)) {
                stk.add(ch);
            }
            /* In this branch, ch is a right bracket */
            else {
                /* No available matching left brackets */
                if (stk.isEmpty()) return false;
                char comp = stk.pop();
                /**
                 * Check if left bracket popped from stack
                 * is indeed a suitable complement
                 */
                if (complement.get(comp) != ch) return false;
            }
        }
        
        /* No stray left brackets */
        return stk.isEmpty();
    }
}