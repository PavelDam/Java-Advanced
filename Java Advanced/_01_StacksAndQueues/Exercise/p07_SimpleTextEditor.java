package _01_StacksAndQueues.Exercises.Queues;

import java.util.*;

public class P07_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int commandsCount = Integer.parseInt(scanner.nextLine());
//
//        ArrayDeque<String> recorderStack = new ArrayDeque<>();
//        StringBuilder textBuilder = new StringBuilder();
//
//        for (int i = 1; i <= commandsCount; i++) {
//            String[] commandsArr = scanner.nextLine().split(" ");
//            String command = commandsArr[0];
//
//            switch (command) {
//                case "1":
//                    recorderStack.push(textBuilder.toString());
//                    String text = commandsArr[1];
//                    textBuilder.append(text);
//                    break;
//
//                case "2":
//                    recorderStack.push(textBuilder.toString());
//                    int charsCount = Integer.parseInt(commandsArr[1]);
//                    textBuilder.delete(textBuilder.length() - charsCount, textBuilder.length());
//
//                    break;
//                case "3":
//                    int index = Integer.parseInt(commandsArr[1]);
//                    System.out.println(textBuilder.charAt(index - 1));
//                    break;
//                case "4":
//                    if (!recorderStack.isEmpty()) {
//                        String lastText = recorderStack.pop();
//                        textBuilder= new StringBuilder(lastText);
//                    }
//            }
//        }
        int operations = Integer.parseInt(scanner.nextLine());


        StringBuilder builder = new StringBuilder();

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < operations; i++) {
            String[] commandArr = scanner.nextLine().split(" ");
            String command = commandArr[0];
            switch (command) {
                case "1":
                    stack.push(builder.toString());
                    String append = commandArr[1];
                    builder.append(append);

                    break;
                case "2":
                    stack.push(builder.toString());
                    int count = Integer.parseInt(commandArr[1]);
                    builder.delete(builder.length() - count, builder.length());

                    break;
                case "3":
                    int index = Integer.parseInt(commandArr[1]);
                    System.out.println(builder.charAt(index - 1));
                    break;
                default:
                    if (!stack.isEmpty()){
                        String lastString = stack.pop();
                        builder = new StringBuilder(lastString);
                    }
                    break;
            }
        }
    }
}

