package main.Java4;

import java.util.*;

public class Lesson5DZ {

    public Collection<String> returnHashset(List<String> list01) {
        return new HashSet<>(list01);
    }

    public <K, V> HashMap<V, K> inverse(Map<K, V> map) {
        HashMap<V, K> hashMap = new HashMap<V, K>();
        for (Map.Entry<K, V> entry : map.entrySet())
            hashMap.put(entry.getValue(), entry.getKey());
        return hashMap;
    }
}