package ru.gb.jSilver.spring.market.cart.converters;

import org.springframework.stereotype.Component;
import ru.gb.jSilver.spring.market.api.CartItemDto;
import ru.gb.jSilver.spring.market.cart.data.CartItem;

@Component
public class CartItemConverter {
    public CartItemDto entityToDto(CartItem cartItem) {

        return CartItemDto.CartItemBuilder.aCartItemDto()
                .withId(cartItem.getId())
                .withProductTitle(cartItem.getProductTitle())
                .withQuantity(cartItem.getQuantity())
                .withPricePerProduct(cartItem.getPricePerProduct())
                .withPrice(cartItem.getPrice())
                .build();

    }
}
