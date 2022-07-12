import java.util.*;

public class recursion {
    public static boolean isPalindrome(String input) {
        if (input.length() <= 1) {
            return true;
        }
        return input.charAt(0) == input.charAt(input.length() - 1) ? isPalindrome(input.substring(1, input.length() - 1)) : false;
    }

    public static ArrayList<Integer> returnSubset(ArrayList<Integer> list, int target, ArrayList<Integer> subset) {
        return findSubset(list, target, subset) ? subset : list;
    }

    public static boolean findSubset(ArrayList<Integer> list, int target, ArrayList<Integer> subset) {
        if (target == 0) {
            return true;
        }
        if (list.size() == 0) {
            return false;
        }
        int next = list.remove(0);
        if (next > target) {
            return findSubset(list, target, subset);
        }
        ArrayList<Integer> copy = new ArrayList<Integer>(subset);
        subset.add(next);
        return findSubset(list, target - next, subset) || findSubset(list, target, copy);
    }

    public static boolean isPartitionable(ArrayList<Integer> list, int partitions) {
        if (partitions == 1) {
            return true;
        }
        int totalSum = 0;
        for (Integer x : list) {
            totalSum += x;
        }
        if (totalSum % partitions != 0 || list.size() < partitions) {
            return false;
        }
        
        int subsetSum = totalSum / partitions;
        int[] partitionSums = new int[partitions];
        boolean[] visited = new boolean[list.size()];

        partitionSums[0] = list.get(0);
        visited[0] = true;

        return isPartitionable(list, subsetSum, partitionSums, visited, 0, 1);
    }

    public static boolean isPartitionable(ArrayList<Integer> list, int subsetSum, int[] partitionSums, boolean[] visited, int currentSubset, int currentListIndex) {
        if (partitionSums[currentSubset] == subsetSum) {
            if (currentSubset == partitionSums.length - 2) {
                return true;
            }
            return isPartitionable(list, subsetSum, partitionSums, visited, currentSubset + 1, currentListIndex - 1);
        }

        for (int i = currentListIndex; i < list.size(); i++) {
            if (visited[i]) {
                continue;
            }
            int path = partitionSums[currentSubset] + list.get(i);

            if (path <= subsetSum) {
                visited[i] = true;
                partitionSums[currentSubset] = path;
                boolean inclusive = isPartitionable(list, subsetSum, partitionSums, visited, currentSubset, i + 1);

                visited[i] = false;
                partitionSums[currentSubset] -= list.get(i);
                if (inclusive)
                    return true;
            }
        }
        return false;
    }

    public static ArrayList<String> numberToWord(String phoneNumber, Queue<String> possibilities, int currentNumber) {
        if (phoneNumber.length() == 0) {
            return new ArrayList<String>();
        }
        if (currentNumber == phoneNumber.length()) {
            ArrayList<String> returnList = new ArrayList<String>();
            while (!possibilities.isEmpty()) {
                returnList.add(possibilities.poll());
            }
            return returnList;
        }
        HashMap<Character, ArrayList<Character>> map = new HashMap<Character, ArrayList<Character>>();
        map.put('2', new ArrayList<Character>(Arrays.asList('a', 'b', 'c')));
        map.put('3', new ArrayList<Character>(Arrays.asList('d', 'e', 'f')));
        map.put('4', new ArrayList<Character>(Arrays.asList('g', 'h', 'i')));
        map.put('5', new ArrayList<Character>(Arrays.asList('j', 'k', 'l')));
        map.put('6', new ArrayList<Character>(Arrays.asList('m', 'n', 'o')));
        map.put('7', new ArrayList<Character>(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<Character>(Arrays.asList('t', 'u', 'v')));
        map.put('7', new ArrayList<Character>(Arrays.asList('w', 'x', 'y', 'z')));

        int currentPossibilities = possibilities.size();
        if (currentPossibilities == 0) {
            for (Character c : map.get(phoneNumber.charAt(currentNumber))) {
                possibilities.add(String.valueOf(c));
            }
        }
        else {
            for (int i = 0; i < currentPossibilities; i++) {
                String current = possibilities.poll();
                for (Character c : map.get(phoneNumber.charAt(currentNumber))) {
                    possibilities.add(current + c);
                }
            }
        }
        return numberToWord(phoneNumber, possibilities, currentNumber + 1);
    }
}
