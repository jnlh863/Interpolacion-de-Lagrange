package interpolacionLagrange;


import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Respuestas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	

	
	public Respuestas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(188, 143, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}
	
	public void resultadosOb(ArrayList<Double> ptsxy, Double valor) {
		/*ArrayList<Double> raices = new ArrayList<Double>();
		ArrayList<Double> errores = new ArrayList<Double>();
		ArrayList<Integer> iteraciones = new ArrayList<Integer>();
		
		for(int i = 0; i< j.size(); i++) {
			if(i != ((j.size()/2))) {
				raices.add(j.get(i));
			}else {
				break;
			}
		}
		
		for(int i = 0; i< j.size(); i++) {
			if(((j.size()/2)) <= i) {
				errores.add(j.get(i));
			}
		}
		
		for(int i = 0; i< (j.size()/2); i++) {
			iteraciones.add(i);
		}

		Object[][] data = new Object[raices.size()][3];
        for (int i = 0; i < raices.size(); i++) {
            data[i][0] = iteraciones.get(i);
            data[i][1] = raices.get(i);
            data[i][2] = errores.get(i);
        }
        
        for (Object[] row : data) {
            model.addRow(row);
        }*/
		
	}

}
