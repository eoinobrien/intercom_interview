package flattener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eoin on 06/11/15.
 */
public class ArrayFlattener {

    public List<Integer> arrayFlattener(Object [] input){
        List<Integer> result = new ArrayList<>();
        for(Object obj : input){
            if(obj instanceof Object []){
                result.addAll(arrayFlattener((Object[]) obj));
            } else if ( obj instanceof Integer){
                result.add((int) obj);
            } else {
                throw new IllegalArgumentException();
            }
        }
        return result;
    }
}
