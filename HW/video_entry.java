public class video_entry extends entry implements playable,visual {
   
    private double dimension,duration;
   
    public video_entry(String n,double dimension,double duration)
    {
        super(n);
        this.dimension=dimension;
        this.duration=duration;
    }
    public double getDuration() // Returns duration value of video object
    {
        return duration;
    }
    public double getDimension()    // Returns dimension value of video object
    {
        return dimension;
    }
   
    public void info()  // Prints information about video_entry object
    {   System.out.println();
        System.out.println("video");
        System.out.println(getName());
        System.out.println(getDuration());
        System.out.println(getDimension());
        System.out.println();
     
    }
  
}
