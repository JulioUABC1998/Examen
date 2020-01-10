package Clases.Peces;

import Clases.Espacio.Lugar;
import Clases.Espacio.Objeto;
import Clases.Espacio.Posicion;

public class Pescado extends Objeto {
   
	String color;
	float size;
	String especie;
	float temperatura;
	 public Pescado(String nombre, Posicion laPosicion, Lugar elLugar,String color, float size, String especie, float temperatura) {
	    	super(nombre, laPosicion, elLugar);
			this.color = color;
			this.size = size;
			this.especie = especie;
			this.temperatura = temperatura;    
	    }
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
		this.size = size;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public float getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}
	@Override
	public String toString() {
		return "Pescado [color=" + color + ", size=" + size + ", especie=" + especie + ", temperatura=" + temperatura
				+ "]";
	}
	
}
