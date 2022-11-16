package Desktop;

public abstract class Person
{
    private String name;
    protected boolean infiziert;
    public Person(String pName, boolean pInfiziert){
        name=pName;
        infiziert=pInfiziert;
    }
    public String getName(){
        return name;
    }
    public boolean getInfitziert(){
        return infiziert;
    }
    public abstract String getKlasse();
}
