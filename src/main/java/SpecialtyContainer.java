import java.util.ArrayList;
import java.util.List;

public class SpecialtyContainer {

    private List<Specialty> specialties;

    public SpecialtyContainer() {
        specialties = new ArrayList<>();
    }

    public List<Specialty> getSpecialties() {
        return specialties;
    }

    public void addSpecialty(Specialty specialty) {
        specialties.add(specialty);
    }
}
