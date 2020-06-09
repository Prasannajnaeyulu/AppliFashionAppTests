package com.common.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Reporter {
    /**
     * A Helper to print the test result in the following format:
     * Task: <Task Number>, Test Name: <Test Name>, DOM Id:: <id>, Browser: <Browser>, Viewport: <Width x Height>, Device<Device type>, Status: <Pass | Fail>
     *
     * Example: Task: 1, Test Name: Search field is displayed, DOM Id: DIV__customsear__41, Browser: Chrome, Viewport: 1200 x 700, Device: Laptop, Status: Pass
     *
     * @param task                    int - 1, 2 or 3
     * @param testName                string - Something meaningful. E.g. 1.1 Search field is displayed
     * @param domId                   string - DOM ID of the element
     * @param comparisonResult        boolean - The result of comparing the "Expected" value and the "Actual" value.
     * @return			  boolean - returns the same comparison result back so that it can be used for further Assertions in the test code.
     */

    public boolean hackathonReporter(int task, String testName, String domId, String browser, String viewport, String device, boolean comparisonResult) {
        BufferedWriter writer=null;
        try{
             writer = new BufferedWriter(new FileWriter("Traditional-V2-TestResults.txt", true));
            writer.write("Task: " + task + ", Test Name: " + testName +", DOM Id: " + domId + ", Browser: " + browser
                    + ", Viewport: " + viewport + ", Device: " + device + ", Status: " + (comparisonResult ? "Pass" : "Fail"));
            writer.newLine();
        }catch(Exception e){
            System.out.println("Error writing to report file");
            e.printStackTrace();
        }
        finally {
            if(writer!=null) {
                try {
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //returns the result so that it can be used for further Assertions in the test code.
        return comparisonResult;
    }
}
