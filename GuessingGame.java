package exercise2;
import java.util.Scanner;
public class GuessingGame {
	public static void main(String[] args){
		char[] chs = generate();
		Scanner sc = new Scanner(System.in);
		int count=0;
		int score;
		while(true){
			System.out.println("Let's guess!");
			String str =sc.next().toUpperCase();
			if(str.equals("EXIT")){
				System.out.println("THANK YOU!");
				break;
			}
			char[] input = str.toCharArray();
			int[] result=check(chs,input);
			if(result[0]==5){
				score = chs.length*100-count*10;
				System.out.println("congratulations!your score "+score);
			}else{
					System.out.println("You've got "+result[1]+" of the letters!"+result[0]+"of them set in their position!");
					System.out.println("EXIT______to exit the game.");
					count++;
			}
		}
		
	}
	public static char[] generate(){
		char[] chs=new char[5];
		char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S',
			'T','U','V','W','X','Y','Z'};
		for(int i=0;i<chs.length;i++){
			int index;
			boolean[] flags= new boolean[26];
			do{
				index = (int)(Math.random()*26);
			}while(flags[index]==true);
			chs[i]=letters[index];
			flags[index]=true;
		}
		return chs;
	}
	public static int[] check(char[] chs,char[] input){
		int[] result = new int[2];
		for(int i=0;i<chs.length;i++){
			for(int j=0;j<input.length;j++){
				if(chs[i]==input[j]){
					result[1]++;
					if(chs[i]==input[i]){
						result[0]++;
						break;
					}
				}
			}
		}
		return result;
				
	}

}
