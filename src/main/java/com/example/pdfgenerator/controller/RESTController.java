package com.example.pdfgenerator.controller;

import com.example.pdfgenerator.model.Invoice;
import com.example.pdfgenerator.service.PDFGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/summa")
public class RESTController {
    @Autowired
    Invoice invoice;

    public RESTController(PDFGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }

    @GetMapping("{name}")
    public Invoice gettingValues(){
        return this.invoice;
    }

//    @PostMapping()
//    public Invoice creatingValues(@RequestBody Invoice invoice){
//        this.invoice = invoice;
//
//        return this.invoice;
//    }

    private final PDFGeneratorService pdfGeneratorService;

    @PostMapping
    public ResponseEntity<String> updateValues(@RequestBody Invoice invoice) throws FileNotFoundException {
        this.invoice = invoice;

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachement; filename=pdf_" + currentDateTime + ".pdf";

//        FileOutputStream io = new FileOutputStream(headerValue);
        boolean success = this.pdfGeneratorService.exportPdf(this.invoice,headerValue);

        if (success){
            return ResponseEntity.ok("PDF generated Successfully");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to generate PDF");
        }


    }
}
