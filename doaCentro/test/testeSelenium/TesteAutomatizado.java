package testeSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TesteAutomatizado {
   
    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\karinaxavier\\Documents\\chromedriver.exe");
   
        driver.get("http:\\www.google.com.br");
        System.out.println(driver.getTitle());
        driver.quit();
 
        
    }
}
