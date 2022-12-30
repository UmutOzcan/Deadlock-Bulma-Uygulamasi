package Odev;


import java.util.Scanner;


public class Odev {

	public static void main(String[] args)  {
		
		try (Scanner konsolVeri = new Scanner(System.in)) {
			int[] max = new int[3];
			int[] allocation = new int[3];
			int[] need = new int[3];
			int i, p0, p1, p2;

			System.out.println();
			System.out.printf("Kaynak degeri giriniz :");
			
			int instance = konsolVeri.nextInt(); //Bellek i�in ayr�lacak �rnek alan

			System.out.println("\n**********************************************************\n");

			for (i = 0; i < 3; i++)
			{
				System.out.printf("P"+ i +" icin maximum degeri giriniz : ");
			    max[i] = konsolVeri.nextInt(); //Max istek matrisinin giri� de�erleri
			    System.out.printf("P"+ i +" icin atanmıs degeri giriniz : ");
			    allocation[i] = konsolVeri.nextInt(); //Atanm�� matrisin giri� de�erleri
			    need[i] = max[i] - allocation[i];
			}

			System.out.println("\n***********************************************************\n");

			System.out.println("�stek Matrisi:\n");

			for (i = 0; i < 3; i++)
			{
				System.out.printf("P"+ i +": "+ need[i] +""); //Max - Allocation = Need
				System.out.println();
			}

			i = 0;
			p0 = need[i];
			p1 = need[i + 1];
			p2 = need[i + 2];


			System.out.println("\n***********************************************************\n");

			if (p0 > instance || p1 > instance || p2 > instance) // n proses varsa en az n kayna��m�z olmal� ki Deadlock olmas�n
			{
				System.out.println("Deadlock var.");
			}
			else
			{
				System.out.println("Deadlock yok.");
				System.out.println("\n********************************************************\n");
			    sjf(p0, p1, p2);
			}
		}
		



	}

	private static void sjf(int p0, int p1, int p2) //Need Matrislerini k���kten b�y��e s�ralad�k. K���kten b�y��e s�ralanan prosesler zamanlama dizisine aktar�ld� ve k���kten b�y��e toplanarak eklenmi� oldu.
    {
        int[] schedulingChart = new int[3];
        int i;
        double averageWT;

        if (p0 < p1 && p0 < p2)
        {
            if (p1 < p2)
            {
            	System.out.println("P0 < P1 < P2");
                schedulingChart[0] = p0;
                schedulingChart[1] = p0 + p1;
                schedulingChart[2] = p0 + p1 + p2;
                for (i = 0; i < 3; i++)
                {
                	System.out.printf("P" + i +" icin calısma zamani: "+ schedulingChart[i]);
                   	System.out.println();
                }
            }
            else if (p2 < p1)
            {
            	System.out.println("P0 < P2 < P1");
                schedulingChart[0] = p0;
                schedulingChart[1] = p0 + p2;
                schedulingChart[2] = p0 + p2 + p1;
                for (i = 0; i < 3; i++)
                {
                	System.out.printf("P" + i +" icin calısma zamani: "+ schedulingChart[i]);
                   	System.out.println();
                }
            }
            else
            {
            	System.out.println("P0 < P1 = P2");
                schedulingChart[0] = p0;
                schedulingChart[1] = p0 + p1;
                schedulingChart[2] = p0 + p1 + p2;
                for (i = 0; i < 3; i++)
                {
                	System.out.printf("P" + i +" icin calısma zamani: "+ schedulingChart[i]);
                   	System.out.println();
                }
            }
        }
        if (p1 < p0 && p1 < p2)
        {
            if (p0 < p2)
            {
            	System.out.println("P1 < P0 < P2");
                schedulingChart[0] = p1;
                schedulingChart[1] = p1 + p0;
                schedulingChart[2] = p1 + p0 + p2;
                for (i = 0; i < 3; i++)
                {
                	System.out.printf("P" + i +" icin calısma zamani: "+ schedulingChart[i]);
                   	System.out.println();
                }
            }
            else if (p2 < p0)
            {
            	System.out.println("P1 < P2 < P0");
                schedulingChart[0] = p1;
                schedulingChart[1] = p1 + p2;
                schedulingChart[2] = p1 + p2 + p0;
                for (i = 0; i < 3; i++)
                {
                	System.out.printf("P" + i +" icin calısma zamani: "+ schedulingChart[i]);
                   	System.out.println();
                }
            }
            else
            {
            	System.out.println("P1 < P0 = P2");
                schedulingChart[0] = p1;
                schedulingChart[1] = p1 + p0;
                schedulingChart[2] = p1 + p0 + p2;
                for (i = 0; i < 3; i++)
                {
                	System.out.printf("P" + i +" icin calısma zamani: "+ schedulingChart[i]);
                   	System.out.println();
                }
            }
        }
        if (p2 < p0 && p2 < p1)
        {
            if (p0 < p1)
            {
            	System.out.println("P2 < P0 < P1");
                schedulingChart[0] = p2;
                schedulingChart[1] = p2 + p0;
                schedulingChart[2] = p2 + p0 + p1;
                for (i = 0; i < 3; i++)
                {
                	System.out.printf("P" + i +" icin calısma zamani: "+ schedulingChart[i]);
                   	System.out.println();
                }
            }
            else if (p1 < p0)
            {
            	System.out.println("P2 < P1 < P0");
                schedulingChart[0] = p2;
                schedulingChart[1] = p2 + p1;
                schedulingChart[2] = p2 + p1 + p0;
                for (i = 0; i < 3; i++)
                {
                	System.out.printf("P" + i +" icin calısma zamani: "+ schedulingChart[i]);
                   	System.out.println();
                }
            }
            else
            {
            	System.out.println("P2 < P0 = P1");
                schedulingChart[0] = p2;
                schedulingChart[1] = p2 + p0;
                schedulingChart[2] = p2 + p0 + p1;
                for (i = 0; i < 3; i++)
                {
                	System.out.printf("P" + i +" icin calısma zamani: "+ schedulingChart[i]);
                   	System.out.println();
                }
            }
        }
        if (p0==p1 && p0==p2 && p1==p2)
        {
        	System.out.println("P0 = P1 = P2");
            schedulingChart[0] = p0;
            schedulingChart[1] = p0 + p1;
            schedulingChart[2] = p0 + p1 + p2;
            for (i = 0; i < 3; i++)
            {
            	System.out.printf("P" + i +" icin calısma zamani: "+ schedulingChart[i]);
               	System.out.println();
            }
        }
       
        if (p0==p1 && p2>p1)
        {
        	System.out.println("P0 = P1 < P2");
            schedulingChart[0] = p0;
            schedulingChart[1] = p0 + p1;
            schedulingChart[2] = p0 + p1 + p2;
            for (i = 0; i < 3; i++)
            {
            	System.out.printf("P" + i +" icin calısma zamani: "+ schedulingChart[i]);
               	System.out.println();
            }
        }
        if (p0==p2 && p1>p2)
        {
        	System.out.println("P0 = P2 < P1");
            schedulingChart[0] = p0;
            schedulingChart[1] = p0 + p2;
            schedulingChart[2] = p0 + p2 + p1;
            for (i = 0; i < 3; i++)
            {
            	System.out.printf("P" + i +" icin calısma zamani: "+ schedulingChart[i]);
               	System.out.println();
            }
        }
        if (p1==p2 && p0>p2)
        {
        	System.out.println("P1 = P2 < P0");
            schedulingChart[0] = p1;
            schedulingChart[1] = p1 + p2;
            schedulingChart[2] = p1 + p2 + p0;
            for (i = 0; i < 3; i++)
            {
            	System.out.printf("P" + i +" icin calısma zamani: "+ schedulingChart[i]);
                System.out.println();
            }
        }

        averageWT = (0 + schedulingChart[0] + schedulingChart[1]) / 3;
        System.out.printf("Ortalama bekleme suresi: ( 0 + " + schedulingChart[0] +  " + "+ schedulingChart[1] + " ) / 3 = "+ averageWT  );
        System.out.println();
    }

}

	
	


