import java.util.Comparator;

public class orderCountCompare implements Comparator<Integer>
{
    public int compare(Integer ord1, Integer ord2)
    {
        return new Integer(ord1).compareTo(ord2);
    }


}
