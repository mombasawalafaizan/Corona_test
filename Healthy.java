public class Healthy extends Person implements EatingAdvice, Prevention{
    public Healthy(){
    }
    
    @Override
    public String whatToEat(){
        return "You should eat lots of green vegetables, pulses and cereals."
                + "\nYou can also eat properly cooked meat and eggs.";
    }
    
    @Override
    public String preventiveMeasures(){
        return "\n-> Wash your hands frequently"
               +"\n-> Avoid physical contact if possible"
               +"\n-> Be kind to those who have corona virus"
                +"\n-> Practice respiratory hygiene"
                +"\n-> Avoid going to crowdy places";
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nCONGRATULATIONS! YOU ARE HEALTHY.";
    }
    
}
