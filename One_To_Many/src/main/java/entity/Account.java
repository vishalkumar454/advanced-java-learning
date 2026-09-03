package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private long ac_no;
	private String accoutHolderName;

	public Account() {
	}

	public Account(long ac_no, String accoutHolderName) {
		this.ac_no = ac_no;
		this.accoutHolderName = accoutHolderName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getAc_no() {
		return ac_no;
	}

	public void setAc_no(long ac_no) {
		this.ac_no = ac_no;
	}

	public String getAccoutHolderName() {
		return accoutHolderName;
	}

	public void setAccoutHolderName(String accoutHolderName) {
		this.accoutHolderName = accoutHolderName;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", ac_no=" + ac_no + ", accoutHolderName=" + accoutHolderName + "]";
	}

	
}
