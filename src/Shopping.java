import java.util.Scanner;

public class Shopping {

    public static void main(String[] args) {

        System.out.println("Вас приветствует список покупок!");

        String[] shoppingList = new String[8];
        int productCount = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите одну из команд:");
            System.out.println("1. Добавление товара в список");
            System.out.println("2. Показать список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить работу");

            int actionNumber = scanner.nextInt(); // переменная для работы с меню

            if (actionNumber == 1) { // Добавление товара в список
                String[] extendedList = new String[shoppingList.length + 1];
                System.arraycopy(shoppingList, 0, extendedList, 0, shoppingList.length);
                shoppingList = extendedList;
                System.out.println("Введите название нового товара: ");
                String productName = scanner.next().replace("_", " "); // несколько слов вводятся через _
                boolean isContain = false; // флаг для проверки повторных вводов продуктов
                for (String s : shoppingList) { // проверка на дубликаты
                    if (productName.equals(s)) {
                        isContain = true;
                        System.out.println("Такой товар уже есть в списке");
                    }
                }
                if (!isContain) { // на основе проверки повторяющихся элементов записываем новые в массив
                    shoppingList[productCount] = productName;
                    System.out.println("Товар " + productName + " добавлен в список под номером " + (productCount + 1));
                    productCount++;
                }
            } else if (actionNumber == 2) { // Показать список покупок
                if (productCount != 0) {
                    for (int i = 0; i < productCount; i++) { //
                        System.out.println((i + 1) + ". " + shoppingList[i]);
                    }
                } else {
                    System.out.println("Список товаров пуст!");
                }
            } else if (actionNumber == 3) { // Очистка списка покупок
                for (int i = 0; i < shoppingList.length; i++) {
                    shoppingList[i] = null;
                    productCount = 0;
                }
                System.out.println("Список товаров очищен!");
            } else if (actionNumber == 4) { // выход из программы
                System.out.println("До скорых встреч!");
                break;
            } else { // обработка неверного ввода
                System.out.println("Неизвестная команда!");
            }
        }
    }
}