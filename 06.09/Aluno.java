import java.util.UUID;

public class Aluno {
    private String nome;
    private int idade;
    private String endereco;
    private UUID uuid;

    public Aluno(String n, int i, String e) {
        nome = n;
        idade = i;
        endereco = e;
        uuid = UUID.randomUUID();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String n) {
        nome = n;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int i) {
        idade = i;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String e) {
        endereco = e;
    }

    public UUID getUUID() {
        return uuid;
    }

    public void setUUID(UUID u) {
        uuid = u;
    }
}