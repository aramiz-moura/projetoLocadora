package pessoa;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class Cliente extends Pessoa{

    @Getter @Setter
    final private Double id;
    final private List<String> filmesLocados = new ArrayList<>();



    public Cliente(String nome, String cpf, Double id) {
        super(nome, cpf);
        this.id = id;
    }

}
