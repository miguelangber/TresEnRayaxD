import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JTextField;

public class MiClickListener implements MouseListener {

	
	JTextField texto;
	JButton miRestartBoton;



	public MiClickListener(JTextField texto, JButton miRestartBoton) 
	{
		this.miRestartBoton = miRestartBoton;
		this.texto = texto;
	}


	@Override
	public void mouseClicked(MouseEvent e) 
	{
		JButton miBoton = (JButton) e.getSource();
		if(miBoton.isEnabled()) {
			
			if (miBoton.getName().equalsIgnoreCase("reiniciar")) {
				miBoton.setEnabled(false);
				texto.setName(miBoton.getName());
				
//				Esto es solo pa mostrar una ventana emergente
//				JOptionPane.showMessageDialog(null, "partida terminada", "fin de partida", JOptionPane.WARNING_MESSAGE);
			}
			else {
				texto.setName(miBoton.getName());
				
//				cambiarturno
				String sMensaje = texto.getText();
				if(sMensaje.equalsIgnoreCase("Turno del jugador 1"))
				{
					texto.setText("Turno del jugador 2");
				}
				else if(sMensaje.equalsIgnoreCase("Turno del jugador 2"))
				{
					texto.setText("Turno del jugador 1");
				}
			}
		}
	}
	

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Apéndice de método generado automáticamente
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Apéndice de método generado automáticamente

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Apéndice de método generado automáticamente

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Apéndice de método generado automáticamente

	}

}
