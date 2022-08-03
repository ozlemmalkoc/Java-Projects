import java.util.ArrayList;

public class Dataset {
    
    private  ArrayList<entry> ds;
    private ArrayList<observer>observers;

    public Dataset()
    {
        ds=new ArrayList<entry>();
        observers=new ArrayList<observer>();
    }
    
    public void add(entry Entry)
    {
        ds.add(Entry);
        notifyObservers(Entry); // When the objects inheriting from the entry are added, the observers will receive a message.
        
        for(int i=0;i<observers.size();++i)
        {  
            observers.get(i).add(Entry);
        }
    }
    
    public void notifyObservers(entry Entry)    // When the objects inheriting from the entry are added, the observers will receive a message.
    {
        if(Entry instanceof playable)
        {
            for(int j=0;j<observers.size();j++)
            {  
                if(observers.get(j) instanceof Player)
                {
                    observers.get(j).update(Entry.getName());
                }
            }
        }
        if(Entry instanceof visual)
        {
            for(int j=0;j<observers.size();j++)
            {
                if(observers.get(j) instanceof Viewer)
                {
                    observers.get(j).update(Entry.getName());
                }
            }
        }

    }
  
    public void remove(entry Entry) // Removes objects from the dataset and from observers' object lists
    {
        ds.remove(Entry);
       
        
        for(int i=0;i<observers.size();++i)
        {  
            observers.get(i).remove(Entry);
        }
    }
  
    public void remove_observer(observer Observer) // Removes observer
    {  
       if(observers.size()>0)
       {
            observers.remove(Observer);
       }
       else
            System.out.println("There is not any observer!");
       
    }

    public void register(observer Observer) // Register observer
    {
        observers.add(Observer);
    }
    
     public ArrayList<entry> get_list()
    {
        return ds;
    }
   
    public ArrayList<observer> get_list_observers()
    {
        return observers;
    }

    public static void main(String[] args)
    { 
        Dataset ds = new Dataset();
       
        Player p1 = new Player();
        Player p2 = new Player();
        Viewer v1 = new Viewer();
        Viewer v2 = new Viewer();
      
        ds.register(p1);
        ds.register(p2);
        ds.register(v1);
        ds.register(v2);
       
        System.out.println("Observers:");
        System.out.println(ds.get_list_observers());
        ds.remove_observer(p1);
        System.out.println("After from applied remove_observer(observer):");
        System.out.println(ds.get_list_observers());
        System.out.println();
       
        ds.add(new image_entry("imagename1", 5.5, "other info1"));
        ds.add(new image_entry("imagename2", 5.4, "other info2"));
        ds.add(new image_entry("imagename3", 5.8, "other info3"));
        ds.add(new image_entry("imagename4", 5.7, "other info4"));
        ds.add(new image_entry("imagename5", 5.9, "other info5"));

        ds.add(new audio_entry("audioname1", 9.4, "other info2"));
        ds.add(new audio_entry("audioname2", 9.4, "other info2"));
        ds.add(new audio_entry("audioname3", 9.7, "other info3"));

        ds.add(new video_entry("videoname1", 5.5, 5.5));
        ds.add(new video_entry("videoname2", 5.5, 5.5));
        ds.add(new video_entry("videoname3", 5.5, 5.5));

        ds.add(new text_entry("textname1", "other info1"));
        ds.add(new text_entry("textname2", "other info2"));
        ds.add(new text_entry("textname3", "other info3"));
        System.out.println();


        playable po = (playable)p2.currently_playing();
        po.info();
       
        System.out.println("List of p2");
        p2.show_list();
        System.out.println("Number of elements in ds before the remove function is applied:");
        System.out.println(ds.get_list().size());
        System.out.println("Number of elements in ds after the remove function is applied:");
        ds.remove((entry)po);
        System.out.println(ds.get_list().size());
        System.out.println("Number of elements in ds after the remove function is applied:");
        p2.show_list();

        non_playable np = (non_playable) v1.currently_viewing();
        np.info();  

        p2.show_list();
        System.out.println( p2.currently_playing().getName());
        p2.next("audio_entry");
        p2.next("video_entry");
        p2.previous("audio_entry");

        v1.show_list();
        System.out.println( v1.currently_viewing().getName());
        v1.next("image_entry");
        v1.next("video_entry");
        v1.previous("image_entry");

    }
}
