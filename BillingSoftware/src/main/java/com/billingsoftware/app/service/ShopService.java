package com.billingsoftware.app.service;

import org.springframework.stereotype.Service;

import com.billingsoftware.app.entity.Shop;
import com.billingsoftware.app.repository.ShopRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    public Optional<Shop> getShopById(Long id) {
        return shopRepository.findById(id);
    }

    public Shop createShop(Shop shop) {
        return shopRepository.save(shop);
    }

    public Shop updateShop(Long id, Shop shopDetails) {
        return shopRepository.findById(id).map(shop -> {
            shop.setShopName(shopDetails.getShopName());
            shop.setShopAddress(shopDetails.getShopAddress());
            shop.setShopContact(shopDetails.getShopContact());
            shop.setShopEmail(shopDetails.getShopEmail());
            shop.setShopLogo(shopDetails.getShopLogo());
            shop.setShopGstNo(shopDetails.getShopGstNo());
            shop.setShopPaymentQr(shopDetails.getShopPaymentQr());
            shop.setShopImg(shopDetails.getShopImg());
            shop.setShopOwnerName(shopDetails.getShopOwnerName());
            shop.setShopRegisterDate(shopDetails.getShopRegisterDate());
            shop.setShopPlanDate(shopDetails.getShopPlanDate());
            shop.setShopPlanValidityDays(shopDetails.getShopPlanValidityDays());
            shop.setShopPlanStatus(shopDetails.getShopPlanStatus());
            return shopRepository.save(shop);
        }).orElseThrow(() -> new RuntimeException("Shop not found with id " + id));
    }

    public void deleteShop(Long id) {
        shopRepository.deleteById(id);
    }
}
