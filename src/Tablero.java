
public class Tablero {

	int[][] arrTab = new int[3][3];
	boolean fichasPuestas = false;
	
	
//	el contructor inicializa las posiciones a 0
	public void limpiarTablero()
	{
		for(int i = 0 ; i < 3 ; i++)
		{
			for(int j = 0 ; j < 3 ; j++)
			{
				arrTab[i][j] = 0;
//				System.out.println("arrTab["+i+"]["+j+"] = "+arrTab[i][j]);
			}
		}
	}
	
	
	public int setFicha (int xPos, int yPos, int iFicha)
	{
		int iResult;
		
//		contamos cuantas fichas de ese jugador hay ya puestas
		int iNumFichas = contadorDeFichas(iFicha);
		
//		validamos si le quedan fichas para poner
		if (iNumFichas == 3)
		{
			fichasPuestas = true;
			if (arrTab[xPos][yPos] == iFicha)
			{
				arrTab[xPos][yPos] = 0;
				iResult = 2;
			}else
				iResult = 0;
		}
		else 
		{
			int sLoQueHay = arrTab[xPos][yPos];
			
//			validamos si el sitio está libre
			if (sLoQueHay == 1 || sLoQueHay == 2)
				iResult = 0;
			else
			{
				arrTab[xPos][yPos] = iFicha;
				iResult = 1;
			}
		}

		/* muestra por consola como va la partida
		for(int i = 0 ; i < 3 ; i++){
			for(int j = 0 ; j < 3 ; j++){
				System.out.print(arrTab[i][j]);
				if (j == 2)
					System.out.println();
			}
		}
		*/

		return iResult;
	}
	public int validarPartida() {
		int ganador = 0;
		for(int i = 0 ; i < 3 ; i++) {
			if ((arrTab[i][0] == 1) && (arrTab[i][1] == 1) && (arrTab[i][2] == 1)) {
				ganador = 1;
			}
			if ((arrTab[0][i] == 1) && (arrTab[1][i] == 1) && (arrTab[2][i] == 1)) {
				ganador = 1;
			}
			if ((arrTab[i][0] == 2) && (arrTab[i][1] == 2) && (arrTab[i][2] == 2)) {
				ganador = 2;
			}
			if ((arrTab[0][i] == 2) && (arrTab[1][i] == 2) && (arrTab[2][i] == 2)) {
				ganador = 2;
			}
			if ((arrTab[0][0] == 2) && (arrTab[1][1] == 2) && (arrTab[2][2] == 2)) {
				ganador = 2;
			}
			if ((arrTab[0][0] == 1) && (arrTab[1][1] == 1) && (arrTab[2][2] == 1)) {
				ganador = 1;
			}
			if ((arrTab[2][0] == 1) && (arrTab[1][1] == 1) && (arrTab[0][2] == 1)) {
				ganador = 1;
			}
			if ((arrTab[2][0] == 2) && (arrTab[1][1] == 2) && (arrTab[0][2] == 2)) {
				ganador = 2;
			}
		}
		return ganador;
	}
	public int contadorDeFichas(int iFicha) {
		
		int contadorDeFichas = 0;
		for(int i = 0 ; i < 3 ; i++){
			for(int j = 0 ; j < 3 ; j++){
				if (arrTab[i][j] == iFicha)
					contadorDeFichas++;
			}
		}
		return contadorDeFichas;
	}
}









