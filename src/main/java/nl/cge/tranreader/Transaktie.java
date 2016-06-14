package nl.cge.tranreader;

import org.joda.time.LocalDate;

public class Transaktie {

	private String rekeningnummer;
	private String valuta;
	private LocalDate transaktiedatum;
	private Boolean afschrijving;
	private Long bedragInCenten;
	private String mutatieSoort;
	
	public void setRekeningnummer(String rekeningnummer) {
		this.rekeningnummer = rekeningnummer;
	}
	
	public String getRekeningnummer() {
		return rekeningnummer;
	}

	public LocalDate getTransaktiedatum() {
		return transaktiedatum;
	}
	
	public void setTransaktiedatum(LocalDate transaktiedatum) {
		this.transaktiedatum = transaktiedatum;
	}

	public String getValuta() {
		return valuta;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
	}
	
	public void setAfschrijving(Boolean afschrijving) {
		this.afschrijving = afschrijving;
	}
	
	public Boolean getAfschrijving() {
		return afschrijving;
	}
	
	public Long getBedragInCenten() {
		return bedragInCenten;
	}
	
	public void setBedragInCenten(Long bedragInCenten) {
		this.bedragInCenten = bedragInCenten;
	}
	
	public String getMutatieSoort() {
		return mutatieSoort;
	}
	
	public void setMutatieSoort(String mutatieSoort) {
		this.mutatieSoort = mutatieSoort;
	}
}
