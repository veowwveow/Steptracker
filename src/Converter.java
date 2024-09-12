public class Converter {
    double convertToKm(int steps) {
        double km = steps * 75.0 / 100000;
        return  km;
    }
    double convertStepsToKilocalories(int steps) {
        double kilocalories = steps * 50.0 / 1000;
        return kilocalories;
    }
}
