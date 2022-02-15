package pessoa;

public class Funcionario extends Pessoa{
    String cargo;
    Double salario;

    public Funcionario(String nome, String cpf, String cargo, Double salario) {
        super(nome,cpf);
        this.cargo = cargo;
        this.salario = salario;
    }
}
