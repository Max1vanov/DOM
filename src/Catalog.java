public class Catalog {
    private String common, botanical, zone, light, price, availability;

    public Catalog(String common, String botanical, String zone, String light, String price, String availability) {
        this.common = common;
        this.botanical = botanical;
        this.zone = zone;
        this.light = light;
        this.price = price;
        this.availability = availability;
    }

    public Catalog(String common, String botanical) {
        this.common = common;
        this.botanical = botanical;
    }

    public Catalog(String common) {
        this.common = common;
    }

    public Catalog() {}

    public String getCommon() {
        return common;
    }

    public String getBotanical() {
        return botanical;
    }

    public String getZone() {
        return zone;
    }

    public String getLight() {
        return light;
    }

    public String getPrice() {
        return price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public void setBotanical(String botanical) {
        this.botanical = botanical;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
