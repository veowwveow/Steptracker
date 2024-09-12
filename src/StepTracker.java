import java.util.Scanner;

public class StepTracker {
    // Red
    // Неиспользуемые поля необходимо удалять
    MonthData monthData = new MonthData();
    Converter converter = new Converter();
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    // Yellow
    // Есть негласное соглашение, что сначала идут все поля
    // Потом конструктор, а потом все остальные методы
    // Поэтому это поле я бы рекомендовал перенести наверх
    int goalByStepTracker = 10000;
    void changeStepGoal() {
        System.out.println("Введите новую цель");
        int newGoal = scanner.nextInt();
        while (true) {
            if (newGoal < 1) {
                System.out.println("Количество шагов не может быть отрицательным или равно нулю");
                newGoal = scanner.nextInt();
            } else {
                break;
            }
        }
        goalByStepTracker = newGoal;
    }

    // Green
    // Очень интересно и круто реализованы проверки! Мне нравится)
    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        while (true) {
            if (month > 12 || month < 0) {
                System.out.println("Такого месяца не существует");
                month = scanner.nextInt();
            } else {
                break;
            }
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();
        while (true) {
            if (day > 30 || day < 1) {
                System.out.println("Такого дня не существует");
                day = scanner.nextInt();
            } else {
                break;
            }
        }

        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        while (true) {
            if (steps < 0) {
                System.out.println("Количество шагов не может быть отрицательным");
                steps = scanner.nextInt();
            } else {
                break;
            }
        }
        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;
    }

    void printStatistic() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        while (true) {
            if (month > 12 || month < 1) {
                System.out.println("Такого месяца не существует");
                month = scanner.nextInt();
            } else {
                break;
            }
        }
        MonthData monthData = monthToData[month - 1];
        int sumSteps = monthData.SumStepsFromMonth();
        System.out.println("Статистика за месяц:");
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Общее количество шагов за месяц: " + sumSteps);
        // Red
        // Метод вызван просто так. Он возвращает значение в пустоту
        monthData.maxSteps();
        System.out.println("Максимальное количество шагов за месяц: " + monthData.maxSteps());
        System.out.println("Среднее количество шагов в день: " + sumSteps / 30);
        // Red
        // Метод вызван просто так. Он возвращает значение в пустоту
        converter.convertToKm(sumSteps);
        System.out.println("Пройденная дистанция (в км): " + converter.convertToKm(sumSteps));
        // Red
        // Метод вызван просто так. Он возвращает значение в пустоту
        converter.convertStepsToKilocalories(sumSteps);
        System.out.println("Количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(sumSteps));
        // Red
        // Метод вызван просто так. Он возвращает значение в пустоту
        monthData.bestSeries(goalByStepTracker);
        System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepTracker));
        System.out.println();
    }
}
