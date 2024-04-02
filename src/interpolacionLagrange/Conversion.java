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
		
		char[] caracteresx = vX.toCharArray();
		char[] caracteresy = vY.toCharArray();
		
		ArrayList<Double> vx = new ArrayList<Double>();
		ArrayList<Double> vy = new ArrayList<Double>();
		ArrayList<Double> pts = new ArrayList<Double>();
		
		while(i < caracteresx.length) {
			if(caracteresx[i] != ',') {
				String v = String.valueOf(caracteresx[i]);
				vx.add(Double.parseDouble(v));
			}
			i++;
		}
		
		while(j < caracteresy.length) {
			if(caracteresy[j] != ',') {
				String v = String.valueOf(caracteresy[j]);
				vy.add(Double.parseDouble(v));
			}
			j++;
		}
		
		pts.addAll(vx);
		pts.addAll(vy);
		
		return pts;
	}
	
	
	
	
	

}
