package AppRegister.application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import App.DAO.RegisterDAO;
import App.entitites.Register;
import App.DAO.FactoryDAO;

public class Program {
    public static void main(String[] args) throws SQLException{
        Scanner scanner = new Scanner(System.in);
		RegisterDAO registerDao = FactoryDAO.createRegisterDAO();
		
		System.out.println("------------------------------------------------------");
		System.out.println("TEST 1: Register FIND BY ID");
		Register register = registerDao.findByID(5);// Selecionar o valor para encontrar no banco de dados
		System.out.println(register);
		System.out.println();
        List<Register> list = new ArrayList<>();

		System.out.println("------------------------------------------------------");
		System.out.println();
		System.out.println("TEST 2: Register FIND ALL");
		System.out.println();
		list = registerDao.findAll();
		
		for(Register obj : list) { // for each
			System.out.println(obj);
		}
		System.out.println("------------------------------------------------------");
		System.out.println();
		System.out.println("TEST 3: Register INSERT"); // Adicionando um id com insert
		Register newRegister = new Register(null, "Greg", "greg@gmail.com", new Date(), 1894215623,12331549,4000.0, register.getDepartment(),register.getDepartmentId());
		registerDao.insert(newRegister);
		System.out.println("Insert register id: " + newRegister.getId());
		
		System.out.println("------------------------------------------------------");
		System.out.println();
		System.out.println("TEST 4: Register UPDATE"); // Adicionando um id com insert
		register = registerDao.findByID(2); // id do name
		register.setName("Laurence");
		registerDao.update(register);
		System.out.println("UPDATE COMPLETE!");
		
		System.out.println("------------------------------------------------------");
		System.out.println();
		System.out.println("TEST 5: Register DELETE"); // Adicionando um id com insert
		System.out.print("Insert a id to delete: ");
		int id = scanner.nextInt();
		registerDao.deleteByID(id);
		System.out.print("DELETE COMPLETE!");
		
		scanner.close();
    }  
}
