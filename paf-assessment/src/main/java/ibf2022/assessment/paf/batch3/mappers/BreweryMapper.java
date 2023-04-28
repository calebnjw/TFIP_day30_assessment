package ibf2022.assessment.paf.batch3.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Brewery;

public class BreweryMapper implements RowMapper<Brewery> {
  List<Beer> beers = new LinkedList<Beer>();

  @Override
  public Brewery mapRow(ResultSet rs, int rowNum) throws SQLException {
    Brewery brewery = new Brewery();

    brewery.setBreweryId(rs.getInt("breweryId"));
    brewery.setName(rs.getString("name"));
    brewery.setAddress1(rs.getString("address1"));
    brewery.setAddress2(rs.getString("address2"));
    brewery.setCity(rs.getString("city"));
    brewery.setPhone(rs.getString("phone"));
    brewery.setWebsite(rs.getString("website"));
    brewery.setDescription(rs.getString("description"));
    beers.add(Beer b = new Beer() -> 
      b.set
      
      );

    brewery.setBeers(beers);
    return brewery;
  }
}
