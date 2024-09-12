public class Converter {

    // Green
    // Очень здорово, что учла, что количество км может быть дробным, молодец!
    double convertToKm(int steps) {
        return steps * 75.0 / 100000;
    }
    double convertStepsToKilocalories(int steps) {
        return steps * 50.0 / 1000;
    }
}
