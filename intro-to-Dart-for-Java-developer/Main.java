import java.util.Arrays;

public class Main {

    public static String repeatString(String s, int count){
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<count; i++){
            sb.append(s);
        }
        return sb.toString();
    }

    static String scream(int length){
        return "A" + repeatString("a", length)+"h!";
    }

    public static void main(String[] args) {
        int[] values = {1,2,3,5,10,50};

        Arrays.stream(values)
                .mapToObj(Main::scream)
                .forEach(System.out::println);

        Arrays.stream(values)
                .skip(1)
                .limit(3)
                .mapToObj(Main::scream)
                .forEach(System.out::println);
    }
}
