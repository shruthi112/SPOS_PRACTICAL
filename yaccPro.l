%{
#include <stdio.h>
#include "y.tab.h"
%}
%%

"int"|"void"|"String"|"char"|"float"  {return Dtype;}
[a-zA-Z_][a-zA-Z0-9]*  {return ID;}
[0-9]+  {return CONST;}
[,;=]    {return  yytext[0];}
['].[']|['][\][nt][']  {printf("%s\t\t%s\n",yytext,"character constant");}
["][^"]["]  {printf("%s\t\t%s\n",yytext,"String constant");}
[ \n\t] {}
.    {printf("lexical error");}
%%

