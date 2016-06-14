package nl.cge.tranreader;

import java.util.Arrays;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import com.google.common.base.Preconditions;

public class TransaktieBuilder {

	public Transaktie build(String[] transaktieregel) {
		Transaktie transaktie = new Transaktie();
		transaktie.setRekeningnummer(transaktieregel[0]);
		transaktie.setValuta(transaktieregel[1]);
		transaktie.setTransaktiedatum(parseTransaktiedatum(transaktieregel[2]));
		transaktie.setAfschrijving(parseAfOfBijschrijving(transaktieregel[3]));
		transaktie.setBedragInCenten(parseBedrag(transaktieregel[4]));
		transaktie.setMutatieSoort(transaktieregel[8]);
		return transaktie;
	}

	private Long parseBedrag(String bedragString) {
		return (long) (Double.parseDouble(bedragString) * 100);
	}

	private Boolean parseAfOfBijschrijving(String mutatiesoort) {
		Preconditions.checkArgument(Arrays.asList("D", "C").contains(mutatiesoort));
		return "D".equals(mutatiesoort);
	}

	private LocalDate parseTransaktiedatum(String datumString) {
		DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
		DateTimeFormatter formatter = dateTimeFormatterBuilder.appendYear(4, 4).appendMonthOfYear(2).appendDayOfMonth(2).toFormatter();
		LocalDate datum = LocalDate.parse(datumString, formatter);
		return datum;
	}

}
