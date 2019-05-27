public class MainApp {

    public static void main(String[] args) {

        final int ROW_LENGTH = 4;

        String data = "";
        try {
            data = Data.getData();
        } catch (Exception e){
            e.getStackTrace();
        }
        String biggestFactor = Calculator.calculate4factor(data, ROW_LENGTH);
        System.out.println(biggestFactor);
    }
}
