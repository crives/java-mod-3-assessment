import java.util.List;
import java.util.ArrayList;

public class Doctor {
    public String name;
    public String specialty;
    public List<Patient> patients = new ArrayList<>();

    public Doctor() {
    }

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Doctor: " + name + ", " + "Specialty: " + specialty + ", " + "Patients: " + patients;
    }
}
