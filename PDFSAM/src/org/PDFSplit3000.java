package org;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;


public class PDFSplit3000 {
private String RESULT = "results/Out1112_";
	
	/** A PDF with the iText logo that will be transformed. */
	private String RESOURCE = "C:\\DEV\\1725tally.pdf";

	public PDFSplit3000(String in) {
		String filename = "";
		String dir = "";
		if (in.indexOf("\\") == -1) {
			filename = in.substring(0, in.toLowerCase().indexOf(".pdf"));

		} else {
			filename = in.substring(in.lastIndexOf("\\") + 1, in.toLowerCase()
					.indexOf(".pdf"));
		}
		dir = in.substring(0, in.indexOf(filename));
		RESOURCE=in;
		RESULT=dir+filename;
	}

	public void delFile(String filePathAndName) {
		try {
			// String filePath = filePathAndName;
			// filePath = filePath.toString();
			java.io.File myDelFile = new java.io.File(filePathAndName);
			myDelFile.delete();

		} catch (Exception e) {
			// System.out.println("删除文件操作出错");
			e.printStackTrace();

		}

	}

	private void splitStepTopLeft() throws IOException, DocumentException {
		Rectangle rect = new Rectangle(0, 0, 295, 360);
		PdfReader reader = new PdfReader(RESOURCE);
		int n = reader.getNumberOfPages();
		for (int i = 1; i <= n; i++) {
			Document document = new Document(rect);
			PdfWriter writer = PdfWriter.getInstance(
					document,
					new FileOutputStream(String.format(RESULT
							+ "_TopLeft_%d.pdf", i)));
			document.open();
			PdfContentByte canvas = writer.getDirectContent();
			PdfTemplate template = writer.getImportedPage(reader, i);
			canvas.saveState();
			// canvas.addTemplate(template, -3, -459);
			canvas.addTemplate(template, -6, -462);
			canvas.restoreState();
			document.close();
		}
	}

	private void splitStepBottomLeft() throws IOException, DocumentException {
		Rectangle rect = new Rectangle(0, 0, 295, 360);
		PdfReader reader = new PdfReader(RESOURCE);
		int n = reader.getNumberOfPages();
		for (int i = 1; i <= n; i++) {
			Document document = new Document(rect);
			PdfWriter writer = PdfWriter.getInstance(
					document,
					new FileOutputStream(String.format(RESULT
							+ "_BottomLeft_%d.pdf", i)));
			document.open();
			PdfContentByte canvas = writer.getDirectContent();
			PdfTemplate template = writer.getImportedPage(reader, i);
			canvas.saveState();
			// canvas.addTemplate(template, -3, -459);
			canvas.addTemplate(template, -6, -66);
			canvas.restoreState();
			document.close();
		}
	}

	private void splitStepBottomRight() throws IOException, DocumentException {
		Rectangle rect = new Rectangle(0, 0, 295, 360);
		PdfReader reader = new PdfReader(RESOURCE);
		int n = reader.getNumberOfPages();
		for (int i = 1; i <= n; i++) {
			Document document = new Document(rect);
			PdfWriter writer = PdfWriter.getInstance(
					document,
					new FileOutputStream(String.format(RESULT
							+ "_BottomRight_%d.pdf", i)));
			document.open();
			PdfContentByte canvas = writer.getDirectContent();
			PdfTemplate template = writer.getImportedPage(reader, i);
			canvas.saveState();
			// canvas.addTemplate(template, -3, -459);
			canvas.addTemplate(template, -300, -66);
			canvas.restoreState();
			document.close();
		}
	}

	private void splitStepTopRight() throws IOException, DocumentException {
		Rectangle rect = new Rectangle(0, 0, 295, 360);
		PdfReader reader = new PdfReader(RESOURCE);
		int n = reader.getNumberOfPages();
		for (int i = 1; i <= n; i++) {
			Document document = new Document(rect);
			PdfWriter writer = PdfWriter.getInstance(
					document,
					new FileOutputStream(String.format(RESULT
							+ "_TopRight_%d.pdf", i)));
			document.open();
			PdfContentByte canvas = writer.getDirectContent();
			PdfTemplate template = writer.getImportedPage(reader, i);
			canvas.saveState();
			// canvas.addTemplate(template, -3, -459);
			canvas.addTemplate(template, -300, -462);
			canvas.restoreState();
			document.close();
		}
	}

	private void splitStepInitialize(String position) throws IOException,
			DocumentException {
		Rectangle rect = new Rectangle(0, 0, 294, 360);
		PdfReader reader = new PdfReader(RESOURCE);
		int n = reader.getNumberOfPages();
		for (int i = 1; i <= n; i++) {
			Document document = new Document(rect);
			PdfWriter writer = PdfWriter.getInstance(
					document,
					new FileOutputStream(String.format(RESULT + position
							+ "%d.pdf", i)));
			document.open();
			PdfContentByte canvas = writer.getDirectContent();
			PdfTemplate template = writer.getImportedPage(reader, i);
			canvas.saveState();
			// canvas.addTemplate(template, -3, -459);
			if (position.equals("_TopLeft_")) {
				canvas.addTemplate(template, -6, -462);
			}
			if (position.equals("_TopRight_")) {
				canvas.addTemplate(template, -301, -462);
			}
			if (position.equals("_BottomLeft_")) {
				canvas.addTemplate(template, -6, -66);
			}
			if (position.equals("_BottomRight_")) {
				canvas.addTemplate(template, -301, -66);
			}

			canvas.restoreState();
			document.close();
		}
	}

	private void splitStepFinal(String position) throws IOException,
			DocumentException {
		// step 1
		Rectangle rect = new Rectangle(0, 0, 310, 370);
		PdfReader reader = new PdfReader(RESOURCE);
		int n = reader.getNumberOfPages();
		System.out.println(n);
		int j = 10000000;
		if (position.equals("_TopLeft_")) {
			j = 1;
		}
		if (position.equals("_TopRight_")) {
			j = 2;
		}
		if (position.equals("_BottomLeft_")) {
			j = 3;
		}
		if (position.equals("_BottomRight_")) {
			j = 4;
		}
		for (int i = 1; i <= n; i++) {
			Document document = new Document(rect);
			PdfReader reader2 = new PdfReader(String.format(RESULT + position
					+ "%d.pdf", i));
			// step 2
			PdfWriter writer = PdfWriter.getInstance(
					document,
					new FileOutputStream(RESULT + "_No" + (4 * (i-1) + j) + ".pdf"));
			// step 3
			document.open();
			// step 4

			PdfContentByte canvas = writer.getDirectContent();

			PdfTemplate template = writer.getImportedPage(reader2, 1);

			canvas.saveState();

			canvas.addTemplate(template, 9, 4);
			canvas.restoreState(); // step 5
			document.close();
			delFile(String.format(String
					.format(RESULT + position + "%d.pdf", i)));
		}
	}

	public void doIt() throws IOException, DocumentException {
		splitStepInitialize("_TopLeft_");
		splitStepFinal("_TopLeft_");
		splitStepInitialize("_TopRight_");
		splitStepFinal("_TopRight_");
		splitStepInitialize("_BottomLeft_");
		splitStepFinal("_BottomLeft_");
		splitStepInitialize("_BottomRight_");
		splitStepFinal("_BottomRight_");
	}

	/**
	 * @param args
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static void main(String[] args) throws DocumentException,
			IOException {

		new PDFSplit3000("C:\\DEV\\1725tally.pdf").doIt();
		System.out.println(System.currentTimeMillis());
		System.exit(0);

	}



}
