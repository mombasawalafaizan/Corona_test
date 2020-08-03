public class CommonColdOrFlu extends Ill implements Prevention{
    
    public CommonColdOrFlu(Ill person){
        super(person.getSymptoms(), person.isSevere(), person.hasPreExistingMedicalConditions(), person.isImprovement(),
                person.getDaysIll(), person.hasTravelled(), person.anyoneNearbyHasCorona());
    }
    
    public String advice(){
        return "You may not have corona virus, but this doesn't mean you are not ill."
                +"\nPlease take some preventive measures and do consult you GP.";
    }
    
    @Override
    public String preventiveMeasures(){
        return "\n-> Wash your hands frequently"
               +"\n-> Maintain social distancing"
                +"\n-> Avoid touching eyes, nose and mouth"
                +"\n-> Practice respiratory hygiene"
                +"\n-> When coughing/sneezing cover you mouth"
                +"\n-> Stay informed and follow advice given by your healthcare provider"
                +"\n-> Consult a doctor if the disease becomes severe";
    }
   
}
