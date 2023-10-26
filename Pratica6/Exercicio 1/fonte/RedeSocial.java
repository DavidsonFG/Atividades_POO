import java.util.ArrayList;

public class RedeSocial {
    private String nomeRedeSocial;
    private String usuario;
    private ArrayList<Publicacao> publicacoes;

    public RedeSocial(String nomeRedeSocial, String usuario) {
        this.nomeRedeSocial = nomeRedeSocial;
        this.usuario = usuario;
        this.publicacoes = new ArrayList<>();
    }

    public void inserePublicacao(Publicacao publicacao) {
        publicacoes.add(publicacao);
    }

    public void imprimePublicacoes() {
        System.out.println("Total de publicações: " + Publicacao.getContadorPublicacao());
        for (Publicacao publicacao : publicacoes) {
            System.out.println("Data de Publicação: " + publicacao.getDataPublicacao());
            System.out.println("Texto da Publicação: " + publicacao.getTextoPublicacao());
            System.out.println("Link da Mídia: " + publicacao.getLinkMidia());
            System.out.println();
        }
    }
}
