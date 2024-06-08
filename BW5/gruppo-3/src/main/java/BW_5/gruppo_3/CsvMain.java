package BW_5.gruppo_3;


import BW_5.gruppo_3.Service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import java.io.IOException;

@SpringBootApplication
public class CsvMain {
@Autowired
private CsvService csvService;


    public void csvLoad(String comuniFilePath, String provinceFilePath) throws IOException {
        csvService.loadCsvData(comuniFilePath, provinceFilePath);
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext context = SpringApplication.run(CsvMain.class, args);
        CsvMain csvMain = context.getBean(CsvMain.class);

        // Esempio di utilizzo del metodo csvLoad con file di esempio
        String comuniFilePath = "./comuni-italiani.csv";
        String provinceFilePath = "./province-italiane.csv";
        csvMain.csvLoad(comuniFilePath, provinceFilePath);
    }



}
