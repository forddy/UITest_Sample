package com.Company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class JobLink {
//    sets up the links from the home page and corresponding titles
//tech debt - move strings to local variables
//tech debt - reduce duplication
//tech debt - replace with link from home not URL

    static private String jobLink = "https://www.randstad.com/find-a-job/";
    static private String jobLinkTitle = "find a job | Randstad Holding";
    static private String jobResults = "";

    public void goToJobLink() {
        Browser.goTo(jobLink);
//        below locates the find a job link element in home page but it opens within page - fix later
//         Browser.driver.findElement(By.linkText("find a job")).click();
    }
    public boolean isAt() {
        return Browser.title().equals(jobLinkTitle);

    }

    public void searchJob() {
        WebElement jobBox = Browser.driver.findElement(By.id("ctl07_ctl05_ctl01_KeywordsTextBox"));
        jobBox.sendKeys("SDET");

        WebElement jobClick = Browser.driver.findElement(By.id("ctl07_ctl05_ctl01_SearchButton"));
        jobClick.click();

        WebElement jobResult = Browser.driver.findElement(By.id("ctl06_ctl05_NrOfJobsLabelTop"));
        jobResults = jobResult.getText();
        System.out.println("********************");
        System.out.println("");
        System.out.print("There are ");
        System.out.print(jobResults);
        System.out.println(" for SDET at Randstad");
        System.out.println("");
        System.out.println("********************");
    }
}