package controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import domain.Product;
import dto.ProductDto;
import enums.CategoryProduct;
import lombok.RequiredArgsConstructor;
import serviceImpl.ProductServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductController {

	private final ProductServiceImpl productServiceImpl;

	@GetMapping("/pre/register/product")
	@PreAuthorize("hasAnyRole('ADM')")
	public ModelAndView preRegister() {
		ModelAndView mv = new ModelAndView();

		try {
			mv.addObject("Product", new ProductDto());
			mv.addObject("category", categorys());
			mv.setViewName("adicionar_produto.html");
			return mv;

		} catch (Exception e) {

			System.out.println(e);
			mv.setViewName("redirect:/error");
			return mv;

		}
	}

	@PostMapping("/register/product")
	@PreAuthorize("hasAnyRole('ADM')")
	public ModelAndView RegisterPorduct(ProductDto productDto) {
		ModelAndView mv = new ModelAndView();
		try {

			saveProduct(productDto);
			mv.setViewName("redirect:/pre/register/product");
			return mv;

		} catch (Exception e) {

			System.out.println(e);
			mv.setViewName("redirect:/error");
			return mv;

		}

	}

	private void saveProduct(ProductDto productDto) throws Exception {

		try {

			String name = productDto.getName();

			Integer amount = productDto.getAmount();

			String category = productDto.getCategory();

			Double price = productDto.getPrice();

			System.out.println(name);
			System.out.println(amount);
			System.out.println(category);
			System.out.println(price);

			if (name == null || amount == null || category == null || price == null) {

				throw new Exception("values not present!");

			}

			Product product = new Product();

			product.setName(name);
			product.setCategory(category);
			product.setAmount(amount);
			product.setPrice(price);

			productServiceImpl.saveTheProduct(product);

		} catch (Exception e) {

			System.out.println(e);

			throw new Exception("unknown error");

		}

	}

	@GetMapping("/list/all/product")
	public ModelAndView ListAllProducts() {
		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("products", productServiceImpl.ListDtoProduct());
			mv.setViewName("produtos.html");
			return mv;

		} catch (Exception e) {

			System.out.println(e);
			mv.setViewName("redirect:/error");
			return mv;

		}

	}

	@PostMapping("/pre/edit/product")
	@PreAuthorize("hasAnyRole('ADM')")
	public ModelAndView preEditarProduct(@RequestParam("id_product") Long id) {

		ModelAndView mv = new ModelAndView();
		try {
			System.out.println(productServiceImpl.ListDtoProductID(id));

			mv.addObject("products", productServiceImpl.ListId(id));
			mv.addObject("category", categorys());
			mv.setViewName("editar_produto.html");

			return mv;

		} catch (Exception e) {
			System.out.println(e);
			mv.setViewName("redirect:/error");
			return mv;

		}

	}

	@PostMapping("/edit/product")
	@PreAuthorize("hasAnyRole('ADM')")
	public ModelAndView EditeProduct(ProductDto productDto) {

		ModelAndView mv = new ModelAndView();

		try {
			upadateProduct(productDto);
			mv.addObject("products", productServiceImpl.ListDtoProduct());
			mv.setViewName("produtos.html");
			return mv;

		} catch (Exception e) {

			System.out.println(e);
			mv.setViewName("redirect:/error");
			return mv;

		}

	}

	private void upadateProduct(ProductDto productDto) throws Exception {

		try {
			Long id = productDto.getId();
			String name = productDto.getName();
			Integer amount = productDto.getAmount();
			String category = productDto.getCategory();
			Double price = productDto.getPrice();

			Product product = new Product();

			product.setId(id);
			product.setName(name);
			product.setAmount(amount);
			product.setCategory(category);
			product.setPrice(price);

			productServiceImpl.UpdateTheProduct(product);

		} catch (Exception e) {

			System.out.println(e);
			throw new Exception("unknown error");

		}

	}

	@PostMapping("/delete/product")
	@PreAuthorize("hasAnyRole('ADM')")
	public ModelAndView Delete(@RequestParam("delete_id") Long id) {
		
		ModelAndView mv = new ModelAndView();
		try {
			productServiceImpl.deleteTheProduct(id);
			mv.addObject("products", productServiceImpl.ListDtoProduct());
			mv.setViewName("produtos.html");
			return mv;
		} catch (Exception e) {
		
			System.out.println(e);
			mv.setViewName("redirect:/error");
			return mv;
			
		}
		
	}
	
	
	
	
	
	private CategoryProduct[] categorys() {

		return CategoryProduct.values();
	}

}
