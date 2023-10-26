import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Artigo> artigos = new ArrayList<>();

        // Adiciona 10 objetos da classe Artigo ao ArrayList
        for (int i = 1; i <= 10; i++) {
            Artigo artigo = new Artigo("Artigo " + i, "Resumo do Artigo " + i, "Autor " + i);
            artigos.add(artigo);
        }

        // Cria Edicao e adiciona todos os artigos
        Edicao edicao = new Edicao(1, 1, "01/01/2023", 1000);
        for (Artigo artigo : artigos) {
            edicao.adicionaArtigo(artigo);
        }

        // Cria Revista Científica e adiciona a Edição
        RevistaCientifica revista = new RevistaCientifica("Minha Revista", 1234567890, "Mensal");
        revista.adicionaEdicao(edicao);
    }
}
