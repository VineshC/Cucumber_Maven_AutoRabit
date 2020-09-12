package com.brillio.rwr.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

public class ReportMerger {
    private static String reportFileName = "report.js";
    private static String reportImageExtension = "png";

    public static void main(String[] args) throws Throwable {
        File reportDirectory = new File(args[0]);
        if (reportDirectory.exists()) {
            ReportMerger munger = new ReportMerger();
            munger.mergeReports(reportDirectory);
/*            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String fileName ="D:\\New folder\\Brillio_Cucumber_D2_Framework\\report\\backup\\overview-features"+timestamp+".html";
            File source = new File("D:\\New folder\\Brillio_Cucumber_D2_Framework\\report\\cucumber-html-reports\\overview-features.html");
            File dest = new File(fileName);
        System.out.println("-------------------------------copy started--------------------");
            copyFileUsingStream(source, dest);
            FileUtils.copyFileToDirectory(source, dest);*/
        }
    }

    /**
     * Merge all reports together into master report in given reportDirectory
     * @param reportDirectory
     * @throws Exception
     */
    public void mergeReports(File reportDirectory) throws Throwable {
        Collection<File> existingReports = FileUtils.listFiles(reportDirectory, new String[]{"js"}, true);

        File mergedReport = null;

        for (File report : existingReports) {
            //only address report files
            if (report.getName().equals(reportFileName)) {
                //rename all the image files (to give unique names) in report directory and update report
                renameEmbededImages(report);

                //if we are on the first pass, copy the directory of the file to use as basis for merge
                if (mergedReport == null) {
                    FileUtils.copyDirectory(report.getParentFile(), reportDirectory);
                    mergedReport = new File(reportDirectory, reportFileName);
                //otherwise merge this report into existing master report
                } else {
                    mergeFiles(mergedReport, report);
                }
            }
        }
    }

    /**
     * merge source file into target
     *
     * @param target
     * @param source
     */
    public void mergeFiles(File target, File source) throws Throwable {
        //copy embeded images
        Collection<File> embeddedImages = FileUtils.listFiles(source.getParentFile(), new String[]{reportImageExtension}, true);
        for (File image : embeddedImages) {
            FileUtils.copyFileToDirectory(image, target.getParentFile());
        }

        //merge report files
        String targetReport = FileUtils.readFileToString(target);
        String sourceReport = FileUtils.readFileToString(source);

        FileUtils.writeStringToFile(target, targetReport + sourceReport);
    }

    /**
     * Give unique names to embedded images to ensure they aren't lost during merge
     * Update report file to reflect new image names
     *
     * @param reportFile
     */
    public void renameEmbededImages(File reportFile) throws Throwable {
        File reportDirectory = reportFile.getParentFile();
        Collection<File> embeddedImages = FileUtils.listFiles(reportDirectory, new String[]{reportImageExtension}, true);

        String fileAsString = FileUtils.readFileToString(reportFile);

        for (File image : embeddedImages) {
            String curImageName = image.getName();
            String uniqueImageName = UUID.randomUUID().toString() + "." + reportImageExtension;

            image.renameTo(new File(reportDirectory, uniqueImageName));
            fileAsString = fileAsString.replace(curImageName, uniqueImageName);
        }

        FileUtils.writeStringToFile(reportFile, fileAsString);
    }
    
    
    
  /*  private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }*/
}






















