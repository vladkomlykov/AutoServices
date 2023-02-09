import java.util.ArrayList;
import java.util.Scanner;

public class AutoServices {

    private static ArrayList<Service> services = new ArrayList<>();
    private static double totalCost = 0.0;

    public void addService () {
        Scanner scanner = new Scanner(System.in);

        services.add(new Service("Замена масла", 30.0));
        services.add(new Service("Вращение шины", 40.0));
        services.add(new Service("Замена батареи", 60.0));
        services.add(new Service("Замена тормозных колодок", 100.0));
        services.add(new Service("Промывка радиатора", 80.0));
        services.add(new Service("Промывка коробки передач", 120.0));
        services.add(new Service("Настройка двигателя", 200.0));
        services.add(new Service("Подзарядка кондиционера", 150.0));
        services.add(new Service("Замена генератора переменного тока", 250.0));
        services.add(new Service("Замена стартера", 180.0));

        System.out.println("**** Доступные услуги****");
        for (int i = 0; i < services.size(); i++) {
            System.out.println((i + 1) + ". " + services.get(i).getName() + " - $" +  services.get(i).getCost());
        }

        ArrayList<Service> selectedServices = new ArrayList<>();
        while (true) {
            System.out.print("Введите номер услуги, которую вы хотите выбрать (0 для завершения): ");
            try {
                int serviceNum = scanner.nextInt();
                if (serviceNum == 0) {
                    break;
                }
                selectedServices.add(services.get(serviceNum - 1));
                totalCost += services.get(serviceNum - 1).getCost();
            } catch (Exception e) {
                System.out.println("Неверный ввод, пожалуйста, попробуйте еще раз.");
                scanner.nextLine();
            }
        }

        System.out.println("**** Выбранные услуги ****");
        for (int i = 0; i < selectedServices.size(); i++) {
            System.out.println((i + 1) + ". " + selectedServices.get(i).getName() + " - $"+ selectedServices.get(i).getCost());
        }
        System.out.println("Общая стоимость: $ " + totalCost);

        System.out.print("Введите сумму ваших средств: $");
        try {
            double funds = scanner.nextDouble();
            if (funds < totalCost) {
                System.out.println("У вас недостаточно денег. Пожалуйста, удалите некоторые сервисы.");
            } else {
                System.out.println("Ваша сдача: $ " + (funds - totalCost));
            }
        } catch (Exception e) {
            System.out.println("Неверный ввод, пожалуйста, попробуйте еще раз.");
            scanner.nextLine();
        }

        scanner.close();
    }
}





