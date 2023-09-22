public class Runner {

    public static void main(String[] args) {
        System.out.println(sum(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }

    static int sum(int a, int b) {
        int result = a+b;
        return result;
    }
}
