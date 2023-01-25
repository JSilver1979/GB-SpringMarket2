package ru.gb.jSilver.spring.market.products;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.gb.jSilver.spring.market.api.ProductDto;
import ru.gb.jSilver.spring.market.products.controllers.TestProduct;
import ru.gb.jSilver.spring.market.products.repos.ProductRepository;
import ru.gb.jSilver.spring.market.products.services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ProductService productService;
    @MockBean
    private ProductRepository productRepository;
    @Autowired
    private TestProduct testProduct;

    @Test
    public void getProductsTest() throws Exception {
        List<ProductDto> productDtoList = new ArrayList<>(List.of(testProduct.getTestProduct()));

        given(productService.findAllProducts()).willReturn(productDtoList);

        mockMvc
                .perform(
                    get("/api/v1/products").contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is(productDtoList.get(0).getTitle())));
    }

    @Test
    public void getProductByIdTest() throws Exception {

        given(productService.findById(777L)).willReturn(Optional.of(testProduct.getTestProduct()));

        mockMvc
                .perform(get("/api/v1/products/777").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(testProduct.getTestProduct().getId().intValue())));
    }

    @Test
    public void getProductNotFoundError() throws Exception {
        int errorId = 77;
        given(productService.findById(777L)).willReturn(Optional.of(testProduct.getTestProduct()));

        mockMvc
                .perform(get("/api/v1/products/" + errorId).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.message", is("Product not found, id: " + errorId)));

    }
}
