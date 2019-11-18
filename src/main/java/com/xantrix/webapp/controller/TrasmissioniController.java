package com.xantrix.webapp.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.xantrix.webapp.dao.RilevazioniDao;
import com.xantrix.webapp.domain.Trasmissioni;
import com.xantrix.webapp.entities.Rilevazioni;
import com.xantrix.webapp.service.GestTrasmissioni;
import com.xantrix.webapp.views.RilevazioniPdfView;

@Controller
@RequestMapping("/trasmissioni")
public class TrasmissioniController 
{
	@Autowired
	private RilevazioniDao rilevRepository;
	
	@Autowired
	private GestTrasmissioni gestTrasmissioni;
	
	private final String PathImages = "static\\trasmissioni\\";
	
	@RequestMapping(value = "/cerca/{filter}/download", method = RequestMethod.GET)
	public ModelAndView GetTrasmissioneByFilterDwld(@PathVariable("filter") String Filter, Model model)
	{
		List<Rilevazioni> recordset = rilevRepository.SelByIdTerminale(Filter);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("Rilevazioni", recordset);
		mav.setView(new RilevazioniPdfView());
	
		return mav;
	}
	
	@GetMapping(value = "/aggiungi")
	public String InsTrasmissione(Model model)
	{
		Trasmissioni trasmissione = new Trasmissioni();
		
		model.addAttribute("Titolo", "Inserimento Nuova Trasmissione");
		model.addAttribute("trasm", trasmissione);
		
		return "insTrasm";
	}
	
	@PostMapping(value="/aggiungi")
	public String GestInsTrasmissione(@ModelAttribute("Trasm") Trasmissioni trasmissione, 
			HttpServletRequest request)
	{
		
		MultipartFile fileTerminale = trasmissione.getFileTerminale();
		
		String NomeFile =  fileTerminale.getOriginalFilename();
		
		int rowNum = 0;
		
		if (fileTerminale != null && !fileTerminale.isEmpty())
		{
			try
			{
				String rootDirectory = request.getSession().getServletContext().getRealPath("/");
				String PathName = rootDirectory + PathImages + NomeFile;
				
				fileTerminale.transferTo(new File(PathName));
				
				rowNum = gestTrasmissioni.GestFile(rootDirectory + PathImages, NomeFile);		 
			} 
			catch (Exception ex)
			{
				throw new RuntimeException("Errore trasferimento file", ex);
			}
		}
		
		if (rowNum > 0)
			return "redirect:/trasmissioni/cerca/" + NomeFile.substring(0,5) + "/download";
		else
			return "";
	}
}
