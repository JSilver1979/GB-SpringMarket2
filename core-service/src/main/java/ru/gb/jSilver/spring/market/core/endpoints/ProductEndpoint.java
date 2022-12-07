package ru.gb.jSilver.spring.market.core.endpoints;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.gb.jSilver.spring.market.core.services.ProductSoapService;
import ru.gb.jSilver.spring.market.core.soap.GetAllProductsRequest;
import ru.gb.jSilver.spring.market.core.soap.GetAllProductsResponse;

@Endpoint
@RequiredArgsConstructor
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://jsilver.gb.ru/springmarket";
    private final ProductSoapService soapService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductsRequest")
    @ResponsePayload
    public GetAllProductsResponse getAllProductsResponse(@RequestPayload GetAllProductsRequest request) {
        GetAllProductsResponse response = new GetAllProductsResponse();
        soapService.getSoapProducts().forEach(response.getProducts()::add);
        return response;
    }
    /*
    http://localhost:8189/app/ws
    Header - Content-Type: text/xml

    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:f="http://jsilver.gb.ru/springmarket">
        <soapenv:Header/>
        <soapenv:Body>
            <f:getAllProductsRequest/>
        </soapenv:Body>
    </soapenv:Envelope>
    */
}
