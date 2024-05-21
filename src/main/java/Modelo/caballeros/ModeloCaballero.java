package Modelo.caballeros;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import Controlador.conector.Conector;

public class ModeloCaballero {
	
	/*CONEXION CON LA BBDD*/
	private Conector conector;

	public Conector getConector() {
		return conector;
	}

	public void setConector(Conector conector) {
		this.conector = conector;
	}

	public ArrayList<Caballero> seleccionarCaballeros() {
		/*CREAR LAS CLASES*/
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
		ModeloCaballero modelo_ca = new ModeloCaballero();
		
		/*CREAR LA VARIABLE SQL*/
		String sql = "SELECT * FROM CABALLEROS";
		
		/*TRY CATCH*/
		try {			
			/*CREAR STATEMENT Y RESULSET*/
			Statement stm = conector.getCon().createStatement();
			ResultSet rst = stm.executeQuery(sql);
			/*WHILE (variable del resulset)*/
			while (rst.next()) {
				/*CREAR LOS CABALLEROS*/
				Caballero caballeross = new Caballero();
				  
				/*ATRIBUTOS DEL CABALLERO*/
				caballeross.setId(rst.getInt("id"));
				caballeross.setNombre(rst.getString("nombre"));
				caballeross.setFuerza(rst.getInt("fuerza"));
				caballeross.setExperiencia(rst.getInt("experiencia"));
				caballeross.setFoto(rst.getString("foto"));
				caballeross.setArma_id(rst.getInt("arma_id"));
				
				/*PRIMERO LA VARIBLE DEL ARRAYLIST, DESPUES LA VARIBLES DEL OBJETO CABALLERO*/
				caballeros.add(caballeross);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return caballeros;
		
	}

}
