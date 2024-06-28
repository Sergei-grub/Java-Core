package StringBuilderTest;

public class StringBuilderTest {
    public static void main(String[] args) {
        String s = "Example";
        long timeStart = System.nanoTime();
        for (int i = 0; i < 30000; ++i) {
            s = s + i;
        }
        double deltaTime = (System.nanoTime() - timeStart) * 0.000000001;
        System.out.println("String Delta time: " + deltaTime);

        StringBuilder sb = new StringBuilder("Example");
        long timeStart2 = System.nanoTime();
        for (int i = 0; i < 100_000; ++i) {
            sb = sb.append(i);
        }
        double deltaTime2 = (System.nanoTime() - timeStart2) * 0.000000001;
        System.out.println("StringBuilder Delta time: " + deltaTime2);
    }
}
