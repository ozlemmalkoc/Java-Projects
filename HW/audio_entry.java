public class audio_entry extends entry implements playable,non_visual {
   
    private double duration;
    private String str;
   
    public audio_entry(String n,double duration,String str)
    {
        super(n);
        this.duration=duration;
        this.str=str;
    }
    public double getDuration() // Returns duration value of audio object
    {
        return duration;
    }
  
    public void info()  // Prints information about audio_entry object
    {   System.out.println();
        System.out.println("audio");
        System.out.println(getName());
        System.out.println(getDuration());
        System.out.println(str);
        System.out.println();
    } 
}
