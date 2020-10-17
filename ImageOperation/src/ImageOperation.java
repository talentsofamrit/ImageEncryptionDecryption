import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ImageOperation {
public static void operate(int key){
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.showOpenDialog(null);
    File file = fileChooser.getSelectedFile();
    //Reading from file
    try{
        FileInputStream fis = new FileInputStream(file);
         byte[] data = new byte[fis.available()];//image converted to bytes
         fis.read(data);
         int i=0;
         for(byte b:data)
         {
             System.out.println(b);
             data[i]= (byte)(b^key);  // encrypting using XOR
             i++;
         }
         //Writing data back to file
        FileOutputStream  fos = new FileOutputStream(file);
         fos.write(data);
         fos.close();
         fis.close();
         JOptionPane.showMessageDialog(null,"Done");
    }catch(Exception e)
    {
        e.printStackTrace();
    }
}
    public static void main(String[]  args){
        JFrame f = new JFrame();
        f.setTitle("Image operation ");
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font = new Font("Roboto",Font.BOLD,25);
        //Button
        JButton button = new JButton();
        button.setText("Open Image");
        button.setFont(font);
        //Text field
        JTextField textField = new JTextField(10);
        textField.setFont(font);

        //ActionListner(is interface), anonymous class therefore using lambda funtion
        button.addActionListener(e->{
            String text = textField.getText();
            int temp = Integer.parseInt(text);
            operate(temp);
        });

        f.setLayout(new FlowLayout());

        f.add(button);
        f.add(textField);
        f.setVisible(true);
    }
}
