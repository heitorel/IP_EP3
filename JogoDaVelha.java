/*********************************************************************/
/**   ACH2001 - Introdução à Programação                            **/
/**   EACH-USP - Primeiro Semestre de 2020                          **/
/**   <2020194> - <Norton Trevisan Roman>                           **/
/**                                                                 **/
/**   Terceiro Exercício-Programa                                   **/
/**                                                                 **/
/**   <HEITOR LOPES BIANCHI>                   <10258730>           **/
/**                                                                 **/
/**   <01/06/2020>         		                                    **/
/*********************************************************************/

/*
	Jogo da Velha - programa para verificar o status de uma partida de Jogo da Velha.
	
	Lista de Status calculado:
	0 - Jogo não iniciado: o tabuleiro esta 'vazio', isto é sem peças X e O;
    1 - Jogo encerrado1: o primeiro jogador (que usa as peças X) é o ganhador;
    2 - Jogo encerrado2: o segundo jogador (que usa as peças O) é o ganhador;
    3 - Jogo encerrado3: empate - todas as casas do tabuleiro estão preenchidas com X e O, mas nenhum dos jogadores ganhou;
    4 - Jogo já iniciado e em andamento: nenhuma das alternativas anteriores.	
*/

public class JogoDaVelha {
	static final char pecaX = 'X';
	static final char pecaY = 'O';
	static final char espacoVazio = ' ';

	/*
		O método determina o status de uma partida de Jogo da Valha
		
		Entrada:
			tabuleiro - matriz 3x3 de caracteres representando uma partida valida de Jogo da Velha
			
		Saida:
			um inteiro contendo o status da partida (valores válidos de zero a quatro)
	*/
	static int verificaStatus(char[][] tabuleiro) {
		int status = -1;
		
		//variáveis auxiliares
		boolean cheio = true;
		boolean vazio = true; 
		
		//verifica se esta vazia ou cheia (ou nenhuma das opções)
		for (int i = 0; i <= tabuleiro.length-1; i+=1){
			for(int j = 0; j <= tabuleiro.length-1; j+=1){
				char valor = tabuleiro[i][j];
				if (valor == espacoVazio){
					cheio = false;
				}
				if ( valor == pecaX || valor == pecaY){
					vazio = false;

				}
			}
		}
		//verifica se esta vazia
		if ( vazio == true){
			status = 0;
			return(status);
		}
		//caso não-vazia
		else {
			//percorre as linhas
			for (int x = 0; x <= tabuleiro.length-1; x+=1){
				int y = 0;
				//se encontrar um vencedor nas linahs o identifica
				if (tabuleiro[x][y] == tabuleiro[x][y+1] && tabuleiro[x][y] == tabuleiro[x][y+2]){
					if (tabuleiro[x][y] == pecaX){
						status = 1;
						break;
					}
					if (tabuleiro[x][y] == pecaY){
						status = 2;
						break;
					}
				}
				//se encontrar um vencedor na diagonal 1 o identifica
				if (tabuleiro[y][y] == tabuleiro[y+1][y+1] && tabuleiro[y][y] == tabuleiro[y+2][y+2]){
					if (tabuleiro[y][y] == pecaX){
						status = 1;
						break;
					}
					if (tabuleiro[y][y] == pecaY){
						status = 2;
						break;
					}
				}
				//se encontrar um vencedor na diagonal 2 o identifica
				if (tabuleiro[y][y+2] == tabuleiro[y+1][y+1] && tabuleiro[y][y+2] == tabuleiro[y+2][y]){
					if (tabuleiro[y+1][y+1] == pecaX){
						status = 1;
						break;
					}
					if (tabuleiro[y+1][y+1] == pecaY){
						status = 2;
						break;
					}
				}
			}
			//percorre as colunas
			for (int y = 0; y <= tabuleiro.length-1; y+=1){
				int x = 0;
				//se encontrar um vencedor nas colunas o identifica
				if (tabuleiro[x][y] == tabuleiro[x+1][y] && tabuleiro[x][y] == tabuleiro[x+2][y]){
					if (tabuleiro[x][y] == pecaX){
						status = 1;
						break;
					}
					if (tabuleiro[x][y] == pecaY){
						status = 2;
						break;
					}
				}
			}
			//verifica se acabou empatado
			if (cheio == true && status == -1){
				status = 3;
			}
			//verifica se não acabou ainda
			else {
				if (cheio == false && status != 1 && status != 2){
					status = 4;
				}
			}
		}
		return(status);
	}
	
	public static void main(String[] args) {

		char[][] tab0 = {{'X','O','X'},{' ','O',' '},{'X','X','X'}};
		char[][] tab1 = {{'X','X','O'},{'O','O','X'},{'X','O','X'}};
		char[][] tab2 = {{'O',' ','X'},{' ','O','X'},{'O',' ','X'}};
		char[][] tab3 = {{'X','O','X'},{'O','O','X'},{'O','X','O'}};
		char[][] tab4 = {{'O',' ','O'},{' ','O','X'},{'X','X','O'}};

		System.out.println("Status calculado: " + verificaStatus(tab0));
		System.out.println("Status esperado para o tabuleiro0: 1\n");

		System.out.println("Status calculado: " + verificaStatus(tab1));
		System.out.println("Status esperado para o tabuleiro1: 3\n");

		System.out.println("Status calculado: " + verificaStatus(tab2));
		System.out.println("Status esperado para o tabuleiro2: 1\n");
		
		System.out.println("Status calculado: " + verificaStatus(tab3));
		System.out.println("Status esperado para o tabuleiro1: 3\n");
		
		System.out.println("Status calculado: " + verificaStatus(tab4));
		System.out.println("Status esperado para o tabuleiro4: 2\n");
		

	}
}