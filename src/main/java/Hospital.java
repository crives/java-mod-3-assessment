import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Hospital {

    private String name;
    List<Patient> patients = new ArrayList<>();

    public Hospital() {}

    public Hospital(String name, List<Patient> patients) {
        this.name = name;
        this.patients = patients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Hospital " + name + ", ";
    }
}
