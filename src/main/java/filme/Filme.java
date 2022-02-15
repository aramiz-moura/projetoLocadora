package filme;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


public class Filme {


    @Getter @Setter
    final private String nome;
    final private int ano;
    final private String genero;

    public Filme(String nome, int ano, String genero) {
        this.nome = nome;
        this.ano = ano;
        this.genero = genero;
    }

}
