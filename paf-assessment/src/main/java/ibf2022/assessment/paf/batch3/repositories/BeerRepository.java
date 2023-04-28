package ibf2022.assessment.paf.batch3.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.assessment.paf.batch3.mappers.StyleRowMapper;
import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.Style;

@Repository
public class BeerRepository {

	@Autowired
	JdbcTemplate template;

	// DO NOT CHANGE THE SIGNATURE OF THIS METHOD
	public List<Style> getStyles() {
		// TODO: Task 2

		String STYLES_QUERY = """
				SELECT styles.id AS styleId, styles.style_name AS name, COUNT(styles.id) as beerCount FROM beers INNER JOIN styles ON beers.style_id=styles.id GROUP BY styles.id ORDER BY COUNT(styles.id) DESC;
				""";

		// ref. Nilesh:
		// create mapper to convert from jdbc rowset
		// to style object, and return as a list
		List<Style> styles = template.query(STYLES_QUERY, new StyleRowMapper(), new Object[] {});

		return styles;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public List<Beer> getBreweriesByBeer(/* You can add any number parameters here */) {
		// TODO: Task 3

		return null;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public Optional<Brewery> getBeersFromBrewery(/* You can add any number of parameters here */) {
		// TODO: Task 4

		return Optional.empty();
	}
}
