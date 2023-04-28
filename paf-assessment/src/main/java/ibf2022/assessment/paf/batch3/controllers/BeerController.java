package ibf2022.assessment.paf.batch3.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.Style;
import ibf2022.assessment.paf.batch3.repositories.BeerRepository;

@Controller
public class BeerController {

	@Autowired
	BeerRepository beerRepo;

	// TODO Task 2 - view 0
	@GetMapping(path = "/")
	public String getStyles(Model model) {
		List<Style> styles = beerRepo.getStyles();
		model.addAttribute("styles", styles);

		return "view0";
	}

	// TODO Task 3 - view 1
	@GetMapping(path = "/beer/style/{styleId}")
	public String getBeersOfStyle(
			@PathVariable String styleId,
			@RequestParam String styleName,
			Model model) {

		List<Beer> beers = beerRepo.getBreweriesByBeer(Integer.parseInt(styleId));

		if (beers.size() == 0) {
			model.addAttribute("valid", false);
			model.addAttribute("styleName", "No beers found for this style.");
		} else {
			model.addAttribute("valid", false);
			model.addAttribute("styleName", styleName);
			model.addAttribute("beers", beers);
		}

		return "view1";
	}

	// TODO Task 4 - view 2
	@GetMapping(path = "/brewery/{breweryId}")
	public String getBrewery(
			@PathVariable String breweryId,
			@RequestParam String breweryName,
			Model model) {

		Optional<Brewery> brewery = beerRepo.getBeersFromBrewery(Integer.parseInt(breweryId));

		if (brewery.isEmpty()) {
			model.addAttribute("valid", false);
			model.addAttribute("breweryName", "Brewery not found.");
		} else {
			model.addAttribute("valid", true);
			model.addAttribute("breweryName", breweryName);
			model.addAttribute("brewery", brewery.get());
		}

		return "view2";
	}

	// TODO Task 5 - view 2, place order

}
