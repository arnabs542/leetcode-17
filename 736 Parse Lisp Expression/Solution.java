class Solution {
    // we should use recursion as expression is recursively defined
    // an expression can be an input of an expression
    public int evaluate(String expression) {
        Map<String, Integer> context = new HashMap<>();
        return evaluate(expression, context);
    }

    public int evaluate(String expression, Map<String, Integer> context) {
        // integer/variable
        if(!expression.startsWith("(")) {
            if (isVariable(expression)) {
                // varaible
                return (int)context.get(expression);
            } else {
                // integer
                return Integer.parseInt(expression);
            }
        }

        String expressionWoParentheses = expression.substring(1, expression.length() - 1);

        int result = 0;

        if (expressionWoParentheses.startsWith("let")) {
            // let
            List<String> params = getParam(expressionWoParentheses.substring(4, expressionWoParentheses.length()));
            Map<String, Integer> newContext = new HashMap<>(context);
            for(int i = 0; i < params.size(); i++) {
                if ((i + 1) < params.size()) {
                    // assign value to variable
                    newContext.put(params.get(i), evaluate(params.get(i + 1), newContext));
                    i++;
                } else {
                    // last expression
                    return evaluate(params.get(i), newContext);
                }
            }
        } else if (expressionWoParentheses.startsWith("add")) {
            // add
            List<String> params = getParam(expressionWoParentheses.substring(4, expressionWoParentheses.length()));
            String add1 = params.get(0);
            String add2 = params.get(1);
            result = evaluate(add1, context) + evaluate(add2, context);
        } else if (expressionWoParentheses.startsWith("mult")) {
            // mult
            List<String> params = getParam(expressionWoParentheses.substring(5, expressionWoParentheses.length()));
            String mult1 = params.get(0);
            String mult2 = params.get(1);
            result = evaluate(mult1, context) * evaluate(mult2, context);
        } else {
            // throw new Exception("Invalid operator");
        }

        return result;
    }

    private boolean isVariable(String expression) {
        return expression.charAt(0) >= 'a' && expression.charAt(0) <= 'z';
    }

    private List<String> getParam(String paramStr) {
        Stack<Character> stack = new Stack<>();
        List<String> params = new ArrayList<>();

        String curStr = "";
        for(int i = 0; i < paramStr.length(); i++) {
            char curChar = paramStr.charAt(i);

            // update stack
            if(curChar == '(') {
                stack.push('(');
            } else if(curChar == ')') {
                stack.pop();
            }

            if((curChar == ' ' || (i + 1) >= paramStr.length()) && stack.empty()) {
                if((i + 1) >= paramStr.length()) curStr += curChar;
                // push to param string
                params.add(curStr);
                curStr = "";
            } else {
                // update current string
                curStr += curChar;
            }
        }

        return params;
    }
}