package _03_SetsAndMaps.Exercise;

import java.util.*;

public class P08_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Integer>> map = new TreeMap<>();
        while (!input.equals("end")) {
            String[] inputArr = input.split(" ");
            String ip = inputArr[0].split("=")[1];
            String user = inputArr[2].split("=")[1];

            if (!map.containsKey(user)) {
                map.put(user, new LinkedHashMap<>());
            }
            Map<String, Integer> insideMap = map.get(user);
            if (!insideMap.containsKey(ip)) {
                insideMap.put(ip, 1);
            } else {
                insideMap.put(ip, insideMap.get(ip) + 1);
            }
            map.put(user, insideMap);

            input = scanner.nextLine();
        }

        map.forEach((entry, value) -> {
            System.out.println(entry + ": ");
            Map<String, Integer> ipMap = value;

            int counter = 0;
            for (String ip :ipMap.keySet()) {

                if (counter==ipMap.size()-1){
                    System.out.println(ip + " => " + ipMap.get(ip)+".");
                }else {
                    System.out.print(ip + " => " + ipMap.get(ip)+", ");
                    counter++;
                }
            }
        });
    }
}

