public class Patient {
    private String name;
    private String specialtyNeeded;

    public Patient(String name, String specialtyNeeded) {
        this.name = name;
        this.specialtyNeeded = specialtyNeeded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialtyNeeded() {
        return specialtyNeeded;
    }

    public void setSpecialtyNeeded(String specialtyNeeded) {
        this.specialtyNeeded = specialtyNeeded;
    }

    @Override
    public String toString() {
        return "Patient: " + name + ", " + "Specialty Needed: " + specialtyNeeded;
    }
}
