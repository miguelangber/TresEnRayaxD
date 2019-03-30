import java.util.Scanner;
public class TresEnRaya {
	
	static Jugador jugador1;
	static Jugador jugador2;
	static TresEnRayaGrafico miVentana;
	static Tablero miTablero;
	static boolean bTurno;
	static boolean bTresEnRaya;
	
	public static void main(String[] args)
	{
//		Se crean los Jugadores
		Scanner miScan = new Scanner(System.in);
		jugador1 = new Jugador(llamarJugador(miScan),1);
		jugador2 = new Jugador(llamarJugador(miScan),2);
		miScan.close();
		
//		creamos la ventana
		miVentana = new TresEnRayaGrafico();
		
//		se crea el tablero
		miTablero = new Tablero();
		miTablero.limpiarTablero();
		
		
//		El programa solo acabará cuando se cierre la ventana
		while (true){
//			inicializamos los turnos
			bTurno = true;
//			true = jugador1 // false = jugador2
			bTresEnRaya = false;
//			true = alguien ha ganado//False = seguir jugando
			
			
//			Se ejecuta el juego hasta que alguien gane
			ejecutarPartido();
			
//			desactivamos los botones
			for (int i = 0 ; i < 3 ; i++) {
				for (int j = 0 ; j < 3 ; j++) {
					miVentana.arrayBotones[i][j].setEnabled(false);
				}
			}
			
//			activamos el restart
			miVentana.miRestartBoton.setEnabled(true);
			pausarTurno("xD",0);
			if (miVentana.texto.getName().equalsIgnoreCase("reiniciar")) {
				for (int i = 0 ; i < 3 ; i++) {
					for (int j = 0 ; j < 3 ; j++) {
						miVentana.arrayBotones[i][j].setEnabled(true);
						miVentana.arrayBotones[i][j].setText("");
					}
				}
			}
			miTablero.limpiarTablero();
			miVentana.texto.setText("Turno del jugador 1");
		}
	}

	public static String llamarJugador(Scanner miScan)
	{
		System.out.println("indicar nombre: ");
		String nombre;
		nombre = miScan.nextLine();
		return nombre;
	}
	
	public static void ejecutarPartido()
	{
		while(!bTresEnRaya)
		{
			if (bTurno)
			{	
				pintarCambioDeFicha(jugador1.iFicha, "x", true);
				bTurno = ejecutarTurno(jugador1.iFicha, "X",bTurno);
				pintarCambioDeFicha(jugador2.iFicha, "", true);
				pintarCambioDeFicha(jugador1.iFicha, "x", false);				
			}
			else
			{
				pintarCambioDeFicha(jugador2.iFicha, "0", true);
				bTurno = ejecutarTurno(jugador2.iFicha, "0", bTurno);
				pintarCambioDeFicha(jugador1.iFicha, "", true);
				pintarCambioDeFicha(jugador2.iFicha, "0", false);
			}
			
//			validamos si la partida debe continuar
			int ganador = miTablero.validarPartida();
			if ((ganador == 1)){
				bTresEnRaya = true;
				miVentana.texto.setText(jugador1.nombre+" ha ganado!!");
			}
			else if ((ganador == 2)) {
				bTresEnRaya = true;
				miVentana.texto.setText(jugador2.nombre+" ha ganado!!");
			}
			else;
				
//			cambiamos de turno
			bTurno = !bTurno;
		}
	}

	public static void pintarCambioDeFicha(int iFicha, String marcaDelJugador, boolean b) {
		if(miTablero.contadorDeFichas(iFicha) == 3) {
			for(int i = 0 ; i < 3 ; i++){
				for(int j = 0 ; j < 3 ; j++){
					if(miVentana.arrayBotones[i][j].getText().equalsIgnoreCase("")) {
						miVentana.arrayBotones[i][j].setEnabled(!b);
					}
					if(miVentana.arrayBotones[i][j].getText().equalsIgnoreCase(marcaDelJugador)) {
						miVentana.arrayBotones[i][j].setEnabled(b);
					}
				}
			}
		}
		
	}

	private static boolean ejecutarTurno(int fichaJugador, String marcaJugador, boolean bTurno) {
		String sMensaje = "Turno del jugador "+fichaJugador;
//		Pausa el turno y escribe a quien le toca
		pausarTurno(sMensaje, fichaJugador);
		
		
		String[] arrStringPos = miVentana.texto.getName().split("");
		int xPos = Integer.parseInt(arrStringPos[0]);
		int yPos = Integer.parseInt(arrStringPos[1]);
		
		int fichaPuesta = miTablero.setFicha(xPos, yPos, fichaJugador);
		
		if (fichaPuesta == 1){
			pintarFicha(xPos,yPos,marcaJugador);
		}
		else if (fichaPuesta == 0){
			bTurno = !bTurno;
		}
		else{
			pintarFicha(xPos,yPos,"");
			bTurno = !bTurno;
		}
		return bTurno;
	}
	
	public static void pausarTurno(String sMensaje, int iFicha)
	{
		if (miVentana.miRestartBoton.isEnabled()) {
			miVentana.texto.setName(sMensaje);
			do
			{
				try 
				{
					Thread.sleep(100); // 100 millisegundos
				}
					catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
			}
			while(miVentana.texto.getName().equalsIgnoreCase(sMensaje));
		}
		else {
			miVentana.texto.setText(sMensaje);
			do
			{
				try 
				{
					Thread.sleep(100); // 100 millisegundos
				}
					catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
			}
			while(miVentana.texto.getText().equalsIgnoreCase(sMensaje));
		}
	}
	
	public static void pintarFicha(int xPos, int yPos, String sFicha) {

		for(int i = 0 ; i < 3 ; i++){
			for(int j = 0 ; j < 3 ; j++){
				if(miVentana.arrayBotones[i][j].getName().equalsIgnoreCase(xPos+""+yPos)) {
					miVentana.arrayBotones[i][j].setText(sFicha);
					if(sFicha.equalsIgnoreCase("X") || sFicha.equalsIgnoreCase("0"))
						miVentana.arrayBotones[i][j].setEnabled(false);
					else 
						miVentana.arrayBotones[i][j].setEnabled(true);
				}
			}
		}
	}

}
