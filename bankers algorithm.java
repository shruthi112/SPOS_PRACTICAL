//Name:Shruthi Bhat
//RollNo-TECOC310
package bankersalgo;
import java.util.Scanner;
import java.io.*;

public class bankers {
	public int alloc[][],max[][],need[][],avail[];
	boolean fin[];
	int n,m,done;
	void input()
	{
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter no of processes: ");
		m=sc.nextInt();
		System.out.println("\nEnter no of resources: ");
		n=sc.nextInt();
		alloc=new int[m][n];
		max=new int[m][n];
		fin=new boolean[m];
		int flag=0;
		need=new int[m][n];
		avail=new int[n];
		System.out.println("\nEnter allocation matrix:\n ");//accept alloc matrix
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				alloc[i][j]=sc.nextInt();
			}
		}
		System.out.println("\nEnter maximum required matrix:\n ");//accept max req matrix
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				max[i][j]=sc.nextInt();
			}
		}
		/*System.out.println("\nALLOCATION MATRIX:\n ");//display alloc matrix
		for(int i=0;i<m;i++)
		{
			System.out.print("P"+i+"\t");
			for(int j=0;j<n;j++)
			{
				System.out.print(alloc[i][j]+"\t");
			}
			System.out.println("");
		}
		System.out.println("\nMAXIMUM REQUIRED MATRIX:\n ");//display max req matrix
		
		for(int i=0;i<m;i++)
		{
			System.out.print("P"+i+"\t");
			for(int j=0;j<n;j++)
			{
				System.out.print(max[i][j]+"\t");
			}
			System.out.println("");
		}*/
		for(int i=0;i<m;i++)//calculate need matrix
		{
			for(int j=0;j<n;j++)
			{
				need[i][j]=max[i][j]-alloc[i][j];
			}
			System.out.println("");
		}
		for(int a=0;a<m;a++)//initialse finish array to false
			fin[a]=false;
		/*System.out.println("\nNEED MATRIX:\n ");//display need matrix
		
		for(int i=0;i<m;i++)
		{
			System.out.print("P"+i+"\t");
			for(int j=0;j<n;j++)
			{
				System.out.print(need[i][j]+"\t");
			}
			System.out.println("");
		}*/
		System.out.println("\nEnter available matrix:\n ");//accept available matrix
		for(int i=0;i<n;i++)
		{
			avail[i]=sc.nextInt();
		}
		/*System.out.println("\n Available matrix:\n ");
		for(int i=0;i<n;i++)
		{
			System.out.print(avail[i]+"\t");
		}*/
		System.out.println("");
		//int work[]=new int[n];
		//work=avail;
		System.out.println("SAFE SEQUENCE :");
		while(done!=m)//while all processes are not true in finish array
		{
			
			for(int i=0;i<m;i++)//need check
			{
				flag=0;
				for(int j=0;j<n;j++)
				{
					if(need[i][j]<=avail[j])//for checking whole row
					{
						flag++;
					}
				
				}
				if(flag==n)
				{
					if(fin[i]!=true)//if finish is false then update work
					{
					System.out.println("P"+(i+1));
					//update(i);
					
						for(int c=0;c<n;c++)
							avail[c]=avail[c]+alloc[i][c];//update work
					}
					fin[i]=true;
					
					
				}
				
			}
			done=0;
			for(int j=0;j<m;j++)
			{
				
				if(fin[j]==true)
				{
					done++;
				}
			}
			//System.out.println("Done="+done);
			/*System.out.println("\n Work matrix:\n ");
			for(int i=0;i<n;i++)
			{
				System.out.print(avail[i]+"\t");
			}*/
		}
		
	}
	
	/*void update(int c)
	{
		while(fin[c]!=true)//if finish is false then update work
		{
			for(int i=0;i<n;i++)
				avail[i]=avail[i]+alloc[c][i];//update work
		}
		
	}*/
	
	
	public static void main(String[] args) {
		
			
				bankers sf=new bankers();
				sf.input();
				
	}

}