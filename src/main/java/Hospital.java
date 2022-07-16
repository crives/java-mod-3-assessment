import java.util.ArrayList;
import java.util.List;

public class Hospital {

    private String name;
    private SpecialtyContainer specialtyContainer;
    List<Patient> patients = new ArrayList<>();

    public Hospital() {}

    public Hospital(String name, List<Patient> patients) {
        this.name = name;
        this.patients = patients;
//        specialtyContainer = new SpecialtyContainer();
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

//    public SpecialtyContainer getSpecialtyContainer() {
//        return specialtyContainer;
//    }
//
//    public List<Specialty> getSpecialtyList() {
//        return specialtyContainer.getSpecialties();
//    }
//
//    public void addSpecialtyToList(Specialty specialty) {
//        specialtyContainer.addSpecialty(specialty);
//    }

    @Override
    public String toString() {
        return "Hospital " + name + ", ";
    }
}
