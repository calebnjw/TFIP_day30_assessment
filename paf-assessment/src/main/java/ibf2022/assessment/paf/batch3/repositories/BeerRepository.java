package ibf2022.assessment.paf.batch3.repositories;

import java.util.LinkedList;
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

		final String STYLES_QUERY = """
				SELECT
					styles.id AS styleId,
					styles.style_name AS name,
					COUNT(styles.id) as beerCount
				FROM beers
				INNER JOIN styles ON beers.style_id=styles.id
				GROUP BY styles.id
				ORDER BY COUNT(styles.id) DESC;
				""";

		// ref. Nilesh:
		// create mapper to convert from jdbc rowset
		// to style object, and return as a list
		List<Style> styles = template.query(STYLES_QUERY, new StyleRowMapper(), new Object[] {});

		return styles;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public List<Beer> getBreweriesByBeer(Integer styleId) {
		// TODO: Task 3

		final String BEERS_QUERY = """
				SELECT
					beers.id AS beerId,
					beers.name AS beerName,
					beers.descript AS beerDescription,
					beers.brewery_id AS breweryId,
					breweries.name AS breweryName
				FROM beers
				INNER JOIN breweries ON beers.brewery_id=breweries.id AND beers.style_id=?
				ORDER BY beers.name ASC;
				""";

		List<Beer> beers = template.query(BEERS_QUERY, new BeerRowMapper(), new Object[] { styleId });

		return beers;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public Optional<Brewery> getBeersFromBrewery(Integer breweryId) {
		// TODO: Task 4

		breweryId;
	private String name;
	private String address1;
	private String address2;
	private String city;
	private String phone;
	private String website;
	private String description;
	private List<Beer> beers = new LinkedList<>();

		final String BEERS_QUERY = """
				SELECT
					breweries.id AS breweryId,
					breweries.name AS name,
					breweries.address1 AS address1,
					breweries.address2 AS address2,
					breweries.city AS city,
					breweries.phone AS phone,
					breweries.website AS website,
					breweries.descript AS description,
				FROM breweries
				INNER JOIN breweries ON beers.brewery_id=breweries.id AND beers.style_id=?
				ORDER BY beers.name ASC;
				""";

		List<Beer> beers = template.query(BEERS_QUERY, new BeerRowMapper(), new Object[] { styleId });

		return beers;

		return Optional.empty();
	}
}
