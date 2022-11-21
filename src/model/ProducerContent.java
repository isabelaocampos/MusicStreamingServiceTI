package model;

public abstract class ProducerContent {

    private String contentname;
    private String imageURL;
    private int duration;
    private int view;

    public ProducerContent(String contentname, String imageURL, int duration){
        this.contentname = contentname;
        this.imageURL = imageURL;
        this.duration = duration;
        view = 0;
    }

    public String getContentName(){
        return contentname;
    }

    public void setContentName(String contentname){
        this.contentname = contentname;
    }
    public String getImageURL(){
        return this.imageURL;
    }

    public void setImageURL(String imageURL){
        this.imageURL = imageURL;
    }

    public int getDuration(){
        return this.duration;
    }

    public void setDuration(int duration){
        this.duration = duration;
    }

    public int getView() {
        return view;
    }


    public void setView(int view) {
        this.view = view;
    }
    
}
