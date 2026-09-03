package repository;

import java.util.ArrayList;
import java.util.List;

import entity.Account;
import entity.Bank;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OneToManyRepository {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vishal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Bank bank = new Bank();
		bank.setName("SBI");
		bank.setIfsc("SBI1234");
		
		Account account1 = new Account();
		account1.setAc_no(123456789);
		account1.setAccoutHolderName("vishal");
		account1.setBank(bank);
		
		Account account2 = new Account();
		account2.setAc_no(6789);
		account2.setAccoutHolderName("rahul");
		account2.setBank(bank);
		
		Account account3 = new Account();
		account3.setAc_no(23456);
		account3.setAccoutHolderName("john");
		account3.setBank(bank);
		
		List<Account> account = new ArrayList<Account>();
		account.add(account1);
		account.add(account2);
		account.add(account3);
		
		
		bank.setAccounts(account);
		
		et.begin();
		em.persist(bank);
		for(Account acc : account) {
			em.persist(acc);
		}
		et.commit();
		
	}
	
	
}
