import java.util.Scanner;

public class TorresDeHanoi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array com as opções de discos disponíveis
        int[] discosDisponiveis = {1, 10, 20, 30, 40, 41};

        // Solicitar ao usuário o número de discos
        System.out.println("Escolha o número de discos (1, 10, 20, 30, 40 ou 41): ");
        int n = scanner.nextInt();

        // Verificar se o número escolhido está na lista de opções
        boolean valido = false;
        for (int discos : discosDisponiveis) {
            if (n == discos) {
                valido = true;
                break;
            }
        }

        if (valido) {
            System.out.println("Executando Torres de Hanoi para " + n + " discos:");

            // Usar long para contar os movimentos devido ao tamanho grande
            long startTime = System.currentTimeMillis();
            long movimentos = torresDeHanoi(n, 'A', 'C', 'B');
            long endTime = System.currentTimeMillis();
            long tempoGasto = endTime - startTime;

            System.out.println("Número de movimentos: " + movimentos);
            System.out.println("Tempo gasto: " + formatarTempo(tempoGasto));
        } else {
            System.out.println("Número de discos inválido. Escolha entre 1, 10, 20, 30, 40 ou 41.");
        }

        scanner.close();
    }

    public static long torresDeHanoi(int n, char origem, char destino, char auxiliar) {
        if (n == 1) {
            return 1;
        } else {
            long movimentos = 0;
            movimentos += torresDeHanoi(n - 1, origem, auxiliar, destino);
            movimentos++;
            movimentos += torresDeHanoi(n - 1, auxiliar, destino, origem);
            return movimentos;
        }
    }

    public static String formatarTempo(long millis) {
        long segundos = millis / 1000;
        long minutos = segundos / 60;
        segundos = segundos % 60;
        millis = millis % 1000;
        return String.format("%02d:%02d:%02d:%d", minutos, segundos, millis / 10, millis % 10);
    }
}
