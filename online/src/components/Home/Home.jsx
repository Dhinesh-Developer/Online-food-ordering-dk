import React from 'react';
import MultiItemCarsoul from './MultiItemCarsoul';
import "./Home.css";
import RestaurantCard from '../Restaurant/RestaurantCard';

const restaurant = [1, 1, 1, 1, 1, 1, 1, 1];

const Home = () => {
  return (
    <div className="pb-10">
      {/* Banner */}
      <div className="banner relative flex flex-col justify-center items-center h-screen">
        <div className="absolute top-0 left-0 w-full h-full bg-black opacity-50 z-0"></div>
        <div className="w-[50vw] text-center z-10">
          <p className="text-3xl lg:text-7xl font-bold py-5 text-white drop-shadow-lg font-serif">
            DK's FOOD
          </p>
          <p className="text-xl lg:text-4xl text-gray-200 drop-shadow-md font-serif">
            Taste the Convenience: Food, Fast and Delivered.
          </p>
        </div>
      </div>

      {/* Carousel Section */}
      <section className="p-10 lg:py-10 lg:px-20">
        <p className="text-2xl font-semibold text-gray-400 py-3 font-serif">Top Meals</p>
        <MultiItemCarsoul />
      </section>

      {/* Restaurants */}
      <section className="px-5 lg:px-20 pt-5">
        <h1 className="text-2xl font-semibold text-gray-400 py-3 font-serif">
          Order From Our Handpicked Favourites
        </h1>
        <div className="flex flex-wrap items-center justify-around gap-5">
          {restaurant.map((item, index) => (
            <RestaurantCard key={index} />
          ))}
        </div>
      </section>
    </div>
  );
};

export default Home;
