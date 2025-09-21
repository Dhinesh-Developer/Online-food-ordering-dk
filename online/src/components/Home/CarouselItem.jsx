import React from 'react';

const CarouselItem = ({ image, title }) => {
  return (
    <div className="flex flex-col justify-center items-center p-2">
      <img
        src={image}
        alt={title}
        className="w-[10rem] h-[10rem] lg:w-[14rem] lg:h-[14rem] rounded-full object-cover object-center"
      />
      <span className="py-2 font-semibold text-xl text-gray-400 capitalize">
        {title}
      </span>
    </div>
  );
};

export default CarouselItem;
