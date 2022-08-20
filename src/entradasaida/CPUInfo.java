package entradasaida;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CPUInfo {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("/proc/cpuinfo"));
		Map<String, String> cpuInfo = new HashMap<>();
		
		while (in.hasNextLine()) {
			String line = in.nextLine();
			String[] fields = line.split(":");
			if (fields.length == 2) { // só considero as linhas com nome e valor
				String name = fields[0].trim();
				String value = fields[1].trim();
				cpuInfo.put(name, value);
			}
		}
		
		in.close();
		
		System.out.println("CPU: " + cpuInfo.get("model name"));
		System.out.println("Número de cores: " + cpuInfo.get("cpu cores"));
		
	}
}
