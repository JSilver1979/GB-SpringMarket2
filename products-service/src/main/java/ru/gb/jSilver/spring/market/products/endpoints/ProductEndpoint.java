package ru.gb.jSilver.spring.market.products.endpoints;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.gb.jSilver.spring.market.products.services.ProductSoapService;
import ru.gb.jSilver.spring.market.products.soap.GetAllProductsRequest;
import ru.gb.jSilver.spring.market.products.soap.GetAllProductsResponse;


@Endpoint
@RequiredArgsConstructor
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://jsilver.gb.ru/springmarket";
    private final ProductSoapService soapService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductsRequest")
    @ResponsePayload
    public GetAllProductsResponse getAllProductsResponse(@RequestPayload GetAllProductsRequest request) {
        GetAllProductsResponse response = new GetAllProductsResponse();
        return response;
    }
}
