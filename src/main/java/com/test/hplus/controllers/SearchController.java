package com.test.hplus.controllers;

import com.test.hplus.beans.Product;
import com.test.hplus.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SearchController {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    private AsyncTaskExecutor taskExecutor;

    @Autowired
    public void setTaskExecutor(AsyncTaskExecutor taskExecutor){
        this.taskExecutor = taskExecutor;
    }


    @GetMapping("/search")
    public DeferredResult<String> search(@RequestParam("search") String search, Model model, HttpServletRequest request){
        DeferredResult<String> deferredResult = new DeferredResult<>();
        System.out.println("in search controller");
        System.out.println("search criteria: "+search);
        System.out.println("Async supported in application: "+request.isAsyncSupported());
        System.out.println("Thread from the servlet container: "+Thread.currentThread().getName());

        taskExecutor.execute(() -> {
            System.out.println("Thread from the spring mvc task executor: "+Thread.currentThread().getName());
            List<Product> products = productRepository.searchByName(search);
            model.addAttribute("products", products);
            deferredResult.setResult("search");
        });
        return deferredResult;
    }

}
