import java.util.List;
import java.util.ArrayList;

public class Doctor {
    public String name;
    public Specialty specialty;

    public int healingPower;

    public List<Patient> patients = new ArrayList<>();

    public Doctor() {
    }

    public Doctor(String name, Specialty specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    //
    // TODO /////// treatPatient()
    //
    public void treatPatient(Patient patient) {


    }

    // TODO removePatient()
    //
    public void removePatient(Patient patient) {

    }

    public int getHealingPower() {
        return healingPower;
    }

    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }

    @Override
    public String toString() {
        return "Doctor: " + name + ", " + specialty + ", " + "Patients: " + patients;
    }
}
