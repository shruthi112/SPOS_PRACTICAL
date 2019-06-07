%{
#include<stdio.h>
#include"y.tab.h"
#include<stdlib.h>
%}
%%
[\t]+ 
am|is|are|was|were|do|does|did|have|has|had|will|would|shall|should|can|could|may|might|must|play {printf("%s is a verb\n",yytext);return VERB;}
very|simply|gently|kindly|calmly {printf("%s is a adverb\n",yytext);return ADVERB;}
to|from|above|under|between|below {printf("%s is a preposition\n",yytext);return PREPOSITION;}
if|then|but|or|and		{printf("%s is a conjunction\n",yytext);return CONJUNCTION;}
their|his|her|its|my|your {printf("%s is a adjective\n",yytext);return ADJECTIVE;}
I|you|he|she|it|they|we|He|We|You|It|She|They {printf("%s is a pronoun\n",yytext);return PRONOUN;}
[a-zA-Z]+ {printf("%s is a noun\n",yytext);return NOUN;}
"." {return DOT;}
%%
