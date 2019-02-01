package ly.abinash.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ly.abinash.dtos.LoginDto;
import ly.abinash.entities.CustomerLoginEntity;
import ly.abinash.repositories.CustomerLoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private CustomerLoginRepository customerLoginRepository;

	public boolean login(LoginDto loginDto) {
		CustomerLoginEntity loginEntity = customerLoginRepository.getLoginByUsername(loginDto.getUsername());
		if(loginEntity == null) {
			System.out.println("Username : " + loginDto.getUsername() + " doesnt exist.");
			return false;
		} else {
			String hashedUserPassword = DigestUtils.sha256Hex(loginDto.getPassword());
			if(hashedUserPassword.equals(loginEntity.getPassword())) {
				System.out.println(" Login Successful");
				return true;
			} else {
				System.out.println("Password didnt match.");
				return false;
			}
		}
	}
	
}
