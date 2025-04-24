Guide: https://cs.usm.maine.edu/~david.b.levine/Spring2025/Project/forms/DeliveryRegisterProposed.pdf

# Delivery Register Form:

## Header information: possibly replace with integer IDs
String facility_name
String sub_district 

## Form-specific information
int SNo
Date date
int NHIS_reg_number

## Patient information: can we get this imported from Patient object?
String name
Address address {
	String location
	String community
	int houseNumber }
int age
? parity

## Pregnancy information
String pregnancy_duration
Date delivery_date
Date discharge_date
Date referred_date

## Delivery Summary
int total_babies
	for each baby:
		char gender # M/F
		Boolean live 
		Boolean still_birth
		Boolean mac (?)
		int birth_weight

## Healthcare Official Information
String who_delivered_baby
int CHO_ID

## Mother health information
String bp
String pulse
String temp
double weight
double height
double blood_loss #https://www.acog.org/clinical/clinical-guidance/committee-opinion/articles/2019/12/quantitative-blood-loss-in-obstetric-hemorrhage 

## Baby health information
int apgar_score [0-10]
double length_of_baby
double baby_head_circumference
int latch_score_within_hour
int latch_score_after_hour

## Perineal care
Boolean episiotomy
Boolean tear
Boolean oxyticin 
Boolean ergometrine # a drug used for the prevention and control of postpartum and post-abortion hemorrhage
Boolean placenta_examined
Boolean mother_alive

## Comments/Remarks
String comments
