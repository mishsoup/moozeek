# Moozeek (A music DSL)- CPSC 410 Group project
![Moozeek](https://user-images.githubusercontent.com/31344971/82974722-80e74000-9f8f-11ea-890b-f9b5acb3884c.jpg)

__EBNF:__<br/>

__/* OVERALL PROGRAM CONTROL */__   
PROGRAM ::=  FUNC*  “,” INSTRUCTION+ [“,” PLAY]?  
INSTRUCTION ::= CREATE | CONNECT | LAYER | COMMENT | RUN  
FUNC ::= “DEF” NAME FUNCBODY  
FUNCBODY::= ( “(“ “REF”? NAME (“,” “REF”? NAME)* “)”  )?  “{“ INSTRUCTION+ “}”  
RUN ::=  “RUN” NAME ( “(“ NAME  (“,” NAME)* ”)” )?  
COMMENT ::= “&” STRING “&”  
PLAY ::= “PLAY” NAME   
CONNECT ::= “CONNECT“  NAME (“,” NAME)+ “INTO” NAME  
LAYER::= “LAYER” NAME (“,” NAME)+ “INTO” NAME  
  
__/* SONG COMPOSURE */__  
CREATE ::= “CREATE“  NAME “,”  SOUND  
NAME ::=  STRING  
SOUND ::= “[“ INSTRUMENT “,” BEAT [“,” BPM]? “,” BASESOUND “]”  

__/* SOUND */__  
BASESOUND ::= MELODY | CHORDPROGRESSION  
INSTRUMENT ::= “Guitar” | “Piano” | … etc  
BASEKEY ::= NOTE | CHORD | REST  
MELODY ::= “MELODY:” ((NOTE | REST) (“,” (NOTE | REST))*  
REST ::= “REST” LENGTH+   
NOTE ::=  [A-G][# | b]? OCTAVE?  LENGTH+  
LENGTH ::= s | i | q | h | w  
CHORDPROGRESSION ::= “CHORD:” ((CHORD | REST) (“,” (CHORD | REST))*  
CHORD :: =  [A-G][# | b]?[M|m]? OCTAVE?   LENGTH+   
OCTAVE ::= (- | +) [1-5]    
  
__/* RHYTHMS */__  
BEAT ::= COUNTS “/“ COUNTVALUE   
BPM ::= “BPM: ” [1 - 200]  
COUNTS ::= [1-8]  
COUNTVALUE ::= 16 | 8| 4| 2  
  
  
------------------------------  
Abbreviations for length:  
s    = sixteenth  
i    = eighth  
q   = quarter  
q   = half  
w  = whole  
