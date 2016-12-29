package sample.logical;

import javafx.scene.image.Image;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;

/**
 * Created by denis on 28.12.16.
 */
public class CollectionKosmikServises {
    private ArrayList<KosmikServises> kosmikServisesArrayList = new ArrayList<KosmikServises>();
    public CollectionKosmikServises(){
        try {
            kosmikServisesArrayList.add(new KosmikServises("1","1500","Бровь","Ж","бровь1 женская",new Image(new File("src/images/browF1.jpg").toURI().toURL().toString())));
            kosmikServisesArrayList.add(new KosmikServises("2","900","Бровь","Ж","brov2 woman",new Image(new File("src/images/browF2.jpg").toURI().toURL().toString())));
            kosmikServisesArrayList.add(new KosmikServises("3","2500","Бровь","Ж","brov3 woman",new Image(new File("src/images/browF3.jpg").toURI().toURL().toString())));
            kosmikServisesArrayList.add(new KosmikServises("4","500","Бровь","М","brov1 man",new Image(new File("src/images/browM1.jpg").toURI().toURL().toString())));
            kosmikServisesArrayList.add(new KosmikServises("5","1500","Бровь","М","brov2 man",new Image(new File("src/images/browM2.jpg").toURI().toURL().toString())));
            kosmikServisesArrayList.add(new KosmikServises("6","1600","Бровь","М","brov3 man",new Image(new File("src/images/browM3.jpg").toURI().toURL().toString())));
            kosmikServisesArrayList.add(new KosmikServises("7","3500","Макияж","Ж","makeup1 woman",new Image(new File("src/images/makeup1.jpg").toURI().toURL().toString())));
            kosmikServisesArrayList.add(new KosmikServises("8","2500","Макияж","Ж","makeup2 woman",new Image(new File("src/images/makeup2.jpg").toURI().toURL().toString())));
            kosmikServisesArrayList.add(new KosmikServises("9","6500","Макияж","Ж","makeup3 woman",new Image(new File("src/images/makeup3.jpg").toURI().toURL().toString())));
            kosmikServisesArrayList.add(new KosmikServises("10","1200","Ногти","Ж","nogti1 woman",new Image(new File("src/images/nogti1.jpg").toURI().toURL().toString())));
            kosmikServisesArrayList.add(new KosmikServises("11","1100","Ногти","Ж","nogti2 woman",new Image(new File("src/images/nogti2.jpg").toURI().toURL().toString())));
            kosmikServisesArrayList.add(new KosmikServises("12","1600","Ногти","Ж","nogti3 woman",new Image(new File("src/images/nogti3.jpg").toURI().toURL().toString())));
            kosmikServisesArrayList.add(new KosmikServises("13","3500","Волосы","Ж","volos1 woman",new Image(new File("src/images/volosF1.jpg").toURI().toURL().toString())));
            kosmikServisesArrayList.add(new KosmikServises("14","1500","Волосы","Ж","volos2 woman",new Image(new File("src/images/volosF2.jpg").toURI().toURL().toString())));
            kosmikServisesArrayList.add(new KosmikServises("15","8500","Волосы","Ж","volos3 woman",new Image(new File("src/images/volosF3.jpg").toURI().toURL().toString())));
            kosmikServisesArrayList.add(new KosmikServises("16","600","Волосы","М","volos1 man",new Image(new File("src/images/volosM1.jpg").toURI().toURL().toString())));
            kosmikServisesArrayList.add(new KosmikServises("17","1200","Волосы","М","volos2 man",new Image(new File("src/images/volosM2.jpeg").toURI().toURL().toString())));
            kosmikServisesArrayList.add(new KosmikServises("18","400","Волосы","М","volos3 man",new Image(new File("src/images/volosM3.jpg").toURI().toURL().toString())));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<KosmikServises> getKosmikServisesArrayList() {
        return kosmikServisesArrayList;
    }

    public void setKosmikServisesArrayList(ArrayList<KosmikServises> kosmikServisesArrayList) {
        this.kosmikServisesArrayList = kosmikServisesArrayList;
    }
}
