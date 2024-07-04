package utils.data;

import java.util.LinkedHashMap;

public class DataSet {
    private static final LinkedHashMap<Data,Object> dataSet = new LinkedHashMap<>();

    public static void put(Data key, Object value){
        dataSet.put(key, value);
    }

    public static String get(Data key){
        return dataSet.get(key).toString();
    }
}