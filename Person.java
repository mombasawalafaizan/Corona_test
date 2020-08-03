public abstract class Person {
    private String Name;
    private int Age;
    private String Phone_no;
    Person(){
    }
    
    Person(String Name, int Age, String Phone_no){
        this.Name = Name;
        this.Age = Age;
        this.Phone_no = Phone_no;
    }
    
    //Setter methods
    public void setName(String Name){ this.Name = Name; }
    public void setAge(int Age){ this.Age = Age; }
    public void setPhone_no(String Phone_no){ this.Phone_no = Phone_no; }
    
    //Getter methods
    public String getName(){ return Name; }
    public int getAge(){ return Age; }
    public String getPhoneNo(){ return Phone_no; } 
    
    @Override
    public String toString(){
        return "Name: "+Name+"\nAge: "+Age+"\nPhone No.: "+Phone_no+"\n";
    }
}
