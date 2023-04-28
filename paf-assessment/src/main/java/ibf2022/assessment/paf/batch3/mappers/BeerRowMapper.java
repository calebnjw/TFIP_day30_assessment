package ibf2022.assessment.paf.batch3.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ibf2022.assessment.paf.batch3.models.Beer;

public class BeerRowMapper implements RowMapper<Beer> {
  @Override
  public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {
    Beer beer = new Beer();

    beer.setBeerId(rs.getInt("beerId"));
    beer.setBeerName(rs.getString("beerName"));
    beer.setBeerDescription(rs.getString("beerDescription"));
    beer.setBreweryId(rs.getInt("breweryId"));
    beer.setBreweryName(rs.getString("breweryName"));

    return beer;
  }
}
