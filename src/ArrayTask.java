import java.util.Arrays;
import java.util.Random;

public class ArrayTask {
    public static void main(String[] args) {
        int[] nums = new Random().ints(20, -100, 101).toArray();
        System.out.println("Елементи масиву: " + Arrays.toString(nums));

        int negSum = 0, even = 0, odd = 0, min = nums[0], max = nums[0], minIdx = 0, maxIdx = 0, firstNeg = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negSum += nums[i];
                if (firstNeg == -1) firstNeg = i;
            }
            if (nums[i] % 2 == 0) even++; else odd++;
            if (nums[i] < min) { min = nums[i]; minIdx = i; }
            if (nums[i] > max) { max = nums[i]; maxIdx = i; }
        }

        System.out.println("Сума від'ємних чисел: " + negSum);
        System.out.println("Кількість парних чисел: " + even);
        System.out.println("Кількість непарних чисел: " + odd);
        System.out.println("Найменший елемент: " + min + " (з індексом " + minIdx + ")");
        System.out.println("Найбільший елемент: " + max + " (з індексом " + maxIdx + ")");

        if (firstNeg == -1 || firstNeg == nums.length - 1) {
            System.out.println("Від'ємних чисел немає або вони в кінці.");
        } else {
            double avg = Arrays.stream(nums, firstNeg + 1, nums.length).average().orElse(0);
            System.out.printf("Середнє арифметичне чисел після першого від'ємного: %.2f\n", avg);
        }
    }
}