package org.tague.invertoryservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Product{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//incrementation de +1 en bdd
	private Long id;
	private String name;
	private double price;
}

@RepositoryRestResource
interface ProductRepository extends JpaRepository<Product, Long> {
}
@Projection(name = "p1", types = Product.class)
interface ProductProjection{
	public Long getId();
	public String getName();
}
@SpringBootApplication
public class InvertoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvertoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration){
		return args -> {
			//exposer les id d'une classe
			repositoryRestConfiguration.exposeIdsFor(Product.class);
			productRepository.save(new Product(null,"ordianteur", 2));
			productRepository.save(new Product(null,"telepone", 32));
			productRepository.save(new Product(null,"montre", 522));
			productRepository.findAll().forEach(System.out::println);
		};


	}

}
