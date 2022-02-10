public class Products {
    protected String name;
    protected String manufacturer;
    protected int price;

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Products(String name, String manufacturer, int price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Имя ='" + name + ", производитель='" + manufacturer + ", цена=" + price;
    }
}
