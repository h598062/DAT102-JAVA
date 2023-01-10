package øving1b.oppg1;

import java.util.Objects;

public class Student implements Comparable<Student>{
	private int studentnummer;
	private String fornavn;
	private String etternavn;
	private String studiested;

	public Student(int studentnummer, String fornavn, String etternavn, String studiested) {
		this.studentnummer = studentnummer;
		this.fornavn       = fornavn;
		this.etternavn     = etternavn;
		this.studiested    = studiested;
	}

	@Override
	public int compareTo(Student o) {
		/* if (this.equals(o)) {
			return 0;
		} else {
			return this.studentnummer > o.getStudentnummer() ? 1 : -1;
		} */

		if (this.etternavn.equals(o.getEtternavn())) {
			if (this.fornavn.equals(o.getFornavn())) {
				return 0;
			} else {
				return this.fornavn.compareTo(o.getFornavn());
			}
		} else {
			return this.etternavn.compareTo(o.getEtternavn());
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return studentnummer == student.studentnummer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentnummer);
	}

	@Override
	public String toString() {
		return "Student{" +
		       "studentnummer=" + studentnummer +
		       ", fornavn='" + fornavn + '\'' +
		       ", etternavn='" + etternavn + '\'' +
		       ", studiested='" + studiested + '\'' +
		       '}';
	}

	public int getStudentnummer() {
		return studentnummer;
	}

	public void setStudentnummer(int studentnummer) {
		this.studentnummer = studentnummer;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getStudiested() {
		return studiested;
	}

	public void setStudiested(String studiested) {
		this.studiested = studiested;
	}
}
