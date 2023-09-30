// This is the first task assigned by CodeClause
// PdfSplitter using java
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.multipdf.Splitter;
import java.util.List;

public class PdfSplitter {
    public static void main(String[] args) {
        String inputPdfPath = "C:\\Users\\SHASHI\\OneDrive\\Documents\\CSS_classroom\\JEEEEE.pdf"; 
        String outputFolder = "C:\\Users\\SHASHI\\OneDrive\\Documents\\CSS_classroom";   

        try {
            PDDocument document = PDDocument.load(new File(inputPdfPath));
            Splitter splitter = new Splitter();
            List<PDDocument> pages = splitter.split(document);

            int pageNumber = 1;
            for (PDDocument page : pages) {
                String outputPdfPath = outputFolder + File.separator + "page" + pageNumber + ".pdf";
                page.save(outputPdfPath);
                pageNumber++;
                page.close();
            }

            document.close();
            System.out.println("PDF split successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
