%{
#include<stdio.h>
int ws=0,wc=0,lc=0,ch=0;
%}

%%
[^ \t\n]+ {wc++;ch+=yyleng;}
[\n]     {lc++;ch++;ws++;}
[ \t]	 {ch++;ws++;}
%%

void main()
{
yyin=fopen("lexinput.txt","r");
yylex();
printf("Word count=%d \n",wc);
printf("Line count=%d \n",lc);
printf("Character count=%d \n",ch);
printf("Whitespace count=%d \n",ws);
}

int yywrap()
{
return 1;
}
