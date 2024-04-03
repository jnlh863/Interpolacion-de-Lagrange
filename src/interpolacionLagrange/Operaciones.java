package interpolacionLagrange;

import java.util.ArrayList;

public class Operaciones {
	
	private ArrayList<Double> pts;
	private String vE = "";
	
	
	public Operaciones() {
	}
	
	
	public ArrayList<Double> getPts() {
		return pts;
	}

	public void setPts(ArrayList<Double> pts) {
		this.pts = pts;
	}

	public String getvE() {
		return vE;
	}

	public void setvE(String vE) {
		this.vE = vE;
	}

	
	
	
	public double operacion() {
		
		ArrayList<Double> aux = this.pts;
		ArrayList<Double> ptsX = new ArrayList<Double>();
		ArrayList<Double> ptsY = new ArrayList<Double>();
		double valorEs = Double.parseDouble(vE);
		double resultado = 0.0;
	
		
		
		for(int i = 0; i< aux.size(); i++) {
			if(i != ((aux.size()/2))) {
				ptsX.add(aux.get(i));
			}else {
				break;
			}
		}
		
		for(int i = 0; i< aux.size(); i++) {
			if(((aux.size()/2)) <= i) {
				ptsY.add(aux.get(i));
			}
		}
		
		
		int y = 0;
		
		while(y < ptsY.size()) {
			
			double numerador = 1.0;
			double denominador = 1.0;
			
			for(int i = 0;i < ptsX.size();i++) {
				int auxi = y;
				if(i != auxi) {
					numerador = numerador*(valorEs - ptsX.get(i));
				}				
			}
			
			for(int j = 0;j < ptsX.size();j++) {
				if(y!=j) {
					denominador = denominador*(ptsX.get(y) - ptsX.get(j));
				}	
			}
			
			resultado = resultado + ptsY.get(y)*(numerador/denominador);
            
			y++;
		}
		
		
		return resultado;
	}
	

}
