package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao =DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: Seller findById ===");
		
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("=== TEST 2: Seller findByDepartment ===");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 3: Seller findAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 4: Seller Insert ===");
		Seller newSeller = new Seller (null,"Greg","Greg@gmail.com",new Date(),4000.00,department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new id = " + newSeller.getId());
		
		System.out.println("=== TEST 5: Seller Update ===");
		seller = sellerDao.findById(1);
		seller.setName("Marta wayne");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("=== TEST 6: Seller Delete ===");
		System.out.println("Enter id for delete test");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		//////////////////////////////////////test Department ////
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TEST 1: findById =======");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: findAll =======");
		List<Department> listDep = departmentDao.findAll();
		for (Department d : listDep) {
			System.out.println(d);
		}

		System.out.println("\n=== TEST 3: insert =======");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());

		System.out.println("\n=== TEST 4: update =======");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: delete =======");
		System.out.print("Enter id for delete test: ");
		int idDep = sc.nextInt();
		departmentDao.deleteById(idDep);
		System.out.println("Delete completed");
		
		sc.close();
		
		
	}

}
