class Solution {
    public int calculate(String s) {
        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == ' ') continue;
            
            if(ch == '+' || ch == '-'){
                while(!operators.empty() && (operators.peek() == '+' || operators.peek() == '-' || operators.peek() == '*' || operators.peek() == '/')){
                    int second = operands.pop();
                    int first = operands.pop();
                    operands.push(evaluate(operators.pop(), first, second));
                }
                operators.push(ch);
            }
            else if(ch == '*' || ch == '/'){
                while(!operators.empty() && (operators.peek() == '*' || operators.peek() == '/')){
                    int second = operands.pop();
                    int first = operands.pop();
                    operands.push(evaluate(operators.pop(), first, second));
                }
                operators.push(ch);
            }
            else{
                StringBuilder num = new StringBuilder();
                char c = ch;
                while(c >= '0' && c <= '9'){
                    num.append(c);
                    if(i+1 < s.length() && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9'){
                        c = s.charAt(++i);
                    }
                    else break;
                }
                
                operands.push(Integer.parseInt(num.toString()));
            }
        }
        
        while(!operators.empty()){
            int second = operands.pop();
            int first = operands.pop();
            operands.push(evaluate(operators.pop(), first, second));
        }
        
        return operands.pop();
    }
    
    public int evaluate(char operator, int first, int second){
        int result = 0;
        switch(operator){
            case '+': 
                result = first + second;
                break;
            case '-': 
                result = first - second;
                break;
            case '*': 
                result = first * second;
                break;
            case '/': 
                result = first / second;
                break;
        }
        
        return result;
    }
}