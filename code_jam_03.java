package microsoftInterview;

import java.util.ArrayList;
import java.util.Scanner;

public class code_jam_03 {
	
	public static void test()
	{
		int a =101101;
		for (int i=2;i<a;i++)
		{
			if(a%i==0)
			{
				System.out.println("test::::::a="+a+"i="+i);
			}
		}
		
	//	for(int i=2;i<=10;i++)
	//	outputNumber("1001",i);
	}
	
	public static boolean prime(long number)
	{
		if(number%2 == 0)
		{
			return false;
		}
		
		long t =(long) Math.sqrt(number);
		
		for(long i =3; i<=t;i+=2)
		{
			if(number%i==0)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static int divisor(long number)
	{
		
		if(number%2 == 0)
		{
			return 2;
		}
		
		int t =(int) Math.sqrt(number);
		
		for(int i =3; i<=t;i+=2)
		{
			if(number%i==0)
			{
				return i;
			}
		}

		return -1;
	}
	
	public static String binaryStringConvert(long number)
	{
		String outputString;
		
		outputString = Integer.toBinaryString((int) number);
		
		return outputString;
	}
	
	public static long baseConvert(String num_string,int base)
	{
		long number=0;
		for(int i = 0;i<=num_string.length()-1;i++)
		{
			if(num_string.charAt(i)=='1')
			{
				//System.out.println("i = "+i+" "+num_string.charAt(i));
				number = (long) (number+Math.pow(base, num_string.length()-1-i));
				//System.out.println("base: "+base+" i="+i+" number="+number);
			}
		}
		
		return number;	
	}
	
	public static boolean judgePrime(String num_string, int base)
	{
		long number=0;
         
		number = baseConvert(num_string,base);
		
		boolean output;
		
		output = prime(number);
		if(output)
		System.out.println("error: "+ num_string+" base: "+base+" value: "+number);
		return output;
	}
	
	public static void outputNumber(String num_string, int base)
	{
		int number=1;
		for(int i = num_string.length()-1;i>0;i--)
		{
			if(num_string.charAt(i)=='1')
			{
				number = (int) (number+Math.pow(base, i));
			}
		}
		//System.out.println("**"+number+"    base:"+base);
	}
	
	public static void main(String[] argv)
	{
		Scanner in = new Scanner(System.in);
		int case_number = in.nextInt();
		
		ArrayList<String> output = new ArrayList<String>();
		
		int N = in.nextInt();
		int J = in.nextInt();
		
		int interval_length = N-2;
		int maximun_step = (int) (Math.pow(2, N-2)-1);
		
		int maximun_number = (int)Math.pow(2,N)-1;
		int minimun_number = (int)Math.pow(2, N-1)+1;
		int temp_number = minimun_number;
		
		
		System.out.print("maximun_step="+maximun_step);
		int result_count =0;
		
		int test_count =0;
		for(int j = 0; j<=maximun_step; j++)
		{
			test_count++;
			temp_number = minimun_number+j*2;
			
			if(!prime(temp_number))
			{
				String binary_string = binaryStringConvert(temp_number);
				//System.out.println(binary_string+" "+temp_number);
				
				boolean flag = false;
				
				for(int index =2;index<=10;index++)
				{
					if(judgePrime(binary_string,index))
					{
						flag = true;
						//System.out.println("--"+binary_string+"  "+index);
						outputNumber(binary_string,index);
						break;
					}
				}
				
				if(!flag)
				{
					output.add(binary_string);
					result_count++;
				}
				
				if(result_count == J)
				{
					break;
				}

			}
		}
		System.out.println("sum of all case: "+test_count);
		
		System.out.println("case #1:");
		for(String outputBinaryString : output)
		{
			printResult(outputBinaryString);
		}
		System.out.println("++++++++");
		//test();
	}
	
	public static void printResult(String output_binary)
	{
		System.out.print(output_binary);
		
		for(int base=2;base<=10;base++)
		{
			long number =1;
			for(int i = output_binary.length()-1;i>0;i--)
			{
				if(output_binary.charAt(i)=='1')
				{
					number = (long) (number+Math.pow(base, i));
				}
			}
			
			System.out.print(" "+number+"("+divisor(number)+")");
			//System.out.print(" "+divisor(number));
		}
		System.out.print("\n");
	}

}
