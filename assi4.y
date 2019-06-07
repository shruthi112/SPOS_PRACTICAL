%{
#include<stdio.h>
void yyerror(char *);
%}
%token  VERB ADVERB PREPOSITION CONJUNCTION ADJECTIVE PRONOUN NOUN DOT
%%
start: sentence start|sentence;
sentence: simple_sentence DOT {printf("It is a simple sentence");}
		| compound_sentence DOT {printf("It is a compound sentence");}
		;
simple_sentence: subject verb object| subject verb object pre_phrase;
compound_sentence: simple_sentence CONJUNCTION simple_sentence| compound_sentence CONJUNCTION simple_sentence;
subject: NOUN|PRONOUN|ADJECTIVE subject;
verb: VERB| ADVERB VERB |verb VERB;
object: NOUN|ADJECTIVE object;
pre_phrase: PREPOSITION NOUN; 	  
%%
int yywrap()
{
return 1;
}
void yyerror(char *s)
{
 printf("%s\n",s);
}
void main()
{
   FILE *fp;
   extern FILE *yyin;
   fp = fopen("sample.txt","r");
   if(fp==NULL)
   printf("Error\n");
   else
   {
     yyin=fp;
     yyparse();	
  }
}
