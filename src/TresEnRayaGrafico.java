import java.awt.Color;

import javax.swing.*;

public class TresEnRayaGrafico extends JFrame{
	private static final long serialVersionUID = 1L;
	
	
	JPanel miPanel;
	JButton miRestartBoton;
	JTextField texto;
	JButton[][] arrayBotones;
	
	public TresEnRayaGrafico ()
	{
		inicializarcomponentes();
	}
	public void inicializarcomponentes() 
	{	
//		propiedades de la ventana
		setTitle("tres en raya xD");
		int ancho = 380;
		int largo = 200;
		setSize(ancho, largo);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		propiedades del panel
		miPanel = new JPanel();
		miPanel.setBackground(Color.ORANGE);
		miPanel.setLayout(null);
		
//		caja de texto
		texto = new JTextField("Turno del jugador 1",100);
		texto.setLocation(390, 150);
		texto.setBounds(10, 130, 170, 20);
		texto.setEditable(false);
		miPanel.add(texto);
		
//		boton de reiniciar
		miRestartBoton = new JButton("Reiniciar");
		miRestartBoton.setBounds(200, 130, 150, 20);
		miRestartBoton.setName("reiniciar");
		miRestartBoton.addMouseListener(new MiClickListener(texto,miRestartBoton));
		miRestartBoton.setEnabled(false);
		miPanel.add(miRestartBoton);
		
//		creamos los botones los botones
		arrayBotones = new JButton[3][3];
		
//		metemos los botones en el panel
		int fila = 0;
		int columna = 0;
		for (int i = 0 ; i < 3 ; i++){
			for (int j = 0 ; j < 3 ; j++){
				JButton boton = new JButton("");
				boton.setName(i+""+j);
				boton.setBounds(10 + ((100+20)*columna),
								  10 + ((20+20)*fila),
								  100, 30);
				arrayBotones[i][j] = boton;
				arrayBotones[i][j].addMouseListener(new MiClickListener(texto,miRestartBoton));
				miPanel.add(arrayBotones[i][j]);
				columna++;
				if (columna > 2)
				{
					fila++;
					columna = 0;
				}
			}
		}
		
		
		
//		metemos el panel en la ventana
		setContentPane(miPanel);
		
//		hacemos visible la pantalla
		setVisible(true);
	}
}