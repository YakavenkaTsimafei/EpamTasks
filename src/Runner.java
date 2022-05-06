import by.epam.lab.Material;
import by.epam.lab.Subject;

public class Runner {
    public static void main(String[] args) {

        Material material = new Material("steel", 7850);

        Subject subject = new Subject("wire", material, 0.03);
        System.out.println(subject);
        material.setName("copper");
        material.setDensity(8500);
        System.out.println(subject);
    }
}
