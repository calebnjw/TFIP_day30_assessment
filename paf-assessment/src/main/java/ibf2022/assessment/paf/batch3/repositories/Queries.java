package ibf2022.assessment.paf.batch3.repositories;

public class Queries {
  public static final String STYLES_QUERY = """
      SELECT
      	styles.id AS styleId,
      	styles.style_name AS name,
      	COUNT(styles.id) as beerCount
      FROM beers
      INNER JOIN styles ON beers.style_id=styles.id
      GROUP BY styles.id
      ORDER BY COUNT(styles.id) DESC;
      """;

  public static final String BEERS_QUERY = """
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

  public static final String BREWERIES_QUERY = """
      SELECT
      	breweries.id AS breweryId,
      	breweries.name AS name,
      	breweries.address1 AS address1,
      	breweries.address2 AS address2,
      	breweries.city AS city,
      	breweries.phone AS phone,
      	breweries.website AS website,
      	breweries.descript AS description,
      	beers.id AS beerId,
      	beers.name AS beerName,
      	beers.descript AS beerDescription
      FROM breweries
      INNER JOIN beers ON breweries.id=beers.brewery_id AND breweries.id=?;
      """;
}
