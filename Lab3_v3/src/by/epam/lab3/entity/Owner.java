package by.epam.lab3.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Owner {
    private static final Logger log = LogManager.getLogger();
    private String name;
    private List<Aircraft> aircraftList;
    private String location;

    public Owner() {
        this.name = "";
        this.aircraftList = new ArrayList<>();
        this.location = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Aircraft> getAircraftList() {
        return aircraftList;
    }

    public void setAircraftList(List<Aircraft> aircraftList) {
        if(aircraftList != null) {
            this.aircraftList = new ArrayList<>(aircraftList);
        } else {
            log.error("Ошибка! В функцию передано значение null");
        }
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void addAircraft(Aircraft aircraft) {
        this.aircraftList.add(aircraft);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owner owner = (Owner) o;

        if (name != null ? !name.equals(owner.name) : owner.name != null) return false;
        if (aircraftList != null ? !aircraftList.equals(owner.aircraftList) : owner.aircraftList != null) return false;
        return location != null ? location.equals(owner.location) : owner.location == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Owner{");
        sb.append("name='").append(name).append('\'');
        sb.append(", aircraftList=").append(aircraftList.size());
        sb.append(", location='").append(location).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
