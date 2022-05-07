import by.epam.lab.Material;
import by.epam.lab.Subject;

public class Runner {
    public static void main(String[] args) {
        Material copper = new Material("copper", 8500);
        Material steel = new Material("steel", 7850);

        Subject subject = new Subject("wire", steel, 0.03);
        System.out.println(subject);
        subject.setMaterial(copper);
        System.out.println(subject);
    }
}
