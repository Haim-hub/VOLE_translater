# VOLE_translater
A program so that i don't need to use table to look up what VOLE commands mean


## How To Use
If nothing is done to the program, you should be able to just run the main file.\
From here you just enter in the line which you need translated.\
The program does not care wether you have spaces in between the hex. A4 43 is the same as A443 and A 4 43.s
To stop the program from running, you have to type "STOP"\
You will be told if there are any lines that does not follow the rules of the commands. Although there are some exeptions where it amsues the "mistake" is on purpose.\
The program will also tell you if you dont have a corret number of hex for having complete commands.

## Examples
### Valid Code
Input: \
11A0 12A1 13A2 14A3 6012 6003 6004 30A4 C000

Output:\
LOAD register 1 with the bit pattern from memory cell A0\
LOAD register 2 with the bit pattern from memory cell A1\
LOAD register 3 with the bit pattern from memory cell A2\
LOAD register 4 with the bit pattern from memory cell A3\
ADD the bit patterns in register 1 and 2 as floating-points and leave result in register 0 as floating point\
ADD the bit patterns in register 0 and 3 as floating-points and leave result in register 0 as floating point\
ADD the bit patterns in register 0 and 4 as floating-points and leave result in register 0 as floating point\
STORE register 0 with the bit pattern from memory cell A4\
HALT

### Invalid Code 1
Input:\
11A0 H2A1 13A2 14A3

Output:\
op-Code: H2A1 not valid


### Invalid Code 2
Input:\
4AF2

Output:\
MOVE operator needs a 0. Current command is 4AF2
