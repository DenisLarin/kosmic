package sample.logical;

import javafx.scene.image.Image;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;

/**
 * Created by denis on 28.12.16.
 */
public class KosmikServises {
    private String name;
    private String coast;
    private String type;
    private String sex;
    private Image image;
    private String about;
    public KosmikServises() {
        coast ="";
        type="";
        sex ="";
        image = null;
        about = "";
        name = "";
    }
    public KosmikServises(String name, String coast, String type, String sex,String about, Image image) {
        this.name = name;
        this.coast = coast;
        this.type = type;
        this.sex = sex;
        this.image = image;
        this.about = about;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(String path) {
        try {
            File file = new File(path);
            String url = file.toURI().toURL().toString();
            Image image = new Image(url);
            this.image = image;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public String getCoast() {
        return coast;
    }

    public void setCoast(String coast) {
        this.coast = coast;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "KosmikServises{" +
                "name='" + name + '\'' +
                ", coast='" + coast + '\'' +
                ", type='" + type + '\'' +
                ", sex='" + sex + '\'' +
                ", image=" + image +
                ", about='" + about + '\'' +
                '}';
    }
}
