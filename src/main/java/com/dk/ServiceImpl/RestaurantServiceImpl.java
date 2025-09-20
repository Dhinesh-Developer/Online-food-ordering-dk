package com.dk.ServiceImpl;

import com.dk.Repository.AddressRespository;
import com.dk.Repository.RestaurantRespository;
import com.dk.Repository.UserRepository;
import com.dk.dto.RestaurantDto;
import com.dk.model.Address;
import com.dk.model.Restaurant;
import com.dk.model.User;
import com.dk.request.CreateRestaurantRequest;
import com.dk.service.RestaurantService;
import com.dk.service.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.RsaAlgorithm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRespository restaurantRespository;

    @Autowired
    private AddressRespository addressRespository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Restaurant createRestaurant(CreateRestaurantRequest req, User user) {
        // Save the address first
        //Address address = addressRespository.save(req.getAddress());

        Restaurant restaurant = new Restaurant();
        //restaurant.setAddress(address);
        restaurant.setContactInformation(req.getContactInformation());
        restaurant.setCuisineType(req.getCuisineType());
        restaurant.setDescription(req.getDescription());
        restaurant.setImages(req.getImages());
        restaurant.setName(req.getName());
        restaurant.setOpeningHours(req.getOpeningHours());
        restaurant.setRegisterationDate(LocalDateTime.now());
        restaurant.setOwner(user);

        return restaurantRespository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updateRestaurant) throws Exception {
       Restaurant restaurant = findRestaurantById(restaurantId);

       if(restaurant.getCuisineType()!=null){
           restaurant.setCuisineType(updateRestaurant.getCuisineType());
       }

       if(restaurant.getDescription() != null){
           restaurant.setDescription(updateRestaurant.getDescription());
       }

       if(restaurant.getName() != null){
           restaurant.setDescription(updateRestaurant.getName());
       }

        return restaurantRespository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) throws Exception {
        Restaurant restaurant = findRestaurantById(restaurantId);

        restaurantRespository.delete(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRespository.findAll();
    }

    @Override
    public List<Restaurant> searchRestaurant(String keyword) {
        return restaurantRespository.findBySearchQuery(keyword);
    }

    @Override
    public Restaurant findRestaurantById(Long id) throws Exception {
        Optional<Restaurant> opt = restaurantRespository.findById(id);
        if(opt.isEmpty()){
            throw new Exception("restaurant not found with id: "+id);
        }
        return opt.get();
    }

    @Override
    public Restaurant getRestaurantByUserId(Long userId) throws Exception {
        Restaurant restaurant = restaurantRespository.findByOwnerId(userId);
        if(restaurant==null){
            throw new Exception("restaurant not found with owner id: "+userId);
        }
        return restaurant;
    }

    @Override
    public RestaurantDto addToFavourite(Long restaurantId, User user) throws Exception {

        Restaurant restaurant = findRestaurantById(restaurantId);

        // Check if restaurant is already in user's favourites
        if (user.getFavourites().contains(restaurant)) {
            user.getFavourites().remove(restaurant); // remove if already favourite
        } else {
            user.getFavourites().add(restaurant); // add otherwise
        }

        // Save updated user
        userRepository.save(user);

        // Convert to DTO for response
        RestaurantDto dto = new RestaurantDto();
        dto.setId(restaurant.getId());
        dto.setTitle(restaurant.getName());
        dto.setDescription(restaurant.getDescription());
        dto.setImages(restaurant.getImages());

        return dto;
    }


    @Override
    public Restaurant updateRestaurantStatus(Long id) throws Exception {
        Restaurant restaurant = findRestaurantById(id);
        restaurant.setOpen(!restaurant.isOpen());
        return restaurantRespository.save(restaurant);

    }
}
