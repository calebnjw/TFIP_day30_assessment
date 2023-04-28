package ibf2022.assessment.paf.batch3.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.assessment.paf.batch3.mappers.BeerRowMapper;
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

		// create mapper to convert from jdbc rowset
		// to style object, and return as a list
		List<Style> styles = template.query(Queries.STYLES_QUERY, new StyleRowMapper(), new Object[] {});

		return styles;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public List<Beer> getBreweriesByBeer(Integer styleId) {
		// TODO: Task 3

		List<Beer> beers = template.query(Queries.BEERS_QUERY, new BeerRowMapper(), new Object[] { styleId });

		return beers;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public Optional<Brewery> getBeersFromBrewery(Integer breweryId) {
		// TODO: Task 4

		Brewery brewery = new Brewery();

		Object results = template.queryForList(Queries.BREWERIES_QUERY, new Object[] { breweryId });

		return Optional.of(brewery);
	}
}
