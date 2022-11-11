package SuperMarket;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue1 = new ArrayBlockingQueue<>(5);
        fillQueue(queue1);
        System.out.println(queue1);

        ArrayBlockingQueue<String> queue2 = new ArrayBlockingQueue<>(5);
        fillQueue(queue2);
        System.out.println(queue2);

        addCustomerToNewQueue("Случайный посетитель N", queue1, queue2);
        System.out.println(queue1);
        System.out.println(queue2);

        removeCustomer(queue1, queue2);

//        ArrayBlockingQueue<String> queue3 = new ArrayBlockingQueue<>(5);
//        fillQueue(queue3);
//
//        addCustomer("Случайный посетитель", queue1, queue2, queue3);
//        addCustomer("Случайный посетитель2", queue1, queue2, queue3);
    }

    public static void fillQueue(ArrayBlockingQueue queue) {
        int random = (int) (Math.random() * 5) + 1;
        for (int i = 0; i < random; i++) {
            String customer = "Посетитель " + (i + 1);
            queue.add(customer);
        }
    }

//    public static void addCustomer(String customer, ArrayBlockingQueue queue1, ArrayBlockingQueue queue2, ArrayBlockingQueue queue3) {
//        if (queue1.remainingCapacity() <= 0 && queue2.remainingCapacity() <= 0 && queue3.remainingCapacity() <= 0) {
//            System.out.println("Все очереди заполнены, срочно зовите Галю");
//        } else if (queue1.size() <= queue2.size() && queue1.size() <= queue3.size()) {
//            queue1.add(customer);
//            System.out.println("Посетитель добавлен в очередь на кассу №1");
//        } else if (queue2.size() <= queue1.size() && queue2.size() <= queue3.size()) {
//            queue2.add(customer);
//            System.out.println("Посетитель добавлен в очередь на кассу №2");
//        } else if (queue3.size() <= queue1.size() && queue3.size() <= queue2.size()) {
//            queue3.add(customer);
//            System.out.println("Посетитель добавлен в очередь на кассу №3");
//        }
//    }

    public static void addCustomerToNewQueue(String customer, ArrayBlockingQueue queue1, ArrayBlockingQueue queue2) {
        if (queue1.remainingCapacity() <= 0 && queue2.remainingCapacity() <= 0) {
            System.out.println("Все очереди заполнены, Галя открывает кассу №3");
            ArrayBlockingQueue<String> queue3 = new ArrayBlockingQueue<>(5);
            queue3.add(customer);
            System.out.println("Посетитель добавлен в очередь на кассу №3");
            System.out.println(queue3);
        } else if (queue1.size() <= queue2.size()) {
            queue1.add(customer);
            System.out.println("Посетитель добавлен в очередь на кассу №1");
        } else if (queue2.size() <= queue1.size()) {
            queue2.add(customer);
            System.out.println("Посетитель добавлен в очередь на кассу №2");
        }
    }

    public static void removeCustomer(ArrayBlockingQueue queue1, ArrayBlockingQueue queue2) {
        int random = (int) (Math.random() * 2);
        ArrayList<ArrayBlockingQueue> queueList = new ArrayList<>();
        queueList.add(queue1);
        queueList.add(queue2);
        for (int i = 0; i < queueList.size(); i++) {
            if (queue1.remainingCapacity() <= 0 && queue2.remainingCapacity() <= 0) {
                ArrayBlockingQueue<String> queue3 = new ArrayBlockingQueue<>(5);
                queue3.add("Случайный посетитель M");
                queueList.add(queue3);
            }
            queueList.get(random).remove();
            break;
        }
        System.out.println(queueList);
    }
}
