package system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class DownloadFile {

	public static void collectForm(String filePath) {

		try {
			File file = new File(filePath);
			file.createNewFile();
			Document doc = new Document();
			doc.setMargins(30, 30, 30, 30);
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(file));
			doc.open();

			Paragraph paragraph = new Paragraph("Booking");
			doc.add(paragraph);

			doc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void bill(String filePath) {

		try {
			File file = new File(filePath);
			file.createNewFile();
			Document doc = new Document();
			doc.setMargins(30, 30, 30, 30);
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(file));
			doc.open();

			Paragraph paragraph = new Paragraph("Booking");
			doc.add(paragraph);

			doc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
