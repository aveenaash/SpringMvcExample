package ly.abinash.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ly.abinash.dtos.RegisterDto;
import ly.abinash.entities.CustomerEntity;
import ly.abinash.entities.CustomerLoginEntity;
import ly.abinash.repositories.CustomerLoginRepository;

@Service
public class RegisterService {

	@Autowired
	private CustomerLoginRepository customerLoginRepository;

	public void registerUser(RegisterDto registerDto) throws Exception {
		CustomerEntity customer = new CustomerEntity();
		customer.setFirstName(registerDto.getFirstname());
		customer.setLastName(registerDto.getLastname());
		customer.setAddress(registerDto.getAddress());
		customer.setPhone(String.valueOf(registerDto.getPhone()));
		customer.setEmail(registerDto.getEmail());
		customer.setGender(String.valueOf(registerDto.getGender()));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dob = (Date) sdf.parse(registerDto.getDob());
		customer.setDob(dob);

		CustomerLoginEntity login = new CustomerLoginEntity();
		login.setUserName(registerDto.getUsername());
		String hashedPassword = DigestUtils.sha256Hex(registerDto.getPassword());
		login.setPassword(hashedPassword);

		login.setCustomer(customer);

		customerLoginRepository.save(login);

	}
}
