package air.go.files;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class CreateDocument {

	public static void main(String[] args) {

		try {

			XWPFDocument document = new XWPFDocument();

			FileOutputStream out = new FileOutputStream(new File("ProjectInfo.docx"));

			XWPFParagraph paragraph = document.createParagraph();
			XWPFRun run = paragraph.createRun();

			run.setText(getText());

			document.write(out);
			out.close();
			System.out.println("createparagraph.docx written successfully");

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static String getText() throws FileNotFoundException {

		File towrite = new File("D:\\Advance Java\\simple-java-maven-app-master\\src\\main\\resources");
		StringBuffer sb = new StringBuffer();

		for (File file : towrite.listFiles()) {

			String line;
			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				while ((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
				sb.append("\n");
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

		return sb.toString();
	}

}
