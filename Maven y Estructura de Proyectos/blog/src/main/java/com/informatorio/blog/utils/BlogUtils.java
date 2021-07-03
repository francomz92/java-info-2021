package com.informatorio.blog.utils;

import java.util.ArrayList;
import java.util.List;

import com.informatorio.blog.model.Blog;

/**
 * BlogUtils
 */
public class BlogUtils {

    public List<Blog> crearBlogs() {
        List<Blog> listaBlogs = new ArrayList<>();
        listaBlogs.add(new Blog("Franco"));
        listaBlogs.add(new Blog("Sebastian"));
        listaBlogs.add(new Blog("Muñoz"));
        return listaBlogs;
    }
}