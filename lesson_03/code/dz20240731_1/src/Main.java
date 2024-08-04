/*
Дан диапазон чисел: от 1 до 2_000_000 включительно. Задача: найти,
сколько чисел из этого диапазона делятся нацело на 21.

Решить данную задачу в один поток.
Решить данную задачу в два потока, разделив между потоками заданный диапазон чисел пополам.

Естественно, результаты должны совпадать.
Попробуйте решить самостоятельно, если не получается подсказка на след. странице.

 */
public class Main {
    public static void main(String[] args) {
        int rangeStart = 1;
        int rangeEnd = 2_000_000;
        int counter = 0;

        for (int i=rangeStart; i<rangeEnd; i++){
            if(isAcceptableNumber(i)){
                counter++;
            }
        }

        System.out.println("Result:" + counter);

    }

    private static boolean isAcceptableNumber(int i) {
        return i % 21 == 0;
    }
}
