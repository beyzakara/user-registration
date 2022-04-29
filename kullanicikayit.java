
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


	public class kullanicikayit extends JFrame {
	    private static final long serialVersionUID = 1L;
	    private JPanel contentPane;
	    private JTextField ad;
	    private JTextField soyad;
	    private JTextField email;
	    private JTextField kullanýcýadi;
	    private JTextField tel;
	    private JPasswordField sifre;
	    private JButton btnNewButton;

	 
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    kullanicikayit frame = new kullanicikayit();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	   

	    public kullanicikayit() {
	        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(450, 190, 1014, 597);
	        setResizable(false);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JLabel lblNewUserRegister = new JLabel("Yeni Kullanýcý");
	        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
	        lblNewUserRegister.setBounds(362, 52, 325, 50);
	        contentPane.add(lblNewUserRegister);

	        JLabel lblName = new JLabel("Ýsim");
	        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblName.setBounds(58, 152, 99, 43);
	        contentPane.add(lblName);

	        JLabel lblNewLabel = new JLabel("Soyisim");
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblNewLabel.setBounds(58, 243, 110, 29);
	        contentPane.add(lblNewLabel);

	        JLabel lblEmailAddress = new JLabel("Email\r\n adres");
	        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblEmailAddress.setBounds(58, 324, 124, 36);
	        contentPane.add(lblEmailAddress);

	        ad = new JTextField();
	        ad.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        ad.setBounds(214, 151, 228, 50);
	        contentPane.add(ad);
	        ad.setColumns(10);

	        soyad = new JTextField();
	        soyad.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        soyad.setBounds(214, 235, 228, 50);
	        contentPane.add(soyad);
	        soyad.setColumns(10);

	        email = new JTextField();

	        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        email.setBounds(214, 320, 228, 50);
	        contentPane.add(email);
	        email.setColumns(10);

	        kullanýcýadi = new JTextField();
	        kullanýcýadi.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        kullanýcýadi.setBounds(707, 151, 228, 50);
	        contentPane.add(kullanýcýadi);
	        kullanýcýadi.setColumns(10);

	        JLabel lblUsername = new JLabel("Nick");
	        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblUsername.setBounds(542, 159, 99, 29);
	        contentPane.add(lblUsername);

	        JLabel lblPassword = new JLabel("Þifre");
	        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblPassword.setBounds(542, 245, 99, 24);
	        contentPane.add(lblPassword);

	        JLabel lblMobileNumber = new JLabel("Tel No");
	        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblMobileNumber.setBounds(542, 329, 139, 26);
	        contentPane.add(lblMobileNumber);

	        tel = new JTextField();
	        tel.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        tel.setBounds(707, 320, 228, 50);
	        contentPane.add(tel);
	        tel.setColumns(10);

	        sifre = new JPasswordField();
	        sifre.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        sifre.setBounds(707, 235, 228, 50);
	        contentPane.add(sifre);

	        btnNewButton = new JButton("Kayýt");
	        btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String isim = ad.getText();
	                String soyisim = soyad.getText();
	                String emailId = email.getText();
	                String nickname = kullanýcýadi.getText();
	                String mobilno = tel.getText();
	                int len = mobilno.length();
	                String parola = sifre.getText();

	                String msg = "" + isim;
	                msg += " \n";
	                if (len != 11) {
	                    JOptionPane.showMessageDialog(btnNewButton, "11 haneli numaranýzý giriniz.");
	                }

	                try {
	                	String url = "jdbc:sqlite:C://sqlitedb/kullanicikaydi.db";
	                    Connection connection = DriverManager.getConnection(url);
	                    System.out.println("veritabanýna baðlandý");

	                    String query = "INSERT INTO account values('" + isim + "','" + soyisim + "','" + nickname + "','" +
	                        parola + "','" + emailId + "','" + mobilno + "')";

	                    Statement sta = connection.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(btnNewButton, "Kullanýcý kayýtlýdýr");
	                    } else {
	                        JOptionPane.showMessageDialog(btnNewButton,
	                            "Hoþgeldiniz, " + msg + "Baþarýyla kaydedildi");
	                    }
	                    connection.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
	            }
	        });
	        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
	        btnNewButton.setBounds(399, 447, 259, 74);
	        contentPane.add(btnNewButton);
	    }
	}

