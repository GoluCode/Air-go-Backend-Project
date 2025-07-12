package go.base.services.servlets;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpHeaders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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

}
