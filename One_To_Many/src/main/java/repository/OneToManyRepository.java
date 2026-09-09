package repository;

import java.util.ArrayList;
import java.util.List;

import entity.Account;
import entity.Bank;
import exception.BankNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class OneToManyRepository {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vishal");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public Bank findBankById(int id) {

		Bank bank = em.find(Bank.class, id);

		if (bank != null) {
			return bank;
		} else {
			throw new BankNotFoundException("Bank not found");
		}

		

	}

	public void findAllBankAccount() {

		String q1 = "select bank from Bank bank ";

		Query query1 = em.createQuery(q1);
		List<Bank> banks = query1.getResultList();
		for (Bank bank : banks) {
			System.out.println(bank);
			System.out.println(bank.getAccounts());
		}

	}

	public void updateBankAccount(int id, String ifsc, long ac_no) {
		try {
			et.begin();

			Bank bank = findBankById(id);
			bank.setIfsc(ifsc);
			List<Account> accounts = bank.getAccounts();
			accounts.get(0).setAc_no(ac_no);

			et.commit();

			System.out.println("updated");
			
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}

	}
	
	public void removeBankAccount(int id) {
		try {
			et.begin();
			Bank bank = findBankById(id);
			List<Account> accounts = bank.getAccounts();
			for (Account account : accounts) {
				em.remove(account);
			}
			em.remove(bank);
			et.commit();
			System.out.println("all bank and account data removed");
			
			
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
	}
	
	public void createBankAccount() {
		et.begin();
		Bank bank = findBankById(2);
		Account account = new Account(89899,"vishnu");
		
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(account);
		bank.setAccounts(accounts);
		
		em.persist(account);
		et.commit();
		
	}

}
