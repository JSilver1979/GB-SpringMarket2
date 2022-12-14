package ru.gb.jSilver.spring.market.products;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.gb.jSilver.spring.market.api.ProductDto;
import ru.gb.jSilver.spring.market.products.services.ProductService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

    @Test
    public void getProductsTest() throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setId(777L);
        productDto.setTitle("Coffee");
        productDto.setPrice(180);
        List<ProductDto> productDtoList = new ArrayList<>(Arrays.asList(productDto));

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
}
