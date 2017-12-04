package com.mvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * 没有整合Spring MVC，没有通过注解配置，比较繁琐
 */
public class CatController extends AbstractController {
    private  ICatService catService;
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
       String action= httpServletRequest.getParameter("action");
       if("add".equals(action)) {
           return this.add(httpServletRequest,httpServletResponse);
       }
        return this.list(httpServletRequest,httpServletResponse);
    }

    protected ModelAndView list(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception{
        List<Cat> catList=catService.listCats();
        httpServletRequest.setAttribute("catList",catList);
        return  new ModelAndView("cat/listCat");
    }

    protected ModelAndView add(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception{
           Cat cat=new Cat();
           cat.setName(httpServletRequest.getParameter("name"));
           cat.setCreatedDate(new Date());
           catService.createCat(cat);
           return  new ModelAndView("cat/listCat","cat",cat);

    }

    public ICatService getCatService(){
        return catService;
    }

    public void setCatService(ICatService CatService){
        this.catService=catService;
    }

}
