/* Gabriel Martins - CB3021521 */

public class TestaAuthor {
    public static void main(String[] args ) {
        Author a1 = new Author("Eduardo Cilto", "ec@tracos.com", 'f');
        System.out.println("Autor depois do setEmail():   " + a1.toString());
        a1.setEmail("ec@submerso.com");
        System.out.println("Autor depois do setEmail():   " + a1.toString());
        System.out.println("\nGetters:");
        System.out.println(a1.getName());
        System.out.println(a1.getEmail());
        System.out.println(a1.getGender());
    }
}
