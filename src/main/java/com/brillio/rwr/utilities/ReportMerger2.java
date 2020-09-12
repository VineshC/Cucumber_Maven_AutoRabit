package com.brillio.rwr.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

public class ReportMerger2 {
    private static String reportImageExtension = "png";

    public static void main(String[] args) throws InterruptedException  {
    	args[0] = "target/cucumber-parallel";
    	System.out.println("Input:: "+ args[0]);
        File reportDirectory = new File(args[0]);
        if (reportDirectory.exists()) {
        	
        	System.out.println("In report class");
            ReportMerger2 munger = new ReportMerger2();
            munger.mergeReports(reportDirectory);
            
           
      
        }
    }

    /**
     * Merge all reports together into master report in given reportDirectory
     * @param reportDirectory
     * @throws InterruptedException 
     * @throws Exception
     */
    public void mergeReports(File reportDirectory) throws InterruptedException  {
    	Thread.sleep(10000);
    	Collection<File> existingReports = FileUtils.listFiles(reportDirectory, new String[]{"json"}, true);
    	File reportOutputDirectory = new File("report");
    List<String> jsonFiles = new ArrayList<>();
    for (File report : existingReports) {
        //only address report files
    	jsonFiles.add(report.getPath());
        
    }

    String jenkinsBasePath = "";
    String buildNumber = "1";
    String projectName = "cucumberProject";
    boolean runWithJenkins = false;
    boolean parallelTesting = false;

    Configuration configuration = new Configuration(reportOutputDirectory, projectName);
    // optional configuration
    configuration.setParallelTesting(parallelTesting);
    configuration.setJenkinsBasePath(jenkinsBasePath);
    configuration.setRunWithJenkins(runWithJenkins);
    configuration.setBuildNumber(buildNumber);

    ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
    Reportable result = reportBuilder.generateReports();
    createBackupReport();
    
    
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
    
//    public void createBackupReport() {
//        
//    	String timeStamp =String.valueOf(new Date().getTime());
//        String sourceFile = new File("report\\cucumber-html-reports\\overview-features.html").getAbsolutePath();
//        String destinationFile = new File("report\\backup\\overview-features_"+timeStamp+".html").getAbsolutePath();
//        File source = new File(sourceFile);
//        File dest = new File("destinationFile");
//        try {
//        copyFiles(source, destinationFile);
//         sourceFile = new File("report\\cucumber-html-reports\\overview-failures.html").getAbsolutePath();
//         destinationFile = new File("report\\backup\\overview-failures_"+timeStamp+".html").getAbsolutePath();
//         source = new File(sourceFile);
//         copyFiles(source, destinationFile);
//         
//         sourceFile = new File("report\\cucumber-html-reports\\overview-steps.html").getAbsolutePath();
//         destinationFile = new File("report\\backup\\overview-steps_"+timeStamp+".html").getAbsolutePath();
//         source = new File(sourceFile);
//         copyFiles(source, destinationFile);
//         
//         sourceFile = new File("report\\cucumber-html-reports\\overview-tags.html").getAbsolutePath();
//         destinationFile = new File("report\\backup\\overview-tags_"+timeStamp+".html").getAbsolutePath();
//         source = new File(sourceFile);
//         copyFiles(source, destinationFile);
//        
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        
//        System.out.println("file copy done");
// }
//
// 
//
//        public static void copyFiles(File sourceLocation , String targetLocation) throws IOException {
//               
//                System.out.println("file copy started");
//               InputStream is = null;
//
//                OutputStream os = null;
//
//                try {
//
//                    is = new FileInputStream(sourceLocation);
//
//                    os = new FileOutputStream(targetLocation,false);
//
//                    byte[] buffer = new byte[1024];
//
//                    int length;
//
//                    while ((length = is.read(buffer)) > 0) {
//
//                        os.write(buffer, 0, length);
//
//                    }
//
//                }catch(Exception ex) {
//
//                    System.out.println("Unable to copy file:"+ex.getMessage());
//
//                }   
//
//                finally {
//
//                    try {
//
//                        is.close();
//
//                        os.close();
//
//                    }catch(Exception ex) {}
//
//                }
//
//            }

    public static void createBackupReport(){
        
        String timestamp = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss").format(new Date());
        String sourceFile = new File("report//cucumber-html-reports").getAbsolutePath();
        String destinationFile = new File("report//backup//report_"+ timestamp+"//").getAbsolutePath();
        
        File source = new File(sourceFile);
        File dest = new File(destinationFile);
        copyFolder(source, dest);
 }

 public static void copyFolder(File source, File destination)
        {
             if (source.isDirectory())
             {
                 if (!destination.exists())
                 {
                     destination.mkdirs();
                 }

                 String files[] = source.list();

                 for (String file : files)
                 {
                     File srcFile = new File(source, file);
                     File destFile = new File(destination, file);

                     copyFolder(srcFile, destFile);
                 }
             }
             else
             {
                 InputStream in = null;
                 OutputStream out = null;

                 try
                 {
                     in = new FileInputStream(source);
                     out = new FileOutputStream(destination,false);

                     byte[] buffer = new byte[1024];

                     int length;
                     while ((length = in.read(buffer)) > 0)
                     {
                         out.write(buffer, 0, length);
                     }
                 }
                 catch (Exception e)
                 {
                     try
                     {
                         in.close();
                     }
                     catch (IOException e1)
                     {
                         e1.printStackTrace();
                     }

                     try
                     {
                         out.close();
                     }
                     catch (IOException e1)
                     {
                         e1.printStackTrace();
                     }
                 }
             }
        }

        

}
