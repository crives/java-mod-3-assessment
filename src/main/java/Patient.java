public class Patient {
    private String name;
    private Specialty specialtyNeeded;

    private Doctor doctor;
    private int healthIndex;

    private Ailment ailment;

    public Patient(String name, Specialty specialtyNeeded, int healthIndex, Ailment ailment) {
        this.name = name;
        this.specialtyNeeded = specialtyNeeded;
        this.healthIndex = healthIndex;
        this.ailment = ailment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specialty getSpecialtyNeeded() {
        return specialtyNeeded;
    }

    public void setSpecialtyNeeded(Specialty specialtyNeeded) {
        this.specialtyNeeded = specialtyNeeded;
    }

    public int getHealthIndex() {
        return healthIndex;
    }

    public void setHealthIndex(int healthIndex) {
        this.healthIndex = healthIndex;
    }

    public Ailment getAilment() {
        return ailment;
    }

    public void setAilment(Ailment ailment) {
        this.ailment = ailment;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", specialtyNeeded='" + specialtyNeeded + '\'' +
                ", healthIndex=" + healthIndex +
                ", ailment=" + ailment +
                '}';
    }
}
