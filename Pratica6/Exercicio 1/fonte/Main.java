import java.util.Date;

public class Main {
    public static void main(String[] args) {
            // Solicita dados da rede social
            String nomeRedeSocial = "Minha Rede Social";
            String usuario = "meuUsuario";

            RedeSocial minhaRedeSocial = new RedeSocial(nomeRedeSocial, usuario);

            // Cria objetos de Publicacao
            Date data1 = new Date();
            Publicacao publicacao1 = new Publicacao(data1, "Minha primeira publicação", "");
            Date data2 = new Date();
            Publicacao publicacao2 = new Publicacao(data2, "Outra publicação interessante", "link-da-midia");

            // Insere publicações na rede social
            minhaRedeSocial.inserePublicacao(publicacao1);
            minhaRedeSocial.inserePublicacao(publicacao2);

            // Chama o método para imprimir as publicações
            minhaRedeSocial.imprimePublicacoes();
        }
    }