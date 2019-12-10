package qwe; 
import java.awt.BorderLayout; 
import java.awt.Color; 
import java.awt.GridLayout; 
import java.awt.LayoutManager; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.KeyAdapter; 
import java.awt.event.KeyEvent; 
import javax.swing.BoxLayout; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane; 
import javax.swing.JPanel; 
import javax.swing.JTextField; 

public class calculator extends JFrame { 
/** 
* 
*/ 
private static final long serialVersionUID = 1L; 
float result; 
JButton buttonResult = new JButton("Результат"); 

public calculator() { 
buttonResult.setEnabled(false); 
add(buttonResult, BorderLayout.NORTH); //Добавляем кнопку суммы и указываем ее расположение 
JPanel radioPanel = new JPanel(new GridLayout(5, 1)); // Определяем расположение элементов 
radioPanel.setBackground(Color.pink); //Устанавливаем цвет панелей 
radioPanel.setLayout((LayoutManager) new BoxLayout(radioPanel, BoxLayout.Y_AXIS)); // Указываем расположение строк 
setBounds(250, 250, 250, 250); //Определяем размер окна 
add(radioPanel, BorderLayout.CENTER);// Указываем расположение строк 
final JTextField month = new JTextField(); //Объявляем поля ввода 
final JTextField stavka = new JTextField(); //Объявляем поля ввода 
final JTextField sum = new JTextField(); //Объявляем поля ввода 

JLabel monthtext = new JLabel("количество месяцев:"); // Задаем название строк 
JLabel stavkatext = new JLabel("ставка по кредиту(%):"); // Задаем название строк 
JLabel sumtext = new JLabel("сумма кредита:"); // Задаем название строк 
//Добавляем текстовые строки и поля для ввода 
radioPanel.add(monthtext); 
radioPanel.add(month); 
radioPanel.add(stavkatext); 
radioPanel.add(stavka); 
radioPanel.add(sumtext); 
radioPanel.add(sum); 

month.addKeyListener(new KeyAdapter() { //Добавляем слушателя на поле для ввода 
public void keyTyped(KeyEvent e) { 
char c = e.getKeyChar(); 
if ( ((c < '0') || (c > '9'))) { 
e.consume(); // Игнорим введенные буквы и пробел 
} 
if (month.getText().length() >= 2){ 
JOptionPane.showMessageDialog(null, "Максимальное кол-во символов 2", "Неправильный ввод",JOptionPane.WARNING_MESSAGE ); 
} //Не даем пользователю вводить больше 2 символов в строку 
} 
}); 
stavka.addKeyListener(new KeyAdapter() { 
public void keyTyped(KeyEvent e) { 
char c = e.getKeyChar(); 
if ( ((c < '0') || (c > '9'))) { 
e.consume(); // Игнорируем введенные буквы и пробел 
} 
if (stavka.getText().length() >= 2){ 
JOptionPane.showMessageDialog(null, "Максимальное кол-во символов 2", "Неправильный ввод",JOptionPane.WARNING_MESSAGE ); 
} //Не даем пользователю вводить больше 2 символов в строку 
} 
}); 
sum.addKeyListener(new KeyAdapter() { 
public void keyTyped(KeyEvent e) { 
char c = e.getKeyChar(); 
if ( ((c < '0') || (c > '9'))) { 
e.consume(); // Игнорируем введенные буквы и пробел 
} 

} 
}); 

JButton calculate = new JButton("РАСЧЕТ"); 
calculate.setBackground(new Color(255, 0, 255)); //Задаем цвет кнопки 
calculate.addActionListener(new ActionListener() { //Добавляем слушателя на кнопку 
public void actionPerformed(ActionEvent e) { 
Float s = Float.parseFloat((sum.getText())); //Преобразовываем введенные в поле значения в тип данных float 
Float t = Float.parseFloat((stavka.getText())); //Преобразовываем введенные в поле значения в тип данных float 
Float m = Float.parseFloat((month.getText())); //Преобразовываем введенные в поле значения в тип данных float 
float result= Result(s,t,m); //Передаем данные в метод для вычисления 
buttonResult.setText(Float.toString(result)); 
} 
}); 

buttonResult.setBackground(new Color(255, 255, 255)); //Устанавливаем цвет панели 
radioPanel.add(calculate); 
setVisible(true); //Делаем окно видимым 
} 

public float Result(float sum,float stavka,float month) { //Задаем переменные и метод 
float result = (sum/month)+((sum/month)*(stavka/100)); //Формула подсчета
return result; //Возвращаем значение 
} 

public static void main(String[] args) { 
new calculator(); 
} 

//Переводим в формат вида string 
private static String format(int i) { 
String result = String.valueOf(i); 
if (result.length() == 1) { 
result = "0" + result; 
} 
return result; //Возвращаем значение 
} 

}
