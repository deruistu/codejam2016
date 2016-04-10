package microsoftInterview;

import java.util.ArrayList;
import java.util.Scanner;

public class code_jam_03_new {
	
	public static void test()
	{
		long a =101101;
		for (long i=2;i<a;i++)
		{
			if(a%i==0)
			{
				System.out.println("test::::::a="+a+"i="+i);
			}
		}
	}
	
	public static long baseConvert(String num_string,long base)
	{
		 long number=0;
		for(int i = 0;i<=num_string.length()-1;i++)
		{
			if(num_string.charAt(i)=='1')
			{
				//System.out.println("position = "+(num_string.length()-1-i)+" "+num_string.charAt(i)+" value: "+Math.pow(base, (num_string.length()-1-i)));
				number = (long) (number+Math.pow(base, (num_string.length()-1-i)));
				//System.out.println("base: "+base+" i="+i+" number="+number);
			}
		}
		
		return number;
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
	
	public static long divisor(long number)
	{
		if(number%2 == 0)
		{
			return 2;
		}
		
		long t =(long) Math.sqrt(number);
		
		for(long i =3; i<=t;i+=2)
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
		
		outputString = Long.toBinaryString(number);
		
		return outputString;
	}
	
	public static boolean judgePrime(String num_string, int base)
	{
		long number=1;

		number=baseConvert(num_string,base);
		boolean output;
		
		output = prime(number);
		/*
		if(output)
			System.out.println("error: "+num_string+" number="+number+" base = "+base);
		
		if(num_string.equals("1000000000000101"))
			System.out.println("attention: "+num_string+" number="+number+" base="+base+"output = "+output);
		*/
		return output;
	}
	
	public static void main(String[] argv)
	{
		Scanner in = new Scanner(System.in);
		long case_number = in.nextInt();
		
		ArrayList<String> output = new ArrayList<String>();
		
		int N = in.nextInt();
		int J = in.nextInt();
		
		long interval_length = N-2;
		long maximun_step = (long) Math.pow(2, N-2)-1;
		
		long maximun_number = (long)Math.pow(2,N)-1;
		long minimun_number = (long)Math.pow(2, N-1)+1;
		long temp_number = minimun_number;
		
		long result_count =0;
		
		long test_count =0;
		
		for(long j = 0; j<=maximun_step; j++)
		{
			test_count ++;
			temp_number = minimun_number+j*2;
			
			if(!prime(temp_number))
			{
				String binary_string = binaryStringConvert(temp_number);
				boolean flag = false;
				
				for(int index =2;index<=10;index++)
				{
					if(judgePrime(binary_string,index))
					{
						flag = true;
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
		//System.out.println("test_count = "+test_count);
		System.out.println("Case #1:");
		for(String outputBinaryString : output)
		{
			printResult(outputBinaryString);
		}
		//System.out.println("++++++++");
		//test();
	}
	
	public static void printResult(String output_binary)
	{
		System.out.print(output_binary);
		
		for(long base=2;base<=10;base++)
		{
			long number =1;
			number = baseConvert(output_binary,base);
			//System.out.print(" "+number+"("+divisor(number)+")");
			System.out.print(" "+divisor(number));
		}
		System.out.print("\n");
	}

}
