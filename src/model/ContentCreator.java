package model;

import java.util.ArrayList;
import java.util.Calendar;

public class ContentCreator extends UserProducer {

    private ArrayList<Podcast> podcasts;

    public ContentCreator(String name, String imageURL, Calendar vinculationDate) {
        super(name, imageURL, vinculationDate);
        
        podcasts = new ArrayList<Podcast>();
    }

    public ArrayList<Podcast> getPodcasts(){
        return podcasts;
    }
  
    public void setPodcasts(ArrayList<Podcast> podcasts){
        this.podcasts = podcasts;
    }

    /**
     * findPodcastCreator: boolean: This method search for a podcast of a content creator in the array of podcast 
     * of that content creator
     * @param podcast: Podcast: is the name of the podcast that we are looking for.
     * @return: isFound: boolean: If it finds the podcast will return true, if not it'll return false.
     */
    public boolean findPodcastCreator(Podcast podcast){
        boolean isFound= false;
        for(int i=0;i<podcasts.size() && !isFound ;i++){
            if( podcasts.get(i) == podcast){
                isFound= true;
            }
         }
    
        return isFound;
    }
}
