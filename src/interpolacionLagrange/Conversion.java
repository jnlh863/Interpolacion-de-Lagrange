package interpolacionLagrange;

import java.util.ArrayList;

public class Conversion {
	
	private String valoresx = "";
	private String valoresy = "";
	
	public Conversion() {
	}
	
	
	public String getValoresx() {
		return valoresx;
	}
	public void setValoresx(String valoresx) {
		this.valoresx = valoresx;
	}
	public String getValoresy() {
		return valoresy;
	}
	public void setValoresy(String valoresy) {
		this.valoresy = valoresy;
	}
	
	
	
	public ArrayList<Double> conversion() {
		
		int i = 0;
		int j = 0;
		
		String vX = this.valoresx;
		String vY = this.valoresy;
		
		
		String[] elementosx = vX.split(",(?=\\d)");
        String[] elementosy = vY.split(",(?=\\d)");
		
		
		ArrayList<Double> vx = new ArrayList<Double>();
		ArrayList<Double> vy = new ArrayList<Double>();
		ArrayList<Double> pts = new ArrayList<Double>();
		
		while(i < elementosx.length) {
			vx.add(Double.parseDouble(elementosx[i]));
			i++;
		}
		
		while(j < elementosy.length) {
			vy.add(Double.parseDouble(elementosy[j]));
			j++;
		}
		
		pts.addAll(vx);
		pts.addAll(vy);
		
		return pts;
	}
	
	
	public int lenghtX() {

		String vX = this.valoresx;
		String[] elementosx = vX.split(",(?=\\d)");
	
		return elementosx.length;
	}
	
	
	public int lenghtY() {

		String vY = this.valoresy;
		String[] elementosy = vY.split(",(?=\\d)");
	
		return elementosy.length;
	}
	
	
	
	
	

}
