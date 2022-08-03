public class text_entry extends entry implements non_visual,non_playable {
    
    String str;
    
    public text_entry(String n,String str)
    {
        super(n);
        this.str=str;
    }
  
    public void info()  // Prints information text_entry object
    {   System.out.println();
        System.out.println("text");
        System.out.println(getName());
        System.out.println(str);
        System.out.println();
    }
}
