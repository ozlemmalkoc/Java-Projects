public class entry 
{
    private String name;
   
    public entry(String n)
    {
        name=n;
    }
   
    public String getName() // Returns name
    {
        return name;
    }
    
    public void info() // Print information
    {
        System.out.println(name);
    }
}
