package ua.nure.tarianyk.SummaryTask4.support.order;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ua.nure.tarianyk.SummaryTask4.util.consts.PDFconst;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.OrdersBean;

/**
 * The class used for generating PDF-file.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class GeneratePDF {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(GeneratePDF.class);

	/**
	 * Path to file for localization.
	 */
	private final static String LOCALIZATION = "ua.nure.tarianyk.SummaryTask4.localization.text";
	/**
	 * Selected language.
	 */
	private String language = null;

	/**
	 * Email of user.
	 */
	private String email = null;

	/**
	 * Style of PDF-document.
	 */
	private String style = null;

	/**
	 * Path to save document
	 */
	private static final String PATH = "c:\\java\\repo\\SummaryTask4\\temp_files\\";

	/**
	 * Path to created document.
	 */
	private String createdDocument = null;

	///////////////////////////////////
	//// Variables for localization.///
	///////////////////////////////////
	private ResourceBundle rb = null;
	private Locale locale = null;

	/**
	 * Constructor with parameters.
	 * 
	 * @param email
	 *            mail which will be sent
	 * @param style
	 *            style of text
	 * @param language
	 *            current language
	 */
	public GeneratePDF(String email, String style, String language) {
		this.email = email;
		this.style = style;
		this.language = language;
	}

	/**
	 * Creates PDF-document.
	 * 
	 * @return instance of Document class
	 * @throws FileNotFoundException
	 *             if file does not exists
	 * @throws DocumentException
	 *             during creating document arose problem
	 */
	public synchronized Document createDocument() throws FileNotFoundException, DocumentException {
		LOG.log(Level.DEBUG, "createDocument method starts.");

		Document document = new Document(PageSize.A4, 50, 50, 50, 50);

		createdDocument = PATH + email + new Random().nextLong() + ".pdf";

		PdfWriter.getInstance(document, new FileOutputStream(createdDocument));
		document.open();

		LOG.log(Level.DEBUG, "createDocument method finished.");
		return document;
	}

	/**
	 * Generates body of document with localization.
	 * 
	 * @param document
	 *            created document
	 * @param ordersBeans
	 *            ordered products
	 * @throws DocumentException
	 *             if object does not exists
	 */
	public synchronized String generateBodyDocument(Document document, List<OrdersBean> ordersBeans)
			throws DocumentException {
		LOG.log(Level.DEBUG, "generateBodyDocument method starts.");

		locale = new Locale(language);
		rb = ResourceBundle.getBundle(LOCALIZATION, locale);

		Font font = FontFactory.getFont(style, BaseFont.IDENTITY_H, true);

		Paragraph p1 = new Paragraph(rb.getString(PDFconst.REPORT), font);
		Paragraph p2 = new Paragraph(rb.getString(PDFconst.TABLE), font);

		Chapter chapter1 = new Chapter(p1, 1);
		chapter1.setNumberDepth(0);
		document.add(p1);
		document.add(p2);

		PdfPTable t = new PdfPTable(5);
		t.setSpacingBefore(25);
		t.setSpacingAfter(25);

		PdfPCell c1 = new PdfPCell(new Phrase(rb.getString(PDFconst.NUMBER), font));
		t.addCell(c1);
		PdfPCell c2 = new PdfPCell(new Phrase(rb.getString(PDFconst.ARTICLE), font));
		t.addCell(c2);
		PdfPCell c3 = new PdfPCell(new Phrase(rb.getString(PDFconst.AMOUNT), font));
		t.addCell(c3);
		PdfPCell c4 = new PdfPCell(new Phrase(rb.getString(PDFconst.PRICE), font));
		t.addCell(c4);
		PdfPCell c5 = new PdfPCell(new Phrase(rb.getString(PDFconst.TOTAL_PRICE), font));
		t.addCell(c5);

		Double total = 0d;
		for (OrdersBean i : ordersBeans) {
			t.addCell(String.valueOf(i.getId()));
			t.addCell(i.getArticle());
			t.addCell(String.valueOf(i.getTotalAmount()));
			t.addCell(String.valueOf(i.getPrice()));
			t.addCell(String.valueOf(i.getTotalPrice()));

			total += i.getTotalPrice();
		}
		document.add(t);

		total = Math.rint(100.0 * total) / 100.0;

		Paragraph p3 = new Paragraph(rb.getString(PDFconst.IN_TOTAL) + total, font);
		document.add(p3);

		document.close();

		LOG.log(Level.DEBUG, "generateBodyDocument method finished.");

		return createdDocument;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreatedDocument() {
		return createdDocument;
	}

}
