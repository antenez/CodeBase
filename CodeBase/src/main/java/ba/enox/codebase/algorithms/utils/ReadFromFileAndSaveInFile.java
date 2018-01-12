package ba.enox.codebase.algorithms.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author eno.ahmedspahic Dictionary Java simple working case
 */
public class ReadFromFileAndSaveInFile {

	public static String DICTIONARY_SEPARATOR = "_";

	public static void main(String[] args) throws IOException {

		// read file and prepare dictionary
		String sourceFilePath = "C:\\Users\\eno.ahmedspahic\\Desktop\\DPDPrepare\\configCodes.txt";
		String targetFileName = "C:\\Users\\eno.ahmedspahic\\Desktop\\DPDPrepare\\targetFile.dpd";
		List<ConfigurationHolder> dictionary = new ArrayList<ConfigurationHolder>();

		FileReader fileReader = null;
		FileWriter fileWriter = new FileWriter(targetFileName);
		PrintWriter printWriter = new PrintWriter(fileWriter);

		try {
			fileReader = new FileReader(sourceFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedReader reader = new BufferedReader(fileReader);
		System.out.println("++++++++++++READiNG LINES++++++++++++");
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				// question2
				System.out.println(
						"+++ new line Line template is XX_XX   minimum and XX_XX_XX_YYYY_YYY where only XXX would be processed: "
								+ line);
				String scanCode = "";
				String pcode = "";
				String infoText = "";
				String location = "";
				scanCode = line.substring(0, line.indexOf(DICTIONARY_SEPARATOR));
				line = line.substring(line.indexOf(DICTIONARY_SEPARATOR) + 1);
				try {
					pcode = line.substring(0, line.indexOf(DICTIONARY_SEPARATOR));
					line = line.substring(line.indexOf(DICTIONARY_SEPARATOR) + 1);
				} catch (StringIndexOutOfBoundsException e) {
					e.printStackTrace();
					line = "";
				}

				try {
					location = line.substring(0, line.indexOf(DICTIONARY_SEPARATOR));
					line = line.substring(line.indexOf(DICTIONARY_SEPARATOR) + 1);
				} catch (StringIndexOutOfBoundsException e) {
					e.printStackTrace();
					line = "";
				}
				try {
					infoText = line.substring(0);
				} catch (StringIndexOutOfBoundsException e) {
					e.printStackTrace();
					line = "";
				}

				ConfigurationHolder cfh = new ConfigurationHolder(scanCode, pcode, location,infoText);
				dictionary.add(cfh);

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("+++IOE can not read file");
			e.printStackTrace();
			throw e;
		}

		
		printWriter.println("PARCELNO;SCAN_CODE;DEPOT_CODE;DEPOTNAME;EVENT_DATE_TIME;ROUTE;TOUR;PCODE;SERVICE;CONSIGNEE_COUNTRY_CODE;CONSIGNEE_ZIP;ADD_SERVICE_1;ADD_SERVICE_2;ADD_SERVICE_3;WEIGHT;CUSTOMER_REFERENCE;POD_IMAGE_REF;RECEIVER_NAME;INFO_TEXT;LOCATION;");
		// go trough dictionary
		Iterator<ConfigurationHolder> iterator = dictionary.iterator();
		while (iterator.hasNext()) {
			ConfigurationHolder currentValue = iterator.next();
			// printWriter.print("Some String");
			// printWriter.printf("Product name is %s and its price is %d $",
			// "iPhone", 1000);
			printWriter.printf("01645300186059;%s;0998;Depot 0998;20160419101930;0000;;01;%s;000;;%s;;;;80000110;;;%s;;\n",
					currentValue.getpCode(),
					currentValue.getService().equals("0") ? 101
							: currentValue.getService().equals("1") ? 300 : "OtherwiseFILLThis",
					currentValue.getLocation(), currentValue.getInfoText());
		}

		printWriter.close();
	}

	private static class ConfigurationHolder {
		public ConfigurationHolder(String service, String pCode, String location, String infoText) {
			super();
			this.service = service;
			this.pCode = pCode;
			this.location = location;
			this.infoText=infoText;
		}

		public String getInfoText() {
			return infoText;
		}

		public void setInfoText(String infoText) {
			this.infoText = infoText;
		}

		public String getService() {
			return service;
		}

		public void setService(String service) {
			this.service = service;
		}

		public String getpCode() {
			return pCode;
		}

		public void setpCode(String pCode) {
			this.pCode = pCode;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		String service = "";
		String pCode = "";
		String location = "";
		String infoText = "";

	}
}
