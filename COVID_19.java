public class COVID_19 extends Ill implements Prevention{
    
    public COVID_19(Ill person){
        super(person.getSymptoms(), person.isSevere(), person.hasPreExistingMedicalConditions(), person.isImprovement(),
                person.getDaysIll(), person.hasTravelled(), person.anyoneNearbyHasCorona());
    }
    
    public String advice(){
        return "WARNING: \"YOU MAY HAVE CORONAVIRUS\" \nPLEASE CONSULT YOUR PHYSICIAN/DOCTOR IMMEDIATELY";
    }
    
    @Override
    public String preventiveMeasures(){
        return "\n-> Immediately consult a doctor"
                +"\n-> Avoid contact with anyone, even your family"
                +"\n-> Don't panic, stay calm";
    }
}
