class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String pathSeparator = "/";
        String[] folders = path.split(pathSeparator);
        for (String folder: folders) {
            if (folder.equals("..")) {
                if (!stack.empty()) stack.pop();
            } else if (!folder.equals(".") && !folder.equals("")) {
                stack.push(folder);
            }
        }

        return printPath(stack);
    }

    public String printPath(Stack<String> stack) {
        String result = "";
        String temp;
        while (!stack.empty()) {
            temp = stack.pop();
            result = "/" + temp + result;
        }
        return result == ""? "/": result;
    }
}
