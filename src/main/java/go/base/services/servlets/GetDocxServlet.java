package go.base.services.servlets;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 * Servlet implementation class GetDocxServlet
 */
@WebServlet("/GetDocxServlet")
public class GetDocxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		System.out.println(getRequestBody(request));
		// reading file
		String path = request.getParameter("path");
		
		
		System.out.println("Received path: " + path);
		String line;
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
		try {
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			sb.append("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// writing file
		try {

			XWPFDocument document = new XWPFDocument();

			String path_to_write = "/Air-go-Backend-Project/src/main/resources/ProjectInfo.docx";
			FileOutputStream out = new FileOutputStream(new File(path_to_write)); // writing
																		// location

			XWPFParagraph paragraph = document.createParagraph();
			XWPFRun run = paragraph.createRun();
			
			run.setText(sb.toString());
			

			document.write(out);
			out.close();
			
			PrintWriter writer = response.getWriter();
			writer.print("File is written successfullt at : " + path_to_write);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public  static String getRequestBody(HttpServletRequest request) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    BufferedReader reader = request.getReader();
	    String line;
	    while ((line = reader.readLine()) != null) {
	        sb.append(line);
	    }
	    return sb.toString();
	}

}
