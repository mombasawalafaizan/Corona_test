public class Ill extends Person{
    private String[] symptoms; //symptoms such as fever, cough, breathing problems, headache, etc.
    private boolean severe; //are there severe conditions
    private boolean pre_existing_medical_conditions;  // like asthma, arthtritis, etc 
    private boolean improvement; //has improved in condition reasonably 
    private int days_ill; //days since symptoms has occurred
    private boolean travelled; //travelled to anyplace where corona cases are found
    private boolean nearby_corona; //has anyone nearby your house been infected from corona
    
    public Ill(String[] symptoms, boolean severe, boolean pre_existing_medical_conditions, boolean improvement,
    int days_ill, boolean travelled, boolean nearby_corona){
        this.symptoms = symptoms;
        this.severe = severe;
        this.pre_existing_medical_conditions = pre_existing_medical_conditions;
        this.improvement = improvement;
        this.days_ill = days_ill;
        this.travelled = travelled;
        this.nearby_corona = nearby_corona;
    }
    
    public String[] getSymptoms(){ return symptoms; }
    public boolean isSevere(){ return severe; }
    public boolean hasPreExistingMedicalConditions(){ return pre_existing_medical_conditions; }
    public int getDaysIll(){ return days_ill; }
    public boolean hasTravelled(){ return travelled; }
    public boolean anyoneNearbyHasCorona(){ return nearby_corona; }
    public boolean isImprovement(){ return improvement; }
    
    public boolean probableCoronaVirus(){
        double check_for_corona_symptoms = 0;
        boolean probable_corona;
        
        for(int i = 0; i < symptoms.length; i++){
            if(symptoms[i].contains("breath") || symptoms[i].contains("cough") || symptoms[i].contains("fever"))
                check_for_corona_symptoms++;
            if(symptoms[i].contains("throat") || symptoms[i].contains("lungs") || symptoms[i].contains("tired") 
                    || symptoms[i].contains("fatigue") || symptoms[i].contains("ache"))
                check_for_corona_symptoms += 0.5;
        }
        
        if(check_for_corona_symptoms >= 2 && (travelled || nearby_corona))
            return true;
        
        probable_corona = (check_for_corona_symptoms >= 3);
        
        if(probable_corona){
            if(travelled || nearby_corona)
                return true;
            
            if(!improvement && days_ill<=3){
                if(pre_existing_medical_conditions && severe && super.getAge() > 60)
                    return true;
            }
            
            if(!improvement && days_ill>=3){
                if(pre_existing_medical_conditions || severe || super.getAge() > 60)
                    return true;
            }
        }
        return false;
    }
    
    public boolean probableCommonColdOrFlu(){
        return !probableCoronaVirus();
    }
    
}
