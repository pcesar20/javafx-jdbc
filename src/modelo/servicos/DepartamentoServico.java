package modelo.servicos;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartamentoServico {

	private DepartmentDao dao = DaoFactory.createDepartmentDao();
	
	public List<Department> findAll() {
		return dao.findAll();
	
//	public List<Department> findAll(){
//		return dao.findAll()
	}
}
	