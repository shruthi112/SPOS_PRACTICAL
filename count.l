%{
#include<stdio.h>
int wc=0,lc=0,ch=0;
%}

%%
[^ \t\n]+ {wc++;ch+=yyleng;}
[\n]     {lc++;ch++;}
.	 {ch++;}
%%

void main()
{
yyin=fopen("lexinput.txt","r");
yylex();
printf("Word count=%d \n",wc);
printf("Line count=%d \n",lc);
printf("Character count=%d \n",ch);
}

int yywrap()
{
return 1;
}
