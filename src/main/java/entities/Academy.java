package entities;

import java.util.List;
import javax.persistence.OneToMany;

/**
 *
 * @author ramib
 */
public class Academy {
    private int id;
    private String name;
    private String category;
    private String imageName;
    private String created_by;

    private int user_id;


    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Academy(int id, String name, String category, String imageName, String created_by, int user_id, List<Coach> coaches) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.imageName = imageName;
        this.created_by = created_by;
        this.user_id = user_id;
        this.coaches = coaches;
    }


    public Academy(int id, String name, String category, String created_by, int user_id) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.created_by = created_by;
        this.user_id = user_id;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getCreated_by() {
        return created_by;
    }

    private List<Coach> coaches;

    public Academy() {
    }

    public Academy(int id, String name, String category,  int user_id) {
        this.id = id;
        this.name = name;
        this.category = category;

        this.user_id = user_id;
    }

    public Academy(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Academy(String name, String category, int user_id) {
        this.name = name;
        this.category = category;

        this.user_id = user_id;
    }

    public Academy(String name, String category, String imageName, String created_by) {
        this.name = name;
        this.category = category;

        this.created_by = created_by;
    }

    public Academy(String name, String category) {
        this.name = name;
        this.category = category;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }







    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    @Override
    public String toString() {
        return "Academy{" + "id=" + id + ", name=" + name + ", category=" + category +  ", user_id=" + user_id + ", coaches=" + coaches + '}';
    }

    @OneToMany(mappedBy = "academy")
    public List<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }
}


