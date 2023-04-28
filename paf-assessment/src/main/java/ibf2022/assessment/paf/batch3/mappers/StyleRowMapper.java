package ibf2022.assessment.paf.batch3.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ibf2022.assessment.paf.batch3.models.Style;

public class StyleRowMapper implements RowMapper<Style> {
  @Override
  public Style mapRow(ResultSet rs, int rowNum) throws SQLException {
    Style style = new Style();

    style.setStyleId(rs.getInt("styleId"));
    style.setName(rs.getString("name"));
    style.setBeerCount(rs.getInt("beerCount"));

    return style;
  }

}
