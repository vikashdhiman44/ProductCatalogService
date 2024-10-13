package org.example.productcatalogservice.clients;

import org.example.productcatalogservice.dtos.FakeStoreProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreApiClient {

    @Autowired
     private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductDto getProductById(Long id) {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity =
                requestForEntity("https://fakestoreapi.com/products/{id}",HttpMethod.GET,null, FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();
        if(fakeStoreProductDtoResponseEntity.getStatusCode().equals(HttpStatusCode.valueOf(200)) &&
                fakeStoreProductDto!=null) {
            return fakeStoreProductDto;
        }

        return null;
    }

    private <T> ResponseEntity<T> requestForEntity(String url, HttpMethod httpMethod, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    public FakeStoreProductDto createProduct(FakeStoreProductDto from) {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity =
                requestForEntity("https://fakestoreapi.com/products",HttpMethod.POST,from, FakeStoreProductDto.class);

        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();
        if(fakeStoreProductDtoResponseEntity.getStatusCode().equals(HttpStatusCode.valueOf(200)) &&
                fakeStoreProductDto!=null) {
            return fakeStoreProductDto;
        }

        return null;
    }
}
