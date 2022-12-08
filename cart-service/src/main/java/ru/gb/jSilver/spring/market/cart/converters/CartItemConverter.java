package ru.gb.jSilver.spring.market.cart.converters;

import org.springframework.stereotype.Component;
import ru.gb.jSilver.spring.market.api.CartItemDto;
import ru.gb.jSilver.spring.market.cart.data.CartItem;

@Component
public class CartItemConverter {
    public CartItemDto entityToDto(CartItem cartItem) {
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setId(cartItem.getId());
        cartItemDto.setProductTitle(cartItem.getProductTitle());
        cartItemDto.setQuantity(cartItem.getQuantity());
        cartItemDto.setPricePerProduct(cartItem.getPricePerProduct());
        cartItemDto.setPrice(cartItem.getPrice());

        return cartItemDto;
    }
}
