package mylib;

import java.sql.Date;
import java.text.SimpleDateFormat;

// Intialize an SQL Date from a string with default format: yyyy-MM-dd
public class MySQLDate {
	private String dateFormat = "";

	public MySQLDate() {
		this.dateFormat = "yyyy-MM-dd";
	}
	
	public MySQLDate(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getDateFormat() {
		return this.dateFormat;
	}

	public Date getDateFrom(String dateString) {
		Date sqlDate = null;
		if(dateString == null || dateString == "") {
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(this.dateFormat);
		try {
			// date string -> util date (parse) -> sql date
			java.util.Date utilDate = formatter.parse(dateString);
			sqlDate = new Date(utilDate.getTime());

			return sqlDate;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sqlDate;
	}

}
