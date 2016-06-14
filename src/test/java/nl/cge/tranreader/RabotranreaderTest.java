package nl.cge.tranreader;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.joda.time.LocalDate;
import org.junit.Test;

import com.google.common.io.Files;
import com.opencsv.CSVReader;

public class RabotranreaderTest {
	
	@Test
	public void testWithOpenCsv() throws IOException {
		CSVReader csvReader = new CSVReader(new FileReader(getCsvFile()));
		String[] readNext = csvReader.readNext();
		TransaktieBuilder transaktieBuilder = new TransaktieBuilder();
		Transaktie transaktie = transaktieBuilder.build(readNext);
		csvReader.close();
		assertEquals("NL60RABO0393939339", transaktie.getRekeningnummer());
		assertEquals("EUR", transaktie.getValuta());
		assertEquals(new LocalDate(2015, 12, 21), transaktie.getTransaktiedatum());
		assertEquals(Boolean.TRUE, transaktie.getAfschrijving());
		assertEquals(Long.valueOf(1848), transaktie.getBedragInCenten());
		assertEquals("ba", transaktie.getMutatieSoort());
		System.out.println("09:" + readNext[9]);
		System.out.println("10:" + readNext[10]);
		System.out.println("11:" + readNext[11]);
		System.out.println("12:" + readNext[12]);
		System.out.println("13:" + readNext[13]);
		System.out.println("14:" + readNext[14]);
	}

	@Test
	public void test() throws IOException {
		CSVReader csvReader = new CSVReader(new FileReader(getCsvFile()));
		for (String[] regel : csvReader) {
			System.out.println("=>" + regel[13]);
		}

		csvReader.close();
	}

	private File getCsvFile() {
		URL resource = RabotranreaderTest.class.getResource("transactions2212-3012.txt");
		File file = new File(resource.getFile());
		return file;
	}

}
