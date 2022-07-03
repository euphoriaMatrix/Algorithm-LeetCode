import java.util.ArrayList;
import java.util.List;

/**
 * @author xwfstart
 * @create 2022-01-10 21:58
 */
public class TestOne {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(0,2);
        for (Integer integer : list) {
            System.out.println(integer);
        }


    }

}
