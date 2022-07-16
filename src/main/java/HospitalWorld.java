import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class HospitalWorld {
    public static int numDoctors;
    public static Doctor doctor;
    public static Patient patient;
    public static Ailment ailment;
    public static Specialty specialty;
    public static Hospital hospital = new Hospital();
    public static Map<Specialty, List<Doctor>> docBySpecialtyMap = new HashMap<>();

    public static List<Specialty> specialtyList = new ArrayList<>();

    public static boolean repeat = true;
    public static Scanner sc = new Scanner(System.in); 
    public static String welcomeMenu = "\nWould you like to: \n1. Create the hospital \n2. Exit \n \n(Enter below the number corresponding to your choice.)";
    public static String askHospitalName = "\nWhat would you like to name your hospital?";
    public static String error = "\n| \n**Please enter a valid input value!** \n| \nV";
    public static String askDoctorNames = "\nNow, let's name 3 doctors who will work at this hospital. \nWhat will be the first doctor's name?";
    public static String doctorsNextName = "\nWhat will be the next doctor's name?";
    public static String askPatientNames = "\nLet's now name 5 patients who will be seeing doctors at this hospital. \nWhat will the first patient be called?";
    public static String askPatientName = "\nWhat will the next patient be called? ";
    public static String askDoctorSpecialty = "\nWhat specialty will this doctor have?";
    public static String addedDoctor = "\nAdded the doctor to their respective list of specialties!";
    public static String doctorCreationComplete = "\nDoctor creation is complete! \nThese doctors now work at this hospital!";
    public static String patientCreationComplete = "\nPatient creation is complete! \nThese patients will now be matched with doctors at the hospital according to their specialty.";
    public static String askPatientSpecialty ="\nWhat specialty are they looking to be seen for?";
    public static String matchingPatients = "\nNow matching patients...";
    public static String printEverything = "\nNow, to show you the whole system:";
    public static String askPatientAilment = "\nWhat ailment does this patient have? (Please choose from the list below with the corresponding number): \n";
    public static String askHealthIndex = "\nWhat is the health index of the patient according to this ailment? \n(Enter a number below):";
    public static String askNumTreatmentsToCure = "\nIn how many treatments will this ailment be cured?";
    public static String askNumTreatments = "\nHow many treatments would you like this patient to have?";
    public static String askIsCurable = "\nIs this ailment curable? \n(Type the number corresponding to your answer): \n1. Yes \n2. No";
    public static String askSpecialtyAilment = "\nWhat is an ailment related to this specialty?";

    public static String displayHealthIndexMsg = "\nA patient with this ailment has a health index of: ";
    public static FileReader fileReader;
    public static final String JSONFILE = "myHospital.json";

    public static void main(String[] args) {
        log("\n~*~*~*~ \nWelcome to the Hospital Space where you can create your own Hospital! \n~*~*~*");
        welcome();
    }

    public static void log(String message) {
        System.out.println(message);
    }

    public static void welcome() {
        while (repeat) {
            try {
                log(welcomeMenu);
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1: 
                        nameHospital();
                        break;
                    case 2:
                        log("Goodbye!");
                        repeat = false;
                        System.exit(0);
                        break;     
                }
            } catch (Exception e) {
                sc.nextLine();
                log(error);
            }
        }
    }

    public static Hospital readHospitalFromJSON() {
        String json = fileReader.readFromFile(JSONFILE);
        try {
            return new ObjectMapper().readValue(new File(JSONFILE), Hospital.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void nameHospital() {
        log(askHospitalName);
        try {
            String hospitalName = sc.nextLine();
            hospital.setName(hospitalName);
            createDoctors(hospital);
        } catch (Exception e) {
            sc.nextLine();
            log(error);
        }
    }

    public static void createDoctors(Hospital hospital) {
        log(askDoctorNames);
        while (numDoctors <= 3) {
            if (numDoctors > 0 && numDoctors < 3) {
                log(doctorsNextName);
            }
            try {
                String doctorName = sc.nextLine();
                log(askDoctorSpecialty);
                String doctorSpecialtyName = sc.nextLine();
                specialty = new Specialty(doctorSpecialtyName);
                specialtyList.add(specialty);
                doctor = new Doctor(doctorName, specialty);
                createDoctorAilments(doctor);
                numDoctors++;

                if (!docBySpecialtyMap.containsKey(specialty.getName())) {
                    docBySpecialtyMap.put(specialty, new ArrayList<Doctor>());
                    docBySpecialtyMap.get(specialty).add(doctor);
                    log(addedDoctor);
                } else if (docBySpecialtyMap.containsKey(specialty)) {
                    docBySpecialtyMap.get(specialty).add(doctor);
                    log(addedDoctor);
                }
                if (numDoctors == 3) {
                    log(doctorCreationComplete);
                    // Print out doctors
                    docBySpecialtyMap.entrySet().forEach(entry -> {
                        System.out.println(entry.getKey() + " " + entry.getValue());
                    });

                    createPatients();

                    sc.nextLine();
                }
            } catch (Exception e) {
                sc.nextLine();
                log(error);
                repeat = false;
            }
        }
    }

    public static void createDoctorAilments(Doctor doctor) {
        log(askSpecialtyAilment);
        String ailmentName = sc.nextLine();
        log(askIsCurable);
        boolean isCurable = sc.nextInt() == 1 ? true : false;
        ailment = new Ailment(ailmentName, doctor.getSpecialty(), isCurable);
        doctor.getSpecialty().addAilment(ailment);
        sc.nextLine();
    }

// Create a list of specialties
//Set<Specialty> specialties = docBySpecialtyMap.keySet();
//        specialties.forEach((specialty) -> specialtyList.add(specialty));
    public static void createPatients() {
        log(askPatientNames);
        while (hospital.patients.size() <= 5) {
            if (hospital.patients.size() > 0 && hospital.patients.size() < 5) {
                log(askPatientName);
            }
            try {
                String patientName = sc.nextLine();
                log(askPatientSpecialty);
                String ptSpecialtyName = sc.nextLine();

                Specialty ptSpecialty = new Specialty(ptSpecialtyName);
                log(askPatientAilment);
                // Print Ailments
                ptSpecialty.printAilmentsString();

                String ptAilmentName = sc.nextLine();
                Ailment ptAilment = specialty.getAilmentFromList(ptAilmentName);

                int healthIndex = ptAilment.isCurable() ? (100 - (ptAilment.getNumTreatmentsToCure() * 10)) : 50;
                log(displayHealthIndexMsg + healthIndex);

                // Ask how many treatments the pt would like to have
                log(askNumTreatments);
                // TODO Display health index after each treatment
                // do patient.doctor.treatPatient();

//                String message = isCurable ? askNumTreatments : askNumTreatments;
//                log(message);
//                int numTreatments = sc.nextInt();
                patient = new Patient(patientName, ptSpecialty, healthIndex, ptAilment);
                hospital.patients.add(patient);
                // match doctor accordingly
                matchPatients(patient);

                if (hospital.patients.size() == 5) {
                    //Print list of patients + their specialties
                    log(patientCreationComplete);
                    System.out.println(hospital.patients);
                    printAll();
                    sc.nextLine();
                }
            } catch (Exception e) {
                sc.nextLine();
                log(error);
            }
        }
    }

    public static void selectPatient() {
        // Allow the user to select a patient to go through a round of treatment
        // Display patients by index in list
        // Allow user to enter value corresponding to index
        // Get patient from list
        // get ailment + health index + apply treatment (doctor.treatPatient()) // CREATE METHOD
        // display message
    }

    public static void matchPatients(Patient patient) {
        System.out.println(matchingPatients);
        List<Doctor> doctorsInSpecialty = docBySpecialtyMap.get(patient.getSpecialtyNeeded());
            if (doctorsInSpecialty.isEmpty()) {
                doctorsInSpecialty.get(0).patients.add(patient);
            }
            if (!doctorsInSpecialty.isEmpty()) {
                if (doctorsInSpecialty.size() == 1) {
                    doctorsInSpecialty.get(0).patients.add(patient);
                } else if (doctorsInSpecialty.size() == 2) { 
                        if (doctorsInSpecialty.get(0).patients.isEmpty()) {
                            doctorsInSpecialty.get(0).patients.add(patient);
                        } else if (doctorsInSpecialty.get(1).patients.isEmpty()) {
                            doctorsInSpecialty.get(1).patients.add(patient);
                        } else {
                            doctorsInSpecialty.get(0).patients.add(patient);
                        } 
                } else if (doctorsInSpecialty.size() == 3) {
                    if (doctorsInSpecialty.get(0).patients.isEmpty()) {
                        doctorsInSpecialty.get(0).patients.add(patient);
                    } else if (doctorsInSpecialty.get(1).patients.isEmpty()) {
                        doctorsInSpecialty.get(1).patients.add(patient);
                    } else if (doctorsInSpecialty.get(2).patients.isEmpty()) {
                        doctorsInSpecialty.get(2).patients.add(patient);
                    } else {
                        doctorsInSpecialty.get(0).patients.add(patient);
                    }
                }
            }
    }

//    public static void retrievePatientAilments(Patient patient) {
//        log(askPatientAilment);
//        patient.getSpecialtyNeeded().printAilments();
//        int choice = sc.nextInt();
//        Ailment ptAilment = patient.getSpecialtyNeeded().getAilmentsList().get(choice+1);
//        int healthIndex = ptAilment.isCurable() ? (100 - (ptAilment.getNumTreatmentsToCure() * 10)) : 50;
//        log(displayHealthIndexMsg + healthIndex);
//        // Ask how many treatments the pt would like to have
//        log(askNumTreatments);
//        // TODO Display health index after each treatment
//        // do patient.doctor.treatPatient();
//
////                String message = isCurable ? askNumTreatments : askNumTreatments;
////                log(message);
//    }

    //
    // TODO //// WriteHospitalToJSON
    //
    public static void writeHospitalToJSON(Hospital hospital) throws IOException {
        String json = new ObjectMapper().writeValueAsString(hospital);
        FileReader.writeToFile(JSONFILE, json);
    }

    public static void printAll() {
//        log(printEverything);
//        System.out.println("Hospital: " + hospital.getName());
//        docBySpecialtyMap.entrySet().forEach(entry -> {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        });
//        System.out.println("\n" + hospital.patients);
        log("\n \nGoodbye!");
        System.exit(0);
    }
}

