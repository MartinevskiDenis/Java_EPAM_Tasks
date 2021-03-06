package by.epam.lab3.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Aircraft {
    private static final Logger log = LogManager.getLogger();
    private String name;
    private int price;
    private int capacity;
    private List<Owner> stores;

    public Aircraft() {
        this.name = "";
        this.price = 0;
        this.capacity = 0;
        this.stores = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Owner> getStores() {
        return stores;
    }

    public void addOwner(Owner owner) {
        this.stores.add(owner);
    }

    public void setStores(List<Owner> stores) {
        if(stores != null) {
            this.stores = new ArrayList<>(stores);
        } else {
            log.error("Ошибка! В функцию передано значение null");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aircraft aircraft = (Aircraft) o;

        if (price != aircraft.price) return false;
        if (capacity != aircraft.capacity) return false;
        if (name != null ? !name.equals(aircraft.name) : aircraft.name != null) return false;
        return stores != null ? stores.equals(aircraft.stores) : aircraft.stores == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + price;
        result = 31 * result + capacity;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Aircraft{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", capacity=").append(capacity);
        sb.append(", stores=").append(stores.size());
        sb.append('}');
        return sb.toString();
    }
}
