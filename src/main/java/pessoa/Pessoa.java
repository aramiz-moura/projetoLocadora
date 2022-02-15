package pessoa;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
public class Pessoa {
    @Getter @Setter
    private String nome;

    @Getter
    private final String cpf;

}
