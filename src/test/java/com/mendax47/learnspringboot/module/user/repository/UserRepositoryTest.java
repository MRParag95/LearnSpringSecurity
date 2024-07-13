package com.mendax47.learnspringboot.module.user.repository;

import com.mendax47.learnspringboot.module.user.User;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void findByUsernameOrEmail() {
		String username = "abc";
		String email = "abc";
		User expected = new User();
		User actual = userRepository.findByUsernameOrEmail(username, email);

		assertEquals(expected, actual);
	}
}
