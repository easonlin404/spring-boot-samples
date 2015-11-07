package easonlin.hello.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import easonlin.hello.entity.Person;

@Controller
public class CRUDController {

	@RequestMapping(value = { "/persons", ",saveperson" }, method = RequestMethod.GET)
	public String listPersons(Model model) {
		List<Person> persons = new ArrayList<Person>();
		Person p1 = new Person("eason", 29);
		Person p2 = new Person("jack", 23);
		persons.add(p1);
		persons.add(p2);

		//model.addAttribute("person", new Person());
		model.addAttribute("listPersons", persons);

		return "hello";
	}

	
	@RequestMapping(value = "/person/save", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p) {

		//add person
		System.out.println("add persons");
		return "redirect:/persons";
	}
	
	/*
	@RequestMapping(value = {"/person/save"}, method = RequestMethod.POST)
    public String savePerson(@ModelAttribute("person") Person person,
            final RedirectAttributes redirectAttributes) {
		
		
		redirectAttributes.addFlashAttribute("saveEmployee", "success");
 
        return "redirect:/savepage";
    }

	@RequestMapping(value = "/person/{operation}/{pName}", method = RequestMethod.GET)
	public String editRemovePerson(@PathVariable("operation") String operation, @PathVariable("pName") String pName,
			final RedirectAttributes redirectAttributes, Model model) {
		if (operation.equals("delete")) {
			// delete success
			redirectAttributes.addFlashAttribute("deletion", "success");

		} else if (operation.equals("edit")) {
			return "editPage";
		}

		return "redirect:/savepage";
	}

	@RequestMapping(value = "/person/update", method = RequestMethod.POST)
	public String updatePerson(@ModelAttribute("editPerson") Person editPerson,
			final RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("edit", "success");
		return "redirect:/savepage";
	}
	
	*/
}