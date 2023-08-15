/* Gabriel Martins - CB3021521 */

public class TestaBook {
    public static void main(String[] args) {
        
        // Declaração do Livro 1
        Author[] livro1 = new Author[1];
        livro1[0] = new Author("Eduardo Cilto", "ec@universo.com", 'm');
        Book tra1 = new Book("Tracos", livro1, 35.99, 1);

        // Declaração do Livro 2
        Author[] livro2 = new Author[3];
        livro2[0] = new Author("Rodrigo Sonoda", "rs@opt.com", 'm');
        livro2[1] = new Author("Waldir Paes", "wp@opt.com", 'm');
        livro2[2] = new Author("Elizabeth Santana", "es@opt.com", 'f');
        Book opt3 = new Book("Optologia", livro2, 57.01, 1);

        System.out.println("Livro 1");
        System.out.println(tra1.toString() + "\n");
        System.out.println("Livro 2");
        System.out.println(opt3.toString());
    }
}
