package mylib;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

// Intialize an SQL Date from a string with default format: yyyy-MM-dd
public class MySQLDate {
	private String dateFormat = "";
//	private String datetimeFormat = "";

	public MySQLDate() {
		this.dateFormat = "yyyy-MM-dd";
//		this.datetimeFormat = "yyyy-MM-dd HH:mm:ss";
	}

	public MySQLDate(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getDateFormat() {
		return this.dateFormat;
	}

	public void setDateFormat(String format) {
		this.dateFormat = format;
	}

	public Date getDateFrom(String dateString) {
		Date sqlDate = null;
		if (dateString == null || dateString == "") {
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(this.dateFormat);
		try {
			// date string -> util date (parse) -> sql date
			java.util.Date utilDate = formatter.parse(dateString);
			System.out.println("utilDate: " + utilDate);
			sqlDate = new Date(utilDate.getTime());
			System.out.println("sqlDate: " + sqlDate);
			
			return sqlDate;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sqlDate;
	}

	

}
