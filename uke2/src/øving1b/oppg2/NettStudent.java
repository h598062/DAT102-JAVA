package øving1b.oppg2;

import øving1b.oppg1.Student;

public class NettStudent extends Student {
	private String hjemsted;
	public NettStudent(int studentnummer, String fornavn, String etternavn, String studiested, String hjemsted) {
		super(studentnummer, fornavn, etternavn, studiested);
		this.hjemsted = hjemsted;
	}

	@Override
	public String toString() {
		return "NettStudent{" +
		       "hjemsted='" + hjemsted + '\'' +
		       "} " + super.toString();
	}

	public String getHjemsted() {
		return hjemsted;
	}

	public void setHjemsted(String hjemsted) {
		this.hjemsted = hjemsted;
	}
}
