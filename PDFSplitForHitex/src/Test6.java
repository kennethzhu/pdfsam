
public class Test6 {

	
	public static String reverse(String s){
		StringBuffer sbr=new StringBuffer();
		for(int i=0;i<s.length();i++){
			sbr.append(s.charAt(s.length()-i-1));
		}
			
		return sbr.toString();
		
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int int1,int2;
		if(args.length<=0){
			System.out.print(" please input a number");
			return;
		}
		for(int i=0;i<args.length;i++){
			try{
			 int1=Integer.parseInt(args[i]);
		 int2=Integer.parseInt(reverse(args[i]));
			}
			catch(Exception e){
//				e.printStackTrace();
				continue;
			}
		if(int1==int2){
			System.out.println("yes"+"  "+args[i]);
		}
			
		}

	}

}
