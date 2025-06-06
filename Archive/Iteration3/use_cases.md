## Use Cases

1. Mother delivers baby; Nurse is able to enter DeliveryRegister form information; DeliveryRegister form is saved to Database. Information is attributed to Patient Mother and Patient Baby. (Josh)

2. Information from DeliveryRegister is sent to MonthlyMidwifeReport. (Josh)

3. Nurse attempts to enter a Delivery Register form, but the patient (mother) does not exist in the system.
 System allows for new patient creation and links the DeliveryRecord accordingly. (Josh)

4. Nurse searches for a specific mother. System displays past delivery records and outcomes linked to her profile. (Nathaniel)
    * According to current Patient object design, Each patient should have a collection of Visit objects, each having records of basic measurements like weight & body temperature as well as a principleCondition, additionalDiagnosis, and any special remarks.
    * As such, this search system should take a PatientID and return that patient's Visits.

6. Possible hereditary red flags from the mother's medical history (such as genetic defects) are included on the newborn's newly created medical history. (Nathaniel)

### Error Cases
1. Delivery Register form is not filled out entirely, leading to insufficient information for a Monthly Midwife Report

2. Health official makes mistake filling out form, either making a typo in a section like name/address or inputting information regarding vitals in incorrect spaces, e.g. Weight of Mother in Body Temperature of Mother section


## Demo #1 Use Case (Mother Delivers Baby)
**Scenario:**  
A mother gives birth. The nurse logs into the system and opens the Delivery Register form

**Steps AFTER Delievery:**
1. Nurse selects or creates a patient record for the mother and baby
2. Nurse enters delivery details including:
   - Date and time of birth
   - Delivery type
   - Outcome
   - Gender
   - Name
3. Nurse submits the form

**System Result:**  
- The delivery information is saved to the database
- It is linked to both the mother and baby’s patient profiles
- The data becomes available

## Demo #2 Use Case (Patient Search)
**Scenario:**
A Nurse searches for a patient's mother to see her medical history in case it affects the patient. The system displays past delivery records and outcomes linked to the mother's profile when given the child's ID as input. If the Nurse sees a health condition that could be passed on to the patient, the Nurse can go on to add a remark in the patient's record/Delivery Register Form.

**Steps involved in a search:**
1. User enters patient's ID (in a GUI environment, clicks on the user's mother information)
2. The system reads the Patient's mother's ID value and searches through the list of Patient objects until it finds the one with a matching ID
3. The system then displays the basic information of the Patient object for the mother. This includes:
   - Name
   - Date of birth
   - Patient ID
   - Patient Mother ID
   - Records
4. The system displays the information found in the mother's Records to the user.
   - "Back Pain"
   - "Heart Disease"
   - "Asthma"
   - etc.

**System Result:**
- If the nurse chooses to add specific conditions to the newborn's Patient profile, those conditions would be added to the newborn's Records.
- Otherwise, no changes to the system should be made, since it would just be a search.


## Demo #3 Use Case (Midwife Report)
**Scenario:**
At the end of the month, a nurse logs into the system and generates the monthly midwife report

**Steps involved:**
1. User selects to generate midwife report
2. The system generates entries for each of the deliveries. Each entry includes:
   - Entry ID
   - Mother's name
   - Baby's name
   - Outcome of birth
3. The system displays and saves generated report

**System Result:**
- The generated report is saved securely to internal systems
- Available to view within internal network


## Demo #4 Use Case (Patient Creation + Linkage)
**Scenario:**
A nurse attempts to enter a Delivery Register Form; however, the patient(mother) is a first-time patient and does not exist in the system. The system creates a new patient record with the mother's ID and allows for the Delivery Register Form to be linked to the mother’s patient profile.

**Steps Involved:**

1. User enters patient ID into Patient collection
2. System searches the collection of Patient objects for the patient ID
3. If there is no matching ID found, then the system allows for the creation of a new Patient Object.
4. The existing/new patient object is returned

**System Result:**
- The new Patient Object now exists and is searchable within the Patient collection
- The user can link a Delivery Register Form to the returned Patient object
- The new Delivery Register Form is saved and available with the rest of the patient’s records.
