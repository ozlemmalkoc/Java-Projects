import java.util.ArrayList;

public class Viewer implements observer {
   
    String name;
    private int index=0; // Keeps the order of the currently viewing object
    private  ArrayList<entry> viewerableList = new ArrayList<>(); // Keeps a list of objects observed by the observer
   
    public void update(String n)    // Prints the name of the inserted object
    {
        System.out.println(n+"  added!");
    }
   
    public void add(entry Entry)    // If the object is inherited from visual, it is added to the object list.
    {   
        if(Entry instanceof visual)
        viewerableList.add(Entry);
    }
    public void remove(entry Entry) // If the object is inherited from visual, it is deleted to the object list.
    {  
        if(Entry instanceof visual)
        viewerableList.remove(Entry);
    }
   
    public void show_list() // Prints the list of objects owned by the observer
    {   
        if(viewerableList.size()>0)
        {   System.err.println("\n"+"******Your list******");
            
            for(int i=0;i<viewerableList.size();++i)
            {
                if(viewerableList.get(i) instanceof visual)
                {
                    System.out.println(viewerableList.get(i).getName());
                }
            }
            System.out.println();
        }
        else 
            System.out.println("List is empty!");
    }

    public entry currently_viewing()    // Returns the currently viewing object
    {
        return  viewerableList.get(index);
    }
    public void previous(String type)   // Views the previous object. Prints name of object. 
    {  
         if(viewerableList.size()>0)
        {    
            for(int i=index-1;i<viewerableList.size();--i)
            {
                if(type.equals("image_entry"))
                {   
                    --index;
                        if(viewerableList.get(i) instanceof image_entry)
                    {    System.err.println("Currently viewing object : "+viewerableList.get(i).getName());
                            break;
                    }
                }
                if(type.equals("video_entry"))
                {
                        --index;
                        if(viewerableList.get(i) instanceof video_entry)
                        {   System.err.println("Currently viewing object : "+viewerableList.get(i).getName());
                            break;
                        }
                    }
                }
        }
        else
            System.out.println("List is empty!");    
    }
    
    public void next(String type)   // Views the next object. Prints name of object. 
    {  
        if(viewerableList.size()>0)
        {   
            for(int i=index+1;i<viewerableList.size();++i)
            {
                if(type.equals("image_entry"))
                {   
                        ++index;
                        if(viewerableList.get(i) instanceof image_entry)
                        {   System.err.println("Currently viewing object : "+viewerableList.get(i).getName());
                            break;
                        }
                }
                if(type.equals("video_entry"))
                {
                    ++index;
                    if(viewerableList.get(i) instanceof video_entry)
                        {   System.err.println("Currently viewing object : "+viewerableList.get(i).getName());
                            break;
                        }
                }
            }
        }
        else 
            System.out.println("List is empty!"); 
    }
}
