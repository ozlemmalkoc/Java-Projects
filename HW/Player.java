import java.util.ArrayList;

public class Player implements observer 
{
    String name;
    private  ArrayList<entry> playableList=new ArrayList<>() ; // Keeps a list of objects observed by the observer
    private int index=0;     // Keeps the order of the currently viewing object
    
    public void update(String n)    // Prints the name of the inserted object
    {
        System.out.println(n+" added!");
    }

    public void show_list() // Prints the list of objects owned by the observer
    {  
         if(playableList.size()>0)
        { 
            System.err.println("\n" +"******Your list******");
        
            for(int i=0;i<playableList.size();++i)
            {
                if(playableList.get(i) instanceof playable)
                {
                    System.out.println(playableList.get(i).getName());
                }
            }
            System.out.println();
        }
        else
            System.out.println("List is empty!");
    }
   
    public void add(entry Entry)    // If the object is inherited from playable, it is added to the object list.
    { 
        if(Entry instanceof playable)
            playableList.add(Entry);
    }
   
    public void remove(entry Entry) // If the object is inherited from playable, it is deleted to the object list.
    {   if(Entry instanceof playable)
            playableList.remove(Entry);
    }
    
    public entry currently_playing()    // Returns the currently playing object
    {
        return  playableList.get(index);
    }
   
    public void previous(String type)   // Plays the previous object. Prints name of object. 
    {   
        if(playableList.size()>0)
        {
            for(int i=index-1;i<playableList.size();--i)
            {
                if(type.equals("audio_entry"))
                {   
                    --index;
                    if(playableList.get(i) instanceof audio_entry)
                    { 
                        System.err.println("Currently playing object : "+playableList.get(i).getName());
                        break;
                    }
                }
                if(type.equals("video_entry"))
                {
                    --index;
                    if(playableList.get(i) instanceof video_entry)
                    {   System.err.println("Currently playing object : "+playableList.get(i).getName());
                        break;
                    }
                    }
            }
        }
        else
        System.out.println("List is empty!");
    }
    
    public void next(String type)   // Plays the next object. Prints name of object. 
    {  
         if(playableList.size()>0)
        { 
            for(int i=index+1;i<playableList.size();++i)
            {
                if(type.equals("audio_entry"))
                {   
                    ++index;
                    if(playableList.get(i) instanceof audio_entry)
                        {   System.err.println("Currently playing object : "+playableList.get(i).getName());
                            break;
                        }
                }
                if(type.equals("video_entry"))
                {
                    ++index;
                    if(playableList.get(i) instanceof video_entry)
                        {   System.err.println("Currently playing object : "+playableList.get(i).getName());
                            break;
                        }
                }
            }
        }
        else 
            System.out.println("List is empty!");
    }
}
