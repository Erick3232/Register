package App.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import App.db.DB;
import App.entitites.Register;
import JDBC.db.DbException;

public class RegisterDaoJDBC implements RegisterDAO{
    private Connection conn;

    public RegisterDaoJDBC(Connection conn){
        this.conn = conn;
    }
    @Override
    public void insert(Register obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                "INSERT INTO register"
                + "(Name, Email, BirthDate, CPF, Phone, BaseSalary, Department, DepartmentId)"
                + "VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getName());
            st.setString(2, obj.getEmail());
            st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
            st.setInt(4, obj.getCPF());
            st.setInt(5, obj.getPhone());
            st.setDouble(6, obj.getBaseSalary());
            st.setString(7, obj.getDepartment());
            st.setInt(8, obj.getDepartmentId());
            
            int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				
				DB.closeResultSet(rs);
				
			} else {
				throw new DbException("Unexpected Error! No rows Affected");
			}

        } catch(SQLException e){
            throw new DbException(e.getMessage());
        } finally{
            DB.closeStatement(st);
        }

    }

    @Override
    public void update(Register obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                "UPDATE register "
                + "SET Name = ?, Email = ?, BirthDate = ?, CPF = ?, Phone = ?, BaseSalary = ?, Department = ?, DepartmentId = ? "
                + "WHERE Id = ?");

                st.setString(1, obj.getName());
                st.setString(2, obj.getEmail());
                st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
                st.setInt(4, obj.getCPF());
                st.setInt(5, obj.getPhone());
                st.setDouble(6, obj.getBaseSalary());
                st.setString(7, obj.getDepartment());
                st.setInt(8, obj.getDepartmentId());
                st.setInt(9, obj.getId());
        
                st.executeUpdate();
            } catch(SQLException e){
            throw new DbException(e.getMessage());
            } finally{
                DB.closeStatement(st);
            }   
    }

    @Override
    public void deleteByID(Integer id) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("DELETE FROM register WHERE Id = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch(SQLException e){
            throw new DbException(e.getMessage());
        } finally{
            DB.closeStatement(st);
        }
    }

    @Override
    public Register findByID(Integer id) {
       PreparedStatement st = null;
       ResultSet rs = null;
       try{
        st = conn.prepareStatement(
            "SELECT * FROM register WHERE Id = ?"
        );
        st.setInt(1, id);
        rs = st.executeQuery();

        if(rs.next()){
            Register obj = instantiateRegister(rs);
            return obj;
        }
        return null;

       } catch(SQLException e){
        throw new DbException(e.getMessage());
       } finally{
        DB.closeStatement(st);
        DB.closeResultSet(rs);
       }
    }

    @Override
    public List<Register> findAll() {
        PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM register ORDER BY Name");
			rs = st.executeQuery();
			
			List<Register> list = new ArrayList<>();
            while(rs.next()){
                Register obj = instantiateRegister(rs);
                list.add(obj);
            }
			return list; // sem vendedor/id	
	}
	catch(SQLException e) {
		throw new DbException(e.getMessage());
	} 
		finally {
		DB.closeStatement(st);
		DB.closeResultSet(rs);
		}
    }
    private Register instantiateRegister(ResultSet rs) throws SQLException{
		Register obj = new Register();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
        obj.setCPF(rs.getInt("CPF"));
        obj.setPhone(rs.getInt("Phone"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setDepartment(rs.getString("Department"));
        obj.setDepartmentId(rs.getInt("DepartmentId"));

		return obj;
	}
    
}
