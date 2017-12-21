package BotPackage;

import java.io.File;
import java.util.*;

/**
 * Created by C17050 on 12/19/2017.
 */
public class MiscUtils {
    
    /*
    copy pasted from https://stackoverflow.com/questions/8119366/sorting-hashmap-by-values, "Rais Alam" response
     */
    public static Map<File, Integer> sortByComparator(Map<File, Integer> unsortMap, final boolean order)
    {

        List<Map.Entry<File, Integer>> list = new LinkedList<Map.Entry<File, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<File, Integer>>()
        {
            public int compare(Map.Entry<File, Integer> o1,
                               Map.Entry<File, Integer> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<File, Integer> sortedMap = new LinkedHashMap<File, Integer>();
        for (Map.Entry<File, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
