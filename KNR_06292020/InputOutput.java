package inputOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class InputOutput {

	HashMap<String, Integer> opPriority;
	Stack<String> opStack, numStack;
	List<String> output = new ArrayList<>();
	List<String> inputString = new ArrayList<>();

    {
        /** �켱���� **/
        opPriority = new HashMap<>();
        opPriority.put("(", 0);
        opPriority.put("+",1);
        opPriority.put("-", 1);
        opPriority.put("*", 2);
        opPriority.put("/", 2);
        opPriority.put("m", 2);
        opPriority.put("^", 2);
        opPriority.put("l", 3);
        opPriority.put("e", 3);
        opPriority.put("!", 3);

        opStack = new Stack<>();
    }
    
    
    void operation() {
    	Double num1, num2 = 0.0;
    	numStack = new Stack<>();
    	Operation operation = new Operation();
    	
    	
    	
    	for(int i=0; i<output.size(); i++ ){
    		String s = output.get(i);
    		
    		if(isOperation(s)) {
    			
    			
    			switch(s) {
					case "+":
						num2 = Double.parseDouble(numStack.pop());
		    			num1 = Double.parseDouble(numStack.pop());
		    			
						num1 = operation.plus(num1, num2);
						numStack.add(num1+"");
						break;
					case "-":
						num2 = Double.parseDouble(numStack.pop());
		    			num1 = Double.parseDouble(numStack.pop());
		    			
						num1 = operation.minus(num1, num2);
						numStack.add(num1+"");
						break;
					case "*":
						num2 = Double.parseDouble(numStack.pop());
		    			num1 = Double.parseDouble(numStack.pop());
		    			
						num1 = operation.multiplication(num1, num2);
						numStack.add(num1+"");
						break;
					case "/":
						num2 = Double.parseDouble(numStack.pop());
		    			num1 = Double.parseDouble(numStack.pop());
		    			
						num1 = operation.division(num1, num2);
						numStack.add(num1+"");
						break;
					case "m":
						num2 = Double.parseDouble(numStack.pop());
		    			num1 = Double.parseDouble(numStack.pop());
		    			
						num1 = operation.mod(num1, num2);
						numStack.add(num1+"");
						break;
					case "^":
						num2 = Double.parseDouble(numStack.pop());
		    			num1 = Double.parseDouble(numStack.pop());
		    			
						num1 = operation.involutionFunction(num1, num2);
						numStack.add(num1+"");
						break;
					case "l":
						num2 = Double.parseDouble(numStack.pop());
						
						num1 = operation.commonLogFunction(num2);
						numStack.add(num1+"");
						break;
					case "e":
						num2 = Double.parseDouble(numStack.pop());
		    			
						num1 = operation.expFunction(num2);
						numStack.add(num1+"");
						break;
					case "!":
						num2 = Double.parseDouble(numStack.pop());
		    			
						num1 = operation.factorialFunction(num2);
						numStack.add(num1+"");
						break;
						
    			}
    			
    		}
    		else {
    			numStack.push(s);
    		}
    	}
    	
    	System.out.print(numStack.get(0));
    	
    }
    
    
    
    void inputOutput() {
    	
    	//�Է¹��� ����
        String input = "2*(21+3!)-6/2*(322*2!+31)";
        char[] inputChar = input.toCharArray();
        
        int i, lastIndex = 0;
        
        
        //�����ڿ� ���� �з�
        for (i=0; i<inputChar.length; i++) {
        	char c = input.charAt(i);
        	
        	//�������� ��
        	if(isOperation(c+"")) {
        		inputString.add(c+"");
        	}
        	//�ǿ������� ��
        	else {
        		lastIndex = inputString.size()-1;
        		
        		if(inputString.isEmpty() || isOperation(inputString.get(lastIndex))) {
        			inputString.add(c+"");
        		}
        		else {
        			inputString.set(lastIndex, inputString.get(lastIndex)+c);
        		}
        	}
        }
        
        
        
        //���� ��������� �����
        for (i=0; i<inputString.size(); i++){
            String s = inputString.get(i);
            

            //�������� ���
            if (isOperation(s)){
            	
                //���� ��ȣ�� ���
                //push
                if (s.equals("(")){
                    opStack.push(s);
                }
                //�ݴ� ��ȣ�� ���
                //���� ��ȣ�� ���ö����� pop
                else if (s == ")"){
                    String top = opStack.pop();
                    while (top != "("){
                        output.add(top);
                        top = opStack.pop();
                    }
                }
                //�� �� �������� ���
                else{
                	
                    //�켱������ ���ų� ������ pop                                    
                    while(!opStack.isEmpty() && opPriority.get(opStack.peek()) >= opPriority.get(s)) {
                    	output.add(opStack.pop());
                    } 
                    
                    //�켱������ ���ų� ������ ��������� push
                    opStack.push(s);
                 
                }
            }
            else{
            	
            	//�ǿ������� ���
                output.add(s);
                
                
                
                   
            }

        }
      //stack�� �����ִ� ������ ���
        while (!opStack.isEmpty()){
            output.add(opStack.pop());
        }
        System.out.print(output);


    }

    
  //������ ����
    boolean isOperation(String s){
        if(s.equals(")")){
            return true;
        }
        return opPriority.containsKey(s);
    }
    
    
	
}


