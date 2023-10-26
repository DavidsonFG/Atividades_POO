public class Main {
    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario("João", "joao@gmail.com", "123456789", "RH", 3000.0, "01/01/2020", "123456789");
        Funcionario funcionario2 = new Funcionario("Maria", "maria@gmail.com", "987654321", "TI", 4000.0, "02/02/2021", "987654321");
        Funcionario funcionario3 = new Funcionario("Pedro", "pedro@gmail.com", "456789123", "Financeiro", 3500.0, "03/03/2019", "456789123");
        Funcionario funcionario4 = new Funcionario("Ana", "ana@gmail.com", "321654987", "Vendas", 3200.0, "04/04/2018", "321654987");
        Funcionario funcionario5 = new Funcionario("Carlos", "carlos@gmail.com", "654987321", "Produção", 3800.0, "05/05/2020", "654987321");

        Empresa minhaEmpresa = new Empresa("Minha Empresa", "123456789");

        minhaEmpresa.adicionarFuncionario(funcionario1);
        minhaEmpresa.adicionarFuncionario(funcionario2);
        minhaEmpresa.adicionarFuncionario(funcionario3);
        minhaEmpresa.adicionarFuncionario(funcionario4);
        minhaEmpresa.adicionarFuncionario(funcionario5);

        for (int i = 0; i < minhaEmpresa.qtdeDeFuncionarios; i++) {
            Funcionario funcionario = minhaEmpresa.funcionarios[i];
            funcionario.mostrarDados();
            System.out.println();
        }
    }
}
