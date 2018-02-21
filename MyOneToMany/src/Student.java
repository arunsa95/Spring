import java.util.Set;

public class Student {
	private Long studentId;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	private String studentName;
	private Set studentPhoneNumbers;

	public Set getStudentPhoneNumbers() {
		return studentPhoneNumbers;
	}

	public void setStudentPhoneNumbers(Set studentPhoneNumbers) {
		this.studentPhoneNumbers = studentPhoneNumbers;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}
