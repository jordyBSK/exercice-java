package ch.jobtrek;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collections {

    /**
     * @param array An array that contains strings of different lengths
     * @param size  The string size used to chunk the array
     * @return An array containing two arrays, one with the stings below and equal
     * of the size, and another with the stings longer than the size
     */
    public static List<List<String>> chunkArrayByStringSize(List<String> array, int size) {
        List<String> shorter = new ArrayList<String>();
        List<String> longer = new ArrayList<String>();

        for (String string : array) {
            if (string.length() <= size) {
                shorter.add(string);
            } else {
                longer.add(string);
            }
        }

        return List.of(shorter, longer); // Replace with your code here
    }

    /**
     * @param numbers A list of integers
     * @return A list containing the integers of the original list, without
     * duplicates, sorted by frequency of occurrence
     */
    public static List<Integer> frequencyOfApparition(List<Integer> numbers) {

        return numbers.stream()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    /**
     * @param numbers A list, containing list of numbers
     * @return The sum of all numbers, but all odd numbers should be multiplied before sum
     * Should return zero if there is no numbers
     */
    public static int sumArrays(List<List<Integer>> numbers) {

        return numbers.stream()
                .flatMap(List::stream)
                .mapToInt(number -> (number % 2 == 1) ? 2 * number : number)
                .sum();
    }

    /**
     * @param students A hashmap containing students name as key, and student grade as value
     * @return The student with the best grade in the map
     */
    public static String bestStudent(Map<String, Integer> students) {
        return students
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getKey))
                .get().getKey();
    }
}
