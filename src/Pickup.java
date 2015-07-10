public class Pickup extends Auto {
    public int peopleNum;
    public int thingsNum;

    public Pickup(String newName, int newPrice, int peopleNum, int thingsNum) {
        this.autoName = newName;
        this.autoPrice = newPrice;
        this.peopleNum = peopleNum;
        this.thingsNum = thingsNum;
    }
}