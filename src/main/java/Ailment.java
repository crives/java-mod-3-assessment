public class Ailment {

    private String name;

    private Specialty associatedSpecialty;

    public boolean isCurable;

    public int numTreatmentsToCure;

    public Ailment() {};
    public Ailment(String name, Specialty associatedSpecialty, boolean isCurable) {
        this.name = name;
        this.associatedSpecialty = associatedSpecialty;
        this.isCurable = isCurable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specialty getAssociatedSpecialty() {
        return associatedSpecialty;
    }

    public void setAssociatedSpecialty(Specialty associatedSpecialty) {
        this.associatedSpecialty = associatedSpecialty;
    }
    public boolean isCurable() {
        return isCurable;
    }

    public void setCurable(boolean curable) {
        isCurable = curable;
    }
//
//    public int getStartingHealthIndex() {
//        return startingHealthIndex;
//    }
//
//    public void setStartingHealthIndex(int startingHealthIndex) {
//        this.startingHealthIndex = startingHealthIndex;
//    }

    public int getNumTreatmentsToCure() {
        return numTreatmentsToCure;
    }

    public void setNumTreatmentsToCure(int numTreatmentsToCure) {
        this.numTreatmentsToCure = numTreatmentsToCure;
    }
}
