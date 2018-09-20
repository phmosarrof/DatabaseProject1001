package dataBaseC;

import java.sql.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class DataBaseConnections {

	public static void main(String[] args) {

		String host = "Localhost";
		String port = "3306";

		Connection con = DriverManager.getConnection("url", "user", "password");

		Statement s=con.createStatement();

		ResultSet rs=s.executeQuery("select * from credentials where scenario ='rewardscard'");

		while(rs.next())

		{

			WebDriver driver= new FirefoxDriver();

			driver.get("https://login.salesforce.com");

			driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("username"));

			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("password"));

		}

	}

}
