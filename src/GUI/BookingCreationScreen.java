package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Parking.*;
import Users.*;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JTextField;
import App.System1;

public class BookingCreationScreen extends JFrame {

	private JPanel contentPane;
	private static BookingCreationScreen frame = new BookingCreationScreen();
	private JTextField textField_LotNumber;
	private JTextField textField_SpaceNumber;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookingCreationScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Your Booking");
		lblNewLabel.setFont(new Font("KufiStandardGK", Font.PLAIN, 18));
		lblNewLabel.setBounds(136, 6, 181, 35);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(365, 219, 79, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Start Date:");
		lblNewLabel_1.setBounds(6, 77, 109, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter End Date:");
		lblNewLabel_2.setBounds(6, 139, 109, 16);
		contentPane.add(lblNewLabel_2);
		
		Integer[] months = new Integer[12];
		for (int i=1; i<13; i++) {
			months[i-1] = i;
		}
		JComboBox<Integer> comboBoxStartMonth = new JComboBox<Integer>(months);
		comboBoxStartMonth.setBounds(192, 53, 71, 27);
		contentPane.add(comboBoxStartMonth);
		
		JLabel lblNewLabel_3 = new JLabel("Hour:");
		lblNewLabel_3.setBounds(136, 96, 44, 16);
		contentPane.add(lblNewLabel_3);
		
		Integer[] hours = new Integer[24];
		for (int i=0; i<24; i++) {
			hours[i] = i;
		}
		JComboBox<Integer> comboBoxStartHour = new JComboBox<Integer>(hours);
		comboBoxStartHour.setBounds(192, 92, 71, 27);
		contentPane.add(comboBoxStartHour);
		
		JLabel lblNewLabel_4 = new JLabel("Minute:");
		lblNewLabel_4.setBounds(275, 96, 50, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Month:");
		lblNewLabel_5.setBounds(136, 57, 44, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Day:");
		lblNewLabel_6.setBounds(292, 57, 33, 16);
		contentPane.add(lblNewLabel_6);
		
		Integer[] days = new Integer[31];
		for (int i=1; i<32; i++) {
			days[i-1] = i;
		}
		JComboBox<Integer> comboBoxStartDay = new JComboBox<Integer>(days);
		comboBoxStartDay.setBounds(338, 53, 71, 27);
		contentPane.add(comboBoxStartDay);
		
		Integer[] minutes = new Integer[60];
		for (int i=0; i<60; i++) {
			minutes[i] = i;
		}
		JComboBox<Integer> comboBoxStartMinute = new JComboBox<Integer>(minutes);
		comboBoxStartMinute.setBounds(337, 92, 72, 27);
		contentPane.add(comboBoxStartMinute);
		
		JLabel lblNewLabel_5_1 = new JLabel("Month:");
		lblNewLabel_5_1.setBounds(136, 139, 44, 16);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Day:");
		lblNewLabel_6_1.setBounds(292, 139, 33, 16);
		contentPane.add(lblNewLabel_6_1);
		
		JComboBox<Integer> comboBoxEndMonth = new JComboBox<Integer>(months);
		comboBoxEndMonth.setBounds(192, 135, 71, 27);
		contentPane.add(comboBoxEndMonth);
		
		JComboBox<Integer> comboBoxEndDay = new JComboBox<Integer>(days);
		comboBoxEndDay.setBounds(338, 135, 71, 27);
		contentPane.add(comboBoxEndDay);
		
		JComboBox<Integer> comboBoxEndHour = new JComboBox<Integer>(hours);
		comboBoxEndHour.setBounds(192, 174, 71, 27);
		contentPane.add(comboBoxEndHour);
		
		JComboBox<Integer> comboBoxEndMinute = new JComboBox<Integer>(minutes);
		comboBoxEndMinute.setBounds(338, 174, 71, 27);
		contentPane.add(comboBoxEndMinute);
		
		JLabel lblNewLabel_3_1 = new JLabel("Hour:");
		lblNewLabel_3_1.setBounds(136, 178, 44, 16);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Minute:");
		lblNewLabel_4_1.setBounds(275, 178, 50, 16);
		contentPane.add(lblNewLabel_4_1);
		
		JButton btnCreateBooking = new JButton("Create Booking");
		btnCreateBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Create starting date
				Calendar calStart = Calendar.getInstance();
				int startHour = (int) comboBoxStartHour.getSelectedItem();
				int startDay = (int) comboBoxStartDay.getSelectedItem() - 1;
				int startMonth = (int) comboBoxStartMonth.getSelectedItem() - 1;
				int startMinute = (int) comboBoxStartMinute.getSelectedItem();
				calStart.set(Calendar.YEAR, 2023);
				calStart.set(Calendar.MONTH, startMonth);
				calStart.set(Calendar.MINUTE, startMinute);
				calStart.set(Calendar.HOUR, startHour);
				calStart.set(Calendar.DAY_OF_MONTH, startDay);
				Date startDate = calStart.getTime();
				
				//Create ending date
				Calendar calEnd = Calendar.getInstance();
				int endHour = (int) comboBoxEndHour.getSelectedItem();
				int endDay = (int) comboBoxEndDay.getSelectedItem() - 1;
				int endMonth = (int) comboBoxEndMonth.getSelectedItem() - 1;
				int endMinute = (int) comboBoxEndMinute.getSelectedItem();
				calEnd.set(Calendar.YEAR, 2023);
				calEnd.set(Calendar.MONTH, endMonth);
				calEnd.set(Calendar.MINUTE, endMinute);
				calEnd.set(Calendar.HOUR, endHour);
				calEnd.set(Calendar.DAY_OF_MONTH, endDay);
				Date endDate = calEnd.getTime();
				
				//Get Parking Space
				int spaceNum = Integer.parseInt(textField_SpaceNumber.getText());
				int lotNum = Integer.parseInt(textField_LotNumber.getText());
				String licensePlate = textField.getText();
				
				//Create Booking
				Client client = (Client) System1.currentUser;
				if(client.bookSpace(startDate, endDate, lotNum, spaceNum, licensePlate)) {
					textField_LotNumber.setText("");
					textField_SpaceNumber.setText("");
					BookingConfirmedScreen bcs = BookingConfirmedScreen.getInstance();
					bcs.setVisible(true);
					frame.setVisible(false);
				}
				else {
					textField_LotNumber.setText("");
					textField_SpaceNumber.setText("");
					bookingErrorScreen bes = bookingErrorScreen.getInstance();
					bes.setVisible(true);
					frame.setVisible(false);
				}
				
			}
		});
		btnCreateBooking.setBounds(165, 249, 125, 29);
		contentPane.add(btnCreateBooking);
		
		JLabel lblNewLabel_7 = new JLabel("Lot NO.");
		lblNewLabel_7.setBounds(6, 224, 50, 16);
		contentPane.add(lblNewLabel_7);
		
		textField_LotNumber = new JTextField();
		textField_LotNumber.setBounds(58, 219, 44, 26);
		contentPane.add(textField_LotNumber);
		textField_LotNumber.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Parking Space NO.");
		lblNewLabel_8.setBounds(114, 224, 115, 16);
		contentPane.add(lblNewLabel_8);
		
		textField_SpaceNumber = new JTextField();
		textField_SpaceNumber.setBounds(230, 219, 44, 26);
		contentPane.add(textField_SpaceNumber);
		textField_SpaceNumber.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_LotNumber.setText("");
				textField_SpaceNumber.setText("");
				SignUpConfirmed suc = SignUpConfirmed.getInstance();
				suc.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(32, 9, 83, 29);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_9 = new JLabel("License Plate");
		lblNewLabel_9.setBounds(283, 224, 83, 16);
		contentPane.add(lblNewLabel_9);
		
	}
	
	public static BookingCreationScreen getInstance() {
		return frame;
	}
}
