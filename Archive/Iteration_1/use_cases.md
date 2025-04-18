## Use Cases

1. Mother delivers baby; Nurse is able to enter DeliveryRegister form information; DeliveryRegister form is saved to Database. Information is attributed to Patient Mother and Patient Baby. (Josh)

2. Information from DeliveryRegister form Database is sent to MonthlyMidwifeReport. (Josh)

3. Nurse attempts to enter a Delivery Register form, but the patient (mother or baby) does not exist in the system.
 System allows for new patient creation and links the delivery data accordingly. (Josh)

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
