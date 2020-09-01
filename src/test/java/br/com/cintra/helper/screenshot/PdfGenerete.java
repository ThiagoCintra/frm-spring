package br.com.cintra.helper.screenshot;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Lazy
@Component
public class PdfGenerete {

	private Document document = new Document();
	private Paragraph paragraph = new Paragraph();
	private static Font CAT_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static Font NORMAL_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
	private static Font HEADER_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
	private float xImg;
	
	@Value("#{${env.pdf.file}")
	private Path path;
	
	@Autowired
	TakeScreenshot takeScreenshot;

	private void createDocument(String testName) {
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			document.setPageSize(PageSize.A4.rotate());

			try {
				PdfWriter.getInstance(document, new FileOutputStream(path + testName + ".pdf"));
			} catch (DocumentException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
		document.open();
		document.addTitle(testName);
	}
	
	public Image getImageInBuffer(BufferedImage bufferedImage) throws BadElementException, IOException {
		Image image = Image.getInstance(bufferedImage, null);
		image.scaleAbsolute(800, 400);
		xImg = (PageSize.A4.rotate().getWidth() - image.getScaledWidth()) / 2;
		image.setAbsolutePosition(xImg, 50f);
		return image;
	}

	public Paragraph getTextsInBuffer(String description) throws IOException, DocumentException {
		paragraph.clear();
		paragraph.add(description);
		paragraph.setAlignment(Element.ALIGN_CENTER);
		return paragraph;

	}
	
	private void constructPdf(String testName) throws IOException, DocumentException {
		//Paragraph pDate = new Paragraph(date+ "   "+ "ass: ");
		Paragraph pNumber = new Paragraph();
	//	pDate.setAlignment(Element.ALIGN_LEFT);
		pNumber.setAlignment(Element.ALIGN_RIGHT);
		int pages = 1;
		for (Entry<String, BufferedImage> textAndImage : takeScreenshot.getBufferImageMap(testName).entrySet()) {
			pNumber.clear();
			document.add(getTextsInBuffer(textAndImage.getKey()));
			document.add(getImageInBuffer(textAndImage.getValue()));
//			document.add(pDate);
			pNumber.add(String.valueOf(pages));
			document.add(pNumber);
			document.newPage();
			pages++;
		}
	}
	
	public void createPdf(String testName) throws DocumentException, IOException, ParseException {
		createDocument(testName);
		try {
			constructPdf(testName);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			document.close();
			takeScreenshot.clearCurrentScenarioScreenshot(testName);
		}
	}
}
