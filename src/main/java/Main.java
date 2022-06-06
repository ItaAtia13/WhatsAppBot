
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.text.ParseException;
import java.time.Duration;

import static java.lang.Character.isDigit;

public class Main extends JFrame {
    public Main() {
        //Panel p=new Panel(new FlowLayout(FlowLayout.LEADING));
        this.setTitle("Whatsapp-Bot");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);

        JButton btn = new JButton("Click here for login to your WhatsApp number");
        String specificUrl="https://api.whatsapp.com/send?phone=972";
          String whatsapp="https://web.whatsapp.com/";


        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        JLabel phoneLabel = new JLabel("Phone number:");
        TextField phoneField = new TextField(10);

        // phoneLabel.setBounds(50,100,200,200);
        JLabel messageLabel = new JLabel("Enter a Message:");
        TextField messageField = new TextField(10);
        // messageLabel.setBounds(50,150,200,200);


        // TODO: add placeholders
        this.add(phoneLabel);
        this.add(phoneField);
        this.add(messageLabel);
        this.add(messageField);
        this.add(btn);
        this.setVisible(true);

        //selenium
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\atia4\\Downloads\\chromedriver_win32\\chromedriver.exe");






        btn.addActionListener(e -> {
            if (phoneField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Phone field is empty ",
                        "Hey!", JOptionPane.ERROR_MESSAGE);
            } else if (!correctPhoneNumber(phoneField.getText())) {
                JOptionPane.showMessageDialog(null, "Invalid Phone number ",
                        "Hey!", JOptionPane.ERROR_MESSAGE);
            } else if (messageField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "massage field is empty ",
                        "Hey!", JOptionPane.ERROR_MESSAGE);
            } else if (e.getSource() == btn) {

                // configurations
                ChromeOptions chromeOptions=new ChromeOptions();
                chromeOptions.addArguments("user-data-dir=C:\\Users\\atia4\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
                ChromeDriver driver = new ChromeDriver(chromeOptions);

                //start private conversation with the number that was entered by the user
                driver.get(specificUrl+phoneField.getText().substring(1));
//                driver.get(whatsapp);

                driver.manage().window().maximize();

                while (true) {
//                    System.out.println("gfdg");
                    if (driver.findElements(By.className("_3ArsE")).size() == 1) {
                        System.out.println("Login successfully");
                        JOptionPane.showMessageDialog(null,"Login successfully");
                        JLabel successLabel = new JLabel("Login successfully");
                        this.add(successLabel);
                        this.setVisible(true);

//try
//                WebElement textField=driver.findElement(By.cssSelector("input[role=\"textbox\"]"));
//                        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(8));
//                        WebElement textField= wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_13NKt copyable-text selectable-text")));
                        WebElement textField=driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[2]"));
                        System.out.println("reader");
                        textField.sendKeys("ddd");
                        break;

                    }

                }



            }
        });

    }

    private boolean correctPhoneNumber(String phoneNumber) {
        boolean correct=false;
        boolean onlyNumbers = false;
        for (int j = 0; j < phoneNumber.length(); j++) {
            if (isDigit(phoneNumber.charAt(j))) {
                onlyNumbers = true;
            }
        }

        if (onlyNumbers) {
            if(phoneNumber.startsWith("05")&&phoneNumber.length()==10){
                correct=true;
            }
        }
        return correct;
    }

    public static void main(String[] args) throws ParseException {
        new Main();


//        if (topArticle!=null) {
//            topArticle.click();
//        }
//        if (searchTextField!=null){
//            searchTextField.sendKeys("Shai Givati");
//        }

    }
}