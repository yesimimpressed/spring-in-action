package sia.tacos.repository;

import org.springframework.data.repository.CrudRepository;

import sia.tacos.data.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {}
