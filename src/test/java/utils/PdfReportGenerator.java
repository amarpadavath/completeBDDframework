package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

public class PdfReportGenerator {

    public static void generatePdf() {

        try {
            String htmlFile = "ExtentReport/ExtentSpark.html";
            String pdfFile = "test-output/ExtentReport.pdf";

            OutputStream os = new FileOutputStream(pdfFile);

            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withFile(new File(htmlFile));
            builder.toStream(os);
            builder.run();

            os.close();

            System.out.println("PDF Generated Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}