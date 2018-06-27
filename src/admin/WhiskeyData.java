package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class WhiskeyData {

    private final StringProperty id;
    private final StringProperty brand;
    private final StringProperty name;
    private final StringProperty desc;
    private final StringProperty sexynod;
    private final StringProperty wowfactor;
    private final StringProperty packaging;
    private final StringProperty rating;

    public WhiskeyData(String id, String brand, String name, String desc, String sexynod, String wowfactor, String packaging, String rating) {
        this.id = new SimpleStringProperty(id);
        this.brand = new SimpleStringProperty(brand);
        this.name = new SimpleStringProperty(name);
        this.desc = new SimpleStringProperty(desc);
        this.sexynod = new SimpleStringProperty(sexynod);
        this.wowfactor = new SimpleStringProperty(wowfactor);
        this.packaging = new SimpleStringProperty(packaging);
        this.rating = new SimpleStringProperty(rating);

    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getBrand() {
        return brand.get();
    }

    public StringProperty brandProperty() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDesc() {
        return desc.get();
    }

    public StringProperty descProperty() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc.set(desc);
    }

    public String getSexynod() {
        return sexynod.get();
    }

    public StringProperty sexynodProperty() {
        return sexynod;
    }

    public void setSexynod(String sexynod) {
        this.sexynod.set(sexynod);
    }

    public String getWowfactor() {
        return wowfactor.get();
    }

    public StringProperty wowfactorProperty() {
        return wowfactor;
    }

    public void setWowfactor(String wowfactor) {
        this.wowfactor.set(wowfactor);
    }

    public String getPackaging() {
        return packaging.get();
    }

    public StringProperty packagingProperty() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging.set(packaging);
    }

    public String getRating() {
        return rating.get();
    }

    public StringProperty ratingProperty() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating.set(rating);
    }

}
