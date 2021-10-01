package com.company;

public class Command {

    private String code;
    private String opCode;
    private String[] operand = new String[3];


    public Command(String code){
        this.code = code;
        String[] codeSplit = code.split("",4);
        this.opCode = codeSplit[0];
        this.operand[0] = codeSplit[1];
        this.operand[1] = codeSplit[2];
        this.operand[2] = codeSplit[3];
    }

    public String getDescription(){
        String rS = "";
        switch (opCode){
            case "1":
                rS = "LOAD register " + operand[0] + " with the bit pattern from memory cell " + operand[1]+operand[2];
                break;
            case "2":
                rS = "LOAD register " + operand[0] + " with the bit pattern " + operand[1]+operand[2];
                break;
            case "3":
                rS = "STORE register " + operand[0] + " with the bit pattern from memory cell " + operand[1]+operand[2];
                break;
            case "4":
                if(operand[0].equals("0"))
                    rS = "MOVE the bit pattern from register " + operand[1] + " to register " + operand[2];
                else
                    throw new IllegalArgumentException("MOVE operator needs a 0. Current command is " + opCode + operand[0] + operand[1] + operand[2]);
                break;
            case "5":
                rS = "ADD the bit patterns in register " + operand[1] + " and " + operand[2] + " as two's complement representations and leave result in register " + operand[0];
                break;
            case "6":
                rS = "ADD the bit patterns in register " + operand[1] + " and " + operand[2] + " as floating-points and leave result in register " + operand[0] + " as floating point";
                break;
            case "7":
                rS = "OR the bit patterns in register " + operand[1] + " and " + operand[2] + " and leave result in register " + operand[0];
                break;
            case "8":
                rS = "AND the bit patterns in register " + operand[1] + " and " + operand[2] + " and leave result in register " + operand[0];
                break;
            case "9":
                rS = "XOR the bit patterns in register " + operand[1] + " and " + operand[2] + " and leave result in register " + operand[0];
                break;
            case "A":
                if(operand[1].equals("0"))
                    rS = "ROTATE the bit pattern in register " + operand[0] + " to the right " + operand[2] + " times";
                else
                    throw new IllegalArgumentException("ROTATE operator needs a 0. Current commands says "+ opCode + operand[0] + operand[1] + operand[2]);
                break;
            case "B":
                rS = "JUMP to the instruction in the memory cell at adress " + operand[1] + operand[2] + " if the bit pattern in register " + operand[0] + " is equal to the bit pattern in register 0";
                break;
            case "C":
                if(operand[0].equals("0") && operand[1].equals("0") && operand[2].equals("0"))
                    rS = "HALT";
                else
                    throw new IllegalArgumentException("HALT operator needs to C000, not "+ opCode + operand[0] + operand[1] + operand[2]);
                break;
            default:
                throw new IllegalArgumentException("op-Code: "+ opCode + operand[0] + operand[1] + operand[2] + " not valid ");
        }
        return rS;
    }

    public String getOperand(){
        String rS = "";
        switch (opCode){
            case "1":
            case "2":
                rS = "LOAD";
                break;
            case "3":
                rS = "STORE";
                break;
            case "4":
                rS = "MOVE";
                break;
            case "5":
            case "6":
                rS = "ADD";
                break;
            case "7":
                rS = "OR";
                break;
            case "8":
                rS = "AND";
                break;
            case "9":
                rS = "XOR";
                break;
            case "A":
                rS = "ROTATE";
                break;
            case "B":
                rS = "JUMP";
                break;
            case "C":
                rS = "HALT";
                break;
            default:
                rS = "Not valid";
        }
        return rS;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString(){

        return getDescription();
    }

}
