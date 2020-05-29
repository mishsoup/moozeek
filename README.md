# Moozeek (A music DSL)- CPSC 410 Group project
![Moozeek](https://user-images.githubusercontent.com/31344971/83210120-e44bac00-a10e-11ea-957c-ea2bd8fd3662.png)

_*Note: The whole tokenizer class is taken from Alex's code posted in the lectures as approved by our project TA Ali._

__EBNF:__<br/>

__/* OVERALL PROGRAM CONTROL */__   
PROGRAM ::=  FUNC* INSTRUCTION+ (“,” PLAY)?  
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
SOUND ::= “[“ INSTRUMENT “,” BEAT (“,” BPM)? “,” BASESOUND “]”  

__/* SOUND */__  
BASESOUND ::= MELODY | CHORDPROGRESSION  
INSTRUMENT ::= “Guitar” | “Piano” | … etc  
BASEKEY ::= NOTE | CHORD | REST  
MELODY ::= “MELODY:” [NOTE | REST] (“,” [NOTE | REST])\*  
REST ::= “REST” LENGTH+   
NOTE ::=  [A-G][# | b]? OCTAVE?  LENGTH+  
LENGTH ::= s | i | q | h | w  
CHORDPROGRESSION ::= “CHORD:” [CHORD | REST] (“,” [CHORD | REST])\*   
CHORD :: =  [A-G][# | b]?[M|m]? OCTAVE?   LENGTH+   
OCTAVE ::= [-|+] [1-5]    
  
__/* RHYTHMS */__  
BEAT ::= COUNTS “/“ COUNTVALUE   
BPM ::= “BPM: ” [1 - 200]  
COUNTS ::= [1-8]  
COUNTVALUE ::= 16|8|4|2  
  
  
------------------------------  
Abbreviations for length:  
s    = sixteenth  
i    = eighth  
q   = quarter  
q   = half  
w  = whole    
  
------------------------------      
__Sample Code:__  
  
DEF repeat (REF SongToRepeat, REF StoreHere) {  
  CONNECT SongToRepeat, SongToRepeat INTO StoreHere  
}  

DEF LayertTwoSongsAndRpeatTwice (song1, song2, REF StoreHere) {  
  LAYER song1, song2 INTO StoreHere  
  CONNECT StoreHere, StoreHere INTO StoreHere  
}  
  
& Simpsons &  
CREATE Simpsons, [Violin, 4/4, BPM: 90, MELODY: Fi, Aq, Bi, D+1i, C+1q, Ai, Fq, Di, Cbq]  
  
& Fur Elise &  
CREATE Fur Elise, [Piano, 4/4,  BPM: 80, MELODY: Es, D#s, Es, D#s, Es, B-1s, Ds, Cs, A+3q, C-1s, E-1s, A-1s, B-1q, E-1s, A-1s, B-1s, Cq]  
  
& Empty Song &  
CREATE My Song, [Piano, 4/4, MELODY: RESTs]  
  
& Call repeat method on Simpsons and store into My Song &  
RUN repeat(Simpsons, My Song)  
& Call LayertTwoSongsAndRpeatTwice method on Simpsons and Fur Elise and store into My Song &  
RUN LayertTwoSongsAndRpeatTwice(Simpsons, Fur Elise, My Song)  
& Play the music created &  
,  
PLAY My Song  
