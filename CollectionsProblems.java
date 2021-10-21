import java.util.ArrayList;

/* 2. Создать коллекцию целых чисел,  написать методы:
2.1 Который отриццательные числа делает положительными и возвращает коллекцию
2.2. Который четные числа умножает на 100, а от нечетных отнимает 100 и возвращает коллекцию
Колличество принимаемых и возвращаемых элементов коллекций должно совпадать */

public class CollectionsProblems {

    public static void main(String []args){
        ArrayList<Integer> given = new ArrayList<>();
        given.add(2);
        given.add(-5);
        given.add(0);
        given.add(101);
        
        System.out.println(given);
        System.out.println(convertToPositive(given));
        System.out.println(multipleEvens100AndReduceOdds100(given));
    }
    
    public static ArrayList<Integer> convertToPositive (ArrayList<Integer> nums) {
        ArrayList<Integer> result = new ArrayList<>(nums.size());
        for (int elem : nums) {
            result.add(Math.abs(elem));
        }
        return result;
    }
    
    public static ArrayList<Integer> multipleEvens100AndReduceOdds100 (ArrayList<Integer> nums) {
        ArrayList<Integer> result = new ArrayList<>(nums.size());
        for (int elem : nums) {
            if (elem % 2 == 0) {
                result.add(elem * 100);
            } else {
                result.add(elem - 100);
            }
        }
        return result;
    }
}