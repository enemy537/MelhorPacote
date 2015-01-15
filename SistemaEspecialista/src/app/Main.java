package app;

import java.util.ArrayList;

import model.Motor;
import model.Premissa;
import model.Regra;

public class Main {

	public static void main(String[] args) {
		Motor motor = new Motor();
		
		Regra r1 = new Regra("AL", "FRIO",3,5000,"Argentina", 54);
		Regra r2 = new Regra("AL", "FRIO",3,5000,"França", 12);
		Regra r3 = new Regra("SP","CALOR",5,2000,"Nordeste", 89);
		
		ArrayList<Regra> regras = new ArrayList<Regra>();
		regras.add(r1); regras.add(r2); regras.add(r3);
		
		motor.setRegras(regras);
		
		Premissa premissa = new Premissa("AL", "FRIO",3,5000);
		
		motor.setPremissa(premissa);
		
		System.out.println(regras);
	}

}
