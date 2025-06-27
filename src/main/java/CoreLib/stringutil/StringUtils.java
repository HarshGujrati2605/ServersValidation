package CoreLib.stringutil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.RandomStringUtils;

import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;

public class StringUtils {

	public static String getName() {

		String name = RandomStringUtils.randomAlphabetic(8);
		return "AutomationName " + name;
	}
	
	

	public static String getEmail() {
		String name = RandomStringUtils.randomAlphabetic(10);
		return name + "@testautomation.com";
	}

	public static String randomPrgCodeGenerator() {
		return "prgcode" + RandomStringUtils.randomNumeric(6);
	}
	
	public static String randomProgramSequenceGenerator() {
		return RandomStringUtils.randomNumeric(6);
	}

	public static String randomProgramNamegenerator() {
		Faker faker = new Faker();
		String name = faker.educator().course();
		return name + RandomStringUtils.randomAlphabetic(8);
	}

	public static String randomCourseCodeGenerator() {
		return "Coursecode" + RandomStringUtils.randomNumeric(6);
	}

	@SuppressWarnings("deprecation")
	public static String randomCourseNamegenerator() {
		Faker faker = new Faker();
		String name = faker.educator().course();
		return name + RandomStringUtils.randomAlphabetic(6);
	}
	
	public static String randomPeriodNamegenerator() {
		return "period"+ RandomStringUtils.randomAlphabetic(9);

	}	
	
	public static String randomBatchGenerator() {
		Faker faker = new Faker();
		String name = faker.animal().name();
		return "batch"+ name + RandomStringUtils.randomAlphanumeric(4);

	}
	
	public static String randomApplicantLastname() {
		Faker faker = new Faker();
		String name = faker.name().lastName();
		return name + RandomStringUtils.randomAlphanumeric(5);
	}
	
	public static String todayDate() {
		 LocalDateTime now = LocalDateTime.now();     
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");     
	     String formattedDate = now.format(formatter);
	     System.out.println("Formatted Date: " + formattedDate);
		return formattedDate;
	}

}
