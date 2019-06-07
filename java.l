%{
#include<stdio.h>
int search(char *st);
void insert(char *st);
void print();
struct symbol{
char s[20];
};
struct symbol STAB[20];
int sind=0;
%}
%%

"class"|"int"|"public"|"static"|"void"|"String"|"char"|"float"|"return"  {printf("%s\t\t%s\n",yytext,"Keyword");}
"main"   {printf("%s\t\t%s\n",yytext,"Main");}
[a-zA-Z_][a-zA-Z0-9]*  {printf("%s\t\t%s\n",yytext,"ID");
			insert(yytext);}
[0-9]+  {printf("%s\t\t%s\n",yytext,"Numbers");}
"("|")"|"{"|"}"|"["|"]"  {printf("%s\t\t%s\n",yytext,"Paraenthesis");}
[-+*/]  {printf("%s\t\t%s\n",yytext,"arithmatic operator");}
[=]     {printf("%s\t\t%s\n",yytext,"assignment operator");}
[,;.]    {printf("%s\t\t%s\n",yytext,"dilimiters");}
['].[']|['][\][nt][']  {printf("%s\t\t%s\n",yytext,"character constant");}
["][^"]["]  {printf("%s\t\t%s\n",yytext,"String constant");}
"//".*[\n]  {printf("%s\t\t%s\n",yytext,"comment");}
[ \n\t] {}
.    {printf("lexical error");}

%%

void main(){
	yyin = fopen("javain.txt","r");
	printf("Lexeme \t\t Tokens\n");
	yylex();
	printf("\n _____SYMBOL TABLE_____\n");
	print();
}

int search(char *st)
{
	int i;
	for(i=0;i<sind;i++)
	{
		if(strcmp(st,STAB[i].s) == 0)
			return 1;
	}
	return -1;
}

void insert(char *st)
{
	if(search(st) == -1)
	{
		strcpy(STAB[sind].s,st); 
		sind++;
	}
}

void print(){
	int i;
	for(i=0;i<sind;i++)
	{
		printf("%s\n",STAB[i].s);
		
	}
}
