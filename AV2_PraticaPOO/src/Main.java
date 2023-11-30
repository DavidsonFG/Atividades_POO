import java.util.ArrayList;
import java.util.Date;

// Classe Categoria
class Categoria {
    private String descCategoria;

    public Categoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }

    public String getDescCategoria() {
        return descCategoria;
    }

    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }
}

// Classe Evento
class Evento {
    private String nomeEvento;
    private Date dataEvento;
    private double precoEvento;
    private Categoria categoria;

    public Evento(String nomeEvento, Date dataEvento, double precoEvento, Categoria categoria) {
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
        this.precoEvento = precoEvento;
        this.categoria = categoria;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public double getPrecoEvento() {
        return precoEvento;
    }

    public void setPrecoEvento(double precoEvento) {
        this.precoEvento = precoEvento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean buscarEvento(Evento evento) {
        return this.nomeEvento.equals(evento.getNomeEvento());
    }
}

// Classe PedidoItem
class PedidoItem {
    private String nomeEvento;
    private int qtdeIngresso;
    private double precoIngresso;

    public PedidoItem(String nomeEvento, int qtdeIngresso, double precoIngresso) {
        this.nomeEvento = nomeEvento;
        this.qtdeIngresso = qtdeIngresso;
        this.precoIngresso = precoIngresso;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public int getQtdeIngresso() {
        return qtdeIngresso;
    }

    public void setQtdeIngresso(int qtdeIngresso) {
        this.qtdeIngresso = qtdeIngresso;
    }

    public double getPrecoIngresso() {
        return precoIngresso;
    }

    public void setPrecoIngresso(double precoIngresso) {
        this.precoIngresso = precoIngresso;
    }

    public void atualizaEstoqueIngresso() {
        // Implemente a lógica para atualizar o estoque de ingressos do evento
        System.out.println("Estoque de ingressos atualizado para o evento: " + this.nomeEvento);
    }
}

// Classe Pedido
class Pedido {
    private int numeroPedido;
    private Date dataHoraPedido;
    private double precoTotal;
    private int statusPedido;
    private ArrayList<PedidoItem> itensPedido;

    public Pedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
        this.dataHoraPedido = new Date();
        this.precoTotal = 0.0;
        this.statusPedido = 1;
        this.itensPedido = new ArrayList<>();
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Date getDataHoraPedido() {
        return dataHoraPedido;
    }

    public void setDataHoraPedido(Date dataHoraPedido) {
        this.dataHoraPedido = dataHoraPedido;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(int statusPedido) {
        this.statusPedido = statusPedido;
    }

    public ArrayList<PedidoItem> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(ArrayList<PedidoItem> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public void inserirItensPedido(PedidoItem item) {
        // Verifica se o evento associado ao item existe
        Evento evento = new Evento(item.getNomeEvento(), new Date(), 0.0, new Categoria("Categoria Exemplo"));
        if (!evento.buscarEvento(evento)) {
            System.out.println("Evento não encontrado. Item não adicionado ao pedido.");
            return;
        }

        // Adiciona o item ao pedido
        this.itensPedido.add(item);

        // Atualiza o estoque de ingressos
        item.atualizaEstoqueIngresso();

        // Atualiza o status do pedido para 2
        this.statusPedido = 2;

        // Calcula o total a pagar
        this.calculaTotalPagar();
    }

    public void excluirItensPedido(PedidoItem item) {
        // Verifica se o item existe no pedido
        if (!this.itensPedido.contains(item)) {
            System.out.println("Item não encontrado no pedido. Nada foi removido.");
            return;
        }

        // Remove o item do pedido
        this.itensPedido.remove(item);

        // Calcula o total a pagar
        this.calculaTotalPagar();
    }

    public void calculaTotalPagar() {
        // Calcula o total a pagar somando os preços dos itens no pedido
        this.precoTotal = 0.0;
        for (PedidoItem item : this.itensPedido) {
            this.precoTotal += item.getPrecoIngresso() * item.getQtdeIngresso();
        }

        System.out.println("Total a pagar atualizado: " + this.precoTotal);
    }

    public boolean consultarPedido(Pedido pedido) {
        return this.numeroPedido == pedido.getNumeroPedido();
    }
}

public class Main {
    public static void main(String[] args) {
        // Crie objetos e teste os métodos conforme as instruções da questão 2

        // Exemplo de uso
        Categoria categoriaExemplo = new Categoria("Show");
        Evento evento1 = new Evento("Show A", new Date(), 50.0, categoriaExemplo);

        PedidoItem item1 = new PedidoItem("Show A", 2, 50.0);
        PedidoItem item2 = new PedidoItem("Show A", 3, 50.0);

        Pedido pedido = new Pedido(1);
        pedido.inserirItensPedido(item1);
        pedido.inserirItensPedido(item2);
        pedido.excluirItensPedido(item1);
    }
}
