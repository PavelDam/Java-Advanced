package _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.core;

import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.core.commands.AddCommand;
import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.core.commands.CommandInterpreterImpl;
import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.core.commands.FightCommand;
import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.core.commands.ReportCommand;
import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.interfaces.*;
import _07_ReflectionAndAnnotation.Exercise.P03_barracksWars.barracksWars.interfaces.Runnable;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {


    CommandInterpreterImpl commandInterpreter;

    public Engine(CommandInterpreterImpl commandInterpreter) {

        this.commandInterpreter = commandInterpreter;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];

                Executable executable = commandInterpreter.interpretCommand(data, commandName);

                String result = executable.execute();

                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
