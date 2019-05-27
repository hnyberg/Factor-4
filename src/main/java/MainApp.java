public class MainApp {

    public static void main(String[] args) {

        final int NUMBER_OF_MULTIPLIERS = 4;

        String data = "";
        try {
            data = Data.getData();
        } catch (Exception e){
            e.getStackTrace();
        }

        System.out.println(
                Calculator.calculate4factor(data, NUMBER_OF_MULTIPLIERS));
    }
}
