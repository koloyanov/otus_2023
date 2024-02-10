package ru.otus;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.data.entity.Shop;
import ru.otus.data.repository.ShopRepository;
import ru.otus.data.repository.StockRepository;
import ru.otus.service.impl.ProductServiceImpl;
import ru.otus.service.impl.ShopsServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShopsServiceTest {
    @InjectMocks
    ShopsServiceImpl shopsService;
    @Mock
    ProductServiceImpl productService;
    @Mock
    ShopRepository shopRepository;
    @Mock
    StockRepository stockRepository;

    @Test
    public void addNewProductToShopExceptionTest() {
        Shop shop = new Shop(1L, "address");
        when(stockRepository.findFirstByShopIdAndProductId(anyLong(), anyLong())).thenReturn(Optional.empty());
        when(productService.getProductById(anyLong())).thenReturn(null);

        Throwable throwable = assertThrows(RuntimeException.class, () -> shopsService.addNewProductsToShop(shop.getId(), 1L,10));

        assertEquals("Product with this id is not exists", throwable.getMessage());
    }

    @Test
    public void getProductFromShopExceptionTest(){
        when(stockRepository.findFirstByShopIdAndProductId(anyLong(), anyLong())).thenReturn(Optional.empty());

        Throwable throwable = assertThrows(RuntimeException.class, () -> shopsService.getProductFromShop(1L, 1L, 10));
        assertEquals("This shop doesn\'t have so much products of this type", throwable.getMessage());
    }

    @Test
    public void getShopByIdExceptionTest() {
        when(shopRepository.getReferenceById(anyLong())).thenReturn(null);

        Throwable throwable = assertThrows(RuntimeException.class, () -> shopsService.getShopById(1L));
        assertEquals("Shop with this id doesn\'t exist", throwable.getMessage());
    }
}
