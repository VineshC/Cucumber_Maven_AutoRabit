package com.brillio.rwr.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CucumberRunner {
	static String sourceDir = "src\\test\\resources\\featurefiles";
	static String destinationDir = "files";
	static File sourceFolder = new File(sourceDir);
	static File destinationFolder = new File(destinationDir);

	public static void main(String[] args) throws IOException {
		CucumberRunner obj = new CucumberRunner();
		if (args.length == 0) {
			System.out.println("No feature file name specified so executing all feature file");
			obj.copyAllFiles();
			System.out.println("All feature files copied to destination folder");
		} else {
			System.out.println("Executing " + args[0] + " Feature files");
			File[] files = sourceFolder.listFiles();
			if (!destinationFolder.exists()) {
				destinationFolder.mkdir();
			} else if (destinationFolder.list().length > 0) {
				FileUtils.cleanDirectory(destinationFolder);
			}
			for (File file : files) {
				if (args[0].contains(file.getName())) {
					FileUtils.copyFileToDirectory(file, destinationFolder);
					System.out.println(file.getName() + " Copying to destination folder");
				}
			}
		}
	}

	public void copyAllFiles() throws IOException {
		if (!destinationFolder.exists()) {
			destinationFolder.mkdir();
		} else if (destinationFolder.list().length > 0) {
			FileUtils.cleanDirectory(destinationFolder);
		}
		try {
			FileUtils.copyDirectory(sourceFolder, destinationFolder);
		} catch (IOException e) {
			throw e;
		}

	}

}
