%{
#include <stdio.h>
%}
%token Dtype ID CONST
%%
dstmt   : Dtype varlist ';' {printf("Valid");}
	;
varlist : var
	| varlist ',' var
	;
var     : ID
	| ID '=' CONST
	;
%%
void main(){
	extern FILE *yyin;
	yyin= fopen("in.txt","r");
	yyparse();
}
int yyerror(char *s)
{
printf("Error in %s\n",s);
}

