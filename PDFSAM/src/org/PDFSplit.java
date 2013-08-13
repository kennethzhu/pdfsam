package org;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.Splitter;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfRectangle;
import com.itextpdf.text.pdf.PdfStamper;

public class PDFSplit {

	/**
	 * This will perform the document copy.
	 * 
	 * @param in
	 *            The filename used for input.
	 * @param out
	 *            The filename used for output.
	 * @throws Exception
	 * 
	 * @throws IOException
	 *             If there is an error parsing the document.
	 * @throws COSVisitorException
	 *             If there is an error while copying the document.
	 */
	public void doIt(String in) throws Exception {
		
		PdfRectangle rect_3_7 = new PdfRectangle(2, 5, 302, 425); 
		PdfRectangle rect_2_6 = new PdfRectangle(290, 420, 590, 840);
		PdfRectangle rect_4_8 = new PdfRectangle(290, 5, 590, 425);
		PdfRectangle rect_1_5 = new PdfRectangle(2, 420, 302, 840);
		
//		rect_3_7 = new PdfRectangle(0.0F, 60F, 310F, 430F);
//		rect_2_6 = new PdfRectangle(285F, 458F, 595F, 828F);
//		rect_4_8 = new PdfRectangle(285F, 60F, 595F, 430F);
//		rect_1_5 = new PdfRectangle(0.0F, 458F, 310F, 828F);
//		rect_1_5 = new PdfRectangle(7, 462, 300, 822);

		try {
			manipulatePdf(rect_1_5, in, "_TopLeft_");
			manipulatePdf(rect_2_6, in, "_TopRight_");
			manipulatePdf(rect_3_7, in, "_BottomLeft_");
			manipulatePdf(rect_4_8, in, "_BottomRight_");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		split(in, "_TopLeft_");
		split(in, "_TopRight_");
		split(in, "_BottomLeft_");
		split(in, "_BottomRight_");
		String filename = "";
		String dir = "";
		if (in.indexOf("\\") == -1) {
			filename = in.substring(0, in.toLowerCase().indexOf(".pdf"));

		} else {
			filename = in.substring(in.lastIndexOf("\\") + 1, in.toLowerCase()
					.indexOf(".pdf"));
		}
		dir = in.substring(0, in.indexOf(filename));
		new PDFSplit3000("c:\\1.pdf").delFile(dir+ filename + "_TopLeft_" + ".pdf");
		new PDFSplit3000("c:\\1.pdf").delFile(dir+ filename + "_TopRight_" + ".pdf");
		new PDFSplit3000("c:\\1.pdf").delFile(dir+ filename + "_BottomLeft_" + ".pdf");
		new PDFSplit3000("c:\\1.pdf").delFile(dir+ filename + "_BottomRight_" + ".pdf");
	}

	/**
	 */
	public void manipulatePdf(PdfRectangle rect, String in,
			String position) throws IOException, DocumentException {
		String filename = "";
		String dir = "";
		if (in.indexOf("\\") == -1) {
			filename = in.substring(0, in.toLowerCase().indexOf(".pdf"));

		} else {
			filename = in.substring(in.lastIndexOf("\\") + 1, in.toLowerCase()
					.indexOf(".pdf"));
		}
		dir = in.substring(0, in.indexOf(filename));
//		System.out.println(dir + "  " + filename);
		PdfReader reader = new PdfReader(in);
		int n = reader.getNumberOfPages();
		PdfDictionary pageDict;
		for (int i = 1; i <= n; i++) {
			pageDict = reader.getPageN(i);
			pageDict.put(PdfName.CROPBOX, rect);
		}
		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dir+ filename + position + ".pdf"));
		stamper.close();
	}

	private void split(String pdfFile, String position) throws Exception {
		String filename = "";
		String dir = "";
		if (pdfFile.indexOf("\\") == -1) {
			filename = pdfFile.substring(0, pdfFile.indexOf(".PDF"));

		} else {
			filename = pdfFile.substring(pdfFile.lastIndexOf("\\") + 1, pdfFile.toLowerCase()
					.indexOf(".pdf"));
		}
		dir = pdfFile.substring(0, pdfFile.indexOf(filename));
//		System.out.println(dir + "  " + filename);
		pdfFile=dir+filename+position+".pdf";
//		System.out.println("pdfFile----"+pdfFile);
//		System.out.println("pdfFile.length()----"+pdfFile.length());
	
		
		Splitter splitter = new Splitter();
		InputStream input = null;
		PDDocument document = null;
		List<PDDocument> documents = null;
		try {
			input = new FileInputStream(pdfFile);
			document = parseDocument(input);
			splitter.setSplitAtPage(1);
			documents = splitter.split(document);
//			System.out.println(documents.size()+"documents.size()");
			int j=10000000;
			if(position.equals("_TopLeft_")){j=1;}
			if(position.equals("_TopRight_")){j=2;}
			if(position.equals("_BottomLeft_")){j=3;}
			if(position.equals("_BottomRight_")){j=4;}
			for (int i = 0; i < documents.size(); i++) {
				PDDocument doc = (PDDocument) documents.get(i);
				String fileName = filename+ "_No" + (4*i+j) + ".pdf";
//				System.out.println(filename+"fileName-");
				
				writeDocument(doc, dir+fileName);
				doc.close();
			}
			
			
		} finally {
			if (input != null) {
				input.close();
			}
			if (document != null) {
				document.close();
			}
			for (int i = 0; documents != null && i < documents.size(); i++) {
				PDDocument doc = (PDDocument) documents.get(i);
				doc.close();
			}
		}

	}

	private static final void writeDocument(PDDocument doc, String fileName)
			throws IOException, COSVisitorException {
		FileOutputStream output = null;
		COSWriter writer = null;
		try {
			output = new FileOutputStream(fileName);
			writer = new COSWriter(output);
			writer.write(doc);
		} finally {
			if (output != null) {
				output.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
	}

	/**
	 * This will parse a document.
	 * 
	 * @param input
	 *            The input stream for the document.
	 * 
	 * @return The document.
	 * 
	 * @throws IOException
	 *             If there is an error parsing the document.
	 */
	private static PDDocument parseDocument(InputStream input)
			throws IOException {
		PDFParser parser = new PDFParser(input);
		parser.parse();
		return parser.getPDDocument();
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args0) throws Exception {
		String args[] = { "C:\\DEV\\1725tally.pdf" };
		PDFSplit splitter = new PDFSplit();
		if (args.length != 1) {
			splitter.usage();
		} else {
			splitter.doIt(args[0]);
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Done, please check the output!");
		System.out.println("\n\n\n");
		System.exit(0);
	}

	/**
	 * This will print out a message telling how to use this example.
	 */
	private void usage() {
		System.err.println("usage: " + this.getClass().getName()
				+ " <input-file>");
	}
}
