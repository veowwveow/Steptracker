public class Converter {

    // Green
    // Очень здорово, что учла, что количество км может быть дробным, молодец!
    double convertToKm(int steps) {
        // Yellow
        // Необязательно в таких случаях создавать дополнительную переменную,
        // чтобы сохранить значение выражения.
        // Можно сразу возвращать
        // return steps * 75.0 / 100000
        double km = steps * 75.0 / 100000;
        return  km;
    }
    double convertStepsToKilocalories(int steps) {
        // Yellow
        // Необязательно в таких случаях создавать дополнительную переменную,
        // чтобы сохранить значение выражения.
        double kilocalories = steps * 50.0 / 1000;
        return kilocalories;
    }
}
