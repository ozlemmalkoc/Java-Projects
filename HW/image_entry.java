public class image_entry extends entry implements visual,non_playable {
   
    private double dimension;
    private String str;
   
    public image_entry(String n,double dimension,String str)
    {
        super(n);
        this.dimension=dimension;
        this.str=str;
    }
  
    public double getDimension()    // Returns dimension value of video object
    {
        return dimension;
    }

     public void info() // Prints information about image_entry object
    {   System.out.println();
        System.out.println("image");
        System.out.println(getName());
        System.out.println(getDimension());
        System.out.println(str);
        System.out.println();
    }
  
}
