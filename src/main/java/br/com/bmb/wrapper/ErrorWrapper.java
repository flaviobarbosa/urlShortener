package br.com.bmb.wrapper;

public class ErrorWrapper {

	String alias;
	
	String err_code;
	
	String description;
	
	public ErrorWrapper(String alias, String err_code, String description) {
		super();
		this.alias = alias;
		this.err_code = err_code;
		this.description = description;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
