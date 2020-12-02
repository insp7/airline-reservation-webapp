package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "airports")
public class Airport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long code;
    private String name;
    private String city;
    private String state;

    Airport() { }

    public Airport(long code, String name, String city, String state) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.state = state;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        return code == airport.code;
    }

    @Override
    public int hashCode() {
        return (int) (code ^ (code >>> 32));
    }

    @Override
    public String toString() {
        return "Airport{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
