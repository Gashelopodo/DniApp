

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Decoder;

/**
 * Servlet implementation class UploadImage
 */
@WebServlet("/UploadImage")
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		BASE64Decoder bd = null;
		OutputStream os = null;
		byte[] imgbytes = null;
		
		System.out.println("POST RECIBIDO");
		imgbytes = bd.decodeBuffer(request.getInputStream());
		
		System.out.println("IMagen decodificada");
		
		try{
			File file = new File("subida.jpg");
			FileOutputStream fos = new FileOutputStream(file);
			os = new BufferedOutputStream(fos);
			os.write(imgbytes);
			
			System.out.println("FICHERO CREADO EN: " + file.getAbsolutePath());
			os.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		
	}

}
