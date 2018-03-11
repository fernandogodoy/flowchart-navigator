package br.fsg.flowchart;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import br.fsg.flowchart.lucidchart.LucidchartNavigable;
import br.fsg.flowchart.lucidchart.LucidchartReader;
import br.fsg.flowchart.lucidchart.YesNo;
import br.fsg.flowchart.spec.FlowchartNavigable;
import br.fsg.flowchart.spec.FlowchartReader;

/**
 * 
 * @author Godoy
 *
 */
public class App {

	private static final String PROPERTIES_FILE = "config.properties";
	private final Properties properties = readProperties();

	public static void main(String[] args) {
		App app = new App();
		String filePath = app.properties.getProperty("filePath");
		FlowchartReader reader = new LucidchartReader(Paths.get(filePath));
		FlowchartNavigable navigable = new LucidchartNavigable(reader.build());
		navigable.start();

		System.out.println(" **** " + navigable.getCurrent().getText() + " **** ");

		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				navigable.next();
				System.out.println(navigable.getCurrent().getText());
				String option = sc.nextLine();
				navigable.selectOption(YesNo.toObject(option));

				System.out.println(navigable.getCurrent().getText());
				if (navigable.getCurrent().isFinal()) {
					break;
				}
				System.out.println(StringUtils.LF);
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getCause());
		}

	}

	public Properties readProperties() {
		try (FileInputStream inputStream = new FileInputStream(Paths.get(PROPERTIES_FILE).toFile())) {
			Properties properties = new Properties();
			properties.load(inputStream);
			return properties;
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}
