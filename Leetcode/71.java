class Solution {
    public String simplifyPath(String path) {
        String[] directories = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String dir:directories){
            if(dir.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(!dir.equals("") && !dir.equals(".")){
                stack.push(dir);
            }
        }
        StringBuilder builder = new StringBuilder("");
        while(!stack.isEmpty()){
            builder.insert(0,stack.pop());
            builder.insert(0,"/");
        }
        if(builder.length()==0){
            return "/";
        }
        return builder.toString();
    }
}
