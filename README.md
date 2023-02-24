## Google Solution Challenge Mobile App
### Solution Challenge Project:
- App that enables people to find the nearest hospitals around them and the mobile numbers of the hospitals ambulances which will make it easier to save lives.

### Project falls under the following UN Development Goals:
- Goal #3: Good Health and Well-being
- Goal #17: Partnerships for the goals

### Tools and Stacks Used
- Android studio
- Kotlin
- Jetpack Compose
- Firebase

### Mobile app features for inclusion
#### Screens
**Basics**:
- Welcome
- Sign In
- Sign Up
- Home
 -Settings 

- **Home** - About 

**Hospitals** -
1. Full names
2. Images of the hospitals
3. Ambulance services availability - YES / NO
4. Mobile numbers
   1. Can be able click and call
   2. Can be able to copy paste
5. Locations
   1. Google map shows locations
   2. Availability of ambulances

### Timelines/Deadlines
- Phase 1: 19 - 25 February
- Phase 2 - 26 - 04 March
- Phase 3 - 05 - 11 March
- Presentation 12 March 2023


### A.I. Description Script
Consider this prompts

I am creating an app that will allow the public to access hospitals and ambulances
The app gives information about nearest hospitals and ambulances
There are contact information and if the hospitals have ambulance services
There is a map view that allows the public to see nearest hospitals on the map
The map element uses Google Maps

Now, based on the above, do this ----->

### Emergencies Based on Severity
common emergencies grouped into three categories based on their severity:

Group 1: Life-Threatening Emergencies

Heart attack
Stroke
Severe bleeding
Choking
Poisoning
Seizures
Severe allergic reactions (anaphylaxis)
Electric shock
Carbon monoxide poisoning
Near-drowning incidents
Group 2: Serious Emergencies

Burns
Broken bones
Head injuries
Allergic reactions
Asthma attacks
Heat stroke
Hypothermia
Drowning
Severe dehydration
Major cuts or wounds
Group 3: Minor Emergencies

Insect bites or stings
Minor burns
Minor cuts or wounds
Sprains or strains
Nosebleeds
Minor allergic reactions
Minor fractures or broken bones
Toothache
Minor eye injuries
Mild fever or flu-like symptoms
Note that the severity of an emergency can vary depending on a number of factors, including age, overall health, and other individual circumstances. It's always important to take any emergency seriously and seek professional medical help when necessary.


#### Lessons 
Q: Is there a Boolean operation that can help me select between the three categories with kotlin?
A: Yes, you can use the when expression in Kotlin to select between the three categories based on the severity of the emergency. Here's an example:

**kotlin**

***Copy code***

``kt
fun getEmergencyCategory(severity: String): String {
    return when(severity) {
        "life-threatening" -> "Group 1: Life-Threatening Emergencies"
        "serious" -> "Group 2: Serious Emergencies"
        "minor" -> "Group 3: Minor Emergencies"
        else -> "Unknown emergency severity"
    }
}
```

In this example, the getEmergencyCategory function takes a severity parameter as a string and uses the when expression to return the appropriate emergency category based on the input severity. If the severity is not one of the three known categories, the function returns an "Unknown emergency severity" message.

You can then call this function with the severity of an emergency to get the corresponding emergency category as a string. For example:

```kt
val emergencySeverity = "life-threatening"
val emergencyCategory = getEmergencyCategory(emergencySeverity)
println(emergencyCategory) // Output: "Group 1: Life-Threatening Emergencies"
```

