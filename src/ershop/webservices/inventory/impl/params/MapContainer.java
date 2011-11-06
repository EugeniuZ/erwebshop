package ershop.webservices.inventory.impl.params;

import java.util.Map;

/**
 * @author Eugen, 11/6/11 11:00 PM
 */
public class MapContainer<K, V> {
    private Map<K, V> map;


    public Map<K, V> getMap() {
        return map;
    }

    public void setMap(Map<K, V> map) {
        this.map = map;
    }
}
