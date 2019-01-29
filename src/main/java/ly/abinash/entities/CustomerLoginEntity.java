package ly.abinash.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_login")
public class CustomerLoginEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private CustomerEntity customer;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "last_signed_on")
	private Date lastSignedOn;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Date getLastSignedOn() {
		return lastSignedOn;
	}

	public void setLastSignedOn(Date lastSignedOn) {
		this.lastSignedOn = lastSignedOn;
	}

	@Override
	public String toString() {
		return "CustomerLoginEntity [id=" + id + ", customer=" + customer + ", userName=" + userName + ", password="
				+ password + ", lastSignedOn=" + lastSignedOn + "]";
	}
	
	
	
}
