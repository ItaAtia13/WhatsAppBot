
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class Main extends JFrame {
    public static void main(String[] args) throws ParseException {
        //frame
        JFrame frame = new JFrame("Whatsapp-Bot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));



        JButton btn=new JButton("click");
        JLabel phoneLabel=new JLabel("Phone number:");
        JLabel messageLabel=new JLabel("Enter a Message:");


        // TODO: add placeholders
        frame.add(phoneLabel);
        frame.add(new TextField(10));
        frame.add(messageLabel);
        frame.add(new TextField(10));
        frame.add(btn);
        frame.setVisible(true);

        //selenium
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\atia4\\Downloads\\chromedriver_win32\\chromedriver.exe");


        btn.addActionListener(e -> {
            if(e.getSource() == btn) {
                ChromeDriver driver = new ChromeDriver();
               driver.get("https://web.whatsapp.com/");
                driver.manage().window().maximize();
                while  (true){
                if (driver.findElements(By.className("_3ArsE")).size()==1) {
                    System.out.println("Login successfully");
                    JLabel successLabel=new JLabel("Login successfully");
                    frame.add(successLabel);
                    frame.setVisible(true);

                    break;

                }
                }


            }
        });



//        if (topArticle!=null) {
//            topArticle.click();
//        }
//        WebElement searchTextField=driver.findElement(By.id("one-search"));
//        if (searchTextField!=null){
//            searchTextField.sendKeys("Shai Givati");
//        }

    }
}
