import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
// import java.util.Iterator;
// import java.util.ListIterator;

public class HospitalWorld {
    public static int numDoctors;
    public static Doctor doctor;
    public static Patient patient;
    public static Hospital hospital = new Hospital();
    public static Map<String, List<Doctor>> docBySpecialtyMap = new HashMap<>(); 

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

    public static void nameHospital() {
        log(askHospitalName);
        try {
            String hospitalName = sc.nextLine();
            hospital.setName(hospitalName);
            nameDoctors();
        } catch (Exception e) {
            sc.nextLine();
            log(error);
        }
    }

    public static void nameDoctors() {
        log(askDoctorNames);
        while (numDoctors <= 3) {
            if (numDoctors > 0 && numDoctors < 3) {
                log(doctorsNextName);
            }
            try {
                String doctorName = sc.nextLine();
                log(askDoctorSpecialty);
                String doctorSpecialty = sc.nextLine();

                doctor = new Doctor(doctorName, doctorSpecialty);
                numDoctors++;

                if (!docBySpecialtyMap.containsKey(doctorSpecialty)) {
                    docBySpecialtyMap.put(doctorSpecialty, new ArrayList<Doctor>());
                    docBySpecialtyMap.get(doctorSpecialty).add(doctor);
                    log(addedDoctor);
                } else if (docBySpecialtyMap.containsKey(doctorSpecialty)) {
                    docBySpecialtyMap.get(doctorSpecialty).add(doctor);
                    log(addedDoctor);
                }
                if (numDoctors == 3) {
                    log(doctorCreationComplete);
                    docBySpecialtyMap.entrySet().forEach(entry -> {
                        System.out.println(entry.getKey() + " " + entry.getValue());
                    });
                    namePatients();
                    sc.nextLine();
                }
            } catch (Exception e) {
                sc.nextLine();
                log(error);
                repeat = false;
            }
        }
    }

    public static void namePatients() {
        log(askPatientNames);
        while (hospital.patients.size() <= 5) {
            if (hospital.patients.size() > 0 && hospital.patients.size() < 5) {
                log(askPatientName);
            }
            try {
                String patientName = sc.nextLine();
                log(askPatientSpecialty);
                String patientSpecialty = sc.nextLine();
                patient = new Patient(patientName, patientSpecialty);
                hospital.patients.add(patient);
                
                if (hospital.patients.size() == 5) {
                    //Print list of patients + their specialties
                    log(patientCreationComplete);
                    System.out.println(hospital.patients);
                    matchPatients();
                    sc.nextLine();
                }
            } catch (Exception e) {
                sc.nextLine();
                log(error);
            }
        }
    }

    //
    // *** Huge bulky method going off what was explained ***
    // Was going to add an iterator or stream, sorry. Ran out of time.
    // Imports were bugging, it didn't like the lambda
    //
    public static void matchPatients() {
        System.out.println(matchingPatients);
        List<Doctor> doctorsInSpecialty = docBySpecialtyMap.get(patient.getSpecialtyNeeded());
        // Iterator<Doctor> iterator = doctorsInSpecialty.listIterator();   
        for (Patient patient : hospital.getPatients()) {
            if (doctorsInSpecialty.isEmpty()) {
                hospital.getPatients().add(patient);
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
        printAll();
    }

    public static void printAll() {
        log(printEverything);
        System.out.println("Hospital: " + hospital.getName());
        docBySpecialtyMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
        System.out.println("\n" + hospital.patients);
        log("\n \nGoodbye!");
        System.exit(0);
    }
}

