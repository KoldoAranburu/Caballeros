package Controlador.caballeros;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.conector.Conector;
import Modelo.caballeros.Caballero;
import Modelo.caballeros.ModeloCaballero;

/**
 * Servlet implementation class VerCaballeros
 */
@WebServlet("/VerCaballeros")
public class VerCaballeros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerCaballeros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*CREAR EL MODELO Y ARRAYLIST*/
		Conector conector = new Conector();
		conector.conectar();
		ModeloCaballero modelo_ca = new ModeloCaballero();
		modelo_ca.setConector(conector);
		ArrayList<Caballero> caballeros = modelo_ca.seleccionarCaballeros();
		
		
		/*AÑADIR REQUEST (SET_ATTRIBUTTE Y GET_REQUEST_DISPATCHER)*/
		request.setAttribute("caballeros", caballeros);
		request.getRequestDispatcher("Prueba/Caballeros_prueba.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
