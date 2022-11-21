package model;

public class Podcast extends ProducerContent {

    private String description;

    private TypeOfCategoryPodcast typeOfCategory;

    public Podcast(String contentname, String imageURL, int duration, String description,int option) {
        super(contentname, imageURL, duration);
        this.description = description;
        switch(option){
            case 1:
            typeOfCategory=TypeOfCategoryPodcast.POLITICS;
            case 2:
            typeOfCategory=TypeOfCategoryPodcast.ENTERTAINMENT;
            case 3:
            typeOfCategory=TypeOfCategoryPodcast.FASHION;
            case 4:
            typeOfCategory=TypeOfCategoryPodcast.VIDEOGAMES;
        }
    }
    public String getDescription(){
        return this.description;
    }

    public TypeOfCategoryPodcast getTypePodcast() {
        return typeOfCategory;
    }

    public void setTypePodcast(TypeOfCategoryPodcast typeOfCategory) {
        this.typeOfCategory = typeOfCategory;
    }
    
    public int typeOfCategory(){
        switch (typeOfCategory) {
            case POLITICS:
                return 1;
            case ENTERTAINMENT:
                return 2;
            case FASHION:
                return 3;
            case VIDEOGAMES:
                return 4;
            default:
             return 0;
        } 
    }
}

