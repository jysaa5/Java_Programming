package team.project;


// String ���ڿ� ������ ���ڹ迭�� �����Ҷ�, ���ڿ� �����ڸ� �����Ͽ� �迭�濡 �����ϴ� �˰��� (1�ڸ� ���� �̻� ����, �Ҽ����϶� ���� �迭 �濡 �ֵ��� ���� ����)
public class Test {
	
	public static void main(String[] args) {
		
		//�Ҽ����� ����
		
        String input = "2.5*(20+3!)-6/2*(3*2!+1)";
        
        String[] inputChar = new String[input.length()];
        
        int j = 0;
        
        for(int i=0; i<input.length(); i++) {
      	          	
        	if(i>0) {
        		
      	  if(((Character.isDigit(input.charAt(i)) && Character.isDigit(input.charAt(i-1))))|| (input.charAt(i)=='.') || (input.charAt(i-1)=='.')) {
      		  inputChar[j] += input.charAt(i);
      	  }else {
      		  j++;
      		 inputChar[j] =  Character.toString(input.charAt(i));
      	  }
        	}else if(i==0) {
        		
          	  if(Character.isDigit(input.charAt(i))){
          		
        		  inputChar[j] = Character.toString(input.charAt(i));
        	  
        	  }else {
        		  j++;
           		 inputChar[j] =  Character.toString(input.charAt(i));
        	  }
        		
        		
        	}
        }
        
        
        
        
        
        for(String str: inputChar ) {
        	System.out.println(str);
        }
        
		
	}

}
