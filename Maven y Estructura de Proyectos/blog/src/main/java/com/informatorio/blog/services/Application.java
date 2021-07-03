// En Service va la lógica de negocio

package com.informatorio.blog.services;

import java.util.List;

import com.informatorio.blog.model.Blog;
import com.informatorio.blog.utils.BlogUtils;

public class Application {
	public static void main(String[] args) {
		BlogUtils blogs = new BlogUtils();
		List<Blog> listaBlogs = blogs.crearBlogs();
		listaBlogs.forEach(System.out::println);
	}
}
