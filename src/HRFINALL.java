import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
 
import javax.swing.*;
import javax.swing.border.EmptyBorder;
 
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Dimension;
 
public class HRFINALL extends JPanel implements ActionListener {
 
        boolean isDirty = false;
 
        static JFrame frame;
 
        private JPanel cardHolder;
 
        static ArrayList<Employee> emps;
 
        JScrollPane scroll;
 
        protected JButton save, quit;
        ArrayList<String> everything = new ArrayList<String>();
        JTextArea output;
        JScrollPane scrollPane;
        private JPanel choicePanel;
        private JButton Overview;
        private JButton ViewProfile;
        private JButton ViewCharacter;
        private JButton SortCharacter;
        private JButton Add;
        private JButton Edit;
        private JButton Delete;
        private JLabel HumanResourcesEmployee;
        private static JTextArea display;
        private JPanel mainPanel;
        private JPanel addProfile;
        private JPanel inputPanel;
        private JTextField firstName;
        private JTextField lastName;
        private JTextField age;
        private JTextField education;
        private JTextField SIN;
        private JTextField empNum;
        private JTextField address;
        private JPanel labelPanel;
        private JLabel lblFirstName;
        private JTextField DoB;
        private JTextField phoneNumber;
        private JTextField eMail;
        private JTextField salary;
        private JTextField department;
        private JPanel radioButtonPanel;
        private JRadioButton male;
        private JRadioButton female;
        private JRadioButton active;
        private JRadioButton inActive;
        private JRadioButton married;
        private JRadioButton notMarried;
        private JRadioButton crimRecYes;
        private JRadioButton crimRecNo;
        private final ButtonGroup sex = new ButtonGroup();
        private final ButtonGroup empActive = new ButtonGroup();
        private final ButtonGroup crimRec = new ButtonGroup();
        private final ButtonGroup marriage = new ButtonGroup();
        private JTextField vacDays;
        private JTextField sicDays;
        private JTextField hoursWorked;
        private JLabel lblLastName;
        private JLabel lblPhoneNumber;
        private JLabel lblAge;
        private JLabel lblEducation;
        private JLabel lblSIN;
        private JLabel lblEmpNum;
        private JLabel lblAddress;
        private JLabel lblDoB;
        private JLabel lblEmail;
        private JLabel lblDepartment;
        private JLabel lblSalary;
        private JLabel lblHoursWorked;
        private JLabel lblVacDays;
        private JLabel lblSicDays;
        private JPanel labelPanel2;
        private JLabel lblSex;
        private JLabel lblEmployeeActivity;
        private JLabel lblMarriageStatus;
        private JLabel lblNewLabel;
        private JLabel lblNewEmployeeProfile;
        private JPanel eastPanel;
        private JPanel labelAndRadioButtonPanel;
        private JPanel panel;
        private JButton btnCancel;
        private JButton btnFinish;
 
        public HRFINALL() {
                super(new CardLayout());
                setPreferredSize(new Dimension(715, 425));
                setBorder(BorderFactory.createEmptyBorder(10, 40, 40, 40));
 
                cardHolder = new JPanel();
                add(cardHolder, "name_7101454952680");
                cardHolder.setLayout(new CardLayout(0, 0));
 
                mainPanel = new JPanel(new BorderLayout());
                cardHolder.add(mainPanel, "mainPanel");
 
                save = new JButton("Save");
                save.setActionCommand("save");
 
                quit = new JButton("Quit");
                quit.setActionCommand("quit");
 
                save.addActionListener(this);
                quit.addActionListener(this);
 
                JPanel buttonPanel = new JPanel(new GridLayout(1, 0));
                buttonPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
                buttonPanel.add(save);
                buttonPanel.add(quit);
                mainPanel.add(buttonPanel, BorderLayout.PAGE_END);
 
                choicePanel = new JPanel(new GridLayout(7, 1));
                choicePanel.setBorder(new EmptyBorder(0, 0, 0, 10));
                mainPanel.add(choicePanel, BorderLayout.WEST);
 
                Overview = new JButton("Overview");
                Overview.setEnabled(true);
                Overview.setActionCommand("overview");
                choicePanel.add(Overview);
 
                ViewProfile = new JButton("View Profile");
                ViewProfile.setActionCommand("profile");
                choicePanel.add(ViewProfile);
 
                ViewCharacter = new JButton("View by Characteristic");
                ViewCharacter.setActionCommand("characteristic");
                choicePanel.add(ViewCharacter);
 
                SortCharacter = new JButton("Sort by Characteristic");
                SortCharacter.setActionCommand("sort");
                choicePanel.add(SortCharacter);
 
                Add = new JButton("Add Profile");
                Add.setActionCommand("add");
                Add.addActionListener(this);
                Add.setEnabled(true);
                choicePanel.add(Add);
 
                Edit = new JButton("Edit Profile");
                Edit.setActionCommand("edit");
                choicePanel.add(Edit);
 
                Delete = new JButton("Delete Profile");
                Delete.setBorder(new EmptyBorder(10, 10, 10, 10));
                Delete.setActionCommand("delete");
                choicePanel.add(Delete);
 
                Overview.addActionListener(this);
                ViewProfile.addActionListener(this);
                ViewCharacter.addActionListener(this);
                SortCharacter.addActionListener(this);
                Add.addActionListener(this);
                Edit.addActionListener(this);
                Delete.addActionListener(this);
 
                HumanResourcesEmployee = new JLabel("Human Resources Employee Database");
                HumanResourcesEmployee.setFont(new Font("Tahoma", Font.BOLD, 20));
                HumanResourcesEmployee.setHorizontalAlignment(SwingConstants.CENTER);
                HumanResourcesEmployee.setBorder(new EmptyBorder(0, 0, 20, 0));
                mainPanel.add(HumanResourcesEmployee, BorderLayout.NORTH);
 
                display = new JTextArea(
                                "Welcome to the Human Resources Employee Database.\nUse the buttons on the left to navigate the application.");
                display.setFont(new Font("Consolas", Font.PLAIN, 14));
                display.setWrapStyleWord(true);
                display.setLineWrap(true);
                display.setEditable(false);
                scroll = new JScrollPane(display);
                scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                mainPanel.add(scroll, BorderLayout.CENTER);
 
                addProfile = new JPanel();
                cardHolder.add(addProfile, "addProfile");
                addProfile.setLayout(new BorderLayout(0, 0));
 
                inputPanel = new JPanel();
                addProfile.add(inputPanel, BorderLayout.CENTER);
                inputPanel.setLayout(new GridLayout(15, 1, 0, 5));
 
                firstName = new JTextField();
                inputPanel.add(firstName);
 
                lastName = new JTextField();
                inputPanel.add(lastName);
 
                age = new JTextField();
                inputPanel.add(age);
                age.setColumns(10);
 
                education = new JTextField();
                inputPanel.add(education);
                education.setColumns(10);
 
                SIN = new JTextField();
                inputPanel.add(SIN);
                SIN.setColumns(10);
 
                empNum = new JTextField();
                inputPanel.add(empNum);
                empNum.setColumns(10);
 
                address = new JTextField();
                inputPanel.add(address);
                address.setColumns(10);
 
                DoB = new JTextField();
                inputPanel.add(DoB);
                DoB.setColumns(10);
 
                phoneNumber = new JTextField();
                inputPanel.add(phoneNumber);
                phoneNumber.setColumns(10);
 
                eMail = new JTextField();
                inputPanel.add(eMail);
                eMail.setColumns(10);
 
                salary = new JTextField();
                salary.setText("");
                inputPanel.add(salary);
                salary.setColumns(10);
 
                department = new JTextField();
                inputPanel.add(department);
                department.setColumns(10);
 
                vacDays = new JTextField();
                inputPanel.add(vacDays);
                vacDays.setColumns(10);
 
                sicDays = new JTextField();
                inputPanel.add(sicDays);
                sicDays.setColumns(10);
 
                hoursWorked = new JTextField();
                hoursWorked.setBackground(Color.WHITE);
                inputPanel.add(hoursWorked);
                hoursWorked.setColumns(10);
 
                labelPanel = new JPanel();
                addProfile.add(labelPanel, BorderLayout.WEST);
                GridLayout gl_labelPanel = new GridLayout(15, 1);
                gl_labelPanel.setVgap(5);
                labelPanel.setLayout(gl_labelPanel);
 
                lblFirstName = new JLabel("First Name");
                lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
                labelPanel.add(lblFirstName);
 
                lblLastName = new JLabel("Last Name");
                lblLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
                labelPanel.add(lblLastName);
 
                lblAge = new JLabel("Age");
                lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
                labelPanel.add(lblAge);
 
                lblEducation = new JLabel("Education");
                lblEducation.setFont(new Font("Tahoma", Font.BOLD, 11));
                labelPanel.add(lblEducation);
 
                lblSIN = new JLabel("SIN");
                lblSIN.setFont(new Font("Tahoma", Font.BOLD, 11));
                labelPanel.add(lblSIN);
 
                lblEmpNum = new JLabel("Employee Number");
                lblEmpNum.setFont(new Font("Tahoma", Font.BOLD, 11));
                labelPanel.add(lblEmpNum);
 
                lblAddress = new JLabel("Address");
                lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
                labelPanel.add(lblAddress);
 
                lblDoB = new JLabel("Date of Birth (MM/DD/YY)");
                lblDoB.setFont(new Font("Tahoma", Font.BOLD, 11));
                labelPanel.add(lblDoB);
 
                lblPhoneNumber = new JLabel("Phone Number");
                lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
                labelPanel.add(lblPhoneNumber);
 
                lblEmail = new JLabel("Email");
                lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
                labelPanel.add(lblEmail);
 
                lblSalary = new JLabel("Salary");
                lblSalary.setFont(new Font("Tahoma", Font.BOLD, 11));
                labelPanel.add(lblSalary);
 
                lblDepartment = new JLabel("Department");
                lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 11));
                labelPanel.add(lblDepartment);
 
                lblVacDays = new JLabel("# of Vacation Days");
                lblVacDays.setFont(new Font("Tahoma", Font.BOLD, 11));
                labelPanel.add(lblVacDays);
 
                lblSicDays = new JLabel("# of Sick Days");
                lblSicDays.setFont(new Font("Tahoma", Font.BOLD, 11));
                labelPanel.add(lblSicDays);
 
                lblHoursWorked = new JLabel("# of Hours Worked");
                lblHoursWorked.setFont(new Font("Tahoma", Font.BOLD, 11));
                labelPanel.add(lblHoursWorked);
 
                lblNewEmployeeProfile = new JLabel("New Employee Profile");
                lblNewEmployeeProfile.setForeground(Color.BLUE);
                lblNewEmployeeProfile.setFont(new Font("Tahoma", Font.BOLD, 20));
                addProfile.add(lblNewEmployeeProfile, BorderLayout.NORTH);
 
                eastPanel = new JPanel();
                addProfile.add(eastPanel, BorderLayout.EAST);
                GridBagLayout gbl_eastPanel = new GridBagLayout();
                gbl_eastPanel.columnWidths = new int[] { 301, 0 };
                gbl_eastPanel.rowHeights = new int[] { 175, 0, 175, 0, 0 };
                gbl_eastPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
                gbl_eastPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0,
                                Double.MIN_VALUE };
                eastPanel.setLayout(gbl_eastPanel);
 
                labelAndRadioButtonPanel = new JPanel();
                GridBagConstraints gbc_labelAndRadioButtonPanel = new GridBagConstraints();
                gbc_labelAndRadioButtonPanel.fill = GridBagConstraints.VERTICAL;
                gbc_labelAndRadioButtonPanel.insets = new Insets(0, 0, 5, 0);
                gbc_labelAndRadioButtonPanel.gridx = 0;
                gbc_labelAndRadioButtonPanel.gridy = 0;
                eastPanel.add(labelAndRadioButtonPanel, gbc_labelAndRadioButtonPanel);
                GridBagLayout gbl_labelAndRadioButtonPanel = new GridBagLayout();
                gbl_labelAndRadioButtonPanel.columnWidths = new int[] { 147, 147, 0 };
                gbl_labelAndRadioButtonPanel.rowHeights = new int[] { 107, 0 };
                gbl_labelAndRadioButtonPanel.columnWeights = new double[] { 0.0, 0.0,
                                Double.MIN_VALUE };
                gbl_labelAndRadioButtonPanel.rowWeights = new double[] { 0.0,
                                Double.MIN_VALUE };
                labelAndRadioButtonPanel.setLayout(gbl_labelAndRadioButtonPanel);
 
                labelPanel2 = new JPanel();
                GridBagConstraints gbc_labelPanel2 = new GridBagConstraints();
                gbc_labelPanel2.fill = GridBagConstraints.VERTICAL;
                gbc_labelPanel2.anchor = GridBagConstraints.WEST;
                gbc_labelPanel2.insets = new Insets(0, 0, 0, 5);
                gbc_labelPanel2.gridx = 0;
                gbc_labelPanel2.gridy = 0;
                labelAndRadioButtonPanel.add(labelPanel2, gbc_labelPanel2);
                GridBagLayout gbl_labelPanel2 = new GridBagLayout();
                gbl_labelPanel2.columnWidths = new int[] { 0, 0 };
                gbl_labelPanel2.rowHeights = new int[] { 0, 0, 0, 0, 0 };
                gbl_labelPanel2.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
                gbl_labelPanel2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
                                Double.MIN_VALUE };
                labelPanel2.setLayout(gbl_labelPanel2);
 
                lblSex = new JLabel("Sex");
                lblSex.setFont(new Font("Tahoma", Font.BOLD, 11));
                GridBagConstraints gbc_lblSex = new GridBagConstraints();
                gbc_lblSex.anchor = GridBagConstraints.WEST;
                gbc_lblSex.weighty = 0.1;
                gbc_lblSex.insets = new Insets(0, 0, 5, 0);
                gbc_lblSex.gridx = 0;
                gbc_lblSex.gridy = 0;
                labelPanel2.add(lblSex, gbc_lblSex);
 
                lblEmployeeActivity = new JLabel("Employee Activity");
                lblEmployeeActivity.setFont(new Font("Tahoma", Font.BOLD, 11));
                GridBagConstraints gbc_lblEmployeeActivity = new GridBagConstraints();
                gbc_lblEmployeeActivity.anchor = GridBagConstraints.WEST;
                gbc_lblEmployeeActivity.weighty = 0.1;
                gbc_lblEmployeeActivity.insets = new Insets(0, 0, 5, 0);
                gbc_lblEmployeeActivity.gridx = 0;
                gbc_lblEmployeeActivity.gridy = 1;
                labelPanel2.add(lblEmployeeActivity, gbc_lblEmployeeActivity);
 
                lblMarriageStatus = new JLabel("Marriage Status");
                lblMarriageStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
                GridBagConstraints gbc_lblMarriageStatus = new GridBagConstraints();
                gbc_lblMarriageStatus.anchor = GridBagConstraints.WEST;
                gbc_lblMarriageStatus.weighty = 0.1;
                gbc_lblMarriageStatus.insets = new Insets(0, 0, 5, 0);
                gbc_lblMarriageStatus.gridx = 0;
                gbc_lblMarriageStatus.gridy = 2;
                labelPanel2.add(lblMarriageStatus, gbc_lblMarriageStatus);
 
                lblNewLabel = new JLabel("Employee Criminal Record");
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
                GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
                gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
                gbc_lblNewLabel.weighty = 0.125;
                gbc_lblNewLabel.gridx = 0;
                gbc_lblNewLabel.gridy = 3;
                labelPanel2.add(lblNewLabel, gbc_lblNewLabel);
 
                radioButtonPanel = new JPanel();
                GridBagConstraints gbc_radioButtonPanel = new GridBagConstraints();
                gbc_radioButtonPanel.anchor = GridBagConstraints.WEST;
                gbc_radioButtonPanel.gridx = 1;
                gbc_radioButtonPanel.gridy = 0;
                labelAndRadioButtonPanel.add(radioButtonPanel, gbc_radioButtonPanel);
                GridBagLayout gbl_radioButtonPanel = new GridBagLayout();
                gbl_radioButtonPanel.columnWidths = new int[] { 0, 0, 0 };
                gbl_radioButtonPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
                gbl_radioButtonPanel.columnWeights = new double[] { 0.0, 0.0,
                                Double.MIN_VALUE };
                gbl_radioButtonPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
                                Double.MIN_VALUE };
                radioButtonPanel.setLayout(gbl_radioButtonPanel);
 
                male = new JRadioButton("Male");
                sex.add(male);
                GridBagConstraints gbc_male = new GridBagConstraints();
                gbc_male.anchor = GridBagConstraints.WEST;
                gbc_male.insets = new Insets(0, 0, 5, 5);
                gbc_male.gridx = 0;
                gbc_male.gridy = 0;
                radioButtonPanel.add(male, gbc_male);
 
                female = new JRadioButton("Female");
                sex.add(female);
                GridBagConstraints gbc_female = new GridBagConstraints();
                gbc_female.anchor = GridBagConstraints.WEST;
                gbc_female.insets = new Insets(0, 0, 5, 0);
                gbc_female.gridx = 1;
                gbc_female.gridy = 0;
                radioButtonPanel.add(female, gbc_female);
 
                active = new JRadioButton("Active");
                empActive.add(active);
                GridBagConstraints gbc_active = new GridBagConstraints();
                gbc_active.anchor = GridBagConstraints.WEST;
                gbc_active.insets = new Insets(0, 0, 5, 5);
                gbc_active.gridx = 0;
                gbc_active.gridy = 1;
                radioButtonPanel.add(active, gbc_active);
 
                inActive = new JRadioButton("Inactive");
                empActive.add(inActive);
                GridBagConstraints gbc_inActive = new GridBagConstraints();
                gbc_inActive.anchor = GridBagConstraints.WEST;
                gbc_inActive.insets = new Insets(0, 0, 5, 0);
                gbc_inActive.gridx = 1;
                gbc_inActive.gridy = 1;
                radioButtonPanel.add(inActive, gbc_inActive);
 
                married = new JRadioButton("Married");
                marriage.add(married);
                GridBagConstraints gbc_married = new GridBagConstraints();
                gbc_married.anchor = GridBagConstraints.WEST;
                gbc_married.insets = new Insets(0, 0, 5, 5);
                gbc_married.gridx = 0;
                gbc_married.gridy = 2;
                radioButtonPanel.add(married, gbc_married);
 
                notMarried = new JRadioButton("Not Married");
                marriage.add(notMarried);
                GridBagConstraints gbc_notMarried = new GridBagConstraints();
                gbc_notMarried.insets = new Insets(0, 0, 5, 0);
                gbc_notMarried.anchor = GridBagConstraints.WEST;
                gbc_notMarried.gridx = 1;
                gbc_notMarried.gridy = 2;
                radioButtonPanel.add(notMarried, gbc_notMarried);
 
                crimRecYes = new JRadioButton("Yes");
                crimRec.add(crimRecYes);
                GridBagConstraints gbc_crimRecYes = new GridBagConstraints();
                gbc_crimRecYes.anchor = GridBagConstraints.WEST;
                gbc_crimRecYes.insets = new Insets(0, 0, 0, 5);
                gbc_crimRecYes.gridx = 0;
                gbc_crimRecYes.gridy = 3;
                radioButtonPanel.add(crimRecYes, gbc_crimRecYes);
 
                crimRecNo = new JRadioButton("No");
                crimRec.add(crimRecNo);
                GridBagConstraints gbc_crimRecNo = new GridBagConstraints();
                gbc_crimRecNo.anchor = GridBagConstraints.WEST;
                gbc_crimRecNo.gridx = 1;
                gbc_crimRecNo.gridy = 3;
                radioButtonPanel.add(crimRecNo, gbc_crimRecNo);
 
                panel = new JPanel();
                GridBagConstraints gbc_panel = new GridBagConstraints();
                gbc_panel.anchor = GridBagConstraints.EAST;
                gbc_panel.insets = new Insets(0, 0, 5, 0);
                gbc_panel.fill = GridBagConstraints.BOTH;
                gbc_panel.gridx = 0;
                gbc_panel.gridy = 2;
                eastPanel.add(panel, gbc_panel);
                GridBagLayout gbl_panel = new GridBagLayout();
                gbl_panel.columnWidths = new int[] { 150, 150, 0 };
                gbl_panel.rowHeights = new int[] { 155, 0 };
                gbl_panel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
                gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
                panel.setLayout(gbl_panel);
 
                btnCancel = new JButton("Cancel");
                btnCancel.addActionListener(this);
                GridBagConstraints gbc_btnCancel = new GridBagConstraints();
                gbc_btnCancel.anchor = GridBagConstraints.SOUTH;
                gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
                gbc_btnCancel.weighty = 1.0;
                gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
                gbc_btnCancel.gridx = 0;
                gbc_btnCancel.gridy = 0;
                panel.add(btnCancel, gbc_btnCancel);
 
                btnFinish = new JButton("Finish");
                btnFinish.addActionListener(this);
                GridBagConstraints gbc_btnFinish = new GridBagConstraints();
                gbc_btnFinish.fill = GridBagConstraints.HORIZONTAL;
                gbc_btnFinish.anchor = GridBagConstraints.SOUTHEAST;
                gbc_btnFinish.gridx = 1;
                gbc_btnFinish.gridy = 0;
                panel.add(btnFinish, gbc_btnFinish);
 
        }
 
        public void actionPerformed(ActionEvent evt) {
                boolean sex = true;
                boolean isActive = true;
                boolean isMarried = false;
                boolean isCrimRec = false;
 
                CardLayout cardLayout = (CardLayout) (cardHolder.getLayout());
                if (evt.getSource() == Add) {
                        cardLayout.show(cardHolder, "addProfile");
                } else if (evt.getSource() == btnCancel) {
                       
                        firstName.setText("");
                        lastName.setText("");
                        age.setText("");
                        education.setText("");
                        SIN.setText("");
                        empNum.setText("");
                        address.setText("");
                        DoB.setText("");
                        phoneNumber.setText("");
                        eMail.setText("");
                        salary.setText("");
                        department.setText("");
                        male.setSelected(false);
                        female.setSelected(false);
                        active.setSelected(false);
                        inActive.setSelected(false);
                        married.setSelected(false);
                        notMarried.setSelected(false);
                       
                        cardLayout.show(cardHolder, "mainPanel");
                } else if (evt.getSource() == btnFinish) {
                        try {
                                if (male.isSelected()) {
                                        sex = true;
                                } else if (female.isSelected()) {
                                        sex = false;
                                }
 
                                if (active.isSelected()) {
                                        isActive = true;
                                } else if (inActive.isSelected()) {
                                        isActive = false;
                                }
 
                                if (married.isSelected()) {
                                        isMarried = true;
                                } else if (notMarried.isSelected()) {
                                        isMarried = false;
                                }
 
                                if (crimRecYes.isSelected()) {
                                        isCrimRec = true;
                                } else if (crimRecNo.isSelected()) {
                                        isCrimRec = false;
                                }
 
                                emps.add(new Employee(firstName.getText(), lastName.getText(),
                                                Integer.parseInt(age.getText()), sex, education
                                                                .getText(), Integer.parseInt(SIN.getText()),
                                                Integer.parseInt(empNum.getText()), address.getText(),
                                                DoB.getText(), phoneNumber.getText(), eMail.getText(),
                                                isActive, isMarried,
                                                Integer.parseInt(vacDays.getText()), Integer
                                                                .parseInt(sicDays.getText()), Double
                                                                .parseDouble(salary.getText()), isCrimRec,
                                                department.getText(), Integer.parseInt(hoursWorked
                                                                .getText())));
                               
                                firstName.setText("");
                                lastName.setText("");
                                age.setText("");
                                education.setText("");
                                SIN.setText("");
                                empNum.setText("");
                                address.setText("");
                                DoB.setText("");
                                phoneNumber.setText("");
                                eMail.setText("");
                                salary.setText("");
                                department.setText("");
                                male.setSelected(false);
                                female.setSelected(false);
                                active.setSelected(false);
                                inActive.setSelected(false);
                                married.setSelected(false);
                                notMarried.setSelected(false);
                               
                                cardLayout.show(cardHolder, "mainPanel");                      
                        } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(frame,
                                                "You have not entered a valid number for one or more of the fields.", "Number Error",
                                                JOptionPane.ERROR_MESSAGE);
                        }
                }
 
                if (emps.size() == 0
                                && (evt.getActionCommand() == "overview"
                                                || evt.getActionCommand() == "profile"
                                                || evt.getActionCommand() == "character"
                                                || evt.getActionCommand() == "sort"
                                                || evt.getActionCommand() == "edit" || evt
                                                .getActionCommand() == "delete")) {
                        display.setText("There are no employees in the database...");
                } else {
                        if (evt.getActionCommand() == "quit") {
                                // if file has not yet been saved, prompt user save
                                if (isDirty) {
                                        int choose = JOptionPane
                                                        .showConfirmDialog(
                                                                        frame,
                                                                        "You have not saved your changes\nAre you sure you want to quit?",
                                                                        "Warning", JOptionPane.YES_NO_OPTION,
                                                                        JOptionPane.WARNING_MESSAGE);
                                        if (choose == JOptionPane.YES_OPTION) {
                                                frame.dispose();
                                        }
                                } else {
                                        frame.dispose();
                                }
                        } else if (evt.getActionCommand() == "save") {
                                try {
                                        write(emps);
                                } catch (IOException e) {
                                }
 
                                isDirty = false;
                        } else if (evt.getActionCommand() == "overview") {
                                overview(emps);
                        } else if (evt.getActionCommand() == "profile") {
                                String name = inputBox();
                                String [] names = name.split(" ");
                                if (names.length == 2) {
                                        display(emps, names[0].trim(), names[1].trim());
                                } else if (names.length < 2) {
                                        infoBox("Full name of employee must be entered.\nPlease try again.",
                                                        "View Profile");
                                } else if (names.length == 3) {
                                        boolean found = false;
                                        for (Employee e : emps) {
                                                if (e.getFirstName().equalsIgnoreCase(
                                                                names[0] + " " + names[1])) {
                                                        names[0] = names[0] + " " + names[1];
                                                        names[1] = names[2];
                                                        found = true;
                                                        break;
                                                }
                                        }
                                        if (found == false) {
                                                names[1] = names[1] + " " + names[2];
                                        }
                                        display(emps, names[0].trim(), names[1].trim());
                                }
 
                        } else if (evt.getActionCommand() == "edit") {
                                String name = inputBox();
                                String[] names = name.split(" ");
                                if (names.length == 2) {
                                        editProfile(emps, names[0].trim(), names[1].trim());
                                } else if (names.length < 2) {
                                        infoBox("Full name of employee must be entered.\nPlease try again.",
                                                        "Edit Profile");
                                } else if (names.length == 3) {
                                        boolean found = false;
                                        for (Employee e : emps) {
                                                if (e.getFirstName().equalsIgnoreCase(
                                                                names[0] + " " + names[1])) {
                                                        names[0] = names[0] + " " + names[1];
                                                        names[1] = names[2];
                                                        found = true;
                                                        break;
                                                }
                                        }
                                        if (found == false) {
                                                names[1] = names[1] + " " + names[2];
                                        }
                                        editProfile(emps, names[0].trim(), names[1].trim());
                                }
                                isDirty = true;
 
                        } else if (evt.getActionCommand() == "delete") {
                                String name = inputBox();
                                String[] names = name.split(" ");
                                if (names.length == 2) {
                                        delete(names[0].trim(), names[1].trim());
                                } else if (names.length < 2) {
                                        infoBox("Full name of employee must be entered.\nPlease try again.",
                                                        "Delete Profile");
                                } else if (names.length == 3) {
                                        boolean found = false;
                                        for (Employee e : emps) {
                                                if (e.getFirstName().equalsIgnoreCase(
                                                                names[0] + " " + names[1])) {
                                                        names[0] = names[0] + " " + names[1];
                                                        names[1] = names[2];
                                                        found = true;
                                                        break;
                                                }
                                        }
                                        if (found == false) {
                                                names[1] = names[1] + " " + names[2];
                                        }
                                        delete(names[0].trim(), names[1].trim());
                                }
                                isDirty = true;
                        } else if (evt.getActionCommand() == "characteristic") {
                                String chara = comboInputBox();
                                viewChars(emps, chara);
                        } else if (evt.getActionCommand() == "sort") {
                                Object[] possibilities = { "Last Name", "Department", "Salary" };
                                String chara = (String) JOptionPane.showInputDialog(frame,
                                                "What characteristic would you like to sort by?",
                                                "Characteristic choice", JOptionPane.PLAIN_MESSAGE,
                                                null, possibilities, "Choose one");
                                int choice;
                                if (chara.equals("Last Name")) {
                                        choice = 1;
                                } else if (chara.equals("Department")) {
                                        choice = 2;
                                } else {
                                        choice = 3;
                                }
                                sort(emps, choice);
                                isDirty = true;
                        } else if (evt.getActionCommand() == "add") {
                                isDirty = true;
                        }
                }
        }
 
        // Method name: birthday
        // Purpose: compares employee's birthdays to current date, prompts user to
        // email employee
        public static void birthday(ArrayList<Employee> employeeList)
                        throws IOException, URISyntaxException {
                String bDay;
                ArrayList<Employee> birthdays = new ArrayList<Employee>();
                // runs through employee list
                for (Employee e : employeeList) {
                        bDay = e.getDoB();
                        // get current date
                        Calendar c = Calendar.getInstance();
                        Calendar birthday = Calendar.getInstance();
                        // create birthday object for employee
                        birthday.set(c.get(Calendar.YEAR),
                                        Integer.parseInt(bDay.substring(0, 2)) - 1,
                                        Integer.parseInt(bDay.substring(3, 5)));
                        // compare birthday of employee to current date. Adds employee to
                        // birthday list if true.
                        if (birthday.get(Calendar.DATE) == c.get(Calendar.DATE)
                                        && birthday.get(Calendar.MONTH) == c.get(Calendar.MONTH)) {
 
                                birthdays.add(e);
                        }
                }
 
                // Tells user the amount of birthdays. Asks user if they want to send a
                // message
                int choose = 0;
                if (birthdays.size() == 1) {
                        choose = JOptionPane
                                        .showConfirmDialog(
                                                        frame,
                                                        "There is 1 birthday today.\nWould you like to send birthday messages by email?",
                                                        "Birthdays", JOptionPane.YES_NO_OPTION,
                                                        JOptionPane.WARNING_MESSAGE);
                } else if (birthdays.size() > 1) {
                        choose = JOptionPane
                                        .showConfirmDialog(
                                                        frame,
                                                        "There are "
                                                                        + birthdays.size()
                                                                        + " birthdays today.\nWould you like to send birthday messages by email?",
                                                        "Birthdays", JOptionPane.YES_NO_OPTION,
                                                        JOptionPane.WARNING_MESSAGE);
                } else {
                        return;
                }
                // If user says yes
                if (choose == JOptionPane.YES_OPTION) {
                        // Loops through each employee in birthday list
                        String[] possibilities = new String[birthdays.size()];
                        int count = 0;
                        for (Employee e : birthdays) {
                                possibilities[count] = e.getFirstName() + " " + e.getLastName();
                                count++;
 
                        }
                        int counter = 0;
                        while (true) {
                                // Asks which employee user wants to send message to;
                                String s = null;
                                if (counter == 0) {
                                        s = (String) JOptionPane
                                                        .showInputDialog(
                                                                        frame,
                                                                        "Which employee would you like to send a message to?",
                                                                        "Characteristic choice",
                                                                        JOptionPane.PLAIN_MESSAGE, null,
                                                                        possibilities, "Choose one");
                                } else {
                                        s = (String) JOptionPane
                                                        .showInputDialog(
                                                                        frame,
                                                                        "Which employee would you like to send a message to?\nPress cancel if finished.",
                                                                        "Characteristic choice",
                                                                        JOptionPane.PLAIN_MESSAGE, null,
                                                                        possibilities, "Choose one");
                                }
                                counter++;
                                String email = null;
                                String fName = null;
                                try {
 
                                        for (Employee e : birthdays) {
                                                if (s.equals(e.getFirstName() + " " + e.getLastName())) {
                                                        email = e.geteMail();
                                                        fName = e.getFirstName();
                                                        break;
                                                }
                                        }
                                        // Creates body text for email
                                        String message = "Hey+"
                                                        + fName
                                                        + ",%0AHope+you+have+a+great+birthday!+We've+awarded+you+with+a+small+bonus+of+$50+to+celebrate!%0A%0AThe+HR+Staff";
                                        // Opens email client to the user's email address
                                        Desktop.getDesktop()
                                                        .mail(new URI("mailto:" + email
                                                                        + "?subject=Happy+birthday&body=" + message));
 
                                        // IO Exception: tells employee something went wrong
                                } catch (IOException e1) {
                                        infoBox("Sorry, could not open email client", "Birthdays");
                                        // URISyntaxException: Happens when someone has a name with
                                        // two separate tokens. (Messes with HTML)
                                } catch (URISyntaxException e1) {
                                        // If first name has two words, does not use name
                                        String message = "Hey,%0AHope+you+have+a+great+birthday!+We've+awarded+you+with+a+small+bonus+of+$50+to+celebrate!%0A%0AThe+HR+Staff";
                                        // Opens email client to the user's email address
                                        Desktop.getDesktop()
                                                        .mail(new URI("mailto:" + email
                                                                        + "?subject=Happy+birthday&body=" + message));
                                }
                        }
 
                }
 
        }
 
        // Method name: overview
        // Purpose: Statistics of all the employees
        public static void overview(ArrayList<Employee> employeeList) {
                System.out.println("\nDatabase Overview: ");
                int activeCount = 0;
                int maleCount = 0;
                int marriedCount = 0;
                int crimCount = 0;
                double totalSal = 0;
                int totalAge = 0;
                // for loop running through the list of employees
                // Increments +1 for every active, male, married, criminal positive
                // employee
                // Sums total salary and age
                for (Employee e : employeeList) {
                        if (e.isActive() == true) {
                                activeCount++;
                        }
                        if (e.isSex() == true) {
                                maleCount++;
                        }
                        if (e.isMarried() == true) {
                                marriedCount++;
                        }
                        if (e.isCrimRec() == true) {
                                crimCount++;
                        }
                        totalSal += e.getSalary();
                        totalAge += e.getAge();
                }
                // Uses information to print out totals and averages
                int size = employeeList.size();
                display.setText("Overview:\n\nNumber of active employees: "
                                + activeCount);
                display.append("\nTotal of all salaries: $" + totalSal);
                display.append("\nAverage salary of employees: $" + (totalSal / size));
                display.append("\nAverage age of employees: " + (totalAge / size));
                display.append("\nNumber of employees with criminal record: "
                                + crimCount);
                display.append("\n\nGender demographics: ");
                int malePerc = (maleCount / size) * 100;
                display.append("\nMale: " + malePerc + "%        Female: "
                                + (100 - malePerc) + "%");
                int marriedPerc = (marriedCount / size) * 100;
                display.append("\n\nMarital status demographics: ");
                display.append("\nMarried: " + marriedPerc + "%     Not Married: "
                                + (100 - marriedPerc) + "%\n");
 
        }
 
        // Method name: display
        // Purpose: Displays employee information
        public static void display(ArrayList<Employee> employeeList, String first,
                        String last) {
 
                Employee i = null;
                ArrayList<Employee> sames = new ArrayList<Employee>();
                // for loop running through list of employees
                // Search by first name, last name
                for (Employee e : employeeList) {
                        if (e.getLastName().equalsIgnoreCase(last)
                                        && e.getFirstName().equalsIgnoreCase(first)) {
                                sames.add(e);
                        }
                }
 
                // If name cannot be found, return error
                // If more than one employee with the same name, displays employee
                // numbers and prompts user to choose
                if (sames.size() == 0) {
                        infoBox("Sorry, employee could not be found", "View Profile");
                        return;
                } else if (sames.size() == 1) {
                        i = sames.get(0);
                } else if (sames.size() > 1) {
                        Object[] possibilities = new Object[sames.size()];
                        int counter = 0;
                        for (Employee e : sames) {
                                possibilities[counter] = Integer.toString(e.getEmpNum());
                                counter++;
                        }
                        String number = (String) JOptionPane
                                        .showInputDialog(
                                                        frame,
                                                        "Which "
                                                                        + first
                                                                        + " "
                                                                        + last
                                                                        + " do you want to delete?\nChoose from the employee numbers listed below",
                                                        "Delete", JOptionPane.QUESTION_MESSAGE, null,
                                                        possibilities, "Employee Number...");
                        if (number == null) {
                                return;
                        }
                        int countess = 0;
                        for (Employee e : emps) {
                                if (e.getLastName().equalsIgnoreCase(last)
                                                && e.getFirstName().equalsIgnoreCase(first)
                                                && e.getEmpNum() == Integer.parseInt(number)) {
                                        i = emps.get(countess);
                                }
                                countess++;
                        }
                }
                if (i == null) {
                        return;
                }
                // Displays employee's information
                display.setText("Name: " + i.getFirstName() + " " + i.getLastName()
                                + "\n");
                display.append("\nCONTACT INFORMATION: ");
                display.append("\nEmployee Number: " + i.getEmpNum());
                display.append("\nDepartment: " + i.getDepartment());
                display.append("\nEmail Address: " + i.geteMail());
                display.append("\nPhone Number: " + i.getPhoneNumber());
                display.append("\nAddress: " + i.getAddress());
 
                display.append("\n\nDETAILED INFORMATION: \n");
                display.append(String.format("%-25s %-1s %n", "Age: " + i.getAge(),
                                "Sick Days: " + i.getSicDays()));
 
                if (i.isSex() == true) {
                        display.append(String.format("%-25s %-1s %n", "Sex: male",
                                        "Vacation days: " + i.getVacDays()));
                } else {
                        display.append(String.format("%-25s %-1s %n", "Sex: female",
                                        "Vacation days: " + i.getVacDays()));
                }
                if (i.isMarried() == true) {
                        display.append(String.format("%-25s %-1s %n",
                                        "Date of Birth: " + i.getDoB(), "Marital Status: Married"));
                } else {
                        display.append(String.format("%-25s %-1s %n",
                                        "Date of Birth: " + i.getDoB(),
                                        "Marital Status: Not Married"));
                }
 
                if (i.isCrimRec() == true) {
                        display.append(String.format("%-25s %-1s %n",
                                        "Salary: " + i.getSalary(), "Criminal Record: Yes"));
                } else {
                        display.append(String.format("%-25s %-1s %n",
                                        "Salary: $" + i.getSalary(), "Criminal Record: No"));
                }
 
                display.append(String.format("%-25s %-1s %n", "SIN: " + i.getSIN(),
                                "Hours worked: " + i.getHoursWorked() + " per week"));
 
                display.append("Education: " + i.getEducation());
 
        }
 
        // Method name: viewChars
        // Purpose: View a list of employees by characteristics
        public static void viewChars(ArrayList<Employee> employeeList, String choice) {
 
                display.setText("Employees by Characteristic:\n\n");
 
                // Characteristics used depending on user input
                if (choice.equalsIgnoreCase("Age")) {
                        display.append(String.format("%-20s %-1s %n", "Name:", "Age:"));
                        for (Employee i : employeeList) {
                                display.append(String.format("%-20s %-1s %n", i.getFirstName()
                                                + " " + i.getLastName(), i.getAge()));
                        }
                } else if (choice.equalsIgnoreCase("First Name")) {
                        display.append("First Name:\n");
                        for (Employee i : employeeList) {
                                display.append(i.getFirstName() + "\n");
                        }
                } else if (choice.equalsIgnoreCase("Last Name")) {
                        display.append("Last Name:\n");
                        for (Employee i : employeeList) {
                                display.append(i.getLastName() + "\n");
                        }
                } else if (choice.equalsIgnoreCase("Sex")) {
                        display.append(String.format("%-20s %-1s %n", "Name:", "Sex:"));
                        for (Employee i : employeeList) {
                                String sex = "";
                                if (i.isSex()) {
                                        sex = "Male";
                                } else {
                                        sex = "Female";
                                }
                                display.append(String.format("%-20s %-1s %n", i.getFirstName()
                                                + " " + i.getLastName(), sex));
                        }
                } else if ((choice.equalsIgnoreCase("Address"))) {
                        display.append(String.format("%-20s %-1s %n", "Name:", "Address:"));
                        for (Employee i : employeeList) {
                                display.append(String.format("%-20s %-1s %n", i.getFirstName()
                                                + " " + i.getLastName(), i.getAddress()));
                        }
                } else if ((choice.equalsIgnoreCase("Employee Number"))) {
                        display.append(String.format("%-20s %-1s %n", "Name:",
                                        "Employee Number:"));
                        for (Employee i : employeeList) {
                                display.append(String.format("%-20s %-1s %n", i.getFirstName()
                                                + " " + i.getLastName(), i.getEmpNum()));
                        }
                } else if ((choice.equalsIgnoreCase("Date of Birth"))) {
                        display.append(String.format("%-20s %-1s %n", "Name:",
                                        "Date of Birth:"));
                        for (Employee i : employeeList) {
                                display.append(String.format("%-20s %-1s %n", i.getFirstName()
                                                + " " + i.getLastName(), i.getDoB()));
                        }
                } else if (choice.equalsIgnoreCase("Phone Number")) {
                        display.append(String.format("%-20s %-1s %n", "Name:",
                                        "Phone Number:"));
                        for (Employee i : employeeList) {
                                display.append(String.format("%-20s %-1s %n", i.getFirstName()
                                                + " " + i.getLastName(), i.getPhoneNumber()));
                        }
                } else if (choice.equalsIgnoreCase("SIN")) {
                        display.append(String.format("%-20s %-1s %n", "Name:", "SIN:"));
                        for (Employee i : employeeList) {
                                display.append(String.format("%-20s %-1s %n", i.getFirstName()
                                                + " " + i.getLastName(), i.getSIN()));
                        }
                } else if (choice.equalsIgnoreCase("Active or Suspended")) {
                        display.append(String.format("%-20s %-1s %n", "Name:",
                                        "Active or Suspended:"));
                        for (Employee i : employeeList) {
                                String active = "";
                                if (i.isActive()) {
                                        active = "Active";
                                } else {
                                        active = "Suspended";
                                }
                                display.append(String.format("%-20s %-1s %n", i.getFirstName()
                                                + " " + i.getLastName(), active));
                        }
                } else if (choice.equalsIgnoreCase("Vacation Days")) {
                        display.append(String.format("%-20s %-1s %n", "Name:",
                                        "Vacation Days:"));
                        for (Employee i : employeeList) {
                                display.append(String.format("%-20s %-1s %n", i.getFirstName()
                                                + " " + i.getLastName(), i.getVacDays()));
                        }
                } else if (choice.equalsIgnoreCase("Sick Days")) {
                        display.append(String
                                        .format("%-20s %-1s %n", "Name:", "Sick Days:"));
                        for (Employee i : employeeList) {
                                display.append(String.format("%-20s %-1s %n", i.getFirstName()
                                                + " " + i.getLastName(), i.getSicDays()));
                        }
                } else if (choice.equalsIgnoreCase("Salary")) {
                        display.append(String.format("%-20s %-1s %n", "Name:", "Salary:"));
                        for (Employee i : employeeList) {
                                display.append(String.format("%-20s %-1s %n", i.getFirstName()
                                                + " " + i.getLastName(), i.getSalary()));
                        }
                } else if (choice.equalsIgnoreCase("Department")) {
                        display.append(String.format("%-20s %-1s %n", "Name:",
                                        "Department:"));
                        for (Employee i : employeeList) {
                                display.append(String.format("%-20s %-1s %n", i.getFirstName()
                                                + " " + i.getLastName(), i.getDepartment()));
                        }
                } else if (choice.equalsIgnoreCase("Marital Status")) {
                        display.append(String.format("%-20s %-1s %n", "Name:",
                                        "Marital Status:"));
                        for (Employee i : employeeList) {
                                String married = "";
                                if (i.isActive()) {
                                        married = "Married";
                                } else {
                                        married = "Not Married";
                                }
                                display.append(String.format("%-20s %-1s %n", i.getFirstName()
                                                + " " + i.getLastName(), married));
                        }
                } else if (choice.equalsIgnoreCase("Email")) {
                        display.append(String.format("%-20s %-1s %n", "Name:", "Email:"));
                        for (Employee i : employeeList) {
                                display.append(String.format("%-20s %-1s %n", i.getFirstName()
                                                + " " + i.getLastName(), i.geteMail()));
                        }
                } else if (choice.equalsIgnoreCase("Criminal Record")) {
                        display.append(String.format("%-20s %-1s %n", "Name:",
                                        "Criminal Record:"));
                        for (Employee i : employeeList) {
                                String crimRec = "";
                                if (i.isCrimRec()) {
                                        crimRec = "Yes";
                                } else {
                                        crimRec = "No";
                                }
                                display.append(String.format("%-20s %-1s %n", i.getFirstName()
                                                + " " + i.getLastName(), crimRec));
                        }
                } else if (choice.equalsIgnoreCase("Education")) {
                        display.append(String
                                        .format("%-20s %-1s %n", "Name:", "Education:"));
                        for (Employee i : employeeList) {
                                display.append(String.format("%-20s %-1s %n", i.getFirstName()
                                                + " " + i.getLastName(), i.getEducation()));
                        }
 
 
                } else if (choice.equalsIgnoreCase("Hours Worked Per Week")) {
                        display.append(String.format("%-20s %-1s %n", "Name:",
                                        "Hours Worked Per Week:"));
                        for (Employee i : employeeList) {
                                display.append(String.format("%-20s %-1s %n", i.getFirstName()
                                                + " " + i.getLastName(), i.getHoursWorked()));
                        }
                }
        }
 
        // Method name: sort
        // Purpose: Sorts the list of employees by characteristics
        public static void sort(ArrayList<Employee> employeeList, int choice) {
                boolean cleared = false;
                int clearCount = 0;
 
                display.setText("Sorted Employees: \n\n");
 
                // Sorts for last name
                if (choice == 1) {
                        String first = new String("");
                        String second = new String("");
                        String first2 = new String("");
                        String second2 = new String("");
 
                        while (cleared == false) {
                                // runs a for loop the size of the employee list
                                // sorts the list in alphabetical order (bubble sort)
                                for (int count = 0; count < employeeList.size() - 1; count++) {
                                        first = employeeList.get(count).getLastName();
                                        second = employeeList.get(count + 1).getLastName();
                                        // switches places of employees if second is greater than
                                        // first
                                        if (first.compareTo(second) > 0) {
                                                Employee f2 = employeeList.remove(count + 1);
                                                employeeList.add(count, f2);
                                                // If they are the same, sorts by first name
                                        } else if (first.compareTo(second) == 0) {
                                                first2 = employeeList.get(count).getFirstName();
                                                second2 = employeeList.get(count + 1).getFirstName();
 
                                                if (first2.compareTo(second2) > 0) {
                                                        Employee f = employeeList.remove(count + 1);
                                                        employeeList.add(count, f);
                                                } else {
                                                        clearCount++;
                                                }
                                                // increments clearCount if order is correct
                                        } else {
                                                clearCount++;
                                        }
 
                                }
                                // If everything correct, end sort
                                if (clearCount == employeeList.size() - 1)
                                        cleared = true;
                                clearCount = 0;
                        }
                        // Displays sorted list
 
                        String text = String.format("%-8s %-1s %n", "Emp #", "Name");
                        display.append(text);
                        for (Employee i : employeeList) {
                                String thing = String.format("%-8s %-1s %n", i.getEmpNum(),
                                                i.getLastName() + ", " + i.getFirstName());
                                display.append(thing);
                        }
                        // Sorts by department
                } else if (choice == 2) {
 
                        String first = new String("");
                        String second = new String("");
                        String first2 = new String("");
                        String second2 = new String("");
 
                        while (cleared == false) {
                                // runs for loop the size of the employee list
                                for (int count = 0; count < employeeList.size() - 1; count++) {
                                        first = employeeList.get(count).getLastName();
                                        second = employeeList.get(count + 1).getLastName();
                                        // switches places of employees if second is greater than
                                        // first
                                        if (first.compareTo(second) > 0) {
                                                Employee f2 = employeeList.remove(count + 1);
                                                employeeList.add(count, f2);
                                                // If same department, sorts by last name
                                        } else if (first.compareTo(second) == 0) {
                                                first2 = employeeList.get(count).getLastName();
                                                second2 = employeeList.get(count + 1).getLastName();
                                                if (first2.compareTo(second2) > 0) {
                                                        Employee f = employeeList.remove(count + 1);
                                                        employeeList.add(count, f);
 
                                                } else {
                                                        clearCount++;
                                                }
                                                // Increments clearCount if in correct order
                                        } else {
                                                clearCount++;
                                        }
                                }
                                // If all in correct order, end sort
                                if (clearCount == employeeList.size() - 1)
                                        cleared = true;
                                clearCount = 0;
                        }
                        // Prints out sorted list
                        String text = String.format("%-8s %-15s %-1s %n", "Emp #",
                                        "Department", "Name");
                        display.append(text);
                        for (Employee i : employeeList) {
                                String thing = String.format("%-8s %-15s %-1s %n",
                                                i.getEmpNum(), i.getDepartment(), i.getLastName()
                                                                + ", " + i.getFirstName());
                                display.append(thing);
                        }
                        // Sorts by salary
                } else if (choice == 3) {
                        double first;
                        double second;
 
                        while (cleared == false) {
                                // runs for loop through all the salaries the size of the
                                // employee list
                                for (int count = 0; count < employeeList.size() - 1; count++) {
 
                                        first = employeeList.get(count).getSalary();
                                        second = employeeList.get(count + 1).getSalary();
                                        // if second salary is greater than first salary remove
                                        // second salary and put it in front of first salary
                                        if (first < second) {
                                                Employee f2 = employeeList.remove(count + 1);
                                                employeeList.add(count, f2);
 
                                                // If in correct order increment clearCount
                                        } else {
                                                clearCount++;
                                        }
                                }
                                // If all in order, end sort
                                if (clearCount == employeeList.size() - 1)
                                        cleared = true;
                                clearCount = 0;
                        }
                        String text = String.format("%-8s %-12s %-1s %n", "Emp #",
                                        "Salary", "Name");
                        display.append(text);
                        for (Employee i : employeeList) {
                                String thing = String.format("%-8s %-12s %-1s %n",
                                                i.getEmpNum(), "$" + i.getSalary(), i.getLastName()
                                                                + ", " + i.getFirstName());
                                display.append(thing);
                        }
 
                }
 
        }
 
        // Method name: editProfile
        // Purpose: Access arraylist, find employee and edit information
        public static void editProfile(ArrayList<Employee> employeeList,
                        String first, String last) {
                ArrayList<Integer> sames = new ArrayList<Integer>();
                ArrayList<Employee> samesEmp = new ArrayList<Employee>();
                Employee toEdit = null;
 
                int count = 0;
                // Runs for loop through the employee list, counting the number of
                // profiles with that name
                for (Employee e : emps) {
                        if (e.getLastName().equalsIgnoreCase(last)
                                        && e.getFirstName().equalsIgnoreCase(first)) {
                                sames.add(new Integer(count));
                                samesEmp.add(e);
                        }
                        count++;
                }
                // if count is 0, name is invalid
                if (sames.size() == 0) {
                        infoBox("Sorry, employee could not be found", "Delete Profile");
                        // if count is 1, remove that profile
                } else if (sames.size() == 1) {
                        toEdit = emps.get((int) sames.get(0));
                        // if count is greater than 1, prompt user choice and then delete
                        // that choice
                } else if (sames.size() > 1) {
                        Object[] possibilities = new Object[samesEmp.size()];
                        int counter = 0;
                        for (Employee e : samesEmp) {
                                possibilities[counter] = Integer.toString(e.getEmpNum());
                                counter++;
                        }
                        String number = (String) JOptionPane
                                        .showInputDialog(
                                                        frame,
                                                        "Which "
                                                                        + first
                                                                        + " "
                                                                        + last
                                                                        + " do you want to edit?\nChoose from the employee numbers listed below",
                                                        "Delete", JOptionPane.QUESTION_MESSAGE, null,
                                                        possibilities, "Employee Number...");
                        if (number == null) {
                                return;
                        }
                        int countess = 0;
                        for (Employee e : emps) {
                                if (e.getLastName().equalsIgnoreCase(last)
                                                && e.getFirstName().equalsIgnoreCase(first)
                                                && e.getEmpNum() == Integer.parseInt(number)) {
                                        toEdit = emps.get(countess);
                                }
                                countess++;
                        }
                }
                String choice = comboInputBox();
                // prompt user input, change accordingly
                if (choice.equals("Age")) {
                        int age = intExceptions("Age\nWhat would you like to change it to? ");
                        toEdit.setAge(age);
                } else if (choice.equals("First Name")) {
                        toEdit.setFirstName(editor("First Name\nWhat would you like to change it to? "));
                } else if (choice.equals("Last Name")) {
                        toEdit.setLastName(editor("Last Name\nWhat would you like to change it to? "));
                } else if (choice.equals("Sex")) {
                        boolean go = true;
                        boolean isMale = true;
                        while (go) {
                                go = false;
                                String sex = JOptionPane
                                                .showInputDialog(frame,
                                                                "Sex\nWhat would you like to change it to? (Input 'male' or 'female')");
                                if (sex.toLowerCase().equals("male")) {
                                        isMale = true;
                                } else if (sex.toLowerCase().equals("female")) {
                                        isMale = false;
                                } else {
                                        infoBox("Invalid input\nPlease try again.", "Edit Profile");
                                        go = true;
                                }
                        }
                        toEdit.setSex(isMale);
                } else if (choice.equals("Address")) {
                        toEdit.setAddress(editor("Address\nWhat would you like to change it to? "));
                } else if (choice.equals("Employee Number")) {
                        int empNum = intExceptions("Employee Number\nWhat would you like to change it to? ");
                        toEdit.setEmpNum(empNum);
                } else if (choice.equals("Date of Birth")) {
                        boolean DOBgo = true;
                        String DoB = "";
                        try {
                                while (DOBgo) {
                                        Calendar today = Calendar.getInstance();
                                        DOBgo = false;
                                        DoB = editor("Date of Birth\nWhat would you like to change it to? (mm/dd/yy) ");
                                        // validate date values
                                        if (Integer.parseInt(DoB.substring(0, 2)) > 12
                                                        || Integer.parseInt(DoB.substring(3, 5)) > 31
                                                        || DoB.substring(6).length() > 4
                                                        || Integer.parseInt(DoB.substring(6)) > today
                                                                        .get(Calendar.YEAR)) {
                                                infoBox("Invalid input\nPlease try again.",
                                                                "Edit Profile");
                                                DOBgo = true;
                                        }
                                }
                        } catch (NumberFormatException e) {
                                infoBox("Invalid input\nPlease try again.", "Edit Profile");
                                DOBgo = true;
                        }
                        toEdit.setDoB(DoB);
                } else if (choice.equals("Phone Number")) {
                        toEdit.setPhoneNumber(editor("Phone Number\nWhat would you like to change it to? "));
                } else if (choice.equals("SIN")) {
                        boolean SINgo = true;
                        int SIN = 0;
                        while (SINgo) {
                                SINgo = false;
                                SIN = intExceptions("SIN\nWhat would you like to change it to? ");
                                // checks if user input is 9 digits exactly
                                if (String.valueOf(SIN).length() != 9) {
                                        infoBox("Invalid input\nPlease try again.", "Edit Profile");
                                        SINgo = true;
                                }
                        }
                        toEdit.setSIN(SIN);
                } else if (choice.equals("Active or Suspended")) {
                        boolean go = true;
                        boolean isActive = true;
                        while (go) {
                                go = false;
                                String active = editor("Active or Suspended\nIs the employee active? (y/n) ");
                                if (active.toLowerCase().equals("y")) {
                                        isActive = true;
                                } else if (active.toLowerCase().equals("n")) {
                                        isActive = false;
                                } else {
                                        infoBox("Invalid input\nPlease try again.", "Edit Profile");
                                        go = true;
                                }
                        }
                        toEdit.setActive(isActive);
                } else if (choice.equals("Vacation Days")) {
                        int vacDays = intExceptions("Vacation Days\nHow many vacation days does this employee have? ");
                        toEdit.setVacDays(vacDays);
                } else if (choice.equals("Sick Days")) {
                        int sickDays = intExceptions("Sick Days\nHow many sick days does this employee have? ");
                        toEdit.setSicDays(sickDays);
                } else if (choice.equals("Salary")) {
                        double salary = doubleExceptions("Salary\nWhat would you like to change it to? $");
                        toEdit.setSalary(salary);
                } else if (choice.equals("Department")) {
                        toEdit.setDepartment(editor("Department\nWhat would you like to change it to? "));
                } else if (choice.equals("Marital Status")) {
                        boolean go = true;
                        while (go) {
                                go = false;
                                String married = editor("Marital Status\nIs this employee married? (y/n) ");
                                if (married.equalsIgnoreCase("y")) {
                                        toEdit.setMarried(true);
                                } else if (married.equalsIgnoreCase("n")) {
                                        toEdit.setMarried(false);
                                } else {
                                        infoBox("Invalid input\nPlease try again.", "Edit Profile");
                                        go = true;
                                }
                        }
                } else if (choice.equals("Email")) {
                        toEdit.seteMail(editor("Email\nWhat would you like to change it to? "));
                } else if (choice.equals("Criminal Record")) {
                        boolean go = true;
                        while (go) {
                                go = false;
                                String crimRecord = editor("Criminal Record\nDoes this employee have a criminal record? (y/n)");
                                if (crimRecord.equalsIgnoreCase("y")) {
                                        toEdit.setCrimRec(true);
                                } else if (crimRecord.equalsIgnoreCase("n")) {
                                        toEdit.setCrimRec(false);
                                } else {
                                        infoBox("Invalid input\nPlease try again.", "Edit Profile");
                                        go = true;
                                }
                        }
                } else if (choice.equals("Education")) {
                        toEdit.setEducation(editor("Education\nWhat is this employee's highest education? "));
 
                } else if (choice.equals("Hours Worked Per Week")) {
                        int hoursWorked = intExceptions("Hours Worked Per Week\nWhat would you like to change it to? ");
                        toEdit.setHoursWorked(hoursWorked);
                }
        }
 
        // Method name: delete
        // Purpose: Finding an employee from the list and remove it
        public static void delete(String first, String last) {
                ArrayList<Integer> sames = new ArrayList<Integer>();
                ArrayList<Employee> samesEmp = new ArrayList<Employee>();
 
                int count = 0;
                // Runs for loop through the employee list, counting the number of
                // profiles with that name
                for (Employee e : emps) {
                        if (e.getLastName().equalsIgnoreCase(last)
                                        && e.getFirstName().equalsIgnoreCase(first)) {
                                sames.add(new Integer(count));
                                samesEmp.add(e);
                        }
                        count++;
                }
                // if count is 0, name is invalid
                if (sames.size() == 0) {
                        infoBox("Sorry, employee could not be found", "Delete Profile");
                        // if count is 1, remove that profile
                } else if (sames.size() == 1) {
                        emps.remove((int) sames.get(0));
                        infoBox("Employee deleted", "Delete Profile");
                        // if count is greater than 1, prompt user choice and then delete
                        // that choice
                } else if (sames.size() > 1) {
                        Object[] possibilities = new Object[samesEmp.size()];
                        int counter = 0;
                        for (Employee e : samesEmp) {
                                possibilities[counter] = Integer.toString(e.getEmpNum());
                                counter++;
                        }
                        String number = (String) JOptionPane
                                        .showInputDialog(
                                                        frame,
                                                        "Which "
                                                                        + first
                                                                        + " "
                                                                        + last
                                                                        + " do you want to delete?\nChoose from the employee numbers listed below",
                                                        "Delete", JOptionPane.QUESTION_MESSAGE, null,
                                                        possibilities, "Employee Number...");
                        if (number == null) {
                                return;
                        }
                        int countess = 0;
                        for (Employee e : emps) {
                                if (e.getLastName().equalsIgnoreCase(last)
                                                && e.getFirstName().equalsIgnoreCase(first)
                                                && e.getEmpNum() == Integer.parseInt(number)) {
                                        emps.remove(countess);
                                }
                                countess++;
                        }
                        infoBox("Employee deleted", "Delete Profile");
                }
        }
 
        public static void write(ArrayList<Employee> employeeList)
        // throw IOException
                        throws IOException {
 
                BufferedWriter bw = null;
                try {
                        // constructs new file named "HRData.txt"
                        File file = new File("HRData.txt");
                        // If file does not exist already, create new file
                        if (!file.exists()) {
                                file.createNewFile();
                        }
 
                        FileWriter fw = new FileWriter(file.getAbsoluteFile());
                        bw = new BufferedWriter(fw);
                        // for the contents of the employee list
                        for (Employee e : employeeList) {
                                // input information with ">" concatenated
                                bw.write(e.getFirstName().trim() + ">");
                                bw.write(e.getLastName() + ">");
                                bw.write(e.getAge() + ">");
                                if (e.isSex() == true) {
                                        bw.write("yes>");
                                } else {
                                        bw.write("no>");
                                }
                                bw.write(e.getEducation() + ">");
                                bw.write(e.getSIN() + ">");
 
                                bw.write(e.getEmpNum() + ">");
                                bw.write(e.getAddress() + ">");
                                bw.write(e.getDoB() + ">");
                                bw.write(e.getPhoneNumber() + ">");
                                bw.write(e.geteMail() + ">");
                                if (e.isActive() == true) {
                                        bw.write("yes>");
                                } else {
                                        bw.write("no>");
                                }
                                if (e.isMarried() == true) {
                                        bw.write("yes>");
                                } else {
                                        bw.write("no>");
                                }
 
                                bw.write(e.getVacDays() + ">");
                                bw.write(e.getSicDays() + ">");
                                bw.write(e.getSalary() + ">");
                                if (e.isCrimRec() == true) {
                                        bw.write("yes>");
                                } else {
                                        bw.write("no>");
                                }
                                bw.write(e.getDepartment() + ">");
                                bw.write(e.getHoursWorked() + ">");
                        }
                        bw.close();
 
                        infoBox("Save Successful!", "Save");
                        // catch IOException, system output to user
                } catch (IOException e) {
                        infoBox("Save Incomplete: Sorry, something went wrong while saving",
                                        "Save");
                } finally {
                        if (bw != null) {
                                bw.close();
                        }
 
                }
 
        }
 
        // Method name: read
        // Purpose: Reading text file
        @SuppressWarnings("resource")
        public static void read(ArrayList<Employee> newList) {
 
                Scanner s = null;
 
                try {
                        File file = new File("HRData.txt");
                        // construct new scanner, with delimiter that splits at ">" while
                        // scanning
                        s = new Scanner(new BufferedReader(new FileReader(file)))
                                        .useDelimiter("\\s*>\\s*");
                        // while scanner has more tokens
                        while (s.hasNext()) {
                                // find and return next complete token to variable
                                String firstName = s.next();
                                String lastName = s.next();
                                int age = s.nextInt();
                                boolean sex;
                                String in = s.next();
                                // if next complete token reads "yes" sex equals true
                                if (in.equals("yes")) {
                                        sex = true;
                                        // else sex equals false
                                } else {
                                        sex = false;
                                }
                                String education = s.next();
                                int SIN = s.nextInt();
                                int empNum = s.nextInt();
                                String address = s.next();
                                String DoB = s.next();
                                String phoneNumber = s.next();
                                String eMail = s.next();
                                boolean isActive = true;
                                in = s.next();
                                // if next complete token reads "yes" active equals true
                                if (in.equals("yes")) {
                                        isActive = true;
                                } else {
                                        isActive = false;
                                }
                                boolean isMarried;
                                in = s.next();
                                // if next complete token reads "yes" married equals true
                                if (in.equals("yes")) {
                                        isMarried = true;
                                } else {
                                        isMarried = false;
                                }
                                int vacDays = s.nextInt();
                                int sicDays = s.nextInt();
                                double salary = s.nextDouble();
                                boolean crimRec = false;
                                in = s.next();
                                // if next complete token reads "yes" crimial record equals true
                                if (in.equals("yes")) {
                                        crimRec = true;
                                } else {
                                        crimRec = false;
                                }
                                String department = s.next();
                                int hoursWorked = s.nextInt();
                                // Creates the employee object with the arguments, and puts into
                                // arraylist
                                newList.add(new Employee(firstName, lastName, age, sex,
                                                education, SIN, empNum, address, DoB, phoneNumber,
                                                eMail, isActive, isMarried, vacDays, sicDays, salary,
                                                crimRec, department, hoursWorked));
                        }
                        // catch InputMismatchException, system output to user
                } catch (InputMismatchException e) {
                        display.setText("Some data in the file is invalid...");
                        // catch FileNotFoundException, system output to user
                } catch (FileNotFoundException e) {
                        display.setText("Sorry, save file could not be found...");
                } finally {
                        if (s != null) {
                                s.close();
                        }
 
                }
 
        }
 
        // Makes a pop-up box with a message (infoMessage) and title of box
        // (location)
        public static void infoBox(String infoMessage, String location) {
                JOptionPane.showMessageDialog(null, infoMessage, location,
                                JOptionPane.INFORMATION_MESSAGE);
        }
 
        public static String inputBox() {
                String s = (String) JOptionPane.showInputDialog(frame,
                                "Enter the full name of the employee");
                return s;
        }
 
        public static String comboInputBox() {
                Object[] possibilities = { "Age", "First Name", "Last Name",
                                "Vacation Days", "Sick Days", "Salary", "Sex", "Department",
                                "Address", "Marital Status", "Employee Number", "Email",
                                "Date of Birth", "Criminal Record", "Phone Number",
                                "Education", "SIN",  "Active or Suspended",
                                "Hours Worked Per Week" };
                String s = (String) JOptionPane.showInputDialog(frame,
                                "What characteristic would you like?",
                                "Characteristic choice", JOptionPane.PLAIN_MESSAGE, null,
                                possibilities, "Choose one");
                return s;
        }
 
        // Method name: doubleExceptions
        // Purpose: Exceptions for double inputs
        public static double doubleExceptions(String question) {
                boolean goFast = true;
                double ret = 0;
                while (goFast == true) {
                        try {
                                goFast = false;
                                ret = Double.parseDouble(JOptionPane.showInputDialog(frame,
                                                question));
                        } catch (NumberFormatException e) {
                                goFast = true;
                                infoBox("Invalid input.\n Please try again.", "Edit Profile");
                        } finally {
 
                        }
                }
 
                return ret;
        }
 
        // Method name: intExceptions
        // Purpose: Exceptions for integer input
        public static int intExceptions(String question) {
                boolean goFast = true;
                int ret = 0;
                while (goFast == true) {
                        try {
                                goFast = false;
                                ret = Integer.parseInt(JOptionPane.showInputDialog(frame,
                                                question));
                        } catch (NumberFormatException e) {
                                goFast = true;
                                infoBox("Invalid input.\n Please try again.", "Edit Profile");
                        } finally {
 
                        }
                }
 
                return ret;
        }
 
        public static String editor(String question) {
                String ret = JOptionPane.showInputDialog(frame, question);
                return ret;
        }
 
        private static void createAndShowGUI() throws IOException,
                        URISyntaxException {
                // Create and set up the window.
                frame = new JFrame("Human Resources Database");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
                // Add contents to the window.
                frame.getContentPane().add(new HRFINALL());
 
                // Display the window.
                frame.setSize(725, 500);
                frame.pack();
                frame.setVisible(true);
 
                emps = new ArrayList<Employee>();
                // reads from file
                read(emps);
                birthday(emps);
        }
 
        public static void main(String[] args) {
                // Schedule a job for the event dispatch thread:
                // creating and showing this application's GUI.
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                                try {
                                        createAndShowGUI();
                                } catch (IOException e) {
                                } catch (URISyntaxException e) {
                                }
                        }
                });
        }
 
        // Name: Employee Class
        // Purpose: Stores employee information
        public static class Employee {
                private String firstName;
                private String lastName;
                private int age;
                private boolean sex;
                private String education;
                private int SIN;
                private int empNum;
                private String address;
                private String DoB;
                private String phoneNumber;
                private String eMail;
                private boolean isActive;
                private boolean isMarried;
                private int vacDays;
                private int sicDays;
                private double salary;
                private boolean crimRec;
                private String department;
                private int hoursWorked;
 
                // Constructors
                private Employee(String firstName, String lastName, int age,
                                boolean sex, String education, int sIN, int empNum,
                                String address, String doB, String phoneNumber, String eMail,
                                boolean isActive, boolean isMarried, int vacDays, int sicDays,
                                double salary, boolean crimRec, String department,
                                int hoursWorked) {
                        super();
                        this.firstName = firstName;
                        this.lastName = lastName;
                        this.age = age;
                        this.sex = sex;
                        this.education = education;
                        SIN = sIN;
                        this.empNum = empNum;
                        this.address = address;
                        DoB = doB;
                        this.phoneNumber = phoneNumber;
                        this.eMail = eMail;
                        this.isActive = isActive;
                        this.isMarried = isMarried;
                        this.vacDays = vacDays;
                        this.sicDays = sicDays;
                        this.salary = salary;
                        this.crimRec = crimRec;
                        this.department = department;
                        this.hoursWorked = hoursWorked;
                }
 
                private Employee(String firstName, String lastName, int age,
                                boolean sex, String education, int empNum, String address,
                                String doB, String phoneNumber, boolean isActive,
                                boolean isMarried, int vacDays, int sicDays, double salary,
                                String department, int hoursWorked) {
                        super();
                        this.firstName = firstName;
                        this.lastName = lastName;
                        this.age = age;
                        this.sex = sex;
                        this.education = education;
                        this.empNum = empNum;
                        this.address = address;
                        DoB = doB;
                        this.phoneNumber = phoneNumber;
                        this.isActive = isActive;
                        this.isMarried = isMarried;
                        this.vacDays = vacDays;
                        this.sicDays = sicDays;
                        this.salary = salary;
                        this.department = department;
                        this.hoursWorked = hoursWorked;
                }
 
                private Employee(String firstName, String lastName, int age,
                                boolean sex, String education, int sIN, int empNum,
                                String address, String doB, String phoneNumber,
                                boolean isActive, boolean isMarried, int vacDays, int sicDays,
                                double salary, String department, int hoursWorked) {
                        super();
                        this.firstName = firstName;
                        this.lastName = lastName;
                        this.age = age;
                        this.sex = sex;
                        this.education = education;
                        SIN = sIN;
                        this.empNum = empNum;
                        this.address = address;
                        DoB = doB;
                        this.phoneNumber = phoneNumber;
                        this.isActive = isActive;
                        this.isMarried = isMarried;
                        this.vacDays = vacDays;
                        this.sicDays = sicDays;
                        this.salary = salary;
                        this.department = department;
                        this.hoursWorked = hoursWorked;
                }
 
                private Employee(String firstName, String lastName, int age,
                                boolean sex, String education, int empNum, String address,
                                String doB, String phoneNumber, String eMail, boolean isActive,
                                boolean isMarried, int vacDays, int sicDays, double salary,
                                String department, int hoursWorked) {
                        super();
                        this.firstName = firstName;
                        this.lastName = lastName;
                        this.age = age;
                        this.sex = sex;
                        this.education = education;
                        this.empNum = empNum;
                        this.address = address;
                        DoB = doB;
                        this.phoneNumber = phoneNumber;
                        this.eMail = eMail;
                        this.isActive = isActive;
                        this.isMarried = isMarried;
                        this.vacDays = vacDays;
                        this.sicDays = sicDays;
                        this.salary = salary;
                        this.department = department;
                        this.hoursWorked = hoursWorked;
                }
 
                private Employee(String firstName, String lastName, int age,
                                boolean sex, String education, int empNum, String address,
                                String doB, String phoneNumber, boolean isActive,
                                boolean isMarried, int vacDays, int sicDays, double salary,
                                boolean crimRec, String department, int hoursWorked) {
                        super();
                        this.firstName = firstName;
                        this.lastName = lastName;
                        this.age = age;
                        this.sex = sex;
                        this.education = education;
                        this.empNum = empNum;
                        this.address = address;
                        DoB = doB;
                        this.phoneNumber = phoneNumber;
                        this.isActive = isActive;
                        this.isMarried = isMarried;
                        this.vacDays = vacDays;
                        this.sicDays = sicDays;
                        this.salary = salary;
                        this.crimRec = crimRec;
                        this.department = department;
                        this.hoursWorked = hoursWorked;
                }
 
                private Employee(String firstName, String lastName, int age,
                                boolean sex, String education, int sIN, int empNum,
                                String address, String doB, String phoneNumber, String eMail,
                                boolean isActive, boolean isMarried, int vacDays, int sicDays,
                                double salary, String department, int hoursWorked) {
                        super();
                        this.firstName = firstName;
                        this.lastName = lastName;
                        this.age = age;
                        this.sex = sex;
                        this.education = education;
                        SIN = sIN;
                        this.empNum = empNum;
                        this.address = address;
                        DoB = doB;
                        this.phoneNumber = phoneNumber;
                        this.eMail = eMail;
                        this.isActive = isActive;
                        this.isMarried = isMarried;
                        this.vacDays = vacDays;
                        this.sicDays = sicDays;
                        this.salary = salary;
                        this.department = department;
                        this.hoursWorked = hoursWorked;
                }
 
                private Employee(String firstName, String lastName, int age,
                                boolean sex, String education, int empNum, String address,
                                String doB, String phoneNumber, String eMail, boolean isActive,
                                boolean isMarried, int vacDays, int sicDays,
                                double salary, boolean crimRec, String department,
                                int hoursWorked) {
                        super();
                        this.firstName = firstName;
                        this.lastName = lastName;
                        this.age = age;
                        this.sex = sex;
                        this.education = education;
                        this.empNum = empNum;
                        this.address = address;
                        DoB = doB;
                        this.phoneNumber = phoneNumber;
                        this.eMail = eMail;
                        this.isActive = isActive;
                        this.isMarried = isMarried;
                        this.vacDays = vacDays;
                        this.sicDays = sicDays;
                        this.salary = salary;
                        this.crimRec = crimRec;
                        this.department = department;
                        this.hoursWorked = hoursWorked;
                }
 
                // Getters and setters for each variable
                private String getFirstName() {
                        return firstName;
                }
 
                private void setFirstName(String firstName) {
                        this.firstName = firstName;
                }
 
                private String getLastName() {
                        return lastName;
                }
 
                private void setLastName(String lastName) {
                        this.lastName = lastName;
                }
 
                private int getAge() {
                        return age;
                }
 
                private void setAge(int age) {
                        this.age = age;
                }
 
                private boolean isSex() {
                        return sex;
                }
 
                private void setSex(boolean sex) {
                        this.sex = sex;
                }
 
                private String getEducation() {
                        return education;
                }
 
                private void setEducation(String education) {
                        this.education = education;
                }
 
                private int getSIN() {
                        return SIN;
                }
 
                private void setSIN(int sIN) {
                        SIN = sIN;
                }
 
                private int getEmpNum() {
                        return empNum;
                }
 
                private void setEmpNum(int empNum) {
                        this.empNum = empNum;
                }
 
                private String getAddress() {
                        return address;
                }
 
                private void setAddress(String address) {
                        this.address = address;
                }
 
                private String getDoB() {
                        return DoB;
                }
 
                private void setDoB(String doB) {
                        DoB = doB;
                }
 
                private String getPhoneNumber() {
                        return phoneNumber;
                }
 
                private void setPhoneNumber(String phoneNumber) {
                        this.phoneNumber = phoneNumber;
                }
 
                private String geteMail() {
                        return eMail;
                }
 
                private void seteMail(String eMail) {
                        this.eMail = eMail;
                }
 
                private boolean isActive() {
                        return isActive;
                }
 
                private void setActive(boolean isActive) {
                        this.isActive = isActive;
                }
 
                private boolean isMarried() {
                        return isMarried;
                }
 
                private void setMarried(boolean isMarried) {
                        this.isMarried = isMarried;
                }
 
                private int getVacDays() {
                        return vacDays;
                }
 
                private void setVacDays(int vacDays) {
                        this.vacDays = vacDays;
                }
 
                private int getSicDays() {
                        return sicDays;
                }
 
                private void setSicDays(int sicDays) {
                        this.sicDays = sicDays;
                }
 
                private double getSalary() {
                        return salary;
                }
 
                private void setSalary(double salary) {
                        this.salary = salary;
                }
 
                private boolean isCrimRec() {
                        return crimRec;
                }
 
                private void setCrimRec(boolean crimRec) {
                        this.crimRec = crimRec;
                }
 
                private String getDepartment() {
                        return department;
                }
 
                private void setDepartment(String department) {
                        this.department = department;
                }
 
                private int getHoursWorked() {
                        return hoursWorked;
                }
 
                private void setHoursWorked(int hoursWorked) {
                        this.hoursWorked = hoursWorked;
                }
 
        }
 
}

