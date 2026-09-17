import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.math.RoundingMode;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.Period;
import java.util.Comparator;

public class Principal {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        // 3.1 - Adicionar funcionários
        funcionarios.add(
            new Funcionario(
                "Maria",
                LocalDate.of(2000, 10, 18),
                new BigDecimal("2009.44"),
                "Operador"
            )
        );  

        funcionarios.add(
            new Funcionario(
                "João",
                LocalDate.of(1990, 5, 12),
                new BigDecimal("2284.38"),
                "Operador"
            )
        );

        funcionarios.add(
            new Funcionario(
                "Caio",
                LocalDate.of(1961, 5, 2),
                new BigDecimal("9836.14"),
                "Coordenador"
            )
        );

        funcionarios.add(
            new Funcionario(
                "Miguel",
                LocalDate.of(1988, 10, 14),
                new BigDecimal("19119.88"),
                "Diretor"
            )
        );

        funcionarios.add(
            new Funcionario(
                "Alice",
                LocalDate.of(1995, 1, 5),
                new BigDecimal("2234.68"),
                "Recepcionista"
            )
        );

        funcionarios.add(
            new Funcionario(
                "Heitor",
                LocalDate.of(1999, 11, 19),
                new BigDecimal("1582.72"),
                "Operador"
            )
        );

        funcionarios.add(
            new Funcionario(
                "Arthur",
                LocalDate.of(1993, 3, 31),
                new BigDecimal("4071.84"),
                "Contador"
            )
        );

        funcionarios.add(
            new Funcionario(
                "Laura",
                LocalDate.of(1994, 7, 8),
                new BigDecimal("3017.45"),
                "Gerente"
            )
        );

        funcionarios.add(
            new Funcionario(
                "Heloísa",
                LocalDate.of(2003, 5, 24),
                new BigDecimal("1606.85"),
                "Eletricista"
            )
        );

        funcionarios.add(
            new Funcionario(
                "Helena",
                LocalDate.of(1996, 9, 2),
                new BigDecimal("2799.93"),
                "Gerente"
            )
        );

        // 3.2 - Remover funcionário com nome "João"
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        NumberFormat formatoSalario = NumberFormat.getNumberInstance(
                new Locale("pt", "BR")
        );

        formatoSalario.setMinimumFractionDigits(2);
        formatoSalario.setMaximumFractionDigits(2);

        // 3.3 - Imprimir funcionários
        System.out.println("\n--- Funcionários ---");

        for (Funcionario funcionario : funcionarios) {
            System.out.println(
                    "Nome: " + funcionario.getNome()
                    + " | Data de nascimento: " + funcionario.getDataNascimento().format(formatoData)
                    + " | Salário: " + formatoSalario.format(funcionario.getSalario())
                    + " | Função: " + funcionario.getFuncao()
            );
        }
        
        // 3.4 - Aplicar aumento de 10%
        BigDecimal percentualAumento = new BigDecimal("1.10");

        for (Funcionario funcionario : funcionarios) {
            BigDecimal novoSalario = funcionario.getSalario()
                .multiply(percentualAumento)
                .setScale(2, RoundingMode.HALF_UP);

            funcionario.setSalario(novoSalario);
        }

        // Teste para verificar o aumento
        System.out.println("\n--- Salários após aumento de 10% ---");

        for (Funcionario funcionario : funcionarios) {
            System.out.println(
                    funcionario.getNome()
                    + ": "
                    + formatoSalario.format(funcionario.getSalario())
            );
        }

        // 3.5 - Agrupar funcionários por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
        
        // 3.6 - Imprimir funcionários agrupados por função
        System.out.println("\n--- Funcionários agrupados por função ---");

        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
        System.out.println("\nFunção: " + entry.getKey());

            for (Funcionario funcionario : entry.getValue()) {
            System.out.println("- " + funcionario.getNome());
            }
        }

        // 3.8 - Imprimir funcionários que fazem aniversário nos meses 10 e 12
        System.out.println("\n--- Aniversariantes dos meses 10 e 12 ---");

        for (Funcionario funcionario : funcionarios) {
            int mesNascimento = funcionario.getDataNascimento().getMonthValue();

            if (mesNascimento == 10 || mesNascimento == 12) {
                System.out.println(
                        funcionario.getNome()
                        + " - "
                        + funcionario.getDataNascimento().format(formatoData)
                );
            }
        }

        // 3.9 - Imprimir funcionário com maior idade
        Funcionario funcionarioMaisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);

        if (funcionarioMaisVelho != null) {
            int idade = Period.between(
                    funcionarioMaisVelho.getDataNascimento(),
                    LocalDate.now()
            ).getYears();

            System.out.println("\n--- Funcionário com maior idade ---");
            System.out.println(
                    "Nome: " + funcionarioMaisVelho.getNome()
                    + " | Idade: " + idade + " anos"
            );
        }

        // 3.10 - Imprimir funcionários em ordem alfabética
        System.out.println("\n--- Funcionários em ordem alfabética ---");

        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(funcionario -> System.out.println(funcionario.getNome()));

        // 3.11 - Imprimir o total dos salários
        BigDecimal totalSalarios = funcionarios.stream()
            .map(Funcionario::getSalario)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("\n--- Total dos salários ---");
        System.out.println("Total: " + formatoSalario.format(totalSalarios));

        // 3.12 - Imprimir quantos salários mínimos ganha cada funcionário
        BigDecimal salarioMinimo = new BigDecimal("1212.00");

        System.out.println("\n--- Salários mínimos por funcionário ---");

        for (Funcionario funcionario : funcionarios) {
            BigDecimal quantidadeSalariosMinimos = funcionario.getSalario()
                    .divide(salarioMinimo, 2, RoundingMode.HALF_UP);

            System.out.println(
                    funcionario.getNome()
                    + ": "
                    + quantidadeSalariosMinimos
                    + " salários mínimos"
            );
        }
    }
}
