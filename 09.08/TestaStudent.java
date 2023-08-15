/* Gabriel Martins - CB3021521 */

public class TestaStudent {
    public static void main(String[] args) {
        Student ariel = new Student("Ariel", "Rua X, 0", "Estudante", 0, 0);
        System.out.println(ariel.toString());

        Staff ed = new Staff("Eduardo", "Rua X, 0", "X", 0);
        System.out.println(ed.toString());

        System.out.println("Getter's -- Student");
        System.out.println(ariel.getName());
        System.out.println(ariel.getAddress());
        System.out.println(ariel.getProgram());
        System.out.println(ariel.getYear());
        System.out.println(ariel.getFee());
        System.out.println("------------------");
        
        ariel.setAddress("Rua V. de V. S., 206");
        ariel.setProgram("Analise e Desenvolvimento de Sistemas");
        ariel.setYear(2022);
        ariel.setFee(0.99);
        System.out.println(ariel.toString());

        System.out.println("------------------");

        System.out.println("Getter's -- Staff");
        System.out.println(ed.getName());
        System.out.println(ed.getAddress());
        System.out.println(ed.getSchool());
        System.out.println(ed.getPay());
        System.out.println("------------------");
        
        ed.setAddress("Rua Maria Cristina, 50");
        ed.setSchool("IFSP - Campus Cubatao");
        ed.setPay(3500);

        System.out.println("------------------");
        System.out.println(ed.toString());
    }
}
