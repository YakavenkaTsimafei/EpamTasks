import by.epam.lab.MaterialEnum;
import by.epam.lab.Subject;


public class Runner {
    public static void main(String[] args) {
        Subject wire = new Subject("wire", MaterialEnum.STEEL, 0.03);
        System.out.println(wire);
        wire.setMaterial(MaterialEnum.COPPER);
        System.out.println("The wire mass is " + wire.getMass() + " kg.");
    }
}
