//Name:Shruthi Bhat
//RollNo-TECOC310
package scheduling;
import java.util.Scanner;

public class cpu {
	int BT[],AT[],WT[],TAT[];
	int n;
	
	void input()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("ENTER NO OF PROCESSES:");
		n=s.nextInt();
		BT=new int[n];
		AT=new int[n];
		WT=new int[n];
		TAT=new int[n];
		System.out.println("ENTER BT AND AT:");
		for(int i=0;i<n;i++)
		{
			BT[i]=s.nextInt();
			AT[i]=s.nextInt();
		}
		
	}
	void sort()
	{
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(AT[i]>AT[j])
				{
					int temp=AT[i];
					AT[i]=AT[j];
					AT[j]=temp;
					
					int t=BT[i];
					BT[i]=BT[j];
					BT[j]=t;
				}
			}
		}
		System.out.println("PROCESS\tARRIVAL\tBURST\n");
		for(int i=0;i<n;i++)
		{
			System.out.print("P"+(i+1)+"\t"+AT[i]+"\t"+BT[i]+"\n");
		}
	}
	void fcfs()
	{
		WT[0]=0;
		TAT[0]=BT[0];
		int t=TAT[0]+AT[0];
		int wt=0,tat=0;
		for(int i=1;i<n;i++)
		{
			WT[i]=t-AT[i];
			System.out.println(t+"\t"+AT[i]+"\n");
			wt=wt+WT[i];
			t=t+BT[i];
			TAT[i]=BT[i]+WT[i];
			tat=tat+TAT[i];
		}
		float w=wt;
		float ta=tat;
		System.out.println("PROCESS\tARRIVAL\tBURST\tWAIT\tTAT\n");
		for(int i=0;i<n;i++)
		{
			System.out.print("P"+(i+1)+"\t"+AT[i]+"\t"+BT[i]+"\t"+WT[i]+"\t"+TAT[i]+"\n");
		}
		System.out.println("AVERAGE WAITING TIME :"+(w/n));
		System.out.println("AVERAGE TAT :"+(ta/n));
		
	}
	void gantt()
	{
		int gnt[]=new int[n];
		int g=AT[0];
		for(int i=0;i<n;i++)
		{
			g=g+BT[i];
			gnt[i]=g;
		}
		System.out.println("-----------------------------------------------------------------\n");
		for(int i=0;i<n;i++)
		{
			System.out.print("\tP"+(i+1)+"\t|");
		}
		System.out.println("\n-----------------------------------------------------------------\n");
		System.out.print(AT[0]+"\t\t");
		for(int i=0;i<n;i++)
		{
			System.out.print(gnt[i]+"\t\t");
		}
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		cpu obj=new cpu();
		obj.input();
		obj.sort();
		obj.fcfs();
		obj.gantt();
	}

}