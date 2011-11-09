package ershop.webservices.inventory.impl.params;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Eugen, 11/6/11 11:00 PM
 */

@XmlRootElement
public class MapEntry<K, V> {
    @XmlElement (name = "key", type = Object.class)
    private K key;
    @XmlElement (name = "value", type = Object.class)
    private V value;

    public MapEntry(){}

    public MapEntry(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
