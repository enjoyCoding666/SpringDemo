package com.mvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

public class CatMultiController extends MultiActionController {

	private ICatService catService;

	public ICatService getCatService() {
		return catService;
	}

	public void setCatService(ICatService catService) {
		this.catService = catService;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) {

		Cat cat = new Cat();
		cat.setName(request.getParameter("name"));
		cat.setCreatedDate(new Date());

		catService.createCat(cat);

		return this.list(request, response);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) {

		List<Cat> catList = catService.listCats();

		request.setAttribute("catList", catList);

		return new ModelAndView("cat/listCat");
	}

}
