package interpolacionLagrange;


import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Respuestas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableu;
	private DefaultTableModel model;
	
	
	public Respuestas(ArrayList<Double> ptsxy, Double valor, String valorE) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(188, 143, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 140, 250, 166);
		contentPane.add(scrollPane);
		
		tableu = new JTable();
		tableu.setFont(new Font("Times New Roman", Font.BOLD, 11));
		
		model = new DefaultTableModel();

		model.addColumn("Valores X");
		model.addColumn("Valores Y");
		tableu.setModel(model);
		
		scrollPane.setViewportView(tableu);
		
		JLabel lblNewLabel = new JLabel("Resultados obtenidos");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(165, 69, 236, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor evaluado");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(389, 160, 131, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel valorEvaluado = new JLabel("");
		valorEvaluado.setBackground(new Color(0, 0, 0));
		valorEvaluado.setForeground(new Color(0, 0, 0));
		valorEvaluado.setHorizontalAlignment(SwingConstants.CENTER);
		valorEvaluado.setFont(new Font("Times New Roman", Font.BOLD, 18));
		valorEvaluado.setBounds(535, 161, 122, 20);
		contentPane.add(valorEvaluado);
		
		JLabel respuesta = new JLabel("");
		respuesta.setHorizontalAlignment(SwingConstants.CENTER);
		respuesta.setFont(new Font("Times New Roman", Font.BOLD, 18));
		respuesta.setBounds(435, 249, 180, 48);
		contentPane.add(respuesta);
		
		
		ArrayList<Double> ptsX = new ArrayList<Double>();
		ArrayList<Double> ptsY = new ArrayList<Double>();
		
		
		for(int i = 0; i< ptsxy.size(); i++) {
			if(i != ((ptsxy.size()/2))) {
				ptsX.add(ptsxy.get(i));
			}else {
				break;
			}
		}
		
		for(int i = 0; i< ptsxy.size(); i++) {
			if((ptsxy.size())/2 <= i) {
				ptsY.add(ptsxy.get(i));
			}
		}
		

		Object[][] data = new Object[ptsX.size()][2];
        for (int i = 0; i < ptsX.size(); i++) {
            data[i][0] = ptsX.get(i);
            data[i][1] = ptsY.get(i);
        }
        
        for (Object[] row : data) {
            model.addRow(row);
        }
        
        valorEvaluado.setText("x = " + valorE);
        respuesta.setText("y(x) = " + String.valueOf(valor));
        
        JLabel lblNewLabel_2 = new JLabel("Función de Lagrange");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(421, 210, 194, 28);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\6TO SEMESTRE\\Análisis Numérico\\3 Proyecto\\Interpolacion-Lagrange\\Imagenes\\duke (1).png"));
        lblNewLabel_3.setBounds(469, 28, 131, 110);
        contentPane.add(lblNewLabel_3);
        
        JButton regresar = new JButton("Ingresar nuevos valores");
        
        regresar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		InterpolacionLagrange frame = new InterpolacionLagrange();
				frame.setTitle("Interpolación de Lagrange");
				frame.setVisible(true);
				frame.setSize(800,430);
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
				ImageIcon icono = new ImageIcon("Imagenes/logo.png");
				frame.setIconImage(icono.getImage());
				dispose();	
        	}
        });
        
        regresar.setFont(new Font("Times New Roman", Font.BOLD, 15));
        regresar.setBounds(431, 308, 198, 33);
        contentPane.add(regresar);
        
	}
}
