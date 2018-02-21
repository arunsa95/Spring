/**
 * 
 */
package cg;

/**
 * @author aruravic
 *
 */
public class SomeService {
	private String administrator;
	private String support;
	private String development;

	public SomeService() {
		// TODO Auto-generated constructor stub
	}

	public String getAdministrator() {
		return administrator;
	}

	public void setAdministrator(String administrator) {
		this.administrator = administrator;
	}

	public String getSupport() {
		return support;
	}

	public void setSupport(String support) {
		this.support = support;
	}

	public String getDevelopment() {
		return development;
	}

	public void setDevelopment(String development) {
		this.development = development;
	}

	@Override
	public String toString() {
		return "SomeService [administrator=" + administrator + ", support="
				+ support + ", development=" + development + "]";
	}

}
