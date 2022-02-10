import java.io.*;
import java.util.*;

public class Communication {

    private List<Products> basket = new ArrayList<>();
    private List<Products> listProducts = new ArrayList<>();

    public Communication() {
        listProducts.add(new Products("Вино", "Коньячный завод", 699));
        listProducts.add(new Products("Водка", "Коньячный завод Апшерон", 399));
        listProducts.add(new Products("Абсент", "Коньячный завод Абсентье", 1999));
        listProducts.add(new Products("Хлеб", "Пивоварня", 18));
    }

    public void communications() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean exit = true;
        while (exit) {
            menu("start");
            switch (reader.readLine()) {
                case "1":
                    boolean exitEditors = true;
                    while (exitEditors) {
                        menu("editors");
                        int variant = Integer.parseInt(reader.readLine());
                        if (variant == 1) {
                            System.out.println("Введите имя,производителя и цену ,через запятую");
                            String[] newProducts = reader.readLine().split(",");
                            listProducts.add(new Products(newProducts[0], newProducts[1], Integer.parseInt(newProducts[2])));
                        } else if (variant == 2) {
                            printListProduct();
                            System.out.println("Введите имя удаляемого товара");
                            String deleted = reader.readLine();
                            listProducts.removeIf(products -> products.name.equals(deleted));
                        } else if (variant == 3) {
                            printListProduct();
                        } else if (variant == 4) {
                            exitEditors = false;
                        } else {
                            System.out.println("Неверный ввод");
                        }
                    }
                    break;

                case "2":
                    while (true) {
                        printListProduct();
                        System.out.println("Выберете товар для покупки,введя его имя,по окончанию наберите exit");
                        String basketProd = reader.readLine();
                        if (basketProd.equals("exit")) {
                            break;
                        } else {
                            for (Products products : listProducts) {
                                if (products.name.contains(basketProd)) {
                                    basket.add(products);
                                }
                            }
                        }
                    }
                    while (true) {
                        menu("basket");
                        int variantBasket = Integer.parseInt(reader.readLine());
                        if (variantBasket == 1) {
                            printBasketList();
                        } else if (variantBasket == 2) {
                            System.out.println("Введите название товара,что хотите удалить:");
                            String basketDelete = reader.readLine();
                            basket.removeIf(products -> products.name.equals(basketDelete));
                            printBasketList();
                        } else if (variantBasket == 3) {
                            break;
                        } else {
                            System.out.println("Неверный выбор повторите попытку");
                        }
                    }
                    break;
                case "3":
                    exit = false;
            }
        }
    }


    public void menu(String action) {
        switch (action) {
            case ("start") -> System.out.println(
                    """
                            Режим работы выберете цифру меню:\s
                            1.Режим редактирования \s
                            2.Режим покупки
                            3.Выйти из программы"""
            );
            case ("editors") -> System.out.println(
                    """
                            Что нужно сделать выберете цифру меню::\s
                            1.Занести новый товар в таблицу\s
                            2.Удалить товар из таблицы\s
                            3.Вывести список всех товаров
                            4.Вернуться в главное меню"""
            );
            case ("basket") -> System.out.println(
                    """
                            Работа с корзиной выберете цифру меню:\s
                            1.Вывести товар в корзине\s
                            2.Удалить товар из корзины\s
                            3.Для завершения"""
            );
        }
    }

    public void printListProduct() {
        for (Products products : listProducts) {
            System.out.println(products);
        }
    }

    public void printBasketList() {
        for (Products products : basket) {
            System.out.println(products);
        }
    }
}

