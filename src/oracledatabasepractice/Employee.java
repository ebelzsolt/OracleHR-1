package oracledatabasepractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

/**
 *
 * @author Ébel Zsolt
 */
public class Employee implements connectionData {

    private int employeeID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date date;
    private String jobID;
    private Integer salary;
    private Integer commissionPCT;
    private Integer managerID;
    private Integer departmentID;

    public Employee() {
    }

    public Employee(int employeeID, String firstName, String lastName, 
            String email, String phoneNumber, Date date, String jobID, 
            Integer salary, Integer commissionPCT, Integer managerID, 
            Integer departmentID) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.jobID = jobID;
        this.salary = salary;
        this.commissionPCT = commissionPCT;
        this.managerID = managerID;
        this.departmentID = departmentID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getJobID() {
        return jobID;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getCommissionPCT() {
        return commissionPCT;
    }

    public void setCommissionPCT(Integer commissionPCT) {
        this.commissionPCT = commissionPCT;
    }

    public Integer getManagerID() {
        return managerID;
    }

    public void setManagerID(Integer managerID) {
        this.managerID = managerID;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }   

    public void insertEmployeeToDatabase() {
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String insertStmt = "INSERT INTO EMPLOYEES "
                    + "(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, "
                    + "EMAIL, PHONE_NUMBER, HIRE_DATE, "
                    + "JOB_ID, SALARY, COMMISSION_PCT, "
                    + "MANAGER_ID, DEPARTMENT_ID) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insertStmt);
            ps.setInt(1, getEmployeeID());
            ps.setString(2, getFirstName());
            ps.setString(3, getLastName());
            ps.setString(4, getEmail());
            ps.setString(5, getPhoneNumber());                        
            ps.setDate(6, getDate());
            ps.setString(7, getJobID());
            ps.setInt(8, getSalary());
            ps.setInt(9, getCommissionPCT());
            ps.setInt(10, getManagerID());
            ps.setInt(11, getDepartmentID());
            ps.executeUpdate();

        } catch (ClassNotFoundException ex) {
            System.out.println("An error has occured! I cannot find driver!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("An error has occured while closing database connection!");
            }
        }
    }
}
