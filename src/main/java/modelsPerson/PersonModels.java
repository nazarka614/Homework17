package modelsPerson;

import java.util.ArrayList;
import java.util.Date;

public class PersonModels {
    public int id;
    public String name;
    public String status;
    public String species;
    public String type;
    public String gender;
    public Origin origin;
    public Location location;
    public String image;
    public ArrayList<String> episode;
    public String url;
    public Date created;

    @Override
    public String toString() {
        return "Name: "+name+"\n"+
                "Status: "+status +"\n"+
                "Species " +species;
    }
}

