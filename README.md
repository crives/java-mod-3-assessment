# Module 3 Project Guidelines

## Overview

Console application to allow a user to build a world, save it, come back to it
later to review it and continue to build it. In this version of the virtual
world, things happen, e.g. Doctors treat patients and patients can get better,
not change or get worse with each treatment.

## Pre-requisite: Create (or re-use) the Virtual Hospital World from the Last Module

Create a virtual world with the appropriate relationships between a Hospital,
Doctors and Patients

**Main Requirements**:

- The system should create a Hospital with a name property provided by the
  user.
- The system should create 3 doctors, each with a name and specialty
  provided by the user.
  - The specialty is user-definable, but good examples are:
    - Dermatology
    - Pediatrics
    - Radiology
    - ...
- The system should establish that the doctors work at the system's hospital.
- The system should ask the user to create 5 patients and match each patient
  to a doctor based on the specialty they need.
- When the system is done collecting input from the user and building the
  world, it should "display" the world to the user (text-based display on
  the command line).
- The system must handle invalid input from the user (at all points where
  input is gathered from the user).

**Stretch goals**:

- User-defined number of doctors.
- Pre-defined list of doctor specialties that the user must select from.
- User-defined number of patients.
- Pre-defined list of patient symptoms that match up to doctor specialties.
- System matches patients to doctors based on user-selected symptoms.

## Current Project Requirements

**Main Requirements**:

- Each doctor specialty has the following properties:
  - Number of treatments required to be fully cured.
  - Whether a full cure is possible.
  - In case a full cure is not possible, treatments go on forever and the
    patient never reaches full health.
- Each patient has a health index that indicates how close to full healthy they
  are. A health index of 100 indicates full health and that the patient no
  longer needs treatment.
- Start each patient with a health index based on their ailment.
  - Note: this must match up to the doctor's specialty that treats the ailment
    and the number of treatments required. Example:
    - Specialty: Pediatrics
    - Ailment: Cold
    - Number of treatments needed: 3
    - Patient's starting health index: 70
    - Gain from each treatment: 10
- Allow the user to select a patient to go through a round of treatment
- Call out places where user input correction is needed
  - User selects a patient index that's outside the range of existing patients
    (e.g. user selects a patient not on the patient list)
- Update the patient's health index when they go through a round of treatment
- Dismiss a patient from the hospital once their health index reaches 100
- Allow the user to stop the virtual world and restore it to its last state when
  they start the virtual world again
- Allow the user to admit new patients at the hospital

**Stretch goals**:

- Randomize whether patients get better with each round of treatment.
  Possibilities are:
  - User gets better by the expected gain from each treatment.
  - User's health index does not change (the treatment has no impact).
  - User gets worse by the expected gain from each treatment.
- Display a "health index" ascii-based progress bar every time the patient
  goes through a round of treatment.
  - E.g.: ========= 90% health
- Create different hospitals, where each hospital has its own set of doctors
  with unique specialties that other hospitals do not have - Assign patients
  to hospitals and doctors based on their ailments.

## Getting Started

- Create a class to model each entity in your virtual world, i.e. you should
  have a class for Hospital, a class for Doctor and a class for Patient.
- Determine the data structures you will need to hold the instances of those
  classes. Hint: think about collections.
- You will need a runnable class to start your world and gather input from the
  user.
- Use JSON to represent your Hospital's "saved" state.
- Make sure to unit test the behavior of your world, e.g. make sure a patient's
  health is impacted as expected when treatment is applied.

## Sample Code

- Start by creating a runnable class:

```java
public class HospitalWorld {
    public static void main(String[] args) {
        System.out.println("Running...");
    }
}
```

- Create a class for each entity you will be modeling:

```java
public class Hospital {

}
```

```java
public class Doctor {

}
```

```java
public class Patient {

}
```

## Reminders

- Use existing built-in Java functions where possible.
- The `Scanner` class has useful functionality for getting input from the user.
- Build your world incrementally.
- Write as many tests as you need to make sure the behavior of your world is as
  expected.
- Make sure your "world persistence" is also unit tested and your unit tests
  validate that all aspects of the world can be restored successfully.
- All doctors do the same thing: they treat patients. They might just do it in
  different ways, with different outcomes, based on their specialty. Think about
  different implementations of the same interface.