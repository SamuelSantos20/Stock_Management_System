package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Moviment;
import domain.Product;
import domain.User;
import dto.MovimentDto;
import enums.TypeMoviment;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import serviceImpl.IdentificationServiceImpl;
import serviceImpl.MovimentServiceImpl;
import serviceImpl.ProductServiceImpl;
import util.RelatorioUtil;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequiredArgsConstructor
public class MovimentController {

	private final ProductServiceImpl productServiceImpl;

	private final MovimentServiceImpl movimentServiceImpl;

	private final HttpServletRequest request;

	private final IdentificationServiceImpl identificationServiceImpl;

	private final RelatorioUtil relatorio;

	@GetMapping("/pre/register/moviment/products")
	@PreAuthorize("hasAnyRole('ADM')")
	public ModelAndView preRegisterMovimente() {

		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("moviment", new MovimentDto());
			mv.addObject("products", productServiceImpl.ListDtoProduct());
			mv.addObject("type", typesMoviments());
			mv.setViewName("movimentacao.html");
			return mv;

		} catch (Exception e) {

			System.out.println(e);
			mv.setViewName("redirect:/error");
			return mv;

		}

	}

	@PostMapping("/register/moviment/product")
	@PreAuthorize("hasAnyRole('ADM')")
	public ModelAndView RegisterMoviment(MovimentDto movimentDto, @RequestParam("producte") Long id_produto) {

		ModelAndView mv = new ModelAndView();

		try {
			saveMoviment(movimentDto, id_produto);
			mv.setViewName("redirect:/pre/register/moviment/products");
			return mv;

		} catch (Exception e) {
			System.out.println(e);
			mv.setViewName("redirect:/error");
			return mv;

		}

	}

	private void saveMoviment(MovimentDto movimentDto, Long id_produto) throws Exception {
		try {

			HttpSession session = request.getSession();

			Product products = productServiceImpl.ListId(id_produto);

			System.out.println(products);

			Integer amount = movimentDto.getAmount();

			String username = (String) session.getAttribute("username");
			User user = identificationServiceImpl.findByLoginSecurity(username);

			String typeMoviment = movimentDto.getType();

			Date date = movimentDto.getDate();

			if (products == null || amount == null || user == null || typeMoviment == null || date == null) {

				throw new Exception("values not present!");

			}

			Moviment moviment = new Moviment();

			moviment.setAmount(amount);
			moviment.setDate(date);
			moviment.setProduct(List.of(products));
			moviment.setType(typeMoviment);
			moviment.setUser(user);

			movimentServiceImpl.saveTheMoviment(moviment);

		} catch (Exception e) {

			System.out.println(e);
			throw new Exception("unknown error");

		}
	}

	@GetMapping("/list/moviments/product")
	@PreAuthorize("hasAnyRole('ADM')")
	public ModelAndView ListMovimnets() {

		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("moviments", movimentServiceImpl.ListMovimentsDto());
			mv.setViewName("relatorios.html");
			return mv;
		} catch (Exception e) {

			System.out.println(e);
			mv.setViewName("redirect:/error");
			return mv;

		}

	}

	
	@PostMapping("/pre/edit/moviment")
	@PreAuthorize("hasAnyRole('ADM')")
	public ModelAndView PreEdit(@RequestParam("edit_id") Long id) {
		ModelAndView mv = new ModelAndView();
		try {
			System.out.println(id);
			
			Moviment moviment = movimentServiceImpl.ListIdMoviment(id);
			
			mv.addObject("Moviments", moviment);
			mv.addObject("typeMoviment", typesMoviments());
			
			for(Product product : moviment.getProduct()) {
			
				mv.addObject("id_product",product.getId());
			
			}
			mv.setViewName("edit_moviment.html");
			mv.addObject("id", id);
			return mv;
			
			
		} catch (Exception e) {
			System.out.println(e);
			mv.setViewName("redirect:/error");
			return mv;
		}
	}
	
	
	
@PostMapping("/delete/moviment")
@PreAuthorize("hasAnyRole('ADM')")
public ModelAndView DeleteMoviment(@RequestParam("delete_id") Long id) {
    
	ModelAndView mv = new ModelAndView();
	
	try {
	
		movimentServiceImpl.deleteTheMoviment(id);
		mv.addObject("moviments", movimentServiceImpl.ListMovimentsDto());
		mv.setViewName("relatorios.html");
		return mv;
		
	} catch (Exception e) {
	
		System.out.println(e);
		mv.setViewName("redirect:/error");
		return mv;
		
	}
    
   
}

	
	
	
	
	@GetMapping("/print/relator/stock")
	@PreAuthorize("hasAnyRole('ADM')")
	public void PrintStock(HttpServletResponse response) {

		try {

			List<Moviment> list = movimentServiceImpl.ListTheMonimets();

			relatorio.gerarRelatoriocontato(response, list);

		} catch (Exception e) {

			System.out.println(e);

		}

	}
	
	
	
	
	

	private TypeMoviment[] typesMoviments() {

		return TypeMoviment.values();

	}

}
