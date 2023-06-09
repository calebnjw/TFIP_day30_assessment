package ibf2022.assessment.paf.batch3.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Brewery;

public class BreweryRowMapper implements RowMapper<Brewery> {

  Brewery brewery = new Brewery();

  @Override
  public Brewery mapRow(ResultSet rs, int rowNum) throws SQLException {

    brewery.setBreweryId(rs.getInt("breweryId"));
    brewery.setName(rs.getString("name"));
    brewery.setAddress1(rs.getString("address1"));
    brewery.setAddress2(rs.getString("address2"));
    brewery.setCity(rs.getString("city"));
    brewery.setPhone(rs.getString("phone"));
    brewery.setWebsite(rs.getString("website"));
    brewery.setDescription(rs.getString("description"));

    Beer beer = new Beer();
    beer.setBreweryId(rs.getInt("breweryId"));
    beer.setBreweryName(rs.getString("name"));
    beer.setBeerId(rs.getInt("beerId"));
    beer.setBeerName(rs.getString("beerName"));
    beer.setBeerDescription(rs.getString("beerDescription"));

    List<Beer> beers = brewery.getBeers();
    beers.add(beer);
    brewery.setBeers(beers);

    return brewery;
  }
}
