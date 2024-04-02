package interpolacionLagrange;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InterpolacionLagrange extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterpolacionLagrange frame = new InterpolacionLagrange();
					frame.setTitle("Interpolación de Lagrange");
					frame.setVisible(true);
					frame.setSize(800,430);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					
					ImageIcon icono = new ImageIcon("Imagenes/logo.png");
					frame.setIconImage(icono.getImage());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JRadioButton nr1;
	JRadioButton nr2;
	private JTextField valoresx;
	private JTextField valoresy;
	private JTextField vevaluar;
	
	public InterpolacionLagrange() {
		setBackground(new Color(255, 240, 245));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 460);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(188, 143, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Interpolación de Lagrange");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(424, 29, 273, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valores de X:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(367, 101, 121, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Valores de Y:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(367, 163, 121, 24);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel alerta = new JLabel("");
		alerta.setHorizontalAlignment(SwingConstants.CENTER);
		alerta.setForeground(new Color(255, 0, 0));
		alerta.setFont(new Font("Tahoma", Font.BOLD, 11));
		alerta.setBounds(367, 269, 377, 14);
		contentPane.add(alerta);
		
		valoresx = new JTextField();
		valoresx.setBounds(496, 103, 248, 24);
		contentPane.add(valoresx);
		valoresx.setColumns(10);
		
		valoresy = new JTextField();
		valoresy.setColumns(10);
		valoresy.setBounds(496, 165, 248, 24);
		contentPane.add(valoresy);
		
		JButton aceptar = new JButton("Aceptar");
		aceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Conversion c = new Conversion();
				Operaciones op = new Operaciones();
				Respuestas r = new Respuestas();
				
				String x = valoresx.getText();
				String y = valoresy.getText();
				String valorE = vevaluar.getText();
				
				c.setValoresx(x);
				c.setValoresy(y);
				
				op.setPts(c.conversion());
				op.setvE(valorE);
				
				System.out.println(c.conversion());
				
				String regex = "^[0-9,-.]*[0-9]$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcherx = pattern.matcher(x);
				Matcher matchery = pattern.matcher(y);
				Matcher matchervE = pattern.matcher(valorE);
				
				
				if(x.length() == y.length()) {
					if(!valoresx.getText().isEmpty() && !valoresy.getText().isEmpty() && !vevaluar.getText().isEmpty()) {
						if(matcherx.matches() && matchery.matches()) {
							if(matchervE.matches()) {
								aceptar.setEnabled(true);
								r.setVisible(true);
								r.setTitle("Interpolación de Lagrange");
								r.setResizable(false);
								r.setSize(730,430);
								r.setLocationRelativeTo(null);
								r.resultadosOb(c.conversion(), op.operacion());
								ImageIcon icono = new ImageIcon("Imagenes/logo.png");
								r.setIconImage(icono.getImage());
								
								dispose();
							}else {
								alerta.setText("El valor a evaluar debe ser un número");
								aceptar.setEnabled(false);
							}
						}else {
							alerta.setText("Respete el formato n1, n2, n3,...");
							aceptar.setEnabled(false);
						}
						
		
					}else {
						alerta.setText("Complete todos los campos para continuar.");
						aceptar.setEnabled(false);
					}
				}
				
				alerta.setText("La cantidad de números en X y Y deben ser iguales");
				aceptar.setEnabled(false);
				
				
				
			}
		});
		
		
		
		aceptar.setFont(new Font("Times New Roman", Font.BOLD, 18));
		aceptar.setBounds(412, 302, 110, 39);
		contentPane.add(aceptar);
		
		JButton reiniciar = new JButton("Reiniciar");
		reiniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				valoresx.setText("");
				valoresy.setText("");
				vevaluar.setText("");
				alerta.setText("");
				aceptar.setEnabled(true);
			}
		});
		
		reiniciar.setFont(new Font("Times New Roman", Font.BOLD, 18));
		reiniciar.setBounds(599, 302, 110, 39);
		contentPane.add(reiniciar);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Valor a evaluar:");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_1_1.setBounds(424, 221, 121, 24);
		contentPane.add(lblNewLabel_1_1_1);
		
		vevaluar = new JTextField();
		vevaluar.setColumns(10);
		vevaluar.setBounds(565, 223, 110, 24);
		contentPane.add(vevaluar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\6TO SEMESTRE\\Análisis Numérico\\3 Proyecto\\Interpolacion-Lagrange\\Imagenes\\img1.png"));
		lblNewLabel_2.setBounds(49, 302, 305, 58);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\6TO SEMESTRE\\Análisis Numérico\\3 Proyecto\\Interpolacion-Lagrange\\Imagenes\\4.jpg"));
		lblNewLabel_3.setBounds(49, 29, 289, 270);
		contentPane.add(lblNewLabel_3);
		
		
	}
}
