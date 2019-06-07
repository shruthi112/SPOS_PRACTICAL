//Name:Shruthi Bhat
//RollNo-TECOC310
#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
main()
{
	pid_t pid;
	//int pid;
	int status, ch;
	int f=0;
	while(f==0)
{
	printf("Select command to execute\n1. ls\n2. ps\n3. join\n4. exit\nEnter Choice :");
	scanf("%d",&ch);
	switch(ch)
	{
	case 1:
		pid=fork();
		if(pid<0)
		{
			printf("Error occured in fork()");
		}
		else if (pid==0)
		{
			execl("/bin/ls","ls",NULL);
		}else
		{
			status=wait();
			printf("\nChild finished execution with status %d\n",status);
		}
		break;
	case 2:
		pid=fork();
		if(pid<0)
		{
			printf("Error occured in fork()");
		}
		else if (pid==0)
		{
			execl("/bin/ps","ps",NULL);
		}else
		{
			status=wait();
			printf("\nChild finished execution with status %d\n",status);
		}
		break;
	case 3:
		pid=fork();
		if(pid<0)
		{
			printf("Error occured in fork()");
		}
		else if (pid==0)
		{
			execl("/usr/bin/join", "join", "p.txt", "b.txt", NULL);
		}else
		{
			status=wait();
			printf("\nChild finished execution with status %d\n",status);
		}
		break;
	case 4:
		f=1;
		break;
	default:
		printf("Wrong Choice\n");
		system("ps");
	}
}

}