package Repository;

import Domain.signup;
import ConnectionDB.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class signupRepo {
    private PreparedStatement ps;
    private ResultSet rs;

    public signup createStudent(signup signup) {
        String query = "insert into signup(id,name,surname,email,student_number,student_department,registration_year) value (?,?,?,?,?,?,?)";
        try {
            ps = DBConnection.getConnection().prepareStatement(query);
            ps.setInt(1, signup.getId());
            ps.setString(2, signup.getName());
            ps.setString(3, signup.getSurname());
            ps.setString(4, signup.getEmail());
            ps.setInt(5, signup.getStudentID());
            ps.setString(6, signup.getStudentDepartment());
            ps.setInt(7, signup.getRegistrationYear());
            ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeAll(ps);
        }
        return signup;
    }

    public List<signup> getSignUp() {
        List<signup> studentList = new ArrayList<>();
        String sql = "select * from signup";
        try {
            ps = DBConnection.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                signup signup = new signup();
                signup.setId(rs.getInt(1));
                signup.setName(rs.getString(2));
                signup.setSurname(rs.getString(3));
                signup.setEmail(rs.getString(4));
                signup.setStudentID(rs.getInt(5));
                signup.setStudentDepartment(rs.getString(6));
                signup.setRegistrationYear(rs.getInt(7));
                studentList.add(signup);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeAll(ps);
        }
        return studentList;
    }

}