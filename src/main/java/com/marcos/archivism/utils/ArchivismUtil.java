package com.marcos.archivism.utils;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArchivismUtil {

    public static List<String> simpleNumericMethod(List<String> input){
        List<Integer> intList = ListUtils.handleStringListToIntegerList(input);
        ListUtils.sort(intList);
        return handleIntegerListToStringList(intList);
    }

    public static List<String> terminalNumericMethod(List<String> input){
        var reversePairsList = input.stream()
                .map(ArchivismUtil::handleReversePairs)
                .toList();
        var intList = ListUtils.handleStringListToIntegerList(reversePairsList);
        var sortedList = ListUtils.sort(intList);
        return handleIntegerListToStringList(sortedList);
    }

    public static List<String>  chronologicalMethod(List<String> input){
        List<String> ordernedList = simpleNumericMethod(input);
        return ordernedList.stream()
                .map(item -> addSeparator(item, "/"))
                .toList();
    }

    public static String addSeparator(String input, String separator){
        String[] separatedString = handleStringToPairs(input);
        return String.join(separator, separatedString);
    }

    public static String handleReversePairs(String input){
        String[] separatedString = handleStringToPairs(input);
        return separatedString[0] + separatedString[1] + separatedString[2];
    }
    public static String[] handleStringToPairs(String input){
        String[] result = new String[3];
        result[0] = input.substring(0,2);
        result[1] = input.substring(2,4);
        result[2]= input.substring(4,6);
        return result;
    }

    public static List<String> handleIntegerListToStringList(List<Integer> input){
        return input.stream()
                .map(item -> String.format("%0" + 6 + "d", item))
                .toList();
    }

    public static void printSimpleNumericList(List<String> simpleNumericList) {
        System.out.println("LISTA ORDENADA PELO MÉTODO NUMÉRICO SIMPLES: " + simpleNumericList.size());
        ListUtils.printList(simpleNumericList);

    }

    public static void printTerminalNumericList(List<String> terminalNumericList) {
        System.out.println("LISTA ORDENADA PELO MÉTODO NUMÉRICO TERMINAL: " + terminalNumericList.size());
        ListUtils.printList(terminalNumericList);
    }

    public static void printChronologicList(List<String> chronologicList) {
        System.out.println("LISTA ORDENADA COM MÉTODO CHRONOLÓGICO: " + chronologicList.size());
        ListUtils.printList(chronologicList);
    }
}