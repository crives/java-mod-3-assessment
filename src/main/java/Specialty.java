import java.util.ArrayList;
import java.util.List;

public class Specialty {
    String name;
    int counter = 1;

    private List<Ailment> ailmentsList = new ArrayList<>();

    public Specialty() {};

    public Specialty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ailment> getAilmentsList() {
        return ailmentsList;
    }

    public Ailment getAilmentFromList(String ailmentName) {
        Ailment ailmentToReturn = new Ailment();

        for (Ailment ail : ailmentsList) {
            if (ail.getName().equals(ailmentName)) {
                ailmentToReturn = ail;
            }
        }
        return ailmentToReturn;
    }

    public void addAilment(Ailment ailment) {
        this.ailmentsList.add(ailment);
    }

    public void printAilmentsString() {
        String ailmentString = "";
        for(Ailment ailment: ailmentsList) {
            ailmentString = counter + ". " + ailment.getName();
            counter++;
        }
        System.out.println(ailmentString);
    }

    public String printAilmentsToString() {
        int counter = 1;
        String ailmentString = "";
        for(Ailment ailment: ailmentsList) {
            ailmentString = counter + ". " + ailment.getName() + "\n";
            counter++;
        }
        return ailmentString;
    }

    @Override
    public String toString() {
        return "Specialty: " + name + ", Ailments: " + printAilmentsToString();
    }
}
