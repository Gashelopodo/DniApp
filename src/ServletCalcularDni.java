

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCalcularDni
 */
@WebServlet("/ServletCalcularDni")
public class ServletCalcularDni extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final char [] letraDNI = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCalcularDni() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    private char calculaLetraDni (int num_dni){
		char letra_dni;
		int n = num_dni % 23;
		letra_dni = letraDNI[n];
				
		return letra_dni;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String numdni = request.getParameter("dni");
		
		System.out.println("LLamo a get");
		System.out.println("Dni pasado " + numdni);
		
		int numDni = Integer.parseInt(numdni);
		char letra = calculaLetraDni(numDni);
		
		String mensaje_respuesta = "Su dni completo es " + numdni + "-" + letra;
		PrintWriter pw = response.getWriter();
		pw.write(mensaje_respuesta);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
//7  6  0 8  5  2  4  3 R
//49 18 0 56 15 2 28  9 17
