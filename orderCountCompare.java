import java.util.Comparator;
//Mithuusan Kirupananthan
//Student ID: 501102123
public class orderCountCompare implements Comparator<Integer>
{
    public int compare(Integer ord1, Integer ord2)
    {
        return new Integer(ord1).compareTo(ord2);
    }


}
