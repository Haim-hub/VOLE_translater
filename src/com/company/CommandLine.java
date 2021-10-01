package com.company;

public class CommandLine {
    private String line;
    private Command[] commands;
    private String[] sCommands;

    public CommandLine(String line){
        line = line.replace(" ", "");
        this.line = line;
        if(line.length()%4 != 0)
            throw new IllegalArgumentException("Wrong size");


        sCommands = line.split("", line.length());
        commands = new Command[sCommands.length/4];
        for (int i = 0; i < line.length(); i+=4) {
            commands[i/4] = new Command(sCommands[i]+sCommands[i+1]+sCommands[i+2]+sCommands[i+3]);

        }

    }

    public String getLine(){
        return line;
    }

    @Override
    public String toString(){
        String rS = "";
        for(Command c : commands){
            rS += c.getDescription() + "\n";
        }
        return rS;
   }
}
