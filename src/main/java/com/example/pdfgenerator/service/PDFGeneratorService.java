package com.example.pdfgenerator.service;

import com.example.pdfgenerator.model.Invoice;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.Response;
import org.apache.catalina.connector.CoyoteOutputStream;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


@Service
@Component
public class PDFGeneratorService {
    public void summa(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        System.out.println(response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph paragraph = new Paragraph("This is my project", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(13);

        Paragraph paragraph1 = new Paragraph("This is my project again", fontParagraph);
        paragraph1.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(paragraph);
        document.add(paragraph1);
        document.close();
    }

    public boolean exportPdf(Invoice invoice,String fileName) throws FileNotFoundException {
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            System.out.println("file name: " + fileName);
            System.out.println(fileName);

            document.open();
            Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            fontTitle.setSize(18);

            Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
            fontParagraph.setSize(13);

            Paragraph paragraph1 = new Paragraph("Seller\n" + invoice.getSeller() + "\n" + invoice.getSellerGstin() + "\n" + invoice.getSellerAddress());
            paragraph1.setAlignment(Paragraph.ALIGN_LEFT);

            document.add(paragraph1);
            document.close();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
