package App.DAO;

import java.util.List;

import App.entitites.Register;

public interface RegisterDAO {
    void insert(Register obj);
	void update(Register obj);
	void deleteByID(Integer id);
	Register findByID(Integer id);
	List<Register> findAll(); 
}
