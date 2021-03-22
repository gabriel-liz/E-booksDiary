package br.univille.ebooksdiary;

import org.springframework.stereotype.Component;

@Component
public class StartupEventListenerBean {
	
	/*
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		City city = cityRepository.findByName("Joinville");
		if(city == null) {
			city = new City();
			city.setName("Joinville");
			city.setState("SC");
			cityRepository.save(city);
		} 

		if(userRepository.findByUsername("user") == null) {
			User user = new User();
			user.setName("Usuário comum");
			user.setUsername("user");
			user.setPassword(passwordEncoder.encode("user"));
			user.setType("ROLE_USER");
			user.setCity(city);
			userRepository.save(user);
		}

		if(userRepository.findByUsername("admin") == null) {
			User user = new User();
			user.setName("Administrador");
			user.setUsername("admin");
			user.setPassword(passwordEncoder.encode("admin"));
			user.setType("ROLE_ADMIN");
			user.setCity(city);
			userRepository.save(user);
		}



	}
	*/
}
	