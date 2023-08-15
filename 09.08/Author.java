/* Gabriel Martins - CB3021521 */

public class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        try {
            this.name = name;
            this.email = email;

            if (gender == 'm' || gender == 'M' || gender == 'f' || gender == 'F') {
                this.gender = gender;
            } else {
                throw new Exception("Tipo inválido");
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    public String toString() {
        String n = String.format("Author[name=%s,email=%s,gender=%s]", getName(), getEmail(), getGender());
        return n;
    }
}
